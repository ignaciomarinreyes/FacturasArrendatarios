package auxiliar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyLocalDate {

    public static String myToString(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return localDate.format(formatter);
    }
}
