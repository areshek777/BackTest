package Lesson4;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class AbstractAuthTest {
    static Properties prop = new Properties();
    private static InputStream configureFile;
    private static String apiKey;
    private static String baseURL;
    private static String hash;

    protected static ResponseSpecification responseSpecification;

    protected static RequestSpecification requestSpecification;
    protected static RequestSpecification requestSpecificationAdd;

    protected static RequestSpecification requestSpecificationAdd1;

    @BeforeAll
    static void initTest() throws IOException {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        configureFile = new FileInputStream("src/main/resources/my.properties");
        prop.load(configureFile);

        apiKey =  prop.getProperty("apiKey");
        baseURL= prop.getProperty("baseURL");
        hash = prop.getProperty("hash");

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(5000L))
                .build();

        requestSpecification = new RequestSpecBuilder()
                .addQueryParam("apiKey", apiKey)
                .setContentType(ContentType.URLENC)
                //.setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        requestSpecificationAdd = new RequestSpecBuilder()
                .addQueryParam("apiKey", apiKey)
                .addQueryParam("hash", hash)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        requestSpecificationAdd1 = new RequestSpecBuilder()
                .addQueryParam("apiKey", apiKey)
                .addQueryParam("hash", hash)
                .log(LogDetail.ALL)
                .build();

        RestAssured.responseSpecification = responseSpecification;
        RestAssured.requestSpecification = requestSpecification;
    }

    public static String getApiKey() {
        return apiKey;
    }

    public static String getBaseUrl() {
        return baseURL;
    }

    public RequestSpecification getRequestSpecification(){
        return requestSpecification;
    }

    public RequestSpecification getRequestSpecificationAdd(){
        return requestSpecificationAdd;
    }

    public RequestSpecification getRequestSpecificationAdd1(){
        return requestSpecificationAdd1;
    }
}
