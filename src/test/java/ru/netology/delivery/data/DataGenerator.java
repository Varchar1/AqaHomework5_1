package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        String date;
        String pattern = "dd.MM.yyyy";
        date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern(pattern));
        return date;
    }

    public static String generateCity(String locale) {
        String[] cityList = {"Липецк", "Пенза", "Пермь", "Петрозаводск", "Москва", "Белгород", "Волгоград"};
        Random random = new Random();
        int pos = random.nextInt(cityList.length);
        String city = cityList[pos];
        return city;
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
