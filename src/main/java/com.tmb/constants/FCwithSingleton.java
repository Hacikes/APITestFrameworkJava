package com.tmb.constants;

import lombok.Getter;

@Getter
public class FCwithSingleton { // Single ton --> Единственный экземпляр для класса в определенный момент времени
    // Это один из шаблонов проектирования. Необходим, если нужно поддерживать только один экземпляр
    // определённого класса

    //Частный статический класс
    private static FCwithSingleton INSTANCE=null;

    private FCwithSingleton(){}

    // synchronized Если используется несколько потоков, то они будут синхронизированы, идти по очереди
    public static synchronized FCwithSingleton getInstance(){ //10 потоков
        if(INSTANCE==null){
            INSTANCE=new FCwithSingleton();
        }
        return INSTANCE;
    }

    private final String getRequestJsonFolderPath=System.getProperty("user.dir")+ "/src/test/resources/jsons/";
    private final String getResponseJsonFolderPath=System.getProperty("user.dir")+"/output/";
}
