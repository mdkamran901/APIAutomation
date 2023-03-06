package com.MorbidityLanguage.webAdmin.ProjectMorbidityVisit;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllMethod_VisitRole {

	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();
	
	@Test(priority=1)
	public static void post_VisitRole() {
		
		String jsonBody ="{\r\n"
				+ "  \"visit_id\": 25,\r\n"
				+ "  \"role\": \"ASHA\",\r\n"
				+ "  \"visit_role_name\": \"Testing\",\r\n"
				+ "  \"priority\": \"123\",\r\n"
				+ "  \"is_active\": true,\r\n"
				+ "  \"created_by\": 103,\r\n"
				+ "  \"created_on\": \"2022-07-27T12:42:29.000Z\",\r\n"
				+ "  \"is_deleted\": false\r\n"
				+ "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.AllMethodVisitRole);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in MorbidityBank table successfully");
		
		
	}
	@Test(priority=2)
	public static void get_VisitRole() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				//.queryParam("rolename", "SuperAdmin")
				//.queryParam("userid", "103")
						.log().all()
						.get(SuperAdminEndPoints.AllMethodVisitRole);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("visit_role_id"), true 
				/*Actual Value*/, "Response body contains visit_role_id");
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}
	@Test(priority=3)
	public static void update_VisitRole() {
			
			String jsonBody ="{\r\n"
					+ "  \"visit_role_id\": 37,\r\n"
					+ "  \"visit_id\": 22,\r\n"
					+ "  \"visit_role_name\": \"tested\",\r\n"
					+ "  \"role\": \"Anonymous\",\r\n"
					+ "  \"priority\": 3,\r\n"
					+ "  \"is_active\": true,\r\n"
					+ "  \"is_deleted\": false,\r\n"
					+ "  \"created_by\": 100,\r\n"
					+ "  \"created_on\": \"2022-07-27T12:53:54\",\r\n"
					+ "  \"updated_by\": 100,\r\n"
					+ "  \"updated_on\": \"2022-07-27T13:29:21.000Z\"\r\n"
					+ "}";
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.body(jsonBody)
					        .log().all()
							.put(SuperAdminEndPoints.AllMethodVisitRole);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "U0001");
			Assert.assertEquals(response.getBody().path("description"),"Record is updated in mw_visit_role table successfully");
	}
//@Test(priority=4)
	public static void delete_VisitRole() {
			
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.pathParam("morbidity_bank_id", "97")
					        .log().all()
							.delete(SuperAdminEndPoints.AllMethodVisitRole);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "D0001");
			Assert.assertEquals(response.getBody().path("statusValue"), "Record deleted successfully");
			Assert.assertEquals(response.getBody().path("description"), "Record deleted successfully");
	}
}
