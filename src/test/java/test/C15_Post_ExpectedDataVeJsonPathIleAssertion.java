package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C15_Post_ExpectedDataVeJsonPathIleAssertion {
    /*
https://restful-booker.herokuapp.com/booking url’ine asagidaki body’ye sahip bir POST request gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin
Request Body
{
“firstname” : “Ahmet”,
 “lastname” : “Bulut”,
 “totalprice” : 500,
 “depositpaid” : false,
 “bookingdates” : {
                    “checkin” : “2021-06-01”,
                    “checkout” : “2021-06-10”
                 },
“additionalneeds” : “wi-fi”
}
ResponseBody
{
“bookingid”: 24,
“booking”: {
“firstname”: “Ahmet”,
“lastname”: “Bulut”,
“totalprice”: 500,
“depositpaid”: false,
“bookingdates”: {
“checkin”: “2021-06-01",
“checkout”: “2021-06-10"
},
“additionalneeds”: “wi-fi”
}
}
     */

    @Test
    public void expected01(){
        //1- Endpoint ve RequestBody Hazırlama
        String  url="https://restful-booker.herokuapp.com/booking";
        JSONObject inner=new JSONObject();
        inner.put("checkin" , "2021-06-01");
        inner.put("checkout" , "2021-06-10");

        JSONObject reqbody=new JSONObject();
        reqbody.put("firstname" , "Ahmet");
        reqbody.put("lastname" , "Bulut");
        reqbody.put("totalprice" , 500);
        reqbody.put("depositpaid" , false);
        reqbody.put("bookingdates" ,inner);
        reqbody.put("additionalneeds" , "wi-fi");

        //2-Expecteddata Hazırlama
        JSONObject expdata=new JSONObject();
        expdata.put("firstname" , "Ahmet");
        expdata.put("lastname" , "Bulut");
        expdata.put("totalprice" , 500);
        expdata.put("depositpaid" , false);
        expdata.put("bookingdates" ,inner);
        expdata.put("additionalneeds" , "wi-fi");

        //3- Response Kaydetme
        Response response=given()
                                .contentType(ContentType.JSON)
                           .when()
                                .body(reqbody.toString()).post(url);

        //response.prettyPeek();

        //4-Assertion İşlemi

        JsonPath resJP=response.jsonPath();

        Assert.assertEquals(expdata.get("firstname"),resJP.get("booking.firstname"));
        Assert.assertEquals(expdata.get("lastname"),resJP.get("booking.lastname"));
        Assert.assertEquals(expdata.get("totalprice"),resJP.get("booking.totalprice"));





        // reqbody.get(booking.firstname)  expbody(firstname)






    }



}
