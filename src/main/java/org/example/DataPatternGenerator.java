package org.example;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class DataPatternGenerator {
    final static String[] federalCities =
            {"Москва", "Ростов-на-Дону", "Воронеж", "НовоРосийск", "Шахты"};

    public static DataPattern generateData() {

        Faker faker = new Faker(new Locale("ru"));
        Random rndCities = new Random();
        String cityName = federalCities[rndCities.nextInt(federalCities.length)];
        String[] customerName = faker.name().name().split(" ");
        return new DataPattern(cityName,
                customerName[0] + " " + customerName[1],
                "+7" + faker.phoneNumber().cellPhone());
    }
}
