package be.icc.reservation.utils;

import be.icc.reservation.entity.Shows;
import be.icc.reservation.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component
public class CSVExporter {

    private static final char SEPARATOR = ';';
    private static final char END_LINE = '\n';
    private static ShowService showService;

    @Autowired
    public CSVExporter(ShowService showService) {
        CSVExporter.showService = showService;
    }

    public static void exportShows() {
        List<Shows> shows = showService.findAll();
        String csvFileLocation = "src/main/resources/static/exportTest.csv";
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(csvFileLocation);
            fileWriter.write("bookable;poster_url;price;slug;title;location_id;description\n");
            for (Shows show : shows) {
                String line = "";
                line += "" + show.isBookable() + SEPARATOR;
                line += show.getPosterUrl() + SEPARATOR;
                line += "" + show.getPrice() + SEPARATOR;
                line += show.getSlug() + SEPARATOR;
                line += show.getTitle() + SEPARATOR;
                line += "" + show.getLocation().getId() + SEPARATOR;
                line += show.getDescription() + SEPARATOR + END_LINE;
                fileWriter.write(line);
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
