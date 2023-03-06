package com.MorbidityLanguage.webAdmin.ProjectMorbidity;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllMethodProjectMorbidityQuestion {

	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();

	@Test(priority = 1)
	public static void post_ProjectMorbidityQuestio() {

		String jsonBody = "{\r\n"
				+ "  \"project_morbidity_question_type_id\": 9,\r\n"
				+ "  \"morbidity_bank_id\": 68,\r\n"
				+ "  \"morbidity_bank_page_id\": 151,\r\n"
				+ "  \"project_morbidity_question_no\": \"kamran Patient History 4\",\r\n"
				+ "  \"project_morbidity_question\": \"Testing\",\r\n"
				+ "  \"morbidity_bank_question_instructions\": \"Testing\",\r\n"
				+ "  \"project_morbidity_question_is_active\": true,\r\n"
				+ "  \"project_morbidity_question_sequence\": 2,\r\n"
				+ "  \"project_morbidity_question_created_by\": 103,\r\n"
				+ "  \"project_morbidity_question_created_on\": \"2022-07-28T15:09:56.000Z\",\r\n"
				+ "  \"project_morbidity_question_is_mandatory\": 1,\r\n"
				+ "  \"project_morbidity_question_flag\": 0,\r\n"
				+ "  \"project_morbidity_question_is_deleted\": false,\r\n"
				+ "  \"ruleset_variable_id\": 9,\r\n"
				+ "  \"defaultvalue\": 1,\r\n"
				+ "  \"orientation\": 1,\r\n"
				+ "  \"readonlyvalue\": 1,\r\n"
				+ "  \"export_key_name\": \"testing123\",\r\n"
				+ "  \"question_group_type\": \"1\",\r\n"
				+ "  \"question_hint\": \"testing123\"\r\n"
				+ "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON).body(jsonBody)
						.log().all().post(SuperAdminEndPoints.CreateProjectMorbidityQuestion);

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
	public static void get_ProjectMorbidityQuestio() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
						.queryParam("projectmorbidityId", "41").queryParam("projectmorbiditypageId", "79")
						.queryParam("question", "").queryParam("userid", "117").queryParam("rolename", "SuperAdmin")
						.log().all().get(SuperAdminEndPoints.CreateProjectMorbidityQuestion);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		// System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("project_morbidity_question_id"), true
		/* Actual Value */, "Response body contains project_morbidity_question_id");

		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}

	@Test(priority = 3)
	public static void update_ProjectMorbidityQuestio() {

		String jsonBody = "{\r\n"
				+ "  \"project_morbidity_question_id\": 993,\r\n"
				+ "  \"project_morbidity_question_type_id\": 14,\r\n"
				+ "  \"morbidity_bank_id\": 93,\r\n"
				+ "  \"morbidity_bank_page_id\": 168,\r\n"
				+ "  \"morbidity_bank_question_id\": 541,\r\n"
				+ "  \"project_morbidity_question_no\": \"2\",\r\n"
				+ "  \"project_morbidity_question\": \"fever\",\r\n"
				+ "  \"project_morbidity_question_formatted_instruction\": \"Testing\",\r\n"
				+ "  \"project_morbidity_question_is_active\": true,\r\n"
				+ "  \"project_morbidity_question_sequence\": 1,\r\n"
				+ "  \"project_morbidity_question_is_mandatory\": 1,\r\n"
				+ "  \"project_morbidity_question_flag\": 0,\r\n"
				+ "  \"project_morbidity_question_is_deleted\": false,\r\n"
				+ "  \"ruleset_variable_id\": 3,\r\n"
				+ "  \"defaultvalue\": 1,\r\n"
				+ "  \"orientation\": 1,\r\n"
				+ "  \"readonlyvalue\": 1,\r\n"
				+ "  \"project_morbidity_question_updated_by\": 103,\r\n"
				+ "  \"project_morbidity_question_updated_on\": \"2022-07-28T15:12:37.000Z\",\r\n"
				+ "  \"project_morbidity_id\": 68,\r\n"
				+ "  \"project_morbidity_page_id\": 130,\r\n"
				+ "  \"project_morbidity_question_created_by\": 100,\r\n"
				+ "  \"project_morbidity_question_created_on\": \"2022-06-20T10:20:28\",\r\n"
				+ "  \"export_key_name\": \"testing123\",\r\n"
				+ "  \"question_group_type\": \"1\",\r\n"
				+ "  \"question_hint\": \"Testing\"\r\n"
				+ "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON).body(jsonBody)
						.log().all().put(SuperAdminEndPoints.CreateProjectMorbidityQuestion);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.getBody().path("statusCode"), "U0001");
		Assert.assertEquals(response.getBody().path("description"),
				"Record is updated in mw_project_morbidity_question table successfully");
	}

	// @Test(priority=4)
	public static void delete_ProjectMorbidityQuestio() {

		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
						.pathParam("morbidity_bank_id", "97").log().all()
						.delete(SuperAdminEndPoints.CreateProjectMorbidityQuestion);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.getBody().path("statusCode"), "D0001");
		Assert.assertEquals(response.getBody().path("statusValue"), "Record deleted successfully");
		Assert.assertEquals(response.getBody().path("description"), "Record deleted successfully");
	}
}
