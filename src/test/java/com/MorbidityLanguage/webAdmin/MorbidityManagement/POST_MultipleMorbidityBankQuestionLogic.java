package com.MorbidityLanguage.webAdmin.MorbidityManagement;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class POST_MultipleMorbidityBankQuestionLogic {
	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();

	@Test
	public static void POSTMultiple_MorbidityBankQuestionLogic() {
		
		String jsonBody ="[\r\n"
				+ "  {\r\n"
				+ "    \"morbidity_bank_id\": 94,\r\n"
				+ "    \"morbidity_bank_parent_question_id\": 680,\r\n"
				+ "    \"morbidity_bank_dependent_question_id\": 698,\r\n"
				+ "    \"morbidity_bank_logic_type_id\": 10,\r\n"
				+ "    \"morbidity_bank_logic_type_value_for_skip\": 1,\r\n"
				+ "    \"morbidity_bank_logic_operator\": \"=\",\r\n"
				+ "    \"morbidity_bank_logic_flag_value\": \"Testing123\",\r\n"
				+ "    \"morbidity_bank_logic_flag_value_name\": \"Testing123\",\r\n"
				+ "    \"morbidity_bank_logic_condition\": \"string\",\r\n"
				+ "    \"morbidity_bank_logic_implement\": \"string\",\r\n"
				+ "    \"morbidity_bank_logic_implement_for\": \"string\",\r\n"
				+ "    \"morbidity_bank_logic_message\": \"string\",\r\n"
				+ "    \"morbidity_bank_logic_created_by\": 103,\r\n"
				+ "    \"morbidity_bank_logic_created_on\": \"2022-08-20T11:03:21\",\r\n"
				+ "    \"morbidity_bank_logic_updated_by\": null,\r\n"
				+ "    \"morbidity_bank_logic_updated_on\": null\r\n"
				+ "  }\r\n"
				+ "]";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.MorbidityBankQuestionLogicPostMultiple);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in mw_project_visit_role_output_referral_question table successfully");
		
		
	}

}
