package us.piit.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    private final Logger LOG = LogManager.getLogger(ExcelReader.class.getName());

    public static String currentDir = System.getProperty("user.dir");

    XSSFWorkbook excelWBook;
    XSSFSheet excelWSheet;
    XSSFCell cell;
    String path;

    public ExcelReader(String path){
        this.path = path;
    }

    public String getStringDataFromCell(String sheet, int rowNum, int colNum){
        try {
            FileInputStream excelFile = new FileInputStream(path);
            excelWBook = new XSSFWorkbook(excelFile);
            excelWSheet = excelWBook.getSheet(sheet);
            cell = excelWSheet.getRow(rowNum).getCell(colNum);
            String cellValue = cell.getStringCellValue();
            excelFile.close();
            return cellValue;
        }catch (Exception e){
            LOG.info("no file found");
            return "";
        }
    }

    public void getNumericDataFromCell(String sheet, int rowNum, int colNum){
        try {
            FileInputStream excelFile = new FileInputStream(path);
            excelWBook = new XSSFWorkbook(excelFile);
            excelWSheet = excelWBook.getSheet(sheet);
            cell = excelWSheet.getRow(rowNum).getCell(colNum);
            double cellValue = cell.getNumericCellValue();
            excelFile.close();
          //  return cellValue;
        }catch (Exception e){
            LOG.info("no file found");
           // return null;
        }
    }

//    public List<String> getEntireColumnData(String sheet, int rowStart, int colNum){
//        List<String> columnData = new ArrayList<>();
//        try {
//            File file = new File(path);
//            FileInputStream excelFile = new FileInputStream(file);
//            excelWBook = new XSSFWorkbook(excelFile);
//            excelWSheet = excelWBook.getSheet(sheet);
//            DataFormatter df=new DataFormatter();
//            String dataString="";
//            for (int i = rowStart; i <= excelWSheet.getLastRowNum(); i++){
//              //  dataString=df.formatCellValue(excelWSheet.getRow(i).getCell(colNum).getStringCellValue());
//                columnData.add(dataString);
//            }
////            int i = rowStart;
////            while (excelWSheet.getRow(i).getCell(colNum).getStringCellValue() != null){
////                columnData.add(excelWSheet.getRow(i).getCell(colNum).getStringCellValue());
////                i++;
////            }
//            excelFile.close();
//        }catch (Exception e){
//            e.printStackTrace();
//            LOG.info("no data found");
//        }
//        return columnData;
//    }

    public List<String> getEntireColumnData(String sheet, int rowStart, int colNum){
        List<String> columnData = new ArrayList<>();
        try {
            File file = new File(path);
            FileInputStream excelFile = new FileInputStream(file);
            excelWBook = new XSSFWorkbook(excelFile);
            excelWSheet = excelWBook.getSheet(sheet);
            DataFormatter df = new DataFormatter();
            String dataString = "";

            for (int i = rowStart; i <= excelWSheet.getLastRowNum() + 1; i++){
                dataString = df.formatCellValue(excelWSheet.getRow(i).getCell(colNum));
                columnData.add(dataString);
            }
//            int i = rowStart;
//            while (excelWSheet.getRow(i).getCell(colNum).getStringCellValue() != null){
//                columnData.add(excelWSheet.getRow(i).getCell(colNum).getStringCellValue());
//                i++;
//            }
            excelFile.close();
        }catch (Exception e){
            e.printStackTrace();
            LOG.info("no data found");
        }
        return columnData;
    }



    public List<String> getEntireColumnForGivenHeader (String sheet, String headerName){
        int i = 0;
        while (getStringDataFromCell(sheet, 0, i) != null) {
            if (getStringDataFromCell(sheet, 0, i).equalsIgnoreCase(headerName)) {
                getEntireColumnData(sheet, 1, i);
                break;
            }
            i++;
        }
        return getEntireColumnData(sheet, 1, i);
    }

    public String getValueForGivenHeaderAndKey(String sheet, String headerName, String key){
        String value = null;
        int i = 0;
        while (getStringDataFromCell(sheet, 0, i) != null){
            if(getStringDataFromCell(sheet, 0, i).equalsIgnoreCase(headerName)){
                for (int j = 0; j < getEntireColumnData(sheet, 1, i).size(); j++){
                    if(getEntireColumnData(sheet, 1, i).get(j).equalsIgnoreCase(key)){
                        value = getEntireColumnData(sheet, 1, i+1).get(j);
                    }
                }
                break;
            }
            i++;
        }
        return value;
    }

    public String[][] getExcelData(String fileName, String sheetName) {
        String[][] data = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sh = wb.getSheet(sheetName);
            XSSFRow row = sh.getRow(0);
            int noOfRows = sh.getPhysicalNumberOfRows();
            int noOfCols = row.getLastCellNum();
            Cell cell;
            data = new String[noOfRows - 1][noOfCols];
            for (int i = 1; i < noOfRows; i++) {
                for (int j = 0; j < noOfCols; j++) {
                    row = sh.getRow(i);
                    cell = row.getCell(j);

                    data[i - 1][j] = cell.toString();
                }
            }
        }
            catch (Exception e) {
            System.out.println("The exception is: " + e.getMessage());
        }
        return data;
    }

//Oussama Code
//    public List<String> getEntireColumnDataFromExcelSheet(String sheet, int rowStart, int colNum) {
//        List<String> columnData = new ArrayList<>();
//        try {
//            File file = new File(path);
//            FileInputStream excelFile = new FileInputStream(file);
//            excelWBook = new XSSFWorkbook(excelFile);
//            excelWSheet = excelWBook.getSheet(sheet);
//
//            DataFormatter formatter = new DataFormatter();
//            for (int i = rowStart; i < excelWSheet.getLastRowNum() + 1; i++) {
//                Cell cell = excelWSheet.getRow(i).getCell(colNum);
//                String cellValue = formatter.formatCellValue(cell);
//                columnData.add(cellValue);
//            }
//
//            excelFile.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            LOG.info("No data found");
//        }
//        return columnData;
//    }
//
//    @DataProvider(name = "checkoutForGuestUsers")
//    public static Object[][] getData() {
//        String currentDir = System.getProperty("user.dir");
//        String path = currentDir+File.separator+"data"+File.separator+"oussama-ScalledupitExcelData.xlsx";
//        System.out.println(path);
//        ExcelReader excelReader = new ExcelReader(path);
//        List<String> items1 = excelReader.getEntireColumnDataFromExcelSheet("CheckoutDataProvider",1,1);
//        List<String> items2 = excelReader.getEntireColumnDataFromExcelSheet("CheckoutDataProvider",1,2);
//        Object[][] data = new Object[2][];
//        data[0] = items1.toArray();
//        data[1] = items2.toArray();
//        return data;
//    }

    public static void main(String[] args)  {

        String path = currentDir + File.separator + "data"+ File.separator + "nopcommercedata.xlsx";
    
        //String path = "C:\\Users\\PNT\\eclipse-workspace\\Feb2023-web-automation-framework\\Datas\\ScalledupitExcelData.xlsx";

        ExcelReader excelReader = new ExcelReader(path);
        System.out.println(excelReader.getStringDataFromCell("Data",8,1));

//        List<String> items = excelReader.getEntireColumnForGivenHeader("Sheet1", "id");
//        //String items = excelReader.getValueForGivenHeaderAndKey("Sheet1", "id", "id004");
//        System.out.println(items);
    }
}
