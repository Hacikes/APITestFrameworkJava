import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;

public class ExtentReportDemo {
    @Test
    public void extentTest(){
        // После изменения теста необходимо сделать ReloadFromDisk нажав правую кнопку по названию проекта,
        // для обновления отчёта
        // Дока по Extern Report https://www.extentreports.com/docs/versions/5/java/index.html
        // Создаём объект для отчёта, как предусловие
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
        extent.attachReporter(spark);

        // Первый тест, записанный в локальную переменную
        ExtentTest test = extent.createTest("MyFirstTest");
        test.log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");

        // Второй тест, записанный в локальную переменную
        ExtentTest test1 = extent.createTest("MySecondTest");
        test1.log(Status.PASS, "This is a logging event for MySecondTest, and it passed!");

        // Проверка статуса теста после каждого теста и запись в отчёт


        // Конец теста
        extent.flush();

    }
}
