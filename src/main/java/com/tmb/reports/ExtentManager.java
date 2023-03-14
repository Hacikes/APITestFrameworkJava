package com.tmb.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
    private ExtentManager(){}
        // Локальный поток, для того, чтобы не было проблем с запуском нескольких потоков
        public static ThreadLocal<ExtentTest> exTest = new ThreadLocal<>();

        // Метод вернёт поток выше
        static ExtentTest getTest(){
            return exTest.get();
        }

        static void setExtent(ExtentTest test){
            exTest.set(test);
        }


}
