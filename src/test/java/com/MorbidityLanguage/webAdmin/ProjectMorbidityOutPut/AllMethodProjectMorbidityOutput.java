package com.MorbidityLanguage.webAdmin.ProjectMorbidityOutPut;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllMethodProjectMorbidityOutput {
	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();
	
	@Test(priority=1)
	public static void post_MethodProjectMorbidityOutput() {
		
		String jsonBody ="{\r\n"
				+ "  \"project_morbidity_output_id\": 0,\r\n"
				+ "  \"morbidity_output_bank_id\": 17,\r\n"
				+ "  \"project_id\": 125,\r\n"
				+ "  \"project_morbidity_output_name\": \"blood test output\",\r\n"
				+ "  \"project_morbidity_questions_count\": 0,\r\n"
				+ "  \"project_morbidity_copied_from\": 0,\r\n"
				+ "  \"project_morbidity_output_is_description\": true,\r\n"
				+ "  \"project_morbidity_output_description\": \"Testing kamran\",\r\n"
				+ "  \"start_date\": \"2022-07-24T18:30:00.000Z\",\r\n"
				+ "  \"end_date\": \"2022-07-26T18:30:00.000Z\",\r\n"
				+ "  \"is_active\": true,\r\n"
				+ "  \"created_by\": 103,\r\n"
				+ "  \"created_on\": \"2022-07-25T06:52:30.000Z\",\r\n"
				+ "  \"is_deleted\": false\r\n"
				+ "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.allMethodProjectMorbidityOutput);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in MorbidityBank table successfully");
		
		
	}
	@Test(priority=2)
	public static void get_MethodProjectMorbidityOutput() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.queryParam("rolename", "SuperAdmin")
				.queryParam("userid", "103")
						.log().all()
						.get(SuperAdminEndPoints.allMethodProjectMorbidityOutput);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("project_morbidity_output_id"), true 
				/*Actual Value*/, "Response body contains project_morbidity_output_id");
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}
	@Test(priority=3)
	public static void update_MethodProjectMorbidityOutput() {
			
			String jsonBody ="{\r\n"
					+ "  \"project_morbidity_output_id\": 35,\r\n"
					+ "  \"morbidity_output_bank_id\": 17,\r\n"
					+ "  \"project_id\": 125,\r\n"
					+ "  \"project_morbidity_output_name\": \"blood test output\",\r\n"
					+ "  \"project_morbidity_questions_count\": 0,\r\n"
					+ "  \"project_morbidity_copied_from\": 0,\r\n"
					+ "  \"project_morbidity_output_is_description\": true,\r\n"
					+ "  \"project_morbidity_output_description\": \"Testing kamran\",\r\n"
					+ "  \"start_date\": \"2022-07-24T18:30:00\",\r\n"
					+ "  \"end_date\": \"2022-07-26T18:30:00\",\r\n"
					+ "  \"is_active\": true,\r\n"
					+ "  \"created_by\": 103,\r\n"
					+ "  \"created_on\": \"2022-07-25T06:52:30\",\r\n"
					+ "  \"updated_by\": 103,\r\n"
					+ "  \"updated_on\": \"2022-07-25T09:59:28.000Z\",\r\n"
					+ "  \"is_deleted\": false\r\n"
					+ "}";
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.body(jsonBody)
					        .log().all()
							.put(SuperAdminEndPoints.allMethodProjectMorbidityOutput);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "U0001");
			Assert.assertEquals(response.getBody().path("description"),"Record is updated in mw_project_morbidity_output table successfully");
	}
//@Test(priority=4)
	public static void delete_MethodProjectMorbidityOutput() {
			
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.pathParam("morbidity_bank_id", "97")
					        .log().all()
							.delete(SuperAdminEndPoints.allMethodProjectMorbidityOutput);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "D0001");
			Assert.assertEquals(response.getBody().path("statusValue"), "Record deleted successfully");
			Assert.assertEquals(response.getBody().path("description"), "Record deleted successfully");
	}

}
