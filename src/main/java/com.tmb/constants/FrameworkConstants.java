package com.tmb.constants;

import lombok.Getter;

public class FrameworkConstants {

    // Если это не статические переменные
    private static @Getter final String requestJsonFolderPath=System.getProperty("user.dir")+ "/src/test/resources/jsons/";
    private static @Getter final String responseJsonFolderPath=System.getProperty("user.dir")+"/output/";
    private static @Getter final String propertyFilePath=System.getProperty("user.dir")+"/src/test/resources/config.properties";




}
