// Использование Faker выносится в отдельный класс, для того, чтобы избежать проблем, когда разрабы Faker изменят
// Синтаксис. И для того, чтобы потом не менять его в нескольких местах, достаточно будет одного изменения в этом классе

// Сервисный уровень
package com.tmb.utils;

import com.github.javafaker.Faker;

public final class FakerUtils {

    private FakerUtils(){}

        private static final Faker faker = new Faker();

        // Метод getNumber принимающий 2 аргумента: min и max числа диапазона
        // И возвращает их
        public static int getNumber(int startvalue, int endvalue){
            return faker.number().numberBetween(startvalue,endvalue);
        }

        // Генерация имени
        public static String getFirstName(){
            return faker.name().firstName();
        }

    public static String getLastName(){
        return faker.name().lastName();
    }
}
