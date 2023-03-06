package com.EndPoints;


	public class DoctorEndPoints {
		
		public static final String token = "/api/auth";
		//public static final String users = "/api/users";
		public static final String ProjectByuserId = "/api/Project"; //?userId=313";
		public static final String userById = "/api/Users/{uuid}";
		public static final String downloadProjectMorbidityDetailsByProjectIdByUserId = "/api/DownloadProjectMorbidityDetails";
		public static final String downloadMasterDetailsByProjectId = "/api/DownloadMasterDetails";
		public static final String DoctorPatientSearchByDoctorIdPgeNo = "/api/DoctorPatientSearch";
		public static final String DoctorVisitScreeningReviewInputFinal = "/api/DoctorVisit/ScreeningReviewInputFinal";
		
		//public static final String PatientEnrollmentByData = "/api/PatientEnrollment";
//		public static final String postPatientEnrollmentByData = "/api/PatientEnrollment/PatientData";
		public static final String postsavewithThirsparty = "/api/DynamicProjectMorbidity/BulkEvaluationSave"; 
		public static final String dynamicProjectMorbidityOutputEvaluation = "/api/DynamicProjectMorbidityOutputEvaluation";
		public static final String DynamicProjectMorbidityByprojectMorbidityEvaluationListpatient_id ="/api/DynamicProjectMorbidity";
		
		
		public static final String PersonAttributeTypeQuestionPatientSearchByprojectId = "/api/PersonAttributeTypeQuestion/PatientSearch";
		public static final String getPatientEnrollmentPatientDataByNameByAddress = "/api/PatientEnrollment/PatientData";
		//public static final String getDownloadPatientEnrollmentPatientDataByCreater = "/api/PatientEnrollment/PatientData";
		//public static final String getDynamicProjectMorbidityOutputEvaluation = "/api/DynamicProjectMorbidityOutputEvaluation";

	}
