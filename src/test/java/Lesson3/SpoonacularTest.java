package Lesson3;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;
//c362ffc2d7874eeea1b9ef8779b443b0

public class SpoonacularTest extends AbstractAuthTest{
    static String getRecipeURL = "recipes/complexSearch";
    static String postRecipeURL = "recipes/cuisine";

    @Test
    void getSearchPizzaSausage() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "pizza")
                .queryParam("cuisine", "italian")
                .queryParam("includeIngredients", "tomato,cheese,sausage")
                .when()
                .get(getBaseURL()+getRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void getSearchIngredients() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("titleMatch", "beet")
                .queryParam("maxReadyTime", 30)
                .when()
                .get(getBaseURL()+getRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void getSearchSearchDishVitamin() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("minVitaminA", 5)
                .queryParam("minVitaminC", 5)
                .queryParam("minVitaminD", 5)
                .queryParam("minVitaminE", 5)
                .queryParam("minVitaminK", 5)
                .when()
                .get(getBaseURL()+getRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void getSearchNutritional() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "Hot Dog")
                .queryParam("cuisine", "american")
                .queryParam("addRecipeNutrition", "true")
                .when()
                .get(getBaseURL()+getRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void getSearchBeetween() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "soup")
                .queryParam("cuisine", "indian")
                .queryParam("number", 1)
                .when()
                .get(getBaseURL()+getRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void getSearchCuisinesRecipes() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "burger")
                .queryParam("excludeCuisine", "greek,mexican,vietnamese")
                .when()
                .get(getBaseURL()+getRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void getSearchFillIngredients() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "bread")
                .queryParam("fillIngredients", "true")
                .queryParam("number", 1)
                .when()
                .get(getBaseURL()+getRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void getSearchExceptionIngredients() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "pilaf")
                .queryParam("excludeIngredients", "rice")
                .when()
                .get(getBaseURL()+getRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void getSearchTypeRecipe() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "cake")
                .queryParam("cuisine", "irish")
                .queryParam("type", "dessert")
                .when()
                .get(getBaseURL()+getRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void getSearchInstrucionRecipe() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "meat")
                .queryParam("cuisine", "thai")
                .queryParam("instructionsRequired", "true")
                .queryParam("addRecipeInformation", "true")
                .when()
                .get(getBaseURL()+getRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void getSearchAuthor() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("author", "coffeebean")
                .when()
                .get(getBaseURL()+getRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void getSearchRecipeId() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("recipeBoxId", 2468)
                .when()
                .get(getBaseURL()+getRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void getSearchSort() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("sort", "healthiness")
                .queryParam("sortDirection", "asc")
                .queryParam("number", 10)
                .queryParam("addRecipeNutrition", "true")
                .when()
                .get(getBaseURL()+getRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void getSearchRecipeLicense() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("limitLicense", "true")
                .queryParam("number", 2)
                .when()
                .get(getBaseURL()+getRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void getSearchRecipeCalories() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("maxCalories", 800)
                .queryParam("number", 1)
                .when()
                .get(getBaseURL()+getRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void getSearchRecipeFat() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("minFat", 100)
                .when()
                .get(getBaseURL()+getRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void getSearchRecipeIntolerants() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "italian")
                .queryParam("intolerances", "Dairy,Egg,Gluten")
                .queryParam("number", 5)
                .when()
                .get(getBaseURL()+getRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void getSearchRecipeDiet() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "british")
                .queryParam("diet", "Vegetarian")
                .queryParam("number", 3)
                .when()
                .get(getBaseURL()+getRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void getSearchRecipeEquipment() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "france")
                .queryParam("equipment", "blender, frying pan, bowl")
                .queryParam("number", 2)
                .when()
                .get(getBaseURL()+getRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void getSearchComplex() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "meat")
                .queryParam("cuisine", "american")
                .queryParam("equipment", "grinder")
                .queryParam("addRecipeInformation", "true")
                .queryParam("instructionsRequired", "true")
                .queryParam("maxReadyTime", 180)
                .queryParam("maxFat", 50)
                .queryParam("maxCalories", 500)
                .queryParam("fillIngredients", "tomato")
                .queryParam("sort", "total-fat")
                .queryParam("sortDirection", "asc")
                .queryParam("minProtein", 50)
                .queryParam("minIron", 50)
                .queryParam("offset", 41)
                .when()
                .get(getBaseURL()+getRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void postCuicineTitle() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Cauliflower, Brown Rice, and Vegetable Fried Rice")
                .when()
                .post(getBaseURL()+postRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void postCuicineTitle1() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Healthy Cauliflower Soup with Bacon and Chili Oil")
                .when()
                .post(getBaseURL()+postRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void postCuicineTitle2() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Thai Coconut Beetroot Soup")
                .when()
                .post(getBaseURL()+postRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void postCuicineTitle3() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Black Bean Soup With Pico De Gallo and Chipotle Creme")
                .when()
                .post(getBaseURL()+postRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void postCuicineTitle4() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Healthy Cabbage Soup with Spicy Kimchi")
                .when()
                .post(getBaseURL()+postRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void postCuicineTitle5() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Spinach Soup With Wontons")
                .when()
                .post(getBaseURL()+postRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void postCuicineTitle6() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Miso Soup With Thin Noodles")
                .when()
                .post(getBaseURL()+postRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void postCuicineTitleIngredients() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Madeleines With Irish Whiskey Fudge")
                .formParam("ingredientList","Milk\n" +
                        "Eggs\n" +
                        "Other Dairy")
                .when()
                .post(getBaseURL()+postRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void postCuicineLangEn() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Healthy Tomato Soup with Coconut and Curry")
                .when()
                .post(getBaseURL()+postRecipeURL)
                .then()
                .statusCode(200);
    }

    @Test
    void postCuicineLangDe() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "de")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Healthy Tomato Soup with Coconut and Curry")
                .when()
                .post(getBaseURL()+postRecipeURL)
                .then()
                .statusCode(200);
    }




}
