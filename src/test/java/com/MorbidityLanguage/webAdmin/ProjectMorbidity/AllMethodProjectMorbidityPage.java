package com.MorbidityLanguage.webAdmin.ProjectMorbidity;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllMethodProjectMorbidityPage {

	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();

	@Test(priority = 1)
	public static void post_ProjectMorbidityPage() {

		String jsonBody = "{\r\n" + "  \"project_morbidity_id\": 64,\r\n" + "  \"morbidity_bank_id\": 83,\r\n"
				+ "  \"morbidity_bank_page_id\": 132,\r\n" + "  \"project_morbidity_pageno\": \"A\",\r\n"
				+ "  \"project_morbidity_page\": \"Fever\",\r\n" + "  \"project_morbidity_page_sequence\": 1,\r\n"
				+ "  \"project_morbidity_page_is_active\": true,\r\n"
				+ "  \"project_morbidity_page_is_deleted\": false,\r\n"
				+ "  \"project_morbidity_page_created_by\": 103,\r\n"
				+ "  \"project_morbidity_page_created_on\": \"2022-07-20T18:10:29.000Z\"\r\n" + "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON).body(jsonBody)
						.log().all().post(SuperAdminEndPoints.ProjectMorbidityPage);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		// Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		// Assert.assertEquals(response.getBody().path("statusValue"), "Record saved
		// successfully");
		// Assert.assertEquals(response.getBody().path("description"), "Record is
		// inserted in MorbidityBank table successfully");

	}

	@Test(priority = 2)
	public static void get_MProjectMorbidityPage() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
						.queryParam("projectmorbidityId", "68").queryParam("projectmorbiditypage", "bimaltesting 3")
						.queryParam("userid", "103").queryParam("rolename", "SuperAdmin").log().all()
						.get(SuperAdminEndPoints.ProjectMorbidityPage);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		// System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("project_morbidity_page_id"), true
		/* Actual Value */, "Response body contains project_morbidity_page_id");

		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}

	@Test(priority = 3)
	public static void update_ProjectMorbidityPage() {

		String jsonBody = "{\r\n" + "  \"project_morbidity_page_id\": 141,\r\n" + "  \"project_morbidity_id\": 64,\r\n"
				+ "  \"morbidity_bank_id\": 83,\r\n" + "  \"morbidity_bank_page_id\": 132,\r\n"
				+ "  \"project_morbidity_pageno\": \"A\",\r\n" + "  \"project_morbidity_page\": \"Fever\",\r\n"
				+ "  \"project_morbidity_page_sequence\": 1,\r\n" + "  \"project_morbidity_page_is_active\": true,\r\n"
				+ "  \"project_morbidity_page_is_deleted\": false,\r\n"
				+ "  \"project_morbidity_page_created_by\": 103,\r\n"
				+ "  \"project_morbidity_page_created_on\": \"2022-07-20T18:10:29\",\r\n"
				+ "  \"project_morbidity_page_updated_by\": 103,\r\n"
				+ "  \"project_morbidity_page_updated_on\": \"2022-07-20T18:11:56.000Z\"\r\n" + "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON).body(jsonBody)
						.log().all().put(SuperAdminEndPoints.ProjectMorbidityPage);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.getBody().path("statusCode"), "U0001");
		Assert.assertEquals(response.getBody().path("description"),
				"Record is updated in mw_project_morbidity_page table successfully");
	}

	// @Test(priority=4)
	public static void delete_ProjectMorbidityPage() {

		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
						.pathParam("morbidity_bank_id", "97").log().all().delete(SuperAdminEndPoints.ProjectMorbidityPage);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.getBody().path("statusCode"), "D0001");
		Assert.assertEquals(response.getBody().path("statusValue"), "Record deleted successfully");
		Assert.assertEquals(response.getBody().path("description"), "Record deleted successfully");
	}

}
