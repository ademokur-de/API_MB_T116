package test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C16_Get_SoftAssertIleExpectedDataTesti {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
        Response Body(expected data)
        {
        "status": "success",
        "data": {
        "id": 3,
        "employee_name": "Ashton Cox",
        "employee_salary": 86000,
        "employee_age": 66, "profile_image": ""
        },
        "message": "Successfully! Record has been fetched."
        }

     */
    @Test
    public void get01(){

        //1-Endpoint Hazırlama
        String url="http://dummy.restapiexample.com/api/v1/employee/3";


        //2-Expected Data Hazırlama
        /*
        {
        "status": "success",
        "data": {
                    "id": 3,
                    "employee_name": "Ashton Cox",
                    "employee_salary": 86000,
                    "employee_age": 66,
                    "profile_image": ""
                },
        "message": "Successfully! Record has been fetched."
        }
         */

        JSONObject data=new JSONObject();
                data.put("id", 3);
                data.put("employee_name", "Ashton Cox");
                data.put("employee_salary", 86000);
                data.put("employee_age", 66);
                data.put("profile_image", "");

        JSONObject expdata=new JSONObject();
                expdata.put("status", "success");
                expdata.put("data", data);
                expdata.put("message", "Successfully! Record has been fetched.");



        //3-Response Kayıt
        Response response=given().when().get(url);

        //4-Assertion

        SoftAssert softassert=new SoftAssert();
        JsonPath resJP=response.jsonPath();
        // soft assert işleminde koşul sıralaması (actual,expected)

        softassert.assertEquals(resJP.get("status"),expdata.get("status"));
        softassert.assertEquals(resJP.get("message"),expdata.get("message"));
        softassert.assertEquals(resJP.get("data.id"),expdata.getJSONObject("data").get("id"));
        softassert.assertEquals(resJP.get("data.employee_name"),expdata.getJSONObject("data").get("employee_name"));
        softassert.assertEquals(resJP.get("data.employee_salary"),expdata.getJSONObject("data").get("employee_salary"));
        softassert.assertEquals(resJP.get("data.employee_age"),expdata.getJSONObject("data").get("employee_age"));
        softassert.assertEquals(resJP.get("data.profile_image"),expdata.getJSONObject("data").get("profile_image"));


        softassert.assertAll();







    }

}
