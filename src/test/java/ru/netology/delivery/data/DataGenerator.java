package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    static Faker faker = new Faker(new Locale("ru"));

    public static String generateDate(int shift) {
        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity(String locale) {

        String [] cities = {
            "Магас",
             "Йошкар-Ола",
            "Иваново",
            "Челябинск",
            "Майкоп",
            "Горно-Алтайск",
            "Уфа",
            "Улан-Удэ",
            "Махачкала",
            "Нальчик",
            "Элиста",
            "Черкесск",
            "Петрозаводск",
            "Сыктывкар",
            "Симферополь",
            "Саранск",
            "Якутск",
            "Владикавказ",
            "Казань",
            "Кызыл",
            "Ижевск",
            "Абакан",
            "Грозный",
            "Чебоксары",
            "Барнаул",
            "Чита",
            "Петропавловск-Камчатский",
            "Краснодар",
            "Красноярск",
            "Пермь",
            "Владивосток",
            "Ставрополь",
            "Хабаровск",
            "Благовещенск",
            "Архангельск",
            "Астрахань",
            "Белгород",
            "Брянск",
            "Владимир",
            "Волгоград",
            "Вологда",
            "Воронеж",
            "Иркутск",
            "Калининград",
            "Калуга",
            "Кемерово",
            "Киров",
            "Кострома",
            "Курган",
            "Курск",
            "Гатчина",
            "Санкт-Петербург",
            "Липецк",
            "Магадан",
            "Красногорск",
            "Мурманск",
            "Нижний Новгород",
            "Великий Новгород",
            "Новосибирск",
            "Омск",
            "Орёл",
            "Оренбург",
            "Пенза",
            "Псков",
            "Ростов-на-Дону",
            "Рязань",
            "Самара",
            "Саратов",
            "Южно-Сахалинск",
            "Екатеринбург",
            "Смоленск",
            "Тамбов",
            "Тверь",
            "Томск",
            "Тула",
            "Тюмень",
            "Ульяновск",
            "Ярославль",
            "Москва",
            "Севастополь",
            "Биробиджан",
            "Нарьян-Мар",
            "Ханты-Мансийск",
            "Анадырь",
            "Салехард"};

        int i = faker.number().numberBetween(0, cities.length);
        String city = cities[i];
        return city;
    }

    public static String generateName(String locale) {
        String name = faker.name().fullName().replace("ё", "е");
        return name;
    }

    public static String generatePhone(String locale) {
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            UserInfo user = new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));
            return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }

}



