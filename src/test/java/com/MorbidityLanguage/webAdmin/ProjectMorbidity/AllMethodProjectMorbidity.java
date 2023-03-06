package com.MorbidityLanguage.webAdmin.ProjectMorbidity;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllMethodProjectMorbidity {
	

	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();
	
	@Test(priority=1)
	public static void postProjectMorbidity() {
		
		String jsonBody ="{\r\n"
				+ "  \"morbidity_bank_id\": 99,\r\n"
				+ "  \"project_id\": 152,\r\n"
				+ "  \"project_morbidity_name\": \"Blood Bank Test\",\r\n"
				+ "  \"project_morbidity_questions_count\": 0,\r\n"
				+ "  \"project_morbidity_copied_from\": 0,\r\n"
				+ "  \"project_morbidity_is_disclaimer\": true,\r\n"
				+ "  \"project_morbidity_disclaimer\": \"Testing\",\r\n"
				+ "  \"project_morbidity_start_date\": \"2022-07-26T18:30:00.000Z\",\r\n"
				+ "  \"project_morbidity_end_date\": \"2022-07-26T18:30:00.000Z\",\r\n"
				+ "  \"project_morbidity_is_active\": true,\r\n"
				+ "  \"project_morbidity_is_deleted\": false,\r\n"
				+ "  \"project_morbidity_created_by\": 103,\r\n"
				+ "  \"project_morbidity_created_on\": \"2022-07-20T15:07:15.000Z\"\r\n"
				+ "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.projectMorbidity);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in MorbidityBank table successfully");
		
		
	}
	@Test(priority=2)
	public static void getProjectMorbidity() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.queryParam("morbiditybankname", "kamran Blood bank")
				.queryParam("project_morbidity_name", "bimaltest")
				.queryParam("ProjectId", "0")
				.queryParam("userid", "103")
				.queryParam("rolename", "SuperAdmin")
						.log().all()
						.get(SuperAdminEndPoints.projectMorbidity);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("project_morbidity_id"), true 
				/*Actual Value*/, "Response body contains project_morbidity_id");
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}
	@Test(priority=3)
	public static void updateProjectMorbidity() {
			
			String jsonBody ="{\r\n"
					+ "  \"morbidity_bank_id\": 99,\r\n"
					+ "  \"project_id\": 152,\r\n"
					+ "  \"project_morbidity_name\": \"Blood Bank Test\",\r\n"
					+ "  \"project_morbidity_questions_count\": 0,\r\n"
					+ "  \"project_morbidity_copied_from\": 0,\r\n"
					+ "  \"project_morbidity_is_disclaimer\": true,\r\n"
					+ "  \"project_morbidity_disclaimer\": \"Blood Testing\",\r\n"
					+ "  \"project_morbidity_start_date\": \"2022-07-26T18:30:00\",\r\n"
					+ "  \"project_morbidity_end_date\": \"2022-07-26T18:30:00\",\r\n"
					+ "  \"project_morbidity_is_active\": true,\r\n"
					+ "  \"project_morbidity_is_deleted\": false,\r\n"
					+ "  \"project_morbidity_created_by\": 103,\r\n"
					+ "  \"project_morbidity_created_on\": \"2022-07-20T15:07:15\",\r\n"
					+ "  \"project_morbidity_id\": 71,\r\n"
					+ "  \"project_morbidity_updated_by\": 103,\r\n"
					+ "  \"project_morbidity_updated_on\": \"2022-07-20T15:09:15.000Z\"\r\n"
					+ "}";
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.body(jsonBody)
					        .log().all()
							.put(SuperAdminEndPoints.projectMorbidity);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "U0001");
			Assert.assertEquals(response.getBody().path("description"),"Record is updated in mw_project_morbidity table successfully");
	}
//@Test(priority=4)
	public static void deleteProjectMorbidity() {
			
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.pathParam("morbidity_bank_id", "97")
					        .log().all()
							.delete(SuperAdminEndPoints.projectMorbidity);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "D0001");
			Assert.assertEquals(response.getBody().path("statusValue"), "Record deleted successfully");
			Assert.assertEquals(response.getBody().path("description"), "Record deleted successfully");
	}
}


