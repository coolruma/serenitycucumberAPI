package serenity.api;

import static org.hamcrest.Matchers.is;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CountriesSearchSteps {
	private String ISO_CODE_SEARCH = "http://services.groupkt.com/country/get/iso2code/";
	   private Response response;

	   @Step
	   public void searchCountryByCode(String code){
	       response = SerenityRest.when().get(ISO_CODE_SEARCH + code);
	   }

	   @Step
	   public void searchIsExecutedSuccesfully(){
	       response.then().statusCode(200);
	   }

	   @Step
	   public void iShouldFindCountry(String country){
	       response.then().body("RestResponse.result.name", is(country));
	   }
	   
	   @Step
	   public void runAPostRequest(){
		   Map<String,String> bodyMap=new HashMap<String, String>();
		   bodyMap.put("title", "foo");
		   bodyMap.put("body", "bar");
		   bodyMap.put("userId", "1");
		   SerenityRest.given().contentType("application/json")
		   .body(bodyMap)
		   .when().post("http://jsonplaceholder.typicode.com/posts")
	    		   .then().assertThat().statusCode(201).
	    		   and().body("id", is(101));
	   }
}
