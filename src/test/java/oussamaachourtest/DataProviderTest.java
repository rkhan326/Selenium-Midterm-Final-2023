package oussamaachourtest;

import org.testng.annotations.Test;
import us.piit.utility.DataProviderClass;

public class DataProviderTest {
    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "data",enabled=false)
    public void dataProviderTest1(String firstName, String lastName, String age){
        System.out.println(firstName +"----"+ lastName +"----"+ age);
    }
    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "excelDPNacer",enabled=false)
    public void dataProviderTest2(String firstName, String lastName, String age){
        System.out.println(firstName +"----"+ lastName +"----"+ age);
    }

    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "excelDPOussamaReviewTest",enabled=false)
    public void dataProviderTest3(String stars, String review, String name, String email){
        System.out.println(stars +"----"+ review +"----"+ name +"----" +email);
    }
}
