package com.EndPoints;

public class SuperAdminEndPoints {
	//LogIn And DashBoard
		public static final String token = "/api/auth";
		public static final String reportDashboardByProjectId = "/api/ProjectReport/Dashboard";
		public static final String projectGraphByuserIdByProjectId = "/api/ProjectGraph";
		public static final String GETProjectByRoleName = "/api/Project";  //?rolename=SuperAdmin&userid=103
		public static final String GETMenuwithroleSuperAdmin = "/api/Menu/Menuwithrole/SuperAdmin";
		
		//Morbidity
		public static final String geMorbidityBankByMorbidityBankId = "/api/MorbidityBank/{morbidity_bank_id}";
		public static final String postMorbidityBank = "/api/MorbidityBank"; //?morbidity_bank=
		public static final String MorbidityBankPageByMorbidityBankId = "/api/MorbidityBankPage/{morbidity_bank_page_id}";
		public static final String postMorbidityBankPage = "/api/MorbidityBankPage";
		public static final String MorbidityQuestionOption = "/api/MorbidityQuestionOption";
		public static final String MorbidityBankQuestion = "/api/MorbidityBankQuestion";
		
		public static final String getQuestionTypee = "/api/QuestionType";
		public static final String MorbidityBankQuestionLogic = "/api/MorbidityBankQuestionLogic";
		
		//Project Management
		public static final String AllMethodProject = "/api/project";
		public static final String DeleteProject = "/api/project/{Project_id}";
		public static final String ProjectPersonAttributeTypeBulkPost = "/api/ProjectPersonAttributeType/BulkPost";
		public static final String BulkPost_ProjectPersonAttributeType = "/api/ProjectPersonAttributeType/BulkPost";
		public static final String ProjectPersonAttributeType = "/api/ProjectPersonAttributeType";
		public static final String BulkPost_ProjectUser = "/api/ProjectUser/BulkPost";
		public static final String ProjectUser = "/api/ProjectUser";
		public static final String ProjectPersonBulkPost = "/api/ProjectPerson/BulkPost";
		public static final String getUserByNameRoles = "/api/Users";
		public static final String getProjectPersion = "/api/ProjectPerson";
		public static final String getPersion = "/api/Person";
		public static final String ProjectTheme = "/api/ProjectTheme";
		public static final String ProjectResourceBulkPost = "/api/ProjectResource/BulkPost";
		public static final String projectResourceByProjectIdByResourceIdByuserIdByRolename = "/api/Resource";
		public static final String ProjectReferralQuestion = "/api/ProjectReferralQuestion";
		public static final String MorbidityBankQuestionLogicPostMultiple = "/api/MorbidityBankQuestionLogic/PostMultiple";
		
		public static final String getResoubceByName = "/api/Resource";
		
		//Project Morbidity
		public static final String projectMorbidity = "/api/ProjectMorbidity";
		
		public static final String ProjectMorbidityPage = "/api/ProjectMorbidityPage";
		public static final String ProjectMorbidityQuestion = "/api/ProjectMorbidityQuestion";
		
		public static final String MorbidityBankQuestionByMorbidityBankId = "/api/MorbidityBankQuestion";
		
		public static final String CreateProjectMorbidityQuestion = "/api/ProjectMorbidityQuestion";
		public static final String GetQuestionType = "/api/QuestionType";
		public static final String ProjectMorbidityQuestionLogic = "/api/ProjectMorbidityQuestionLogic";
		public static final String getMorbidityQuestionOption = "/api/MorbidityQuestionOption";
		
		//Morbidity Language
		public static final String Getlanguage = "/api/Language";
		public static final String GetMorbidityBankLanguage = "/api/MorbidityBankLanguage";
		public static final String GrtMorbidityBankSectionLanguage = "/api/MorbidityBankSectionLanguage";
		public static final String Get_MorbidityBankQuestionLanguage = "/api/MorbidityBankQuestionLanguage";
		public static final String GetMorbidityQuestionOption = "/api/MorbidityQuestionOption";
		public static final String get_MorbidityQuestionOptionLanguage = "/api/MorbidityQuestionOptionLanguage";
		
		//Morbidity Output
		public static final String allMethodMorbidityOutPutBank = "/api/MorbidityOutputBank";
		
		public static final String allMethodMorbidityOutputBankSection = "/api/MorbidityOutputBankSection";
		public static final String allMethodMorbidityOutputBankQuestion = "/api/MorbidityOutputBankQuestion";
		public static final String GetProjectReferralQuestion = "/api/ProjectReferralQuestion";
		public static final String get_ProjectMorbidityQuestion = "/api/ProjectMorbidityQuestion";
		
		public static final String ProjectReferralQuestionBulkPost = "/api/ProjectReferralQuestion/BulkPost";
		public static final String ProjectReferralQuestionBulkDelete = "/api/ProjectReferralQuestion/BulkDelete";
		
		public static final String GetProjectMorbidityOutputQuestion = "/api/ProjectMorbidityOutputQuestion";
		
