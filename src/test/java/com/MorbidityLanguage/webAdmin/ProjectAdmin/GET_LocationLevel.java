package com.MorbidityLanguage.webAdmin.ProjectAdmin;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.ProjectAdminEndPoints;
import com.TokenAuthentication.GenerateTokenProjectAdmin;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GET_LocationLevel {
	
	static GenerateTokenProjectAdmin tg = new GenerateTokenProjectAdmin();
	static String accessToken = tg.getAccessToken();

	@Test
	public static void GET_LocationLevelByLocation_Level() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.queryParam("location_level", "INDIA")
				.queryParam("language_id", "0")
				.log().all()
						.get(ProjectAdminEndPoints.GETLocationLevel1Bylocation_level);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("mst_location_level1_id"), true 
				/*Actual Value*/, "Response body contains mst_location_level1_id");
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}

}
