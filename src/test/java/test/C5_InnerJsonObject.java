package test;

import org.json.JSONObject;
import org.junit.Test;

public class C5_InnerJsonObject {
    /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.

    {
    "firstname":"Jim",
     "additionalneeds":"Breakfast",
     "bookingdates":{
                    "checkin":"2018-01-01",
                    "checkout":"2019-01-01"
                    },
    "totalprice":111,
    "depositpaid":true,
     "lastname":"Brown"
    }
     */

    @Test
    public void innerJson(){

        //İç içe JSON objeleri içeren bir body de önce içerdeki JSON objesi oluşturulur
        JSONObject innerObje=new JSONObject();

        innerObje.put("checkin","2018-01-01");
        innerObje.put("checkout","2019-01-01");

        // arr={1,2,3,{elma,armut},10}

        //Ana JSON Objemizi oluştururken key,value değerleri yazılır.
        // İçinde inner olan keyin value'su innerObje olacaktır
        JSONObject outerObje=new JSONObject();
        outerObje.put("firstname","Jim");
        outerObje.put("lastname","Brown");
        outerObje.put("additionalneeds","Breakfast");
        outerObje.put("bookingdates",innerObje);
        outerObje.put("totalprice",111);
        outerObje.put("depositpaid",true);


        System.out.println("İçiçe Json Objesi = " + outerObje);







    }





}
