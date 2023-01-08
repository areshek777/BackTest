package Lesson4;

import org.example.AddMealRequest;
import org.example.AddMealResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.trustStore;
import static org.hamcrest.MatcherAssert.assertThat;

public class SpoonacularTest extends AbstractAuthTest{
    static String getRecipeURL = "recipes/complexSearch";
    static String postRecipeURL = "recipes/cuisine";
    public AddMealRequest addMeal;

    @Test
    void getSearchPizzaSausage() {
        given()
                .spec(getRequestSpecification())
                .queryParam("query", "pizza")
                .queryParam("cuisine", "italian")
                .queryParam("includeIngredients", "tomato,cheese,sausage")
                .when()
                .get(getBaseUrl()+getRecipeURL)
                .then()
                .spec(responseSpecification);
    }

    @Test
    void getSearchIngredients() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("titleMatch", "beet")
                .queryParam("maxReadyTime", 30)
                .when()
                .get(getBaseUrl()+getRecipeURL)
                .then()
                .spec(responseSpecification);
    }

    @Test
    void getSearchSearchDishVitamin() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("minVitaminA", 5)
                .queryParam("minVitaminC", 5)
                .queryParam("minVitaminD", 5)
                .queryParam("minVitaminE", 5)
                .queryParam("minVitaminK", 5)
                .when()
                .get(getBaseUrl()+getRecipeURL)
                .then()
                .spec(responseSpecification);
    }

    @Test
    void getSearchNutritional() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "Hot Dog")
                .queryParam("cuisine", "american")
                .queryParam("addRecipeNutrition", "true")
                .when()
                .get(getBaseUrl()+getRecipeURL)
                .then()
                .spec(responseSpecification);
    }

    @Test
    void getSearchBeetween() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "soup")
                .queryParam("cuisine", "indian")
                .queryParam("number", 1)
                .when()
                .get(getBaseUrl()+getRecipeURL)
                .then()
                .spec(responseSpecification);
    }

    @Test
    void getSearchCuisinesRecipes() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "burger")
                .queryParam("excludeCuisine", "greek,mexican,vietnamese")
                .when()
                .get(getBaseUrl()+getRecipeURL)
                .then()
                .spec(responseSpecification);
    }

    @Test
    void getSearchFillIngredients() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "bread")
                .queryParam("fillIngredients", "true")
                .queryParam("number", 1)
                .when()
                .get(getBaseUrl()+getRecipeURL)
                .then()
                .spec(responseSpecification);
    }

    @Test
    void getSearchExceptionIngredients() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "pilaf")
                .queryParam("excludeIngredients", "rice")
                .when()
                .get(getBaseUrl()+getRecipeURL)
                .then()
                .spec(responseSpecification);
    }

    @Test
    void getSearchTypeRecipe() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "cake")
                .queryParam("cuisine", "irish")
                .queryParam("type", "dessert")
                .when()
                .get(getBaseUrl()+getRecipeURL)
                .then()
                .spec(responseSpecification);
    }

    @Test
    void getSearchInstrucionRecipe() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "meat")
                .queryParam("cuisine", "thai")
                .queryParam("instructionsRequired", "true")
                .queryParam("addRecipeInformation", "true")
                .when()
                .get(getBaseUrl()+getRecipeURL)
                .then()
                .spec(responseSpecification);
    }

    @Test
    void getSearchAuthor() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("author", "coffeebean")
                .when()
                .get(getBaseUrl()+getRecipeURL)
                .then()
                .spec(responseSpecification);
    }

    @Test
    void getSearchRecipeId() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("recipeBoxId", 2468)
                .when()
                .get(getBaseUrl()+getRecipeURL)
                .then()
                .spec(responseSpecification);
    }

    @Test
    void getSearchSort() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("sort", "healthiness")
                .queryParam("sortDirection", "asc")
                .queryParam("number", 10)
                .queryParam("addRecipeNutrition", "true")
                .when()
                .get(getBaseUrl()+getRecipeURL)
                .then()
                .spec(responseSpecification);
    }

    @Test
    void getSearchRecipeLicense() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("limitLicense", "true")
                .queryParam("number", 2)
                .when()
                .get(getBaseUrl()+getRecipeURL)
                .then()
                .spec(responseSpecification);
    }

    @Test
    void getSearchRecipeCalories() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("maxCalories", 800)
                .queryParam("number", 1)
                .when()
                .get(getBaseUrl()+getRecipeURL)
                .then()
                .spec(responseSpecification);
    }

    @Test
    void getSearchRecipeFat() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("minFat", 100)
                .when()
                .get(getBaseUrl()+getRecipeURL)
                .then()
                .spec(responseSpecification);
    }

    @Test
    void getSearchRecipeIntolerants() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "italian")
                .queryParam("intolerances", "Dairy,Egg,Gluten")
                .queryParam("number", 5)
                .when()
                .get(getBaseUrl()+getRecipeURL)
                .then()
                .spec(responseSpecification);
    }

    @Test
    void getSearchRecipeDiet() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "british")
                .queryParam("diet", "Vegetarian")
                .queryParam("number", 3)
                .when()
                .get(getBaseUrl()+getRecipeURL)
                .then()
                .spec(responseSpecification);
    }

    @Test
    void getSearchRecipeEquipment() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "france")
                .queryParam("equipment", "blender, frying pan, bowl")
                .queryParam("number", 2)
                .when()
                .get(getBaseUrl()+getRecipeURL)
                .then()
                .spec(responseSpecification);
    }

    @Test
    void getSearchComplex() {
        given()
                .spec(getRequestSpecification())
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
                .get(getBaseUrl()+getRecipeURL)
                .then()
                .spec(responseSpecification);
    }

    @Test
    void postCuicineTitle() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .formParam("title","Cauliflower, Brown Rice, and Vegetable Fried Rice")
                .when()
                .post(getBaseUrl()+postRecipeURL).prettyPeek()
                .then()
                .spec(responseSpecification);
    }

    @Test
    void postCuicineTitle1() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .formParam("title","Healthy Cauliflower Soup with Bacon and Chili Oil")
                .when()
                .post(getBaseUrl()+postRecipeURL).prettyPeek()
                .then()
                .spec(responseSpecification);
    }

    @Test
    void postCuicineTitle2() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .formParam("title","Thai Coconut Beetroot Soup")
                .when()
                .post(getBaseUrl()+postRecipeURL).prettyPeek()
                .then()
                .spec(responseSpecification);
    }

    @Test
    void postCuicineTitle3() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .formParam("title","Black Bean Soup With Pico De Gallo and Chipotle Creme")
                .when()
                .post(getBaseUrl()+postRecipeURL).prettyPeek()
                .then()
                .spec(responseSpecification);
    }

    @Test
    void postCuicineTitle4() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .formParam("title","Healthy Cabbage Soup with Spicy Kimchi")
                .when()
                .post(getBaseUrl()+postRecipeURL).prettyPeek()
                .then()
                .spec(responseSpecification);
    }

    @Test
    void postCuicineTitle5() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .formParam("title","Spinach Soup With Wontons")
                .when()
                .post(getBaseUrl()+postRecipeURL).prettyPeek()
                .then()
                .spec(responseSpecification);
    }

    @Test
    void postCuicineTitle6() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .formParam("title","Miso Soup With Thin Noodles")
                .when()
                .post(getBaseUrl()+postRecipeURL).prettyPeek()
                .then()
                .spec(responseSpecification);
    }

    @Test
    void postCuicineTitleIngredients() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .formParam("title","Madeleines With Irish Whiskey Fudge")
                .formParam("ingredientList","Milk\n" +
                        "Eggs\n" +
                        "Other Dairy")
                .when()
                .post(getBaseUrl()+postRecipeURL).prettyPeek()
                .then()
                .spec(responseSpecification);
    }

    @Test
    void postCuicineLangEn() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .formParam("title","Healthy Tomato Soup with Coconut and Curry")
                .when()
                .post(getBaseUrl()+postRecipeURL).prettyPeek()
                .then()
                .spec(responseSpecification);
    }

    @Test
    void postCuicineLangDe() {
        given()
                .spec(getRequestSpecification())
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "de")
                .formParam("title","Healthy Tomato Soup with Coconut and Curry")
                .when()
                .post(getBaseUrl()+postRecipeURL).prettyPeek()
                .then()
                .spec(responseSpecification);
    }

    @Test
    void getMealEndpoint(){
        addMeal = new AddMealRequest();
        given()
                .spec(getRequestSpecificationAdd())
                .body(addMeal)
                .when()
                .post("https://api.spoonacular.com/mealplanner/areshek6/shopping-list/items").prettyPeek()
                .then()
                .spec(responseSpecification);

        AddMealResponse resp = given().spec(getRequestSpecificationAdd())
                .when()
                .get("https://api.spoonacular.com/mealplanner/areshek6/shopping-list").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(AddMealResponse.class);

                Integer id = resp.getId();

        given()
                .spec(getRequestSpecificationAdd1())
                .when()
                .delete("https://api.spoonacular.com/mealplanner/areshek6/shopping-list/items/"+id).prettyPeek()
                .then()
                .spec(responseSpecification);




    }

}
