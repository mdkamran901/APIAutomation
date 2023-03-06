package com.SuperAdminAPIs;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ConstantData.WebConstantData;
import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.GenerateTokenWebUser;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GET_ProjectByRoleName {
	
	static GenerateTokenWebUser tg = new GenerateTokenWebUser();
	static String accessToken = tg.getAccessToken();
	
	@Test
	public static void GET_projectByRoleName() {
		WebConstantData cd = new WebConstantData();
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.queryParam("rolename", cd.getRoleName())
				.queryParam("userid", cd.getUserid())
						.log().all()
						.get(SuperAdminEndPoints.GETProjectByRoleName);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
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
