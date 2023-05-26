package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {

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

//        ii) Set the expected data --> Bu adımı post ve put gibi data gönderilecek metholarda yapacağız.

//        iii) Send the request and get the response --> request'i gönder ve response'ı al
        Response response = given().get(url);
        response.prettyPrint();

//        iv) Do assertion --> Doğrulama yap

        //datanın header kısmı metadeta
        response.then() //dogrulanabilir data döner 'validatable'
                .statusCode(200)//HTTP Status Code should be 200
                .contentType("application/json; charset=utf-8")//Content Type should be "application/JsonPlaceHolderBaseUrl"
                .statusLine("HTTP/1.1 200 OK");//Status Line should be "HTTP/1.1 200 OK"
    }

}