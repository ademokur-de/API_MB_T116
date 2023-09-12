package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.testng.annotations.BeforeTest;

public class baseURL_JSONHolder {

    //BaseURL oluştururken RequestSpecification interfac'inden bir specobje oluşturdurk

    protected RequestSpecification specJsonHolder;

    @Before
    public void setUP (){
        specJsonHolder =new RequestSpecBuilder()
                                                 .setBaseUri("https://jsonplaceholder.typicode.com")
                                                 .build();
    }



}
