package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class practice01 {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/55
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be "application/JsonPlaceHolderBaseUrl"
        And
            Status Line should be "HTTP/1.1 200 OK"
        */

    @Test //test metot public void ve parametresiz olmalı
    public void get01() {
//        i) Set the url --> endpoint'i kur
        String url = "https://restful-booker.herokuapp.com/booking/55";

       // ii) Set the expected data --> Bu adımı post ve put gibi data gönderilecek metholarda yapacağız.

//        iii) Send the request and get the response --> request'i gönder ve response'ı al
                Response response = given().get(url);
                  response.prettyPrint();

                  //hazır methot larla test yapıyorum
        //tek seferde yapmak pratik sağlıyor
                  response.then().statusCode(200)
                          .contentType("application/Json")
                          .statusLine("HTTP/1.1 200 OK");


    }
}
