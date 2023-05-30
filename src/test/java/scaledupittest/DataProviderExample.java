package scaledupittest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
    //create data provider

//    @DataProvider (name="data-provider")
//
//    public Object [][] testData1() {
//        Object[][] data = new Object[3][3];
//        data[0][0] = 1;
//        data[0][1] = 2;
//        data[0][2] = 3;
//
//        data[1][0] = 4;
//        data[1][1] = 5;
//        data[1][2] = 6;
//
//        data[2][0] = 7;
//        data[2][1] = 8;
//        data[2][2] = 9;
//        return data;
//    }
//    @Test(dataProvider="data-provider")
//
//    public void getData (int a,int b,int c) {
//
//       // ExcelReader excelReader = new ExcelReader(Utility.currentDir + "/AmelData/ScalledupitExcelData.xlsx");
//        System.out.println("First Data set is :"+a+ "Second Data set is :"+b+ "Third Data set is :"+c);
//       // String validUsername= excelReader.getStringDataFromCell("Sheet1",1,1);
//    }
//
    @Test (dataProvider ="LoginDataProvider")
    public void loginTest(String email,String password){
        System.out.println(email+"    "+password);

    }
   @DataProvider(name="LoginDataProvider")
    public Object[][]getData(){
        Object[][]data={{"abc@gmail.com","abc"},{"edg@gmail.com","xvg"},{"vuyt@gmail.com","pnyy"}};
        return data;
    }

}

