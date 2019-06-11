package be.icc.reservation.utils;

import be.icc.reservation.entity.Shows;
import be.icc.reservation.service.ShowService;
import com.thoughtworks.xstream.XStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component
public class RSSExporter {

    private static ShowService showService;

    @Autowired
    public RSSExporter(ShowService showService) {
        RSSExporter.showService = showService;
    }

    public static void exportShows() {
        List<Shows> shows = showService.findAll();
        String rssFileLocation = "src/main/resources/static/exportTest.xml";
        XStream stream = new XStream();
        stream.alias("Shows", List.class);
        stream.alias("Shows", Shows.class);
        String xml = stream.toXML(shows);
        File file = new File(rssFileLocation);
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(xml);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
