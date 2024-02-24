package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormGenerator {
    public String date(int addDays) {
        LocalDate deliveryDateCard = LocalDate.now().plusDays(addDays);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return deliveryDateCard.format(formatter);
    }
}