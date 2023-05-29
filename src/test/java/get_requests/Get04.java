package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class Get04 extends JsonPlaceHolderBaseUrl {
     /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
          I send a GET request to the Url
       And
           Accept type is "application/json"
       Then
           HTTP Status Code should be 200
       And
           Response format should be "application/json"
       And
           There should be 200 todos => toplam 200 todos olması gerekir
       And
           "quis eius est sint explicabo" should be one of the todos title => todos başlıklarından en az birinin "quis eius est sint explicabo" olması gerekir
       And
           2, 7, and 9 should be among the userIds => userId değerleri arasında 2, 7 ve 9 bulunmalıdır
     */

    @Test
    public void get04() {
        //Set the url
        //String url = "https://jsonplaceholder.typicode.com/todos"; ==> Tavsiye edilmeyen yöntem
        spec.pathParam("first", "todos");//spec --> tekrarlı işlemleri içeren RequestSpecification objesi

        //Set the expected data

        //Send the request and get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        //Do assertion
        response.then()
                .statusCode(200)//HTTP Status Code should be 200
                .contentType(ContentType.JSON)//Response format should be "application/json"
                .body("id", hasSize(200))// There should be 200 todos
                .body("title", hasItem("quis eius est sint explicabo"))//"quis eius est sint explicabo" should be one of the todos title
                .body("userId", hasItems(2, 7, 9))//2, 7, and 9 should be among the userIds
        ;

        // hasSize() methodu eleman sayısını (kontrol eder) assert eder
        // hasItem() methodu contains() gibi tek bir objenin içerilip içrilmediğini assert eder.
        // hasItems() methodu containsAll() gibi çoklu objelerin içerilip içrilmediğini assert eder.


    }

}