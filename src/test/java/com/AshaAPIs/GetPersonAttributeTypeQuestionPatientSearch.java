package com.AshaAPIs;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.Asha_Endpoints;
import com.TokenAuthentication.GenerateTokenAshaUser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetPersonAttributeTypeQuestionPatientSearch {
	
	static GenerateTokenAshaUser tg = new GenerateTokenAshaUser();
	static String accessToken = tg.getAccessToken();

	@Test
	public static void getpersonAttributeTypeQuestionPatientSearch() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
						.queryParam("project_Id", "152")
						.queryParam("value", "1234567890123456")
						.log().all()
						.get(Asha_Endpoints.PersonAttributeTypeQuestionPatientSearchByprojectId);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		//String bodyAsString = response.getBody().asString();
	//	Assert.assertEquals(bodyAsString.contains("mask_Validations"), true 
		//		/*Actual Value*/, "Response body contains mask_Validations");
	
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}

}
