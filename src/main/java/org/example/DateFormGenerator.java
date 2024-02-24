package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormGenerator {
    public String date() {
        LocalDate deliveryDateCard = LocalDate.now().plusDays(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return deliveryDateCard.format(formatter);
    }
}