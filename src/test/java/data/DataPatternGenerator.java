package data;


import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataPatternGenerator {
    final static String[] federalCities =
            {"Москва", "Ростов-на-Дону", "Воронеж", "Горно-Алтайск", "Казань"};

    public static DataPattern generateData() {

        Faker faker = new Faker(new Locale("ru"));
        Random rndCities = new Random();
        String cityName = federalCities[rndCities.nextInt(federalCities.length)];
        String[] customerName = faker.name().name().split(" ");
        return new DataPattern(cityName,
                customerName[0] + " " + customerName[1],
                "+7" + faker.phoneNumber().cellPhone());
    }

    public String date(int addDays) {
        LocalDate deliveryDateCard = LocalDate.now().plusDays(addDays);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return deliveryDateCard.format(formatter);
    }

    @Value
    public static class DataPattern {
        private final String city;
        private final String name;
        private final String phone;
    }
}
