package us.piit.utility;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class DataProviderClass{

    @DataProvider
    public Object[][] data(Method name) {
        System.out.println("Method " +name+ "is using data provider.");

        String path = ExcelReader.currentDir + File.separator + "data" + File.separator + "scaledupitdata.xlsx";

       
        ExcelReader excelReader = new ExcelReader(path);
        List<String> columnData = new ArrayList<>();
        columnData = excelReader.getEntireColumnData("Data", 1, 0);
        Object[][] data = new Object[3][3];
        for (int i = 0; i < 3; i++) {
            if (i != 0) {
                columnData = excelReader.getEntireColumnData("Data", 1, i);
            }
            for (int j = 0; j < columnData.size(); j++) {
                data[j][i] = columnData.get(j);
            }
        }
        return data;
    }
    @DataProvider
    public Object[][] excelDPNacer() throws IOException {
        //We are creating an object from the excel sheet data by calling a method that reads data from the excel stored locally in our system
        String path = currentDir + File.separator + "data" + File.separator + "scaledupitdata.xlsx";
        ExcelReader excelReader = new ExcelReader(path);
        Object[][] arrObj = excelReader.getExcelData(path,"Data");
        return arrObj;
    }

    @DataProvider
    public Object[][] excelDPOussamaReviewTest() throws IOException {
        String path = currentDir + File.separator + "data" + File.separator + "oussamatestdata.xlsx";
        ExcelReader excelReader = new ExcelReader(path);
        Object[][] arrObj = excelReader.getExcelData(path,"ReviewTest");
        return arrObj;
    }

  

    //    @DataProvider
//    public Object[][] dataForOussamaReviewTest(Method name) {
//        System.out.println("Method " +name+ "is using data provider.");
//        String path = currentDir + File.separator + "data" + File.separator + "oussamatestdata.xlsx";
//        ExcelReader excelReader = new ExcelReader(path);
//        List<String> columnData = new ArrayList<>();
//        columnData = excelReader.getEntireColumnData("ReviewTest", 1, 0);
//
//        Object[][] data = new Object[8][3];
//        for (int i = 0; i < 8; i++) {
//            if (i != 0) {
//                columnData = excelReader.getEntireColumnData("ReviewTest", 1, i);
//
//            }
//            for (int j = 0; j < columnData.size(); j++) {
//                data[j][i] = columnData.get(j);
//            }
//        }
//        return data;
//    }




    @DataProvider
    public Object[][] excelDPScalledupitBlogTest() throws IOException {
        String path = currentDir + File.separator + "data" + File.separator + "ScalledupitDataProvider.xlsx";
        ExcelReader excelReader = new ExcelReader(path);
        Object[][] arrObj = excelReader.getExcelData(path,"Sheet1");
        return arrObj;
    }

}


