package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class practice0 {

    public static void main(String[] args) {


        //Get request nasıl yapılır:
        String url = "https://petstore.swagger.io/v2/pet/1874101700";
        Response response = given().get(url);//import static io.restassured.RestAssured.given;
       // response.prettyPrint();//prettyPrint() methodu ile response'ı konsola yazdırdık.

        System.out.println("startus code "+response.statusCode());//200


        System.out.println("coontent Type"+response.contentType());

        System.out.println("status line "+response.statusLine()); //200 OK

        System.out.println(response.header("Date"));
        System.out.println(response.header("Connection"));
        System.out.println(response.header("Server"));
        System.out.println(response.header("TransferEncoding"));


        //Headers
        System.out.println("------------Heders----------------");
        System.out.println(response.headers());

        //Time
        System.out.println("\nTime:"+response.time());


    }
}
