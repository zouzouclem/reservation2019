package be.icc.reservation.utils;

import be.icc.reservation.entity.Shows;
import be.icc.reservation.service.LocationsService;
import be.icc.reservation.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

@Component
public class CSVImporter {

    private static LocationsService locationsService;
    private static ShowService showService;

    @Autowired
    public CSVImporter(LocationsService locationsService, ShowService showService) {
        CSVImporter.locationsService = locationsService;
        CSVImporter.showService = showService;
    }

    /**
     * Import shows contained in a csv file considering the first row is the column names.
     *
     * @param fileUrl The url of the resource.
     */
    public static void importShows(String fileUrl) {
        String line, csvSplitSeparator = ";"; // the csv separator
        String[] csvColumns;

        try (BufferedReader br = new BufferedReader(new FileReader(fileUrl))) {
            if ((line = br.readLine()) != null) {
                // first line is column names so we can ignore it
                csvColumns = line.split(csvSplitSeparator);
            } else {
                return; // however, if it's null then we end the method
            }

            while ((line = br.readLine()) != null) {
                String[] show = line.split(csvSplitSeparator);
                System.out.printf("Show to import %s%n", Arrays.toString(show));

                Shows showEntity = convertArrayIntoObject(show, csvColumns);
                showService.saveShow(showEntity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Shows convertArrayIntoObject(String[] showData, String[] csvColumns) {
        Shows show = new Shows();
        for (int i = 0; i < csvColumns.length; i++) {
            switch (csvColumns[i]) {
                case "bookable":
                    show.setBookable(Boolean.valueOf(showData[i]));
                    break;
                case "poster_url":
                    show.setPosterUrl(showData[i]);
                    break;
                case "price":
                    show.setPrice(BigDecimal.valueOf(Double.valueOf(showData[i])));
                    break;
                case "slug":
                    show.setSlug(showData[i]);
                    break;
                case "title":
                    show.setTitle(showData[i]);
                    break;
                case "location_id":
                    show.setLocationId(locationsService.findById(Integer.valueOf(showData[i])));
                    break;
                case "description":
                    show.setDescription(showData[i]);
                    break;
            }
        }
        return show;
    }
}
