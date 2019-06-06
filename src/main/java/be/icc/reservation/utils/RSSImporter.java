package be.icc.reservation.utils;

import be.icc.reservation.entity.Locations;
import be.icc.reservation.entity.Shows;
import be.icc.reservation.service.LocationsService;
import be.icc.reservation.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Component
public class RSSImporter {

    private static LocationsService locationsService;
    private static ShowService showService;

    @Autowired
    public RSSImporter(LocationsService locationsService, ShowService showService) {
        RSSImporter.locationsService = locationsService;
        RSSImporter.showService = showService;
    }

    /**
     * Import shows contained in a xml file.
     *
     * @param fileUrl The url of the resource.
     */
    public static void importShows(String fileUrl) {
        Shows show = jaxbXmlFileToObject(fileUrl);
        showService.saveShow(show);
    }

    private static Shows jaxbXmlFileToObject(String fileName) {
        File xmlFile = new File(fileName);
        JAXBContext jaxbContext;
        Shows show = null;
        try {
            jaxbContext = JAXBContext.newInstance(Shows.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            show = (Shows) jaxbUnmarshaller.unmarshal(xmlFile);
            Locations locations = locationsService.findLocationsById(show.getLocation().getId());
            // for now it only works if the location already exist, just specify the id in the xml
            show.setLocation(locations);
            System.out.printf("Show extracted from xml : %s%n", show);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return show;
    }
}
