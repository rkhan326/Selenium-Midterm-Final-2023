//package scaledupittest;
//
//import org.testng.annotations.Test;
//import us.piit.base.CommonAPI;
//import us.piit.utility.ExcelReader;
//import us.piit.utility.Utility;
//
//
//public class LoginExcelReader extends CommonAPI {
//
//
//    @Test
//    public void LoginCredientials() {
//
//        ExcelReader excelReader = new ExcelReader(Utility.currentDir + "/AmelData/data.xlsx");
//
////        String validUsername= excelReader.getStringDataFromCell("Sheet1",1,1);
////        System.out.println(validUsername);
////
////        String validPassword= excelReader.getStringDataFromCell("Sheet1",1,2);
////        System.out.println(validPassword);
////
////        String InvalidUsername= excelReader.getStringDataFromCell("Sheet1",3,1);
////        System.out.println(InvalidUsername);
////
////        String invalidPassword= excelReader.getStringDataFromCell("Sheet1",2,2);
////        System.out.println(invalidPassword);
////
////        String FirstName= excelReader.getStringDataFromCell("Sheet2",1,0);
////        System.out.println(FirstName);
//////
//        String am= excelReader.getValueForGivenHeaderAndKey("Sheet1","Credentials","valid username and valid password");
//      //  String amel= String.valueOf(excelReader.getEntireColumnForGivenHeader("Sheet1","credentials"));
//       System.out.println(am);
////    }
//}}