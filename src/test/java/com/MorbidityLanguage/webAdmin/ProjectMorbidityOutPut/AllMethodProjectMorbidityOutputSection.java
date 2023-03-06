package com.MorbidityLanguage.webAdmin.ProjectMorbidityOutPut;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllMethodProjectMorbidityOutputSection {
	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();
	
	@Test(priority=1)
	public static void post_MethodProjectMorbidityOutputSection() {
		
		String jsonBody ="{\r\n"
				+ "  \"project_morbidity_output_section_id\": 0,\r\n"
				+ "  \"project_morbidity_output_id\": 33,\r\n"
				+ "  \"morbidity_output_bank_id\": 17,\r\n"
				+ "  \"morbidity_output_section_id\": 27,\r\n"
				+ "  \"project_morbidity_output_section\": \"1a\",\r\n"
				+ "  \"project_morbidity_output_sectionno\": \"123\",\r\n"
				+ "  \"sequence\": \"123\",\r\n"
				+ "  \"is_active\": true,\r\n"
				+ "  \"created_by\": 103,\r\n"
				+ "  \"created_on\": \"2022-07-25T12:58:16.000Z\",\r\n"
				+ "  \"is_deleted\": false\r\n"
				+ "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.allMethodPProjectMorbidityOutputSection);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in MorbidityBank table successfully");
		
		
	}
	@Test(priority=2)
	public static void get_MethodProjectMorbidityOutputSection() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.queryParam("project_morbidity_output_id", "33")
				.queryParam("rolename", "SuperAdmin")
				.queryParam("userid", "103")
						.log().all()
						.get(SuperAdminEndPoints.allMethodPProjectMorbidityOutputSection);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("project_morbidity_output_section_id"), true 
				/*Actual Value*/, "Response body contains project_morbidity_output_section_id");
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}
	@Test(priority=3)
	public static void update_MethodProjectMorbidityOutputSection() {
			
			String jsonBody ="{\r\n"
					+ "  \"project_morbidity_output_section_id\": 48,\r\n"
					+ "  \"project_morbidity_output_id\": 33,\r\n"
					+ "  \"morbidity_output_bank_id\": 17,\r\n"
					+ "  \"project_morbidity_output_section\": \"1a\",\r\n"
					+ "  \"project_morbidity_output_sectionno\": \"123\",\r\n"
					+ "  \"morbidity_output_section_id\": 27,\r\n"
					+ "  \"sequence\": 123,\r\n"
					+ "  \"is_active\": true,\r\n"
					+ "  \"created_by\": 103,\r\n"
					+ "  \"created_on\": \"2022-07-25T12:58:16\",\r\n"
					+ "  \"updated_by\": 103,\r\n"
					+ "  \"updated_on\": \"2022-07-25T13:03:15.000Z\",\r\n"
					+ "  \"is_deleted\": false\r\n"
					+ "}";
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.body(jsonBody)
					        .log().all()
							.put(SuperAdminEndPoints.allMethodPProjectMorbidityOutputSection);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "U0001");
			Assert.assertEquals(response.getBody().path("description"),"Record is updated in mw_project_morbidity_output_section table successfully");
	}
//@Test(priority=4)
	public static void delete_MethodProjectMorbidityOutputSection() {
			
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.pathParam("morbidity_bank_id", "97")
					        .log().all()
							.delete(SuperAdminEndPoints.allMethodPProjectMorbidityOutputSection);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "D0001");
			Assert.assertEquals(response.getBody().path("statusValue"), "Record deleted successfully");
			Assert.assertEquals(response.getBody().path("description"), "Record deleted successfully");
	}

}