		//Project Morbidity Output
		public static final String allMethodProjectMorbidityOutput = "/api/ProjectMorbidityOutput";
		public static final String allMethodPProjectMorbidityOutputSection = "/api/ProjectMorbidityOutputSection";
		
		public static final String allMethodProjectMorbidityOutputQuestion = "/api/ProjectMorbidityOutputQuestion";
		
		public static final String GET_MorbidityOutputBankQuestion = "/api/MorbidityOutputBankQuestion";
		
		public static final String BulkDelete_ProjectMorbidityOutputQuestion = "/api/ProjectMorbidityOutputQuestion/BulkDelete";
		public static final String BulkPost_ProjectMorbidityOutputQuestion = "/api/ProjectMorbidityOutputQuestion/BulkPost";
		
		public static final String GetProjectVisitRoleOutputQuestion = "/api/ProjectVisitRoleOutputQuestion";
		public static final String Get_ProjectMorbidityOutputQuestion = "/api/ProjectMorbidityOutputQuestion";
		public static final String BulkPost_ProjectVisitRoleOutputQuestion = "/api/ProjectVisitRoleOutputQuestion/BulkPost";
		public static final String BulkDelete_ProjectVisitRoleOutputQuestion = "/api/ProjectVisitRoleOutputQuestion/BulkDelete";
		
		//Project Morbidity Visit
		public static final String AllMethodVisitMaster = "/api/VisitMaster";
		public static final String AllMethodVisitRole = "/api/VisitRole";
		public static final String GET_ProjectVisitRole = "/api/ProjectVisitRole";
		
		public static final String BulkPOST_ProjectVisitRole = "/api/ProjectVisitRole/BulkPost";
		public static final String BulkDELETE_ProjectVisitRole = "/api/ProjectVisitRole/BulkDelete";
		
		public static final String GET_ProjectVisitRoleQuestion = "/api/ProjectVisitRoleQuestion";
		public static final String GET_ProjectMorbidityQuestion = "/api/ProjectMorbidityQuestion";
		
		public static final String BulkPOST_ProjectVisitRoleQuestion = "/api/ProjectVisitRoleQuestion/BulkPost";
		public static final String BulkDELETE_ProjectVisitRoleQuestion = "/api/ProjectVisitRoleQuestion/BulkDelete";
		
		//Ruleset Master
		public static final String ALLMethod_Ruleset = "/api/Ruleset";
		public static final String ALLMethod_RulesetVariable = "/api/RulesetVariable";
		public static final String ALLMethod_RulesetVariableDataType = "/api/RulesetVariableDatatype";
		public static final String GET_RulesetMapping = "/api/RulesetMapping";
		
		public static final String BulkPOST_RulesetMapping = "/api/RulesetMapping/BulkPost";
		public static final String BulkDELETE_RulesetMapping = "/api/RulesetMapping/BulkDelete";
		
		//Privillage Master
		public static final String GET_Privilege = "/api/Privilege";
		//Role Master
		public static final String AllMethod_Roles = "/api/Roles";
		public static final String Delete_Roles = "/api/Roles/181cdacf-7095-4758-9d7b-4d82b75318d5";
		
		//User Management
		public static final String ALLMethod_Users = "/api/users";
		public static final String POST_UserBulkUpload = "/api/Users/BulkUpload";
		public static final String DeleteUser = "/api/Users/{id}";
		public static final String StatusActiveUser = "/api/users/24c1fc58-33b0-4c4d-9ed6-602fe1281365/status/activate";
		
		//Master Management
		public static final String AddAppLabel = "/api/AppLabel";
		public static final String AddColor = "/api/Colour";
		public static final String FacilitiesType = "/api/FacilityType";
		public static final String HealthFacilities = "/api/HealthFacilities";
		public static final String ResourceMaster = "/api/Resource";
		public static final String ResourceType = "/api/ResourceType";
		public static final String RegistrationScreeQuestion = "/api/PersonAttributeTypeQuestion";
		public static final String PersonAttributeQuestionOption = "/api/PersonAttributeQuestionOption";
		public static final String ThirdPartyIntegration = "/api/ThirdPartyIntegration";
		public static final String ThirdPartyEndPoint = "/api/ThirdPartyEndPoint";
		public static final String ThirdPartyVariable = "/api/ThirdPartyVariable";
		public static final String ThirdPartyStaticVariable = "/api/ThirdPartyStaticVariable";
		
		public static final String Followup = "/api/Followup";
		
		
		//Language Management
		public static final String GET_MorbidityBankLanguage = "/api/MorbidityBankLanguage";
		public static final String GET_MorbidityBankSectionLanguage = "/api/MorbidityBankSectionLanguage";
		public static final String GET_MorbidityBankQuestionLanguageId = "/api/MorbidityBankQuestionLanguage";
		public static final String GET_MorbidityBankOptionLanguage = "/api/MorbidityQuestionOption";
		
		
		
		
		
		
		
		
		
		

}
