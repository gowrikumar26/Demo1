package com.Utilities;

import io.restassured.RestAssured;

public class Constants {
	public static final String base_URI = "https://dummy.restapiexample.com/api/v1";
	public static final String read_Data = base_URI+"/employees";
	public static final String add_Data = base_URI+"/create";
	public static final String get_Particular_Data = base_URI+"/employee";
	public static final String delete_Data = base_URI+"/delete/{id}";
	
}
