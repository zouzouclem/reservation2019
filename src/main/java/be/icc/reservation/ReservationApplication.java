package be.icc.reservation;

import be.icc.reservation.utils.CSVExporter;
import be.icc.reservation.utils.CSVImporter;
import be.icc.reservation.utils.RSSExporter;
import be.icc.reservation.utils.RSSImporter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//TODO (exclude = SecurityAutoConfiguration.class) A ajouter pour la desactivation de la sécurité
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ReservationApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReservationApplication.class, args);
        //CSVImporter.importShows("src/main/resources/static/showTest.csv");
        //RSSImporter.importShows("src/main/resources/static/showTest.xml");
        //CSVExporter.exportShows();
        //RSSExporter.exportShows();
    }
}
