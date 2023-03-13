package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class DataProviderTest {
    // Делаем мы всё это для передачи тестовых данных
    // Поставщик данных
    // Можно запустить тест с разными наборами тестовых данных
    // если будет использован цикл, то будет всё равно один тест

    @Test(dataProvider = "getData1")
    public void dpTest(Map<String, String> data){ // На входе 2 параметра и записываем мы их в объект data
            System.out.println(data.get("username"));
        System.out.println("Password = "+ data.get("password"));
    }

    @DataProvider
    public Object[][] getData1(){
        // Список наборов тестовых данных
        // хеш карта по классике используется для сериализации
        Object[][] data = new Object[3][1]; // инициализируем массив
        // Записываем данные в хеш карты
        Map<String, String > map1 = new HashMap<>();
        map1.put("username", "dfdfgdfgd");
        map1.put("password", "dfgdfdfgfdgdfgd");
        map1.put("email", "weddffdfgdfgd");

        Map<String, String > map2 = new HashMap<>();
        map2.put("username", "gfnbcvn");
        map2.put("password", "hnjmgf");
        map2.put("email", "fghgfh");

        Map<String, String > map3 = new HashMap<>();
        map3.put("username", "xcvdfg");
        map3.put("password", "ewrtert");
        map3.put("email", "hjh");
        // по итерациям получаем карты
        data[0][0] = map1;
        data[1][0] = map2;
        data[2][0] = map3;
        return data;
    };

        // map --> username-abcd, password-dhdfgdfg
        // map1
        // map2
        // list --> map1, map2, map3


    // Таким способом тяжело передавать большой объём тестовых данных, особенно,
    // если они будут масштабироваться горизонтально
    @DataProvider
    public Object[][] getData(){
        // Первый элемент массива - количество запусков теста
        // Второй элемент массива количество параметров метода
        return new Object[][]{ // Размерность 3*2
                {"first","fgfgfgf"},
                {"second","fgfqweqwe"},
                {"third","hjkhgfh"}
        };

        // map --> username-abcd, password-dhdfgdfg
        // map1
        // map2
        // list --> map1, map2, map3
    }

}
