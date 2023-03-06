package com.AshaAPIs;

import static io.restassured.RestAssured.given;
import org.testng.Assert;

import com.ConstantData.AshaContantData;
import com.EndPoints.Asha_Endpoints;
import com.TokenAuthentication.GenerateTokenAshaUser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetProjectByuserId {
	//static GenerateTokenAshaUser tg = new GenerateTokenAshaUser();
	//String accessToken = tg.getAccessToken();
	
	public static void getprojectByuserId() {
		AshaContantData cd = new AshaContantData();
		GenerateTokenAshaUser tg = new GenerateTokenAshaUser();
		String accessToken = tg.getAccessToken();
		Response response =

				given()
				.header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
						.queryParams("userId", cd.getUserid())
						.log().all()
						.get(Asha_Endpoints.ProjectByuserId);

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