package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.testng.annotations.BeforeTest;

public class baseURLHerOkuapp {


    protected RequestSpecification specHerOkuApp;

    @Before

    public void setUp(){
        specHerOkuApp= new RequestSpecBuilder()
                                .setBaseUri("https://restful-booker.herokuapp.com")
                                .build();
    }
}
