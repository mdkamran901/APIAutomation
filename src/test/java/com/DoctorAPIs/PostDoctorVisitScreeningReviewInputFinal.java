package com.DoctorAPIs;

import static io.restassured.RestAssured.given;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.DoctorEndPoints;
import com.TokenAuthentication.GenerateTokenDoctorUser;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostDoctorVisitScreeningReviewInputFinal {
	
	static GenerateTokenDoctorUser tg = new GenerateTokenDoctorUser();
	static String accessToken = tg.getAccessToken();
	
	@Test
	public static void postDoctorVisitScreeningReviewInputFinal() {
		 
		String randomNumber = RandomStringUtils.randomNumeric(2);
	    System.out.println(randomNumber);
	    
		String jsonBody = "{\r\n"
				+ "				\"heartDisease\": true,\r\n"
				+ "				\"heartAttackYearsAgo\": \"2022-07-14T09:51:21.027Z\",\r\n"
				+ "				\"stroke\": true,\r\n"
				+ "				\"strokeYearsAgo\": \"2022-07-14T09:51:21.027Z\",\r\n"
				+ "				\"pad\": true,\r\n"
				+ "				\"vascularDiseaseYearsAgo\":\"2022-07-14T09:51:21.027Z\",\r\n"
				+ "				\"hypertension\": true,\r\n"
				+ "				\"hypertensionYearsAgo\":\"2022-07-14T09:51:21.027Z\",\r\n"
				+ "				\"dm\": true,\r\n"
				+ "				\"diabetesYearsAgo\":\"2022-07-14T09:51:21.027Z\",\r\n"
				+ "				\"fHx_DM\": true,\r\n"
				+ "				\"fHx_HeartDisease\": true,\r\n"
				+ "				\"fHx_Stroke\": true,\r\n"
				+ "				\"smoking\": 0,\r\n"
				+ "				\"smokingAgeStarted\": 25,\r\n"
				+ "				\"smokingAgeStartedChewing\": 25,\r\n"
				+ "				\"physActivity\": true,\r\n"
				+ "				\"diet\": true,\r\n"
				+ "				\"bP_Rx\": true,\r\n"
				+ "				\"bpTabletsPerDay\": 0,\r\n"
				+ "				\"medsWeekly\": 0,\r\n"
				+ "				\"medsTaken\": 0,\r\n"
				+ "				\"bpTabletsYesterday\": 0,\r\n"
				+ "				\"lipid_Rx\": true,\r\n"
				+ "				\"lipidTabletsPerDay\": 0,\r\n"
				+ "				\"lipidTabletsPerWeek\": 0,\r\n"
				+ "				\"lipidTabletsLastWeek\": 0,\r\n"
				+ "				\"lipidTabletsYesterday\": 0,\r\n"
				+ "				\"antiplt\": true,\r\n"
				+ "				\"antiplateletTabletsPerDay\": 0,\r\n"
				+ "				\"antiplateletTabletsPerWeek\": 0,\r\n"
				+ "				\"antiplateletTabletsLastWeek\": 0,\r\n"
				+ "				\"antiplateletTabletsYesterday\": 0,\r\n"
				+ "				\"dM_Rx\": true,\r\n"
				+ "				\"diabetesTabletsPerDay\": 0,\r\n"
				+ "				\"diabetesTabletsPerWeek\": 0,\r\n"
				+ "				\"diabetesTabletsLastWeek\": 0,\r\n"
				+ "				\"diabetesTabletsYesterday\": 0,\r\n"
				+ "				\"isReferredToDoctor\": true,\r\n"
				+ "				\"hasSeenDoctorAfterReferral\": true,\r\n"
				+ "				\"healthCareService\": \"Testing\",\r\n"
				+ "				\"reasonsNotSeeingDoctorAfterReferral\":\"bad habit\",\r\n"
				+ "				\"systolicFirstReading\": 0,\r\n"
				+ "				\"sbP2\": 0,\r\n"
				+ "				\"sbP3\": 0,\r\n"
				+ "				\"sbp\": 0,\r\n"
				+ "				\"diastolicFirstReading\": 0,\r\n"
				+ "				\"dbP2\": 0,\r\n"
				+ "				\"dbP3\": 0,\r\n"
				+ "				\"dbp\": 0,\r\n"
				+ "				\"bpmFirstReading\": 0,\r\n"
				+ "				\"bpmSecondReading\": 0,\r\n"
				+ "				\"pulse3\": 0,\r\n"
				+ "				\"pulseAverage\": 0,\r\n"
				+ "				\"isLargeCuffSize\": true,\r\n"
				+ "				\"lastBPDate\": \"2022-07-14T09:51:21.027Z\",\r\n"
				+ "				\"glucoseCapillary\": 0,\r\n"
				+ "				\"hoursFasted\": \"string\",\r\n"
				+ "				\"lastGlucoseCapillaryDate\": \"2022-07-14T09:51:21.027Z\",\r\n"
				+ "				\"tC_mgdl\": 0,\r\n"
				+ "				\"ldl\": 0,\r\n"
				+ "				\"hdl\": 0,\r\n"
				+ "				\"tg\": 0,\r\n"
				+ "				\"resultDate\": \"2022-07-14T09:51:21.027Z\",\r\n"
				+ "				\"height\": 25,\r\n"
				+ "				\"weight\": 90,\r\n"
				+ "				\"dob\": \"2022-07-14T09:51:21.027Z\",\r\n"
				+ "				\"sex\": \"Female\",\r\n"
				+ "				\"today\": \"2022-07-14T09:51:21.027Z\",\r\n"
				+ "				\"unsure_DOB\": \"\"\r\n"
				+ "				}";

		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON).body(jsonBody)
						.log().all().post(DoctorEndPoints.DoctorVisitScreeningReviewInputFinal);

		response.prettyPrint();
		System.out.println("status code is" + response.statusCode());

		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "person_id");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Operation Successfully");
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("name"), true 
				/*Actual Value*/, "Response body contains name");

	}


}
