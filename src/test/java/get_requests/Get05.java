package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertTrue;

public class Get05 extends HerOkuAppBaseUrl {
      /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User sends a GET request to the URL
        Then
            Status code is 200
      And
         Among the data there should be someone whose firstname is "John" and last name is "Smith"
            (Data içerisinde firstname değeri "John", lastname değeri "Smith" olan biri olmalı)
     */

    @Test
    public void get05() {
        //Set the url
        spec.pathParam("first", "booking")
                .queryParams("firstname", "John", "lastname", "Smith");

        //Set the expected data

        //Send the request and get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        //Do assertion
        response.then().statusCode(200).body("bookingid", hasSize(greaterThan(0)));

        //yada
        assertTrue(response.asString().contains("bookingid"));

    }

}