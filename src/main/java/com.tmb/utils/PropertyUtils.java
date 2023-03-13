package com.tmb.utils;

import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.PropertiesType;
import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtils {

    private PropertyUtils(){}

    // Прочитать контент из файла свойств и сохранить это в hashmap
    // Прочитать контент только один и раз и сохранить его в какой-нибудь коллекции Java

    public static Properties properties = new Properties();
    private static Map<String,String> MAP = new HashMap<>();

    // Общее исключение, кто-то должен вызвать этот метод,

    // Для чтения файла и сохранения на карте
    static { // Перед началом выполнение всего теста необходимо вызвать этот метод
        // Получаем путь к файлу свойств с помощью FrameworkConstants.getPropertyFilePath
        try (FileInputStream inputStream = new FileInputStream(FrameworkConstants.getPropertyFilePath())) { // Autocloseable
            properties.load(inputStream);
        }
/*        catch (FileNotFoundException e) { // Исключение файл не найден
            e.printStackTrace();
        }*/
        catch (IOException e) {
            e.printStackTrace();
            System.exit(0); // Завершение выполнения программы, при срабатывании исключения
        }

        // entrySet - получение значений из хэш-карты
        // Использован лямбда оператор ->
        // Берётся ключ и его значение getKey и getValue
        properties.entrySet().forEach(e-> PropertyUtils.MAP.put(String.valueOf(e.getKey()),String.valueOf(e.getValue())));

        //Цикл ниже это тоже самое, что и записано в лямбде, но тут более наглядно
        /*for (Map.Entry<Object,Object> temp : properties.entrySet()) {
            // Получение ключа
            String key = String.valueOf(temp.getKey());
            // Получение цикла
            String value = String.valueOf(temp.getKey());
            MAP.put(key,value);
        }*/
    }
    // Получаем наш ключ
    public static String getValue(@NotNull PropertiesType key){
        return MAP.get(key.name().toLowerCase());
    }

}
