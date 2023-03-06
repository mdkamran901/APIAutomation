package com.AshaAPIs;

import static io.restassured.RestAssured.given;
import java.util.UUID;

import org.junit.Assert;
import org.testng.annotations.Test;
import com.EndPoints.Asha_Endpoints;
import com.TokenAuthentication.GenerateTokenAshaUser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostProjectMorbidityOutputEvaluation {

	static GenerateTokenAshaUser tg = new GenerateTokenAshaUser();
	static String accessToken = tg.getAccessToken();

	@Test
	public static void postDynamicProjectMorbidityOutputEvaluation() {
		
		UUID uuid = UUID.randomUUID();
		//String uuidAsString = uuid.toString();
		System.out.println(uuid);
		
		UUID uuid1 = UUID.randomUUID();
		//String uuidAsString1= uuid1.toString();
		System.out.println(uuid1);
		
		String jsonBody = "\r\n"
				+ "{\r\n"
				+ "	\"mw_project_morbidity_output_evaluation\": {\r\n"
				+ "		\"project_morbidity_output_evaluation_id\": 0,\r\n"
				+ "		\"project_morbidity_output_evaluation_guid\": \"uuid\",\r\n"
				+ "		\"project_morbidity_evaluation_guid\": \"22847da9-9a6e-4059-a459-bee90c1b5d2b\",\r\n"
				+ "		\"project_id\": 152,\r\n"
				+ "		\"project_morbidity_output_id\": 37,\r\n"
				+ "		\"user_id\": 385,\r\n"
				+ "		\"project_visit_role_id\": 20,\r\n"
				+ "		\"location1_id\": null,\r\n"
				+ "		\"location2_id\": null,\r\n"
				+ "		\"location3_id\": null,\r\n"
				+ "		\"location4_id\": null,\r\n"
				+ "		\"health_facility_id\": null,\r\n"
				+ "		\"project_morbidity_output_evaluation_date\": \"2022-08-25T10:08:43\",\r\n"
				+ "		\"start_date\": \"2022-08-25T10:08:43\",\r\n"
				+ "		\"end_date\": \"2022-08-25T10:08:43\",\r\n"
				+ "		\"is_deleted\": false,\r\n"
				+ "		\"created_by\": 385,\r\n"
				+ "		\"created_on\": \"2022-06-06T10:08:43\",\r\n"
				+ "		\"updated_by\": null,\r\n"
				+ "		\"updated_on\": null,\r\n"
				+ "		\"uploaded_by\": null,\r\n"
				+ "		\"uploaded_on\": null,\r\n"
				+ "		\"patient_id\": 458\r\n"
				+ "	},\r\n"
				+ "	\"mw_project_morbidity_output_evaluation_detail\": [\r\n"
				+ "		{\r\n"
				+ "			\"project_morbidity_output_evaluation_detail_id\": 0,\r\n"
				+ "			\"project_morbidity_output_evaluation_detail_guid\": \"uuid1\",\r\n"
				+ "			\"project_morbidity_output_evaluation_id\": 0,\r\n"
				+ "			\"project_morbidity_output_evaluation_guid\": \"uuid\",\r\n"
				+ "			\"project_morbidity_output_id\": 37,\r\n"
				+ "			\"project_morbidity_output_question_id\": 117,\r\n"
				+ "			\"project_morbidity_output_queston_value\": \"34.468400638831845\",\r\n"
				+ "			\"project_morbidity_output_queston_value_tl\": null,\r\n"
				+ "			\"project_morbidity_output_queston_value_id\": null,\r\n"
				+ "			\"is_deleted\": false,\r\n"
				+ "			\"created_by\": 284,\r\n"
				+ "			\"created_on\": \"2022-06-06T10:08:43\",\r\n"
				+ "			\"updated_by\": null,\r\n"
				+ "			\"updated_on\": null,\r\n"
				+ "			\"uploaded_by\": null,\r\n"
				+ "			\"uploaded_on\": null\r\n"
				+ "		}\r\n"
				+ "        ]\r\n"
				+ "}";

		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON).body(jsonBody)
						.log().all().post(Asha_Endpoints.dynamicProjectMorbidityOutputEvaluation);

		response.prettyPrint();
		System.out.println("status code is" + response.statusCode());

		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "E0001");
		//Assert.assertEquals(response.getBody(), "project_morbidity_output_evaluation_id");
		//Assert.assertEquals(response.getBody(), "project_morbidity_output_evaluation_guid");

	}

}
