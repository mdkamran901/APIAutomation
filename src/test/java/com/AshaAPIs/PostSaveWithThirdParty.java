package com.AshaAPIs;

import static io.restassured.RestAssured.given;

import java.util.UUID;

import org.junit.Assert;
import org.testng.annotations.Test;
import com.EndPoints.Asha_Endpoints;
import com.TokenAuthentication.GenerateTokenAshaUser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostSaveWithThirdParty {

		static GenerateTokenAshaUser tg = new GenerateTokenAshaUser();
		static String accessToken = tg.getAccessToken();
		
		@Test
		public static void postsaveWithThirdParty() {
			
			UUID uuid = UUID.randomUUID();
			String uuidAsString= uuid.toString();
			System.out.println("uuid" + uuidAsString);
			
			UUID uuid1 = UUID.randomUUID();
			String uuidAsString1= uuid1.toString();
			System.out.println("uuid1"  +uuidAsString1);
			
			String jsonBody = "{\r\n"
					+ "    \"mw_project_morbidity_evaluation\": {\r\n"
					+ "        \"project_morbidity_evaluation_id\": 0,\r\n"
					+ "        \"project_morbidity_evaluation_guid\": \"uuidAsString\",\r\n"
					+ "        \"project_id\": 152,\r\n"
					+ "        \"project_morbidity_id\": 70,\r\n"
					+ "        \"project_morbidity_evaluation_user_id\": 385,\r\n"
					+ "        \"project_visit_role_id\": 16,\r\n"
					+ "        \"project_morbidity_evaluation_location1_id\": null,\r\n"
					+ "        \"project_morbidity_evaluation_location2_id\": null,\r\n"
					+ "        \"project_morbidity_evaluation_location3_id\": null,\r\n"
					+ "        \"project_morbidity_evaluation_location4_id\": null,\r\n"
					+ "        \"health_facility_id\": 0,\r\n"
					+ "        \"project_morbidity_evaluation_date\": \"2022-06-15T10:44:21\",\r\n"
					+ "        \"project_morbidity_evaluation_start_date\": \"2022-08-26T10:44:21\",\r\n"
					+ "        \"project_morbidity_evaluation_end_date\": \"2022-08-26T10:44:21\",\r\n"
					+ "        \"project_morbidity_evaluation_is_exported\": null,\r\n"
					+ "        \"project_morbidity_evaluation_is_deleted\": false,\r\n"
					+ "        \"project_morbidity_evaluation_created_by\": 385,\r\n"
					+ "        \"project_morbidity_evaluation_created_on\": \"2022-08-26T10:44:21\",\r\n"
					+ "        \"project_morbidity_evaluation_updated_by\": null,\r\n"
					+ "        \"project_morbidity_evaluation_updated_on\": null,\r\n"
					+ "        \"project_morbidity_evaluation_uploaded_by\": null,\r\n"
					+ "        \"project_morbidity_evaluation_uploaded_on\": null,\r\n"
					+ "        \"patient_id\": 590,\r\n"
					+ "        \"projectNavigation\": null,\r\n"
					+ "        \"projectMorbidityNavigation\": null,\r\n"
					+ "        \"createByNavigation\": null,\r\n"
					+ "        \"projectMorbidityEvaluationDetailId\": []\r\n"
					+ "    },\r\n"
					+ "    \"mw_project_morbidity_evaluation_detail\": [\r\n"
					+ "        {\r\n"
					+ "            \"project_morbidity_evaluation_detail_id\": 0,\r\n"
					+ "            \"project_morbidity_evaluation_detail_guid\": \"uuidAsString1\",\r\n"
					+ "            \"project_morbidity_evaluation_id\": 0,\r\n"
					+ "            \"project_morbidity_evaluation_guid\": \"uuidAsString\",\r\n"
					+ "            \"project_morbidity_id\": 74,\r\n"
					+ "            \"project_morbidity_queston_id\": 1033,\r\n"
					+ "            \"project_morbidity_queston_value\": \"2022-08-26 10:41\",\r\n"
					+ "            \"project_morbidity_evaluation_detail_is_deleted\": false,\r\n"
					+ "            \"project_morbidity_evaluation_detail_created_by\": 385,\r\n"
					+ "            \"project_morbidity_evaluation_detail_created_on\": \"2022-08-26T10:44:21\",\r\n"
					+ "            \"project_morbidity_evaluation_detail_updated_by\": null,\r\n"
					+ "            \"project_morbidity_evaluation_detail_updated_on\": null,\r\n"
					+ "            \"project_morbidity_evaluation_detail_uploaded_by\": null,\r\n"
					+ "            \"project_morbidity_evaluation_detail_uploaded_on\": null,\r\n"
					+ "            \"projectMorbidityEvaluationNavigation\": null,\r\n"
					+ "            \"createByNavigation\": null\r\n"
					+ "        }\r\n"
					+ "    ]\r\n"
					+ "}";

			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.body(jsonBody)
							.log().all().post(Asha_Endpoints.postsavewithThirsparty);

			response.prettyPrint();
			System.out.println("status code is" + response.statusCode());

			Assert.assertEquals(response.statusCode(), 200);
			//Assert.assertEquals(response.getBody().path("statusCode"), "U0001");
			//Assert.assertEquals(response.getBody().path("statusValue"), "Operation Successfully");

		}

}
