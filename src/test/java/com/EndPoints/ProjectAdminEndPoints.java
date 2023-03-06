package com.EndPoints;

public class ProjectAdminEndPoints {

	//logIn
		public static final String token = "/api/auth";
		public static final String GETMenuwithrole = "/api/Menu/Menuwithrole/ProjectAdmin";
		public static final String GETProjectByUserIdRByRole = "/api/Project";
		
		//Language Management
		public static final String AllMethodCountryMaster = "/api/LocationLevel1";
		public static final String GETLocationLevel1Bylocation_level =  "/api/LocationLevel1";
		public static final String AllMethod_StateLocationMaster = "/api/LocationLevel2/LocationLevel2Master";
		public static final String GET_StateLocationMaster = "api/LocationLevel2/LocationLevel2Master";
		public static final String AllMethodDistrictLocationMaster = "/api/LocationLevel3/LocationLevel3Master";
		public static final String AllMethodBlockLocationMaster = "/api/LocationLevel4/LocationLevel4Master";
		public static final String AllMethodMaskValidation =  "/api/MaskValidation";
		public static final String AllMethodLanguageMaster =  "/api/Language";
		
		
		//User Management
		public static final String ALLMethod_Users = "/api/users";
		public static final String BulkUploadUserCreation = "/api/Users/BulkUpload";
		public static final String DeleteUser = "/api/Users/{id}";
		public static final String StatusActiveUser = "/api/users/24c1fc58-33b0-4c4d-9ed6-602fe1281365/status/activate";
	}


