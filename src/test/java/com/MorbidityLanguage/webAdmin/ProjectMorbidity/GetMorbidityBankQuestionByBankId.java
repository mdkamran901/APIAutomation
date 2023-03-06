package com.MorbidityLanguage.webAdmin.ProjectMorbidity;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetMorbidityBankQuestionByBankId {
	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();

	@Test
	public static void getMorbidityBankQuestionByBankId() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.queryParam("morbiditybankId", "79")
				.queryParam("morbiditybankpageId", "126")
				//.queryParam("question", "test")
				//.queryParam("userid", "103")
				//.queryParam("rolename", "SuperAdmin")
						.log().all()
						.get(SuperAdminEndPoints.MorbidityBankQuestionByMorbidityBankId);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("morbidity_bank_question_id"), true 
				/*Actual Value*/, "Response body contains morbidity_bank_question_id");
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}


}
