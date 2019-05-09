package be.icc.reservation;

import be.icc.reservation.utils.CSVImporter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//TODO (exclude = SecurityAutoConfiguration.class) A ajouter pour la desactivation de la sécurité
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ReservationApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReservationApplication.class, args);
        CSVImporter.importShows("C:\\Users\\Medion\\Desktop\\showTest.csv");
    }
}
