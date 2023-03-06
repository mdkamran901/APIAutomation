package com.DoctorAPIs;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.DoctorEndPoints;
import com.TokenAuthentication.GenerateTokenDoctorUser;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetPersonAttributeTypeQuestionPatientSearchByprojectId {
	
	static GenerateTokenDoctorUser tg = new GenerateTokenDoctorUser();
	static String accessToken = tg.getAccessToken();

	
	@Test
	public static void getPersonAttributeTypeQuestionPatientSearchByprojectId() {
		
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.queryParam("project_Id", "152")
				//.queryParam("value", "1234567890123456")
						.log().all()
						.get(DoctorEndPoints.PersonAttributeTypeQuestionPatientSearchByprojectId);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		// System.out.println(response.getBody().asString())
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("project_id"), true 
				/*Actual Value*/, "Response body contains project_id");
	
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}

}
