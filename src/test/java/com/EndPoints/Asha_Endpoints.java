package com.EndPoints;

public class Asha_Endpoints {

		public static final String token = "/api/auth";
		public static final String users = "/api/users";
		public static final String ProjectByuserId = "/api/Project"; //?userId=313";
		public static final String userById = "/api/Users/{uuid}";
		public static final String downloadProjectMorbidityDetails = "/api/DownloadProjectMorbidityDetails";
		public static final String downloadMasterDetailsByProjectId = "/api/DownloadMasterDetails";
		public static final String PatientEnrollmentByData = "/api/PatientEnrollment"; //?creator=41
		public static final String postPatientEnrollmentByData = "/api/PatientEnrollment/PatientData"; //POST API
		public static final String postsavewithThirsparty = "/api/DynamicProjectMorbidity/BulkEvaluationSave"; //POST API screening Input
		public static final String dynamicProjectMorbidityOutputEvaluation = "/api/DynamicProjectMorbidityOutputEvaluation"; //POST API screening output
		public static final String PersonAttributeTypeQuestionPatientSearchByprojectId = "/api/PersonAttributeTypeQuestion/PatientSearch";
		public static final String getPatientEnrollmentPatientDataByNameByAddress = "/api/PatientEnrollment/PatientData";
		public static final String getDownloadPatientEnrollmentPatientDataByCreater = "/api/PatientEnrollment/PatientData";
		public static final String getDynamicProjectMorbidityOutputEvaluation = "/api/DynamicProjectMorbidityOutputEvaluation";
	}

