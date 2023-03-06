package com.DoctorAPIs;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.DoctorEndPoints;
import com.TokenAuthentication.GenerateTokenDoctorUser;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetDynamicProjectMorbidityByprojectMorbidityEvaluationListpatient_id {
	
	static GenerateTokenDoctorUser tg = new GenerateTokenDoctorUser();
	static String accessToken = tg.getAccessToken();
	
	@Test
	public static void getDynamicProjectMorbidityByprojectMorbidityEvaluationListpatient_id() {
		 
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
						.queryParams("projectMorbidityEvaluationList.patient_id", "458")
						.log().all()
						.get(DoctorEndPoints.DynamicProjectMorbidityByprojectMorbidityEvaluationListpatient_id);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		// System.out.println(response.getBody().asString())
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("totalcount"), true 
				/*Actual Value*/, "Response body contains totalcount");
	
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}

}
