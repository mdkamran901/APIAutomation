package com.MorbidityLanguage.webAdmin.MorbidityManagement;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GET_ProjectMorbidityOutputQuestion {
	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();

	@Test
	public static void get_ProjectMorbidityOutputQuestion() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.queryParam("project_morbidity_output_section_id", "0")
				.queryParam("project_morbidity_output_id", "0")
				.queryParam("project_morbidity_output_question", "")
				.queryParam("userid", "117")
				.queryParam("rolename", "SuperAdmin")
						.log().all()
						.get(SuperAdminEndPoints.GetProjectMorbidityOutputQuestion);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("project_morbidity_output_question_id"), true 
				/*Actual Value*/, "Response body contains project_morbidity_output_question_id");
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}


}
