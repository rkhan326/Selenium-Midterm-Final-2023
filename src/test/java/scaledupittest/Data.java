package scaledupittest;

import org.testng.annotations.DataProvider;
import us.piit.utility.ExcelReader;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Data {
    @DataProvider
    public Object[][]data(Method name) {
        System.out.println("Method"+name+"is using Data Provider");
        ExcelReader read = new ExcelReader("C:\\Users\\Amel Boucetta Gacem\\eclipse-workspace\\Selenium-Midterm-Final-2023\\data\\data.xlsx");
        List<String> columnData = new ArrayList<>();
        columnData = read.getEntireColumnData("Data", 1, 0);
        Object[][] data = new Object[3][3];
        for (int i = 0; i < 3; i++) {
            if (i != 0) {
                columnData = read.getEntireColumnData("Data", 1, i);
            }
            for (int j = 0; j < columnData.size(); j++) {
                data[j][i] = columnData.get(j);

            }
        }
        return data;
    }
}


