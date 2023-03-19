import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.POJOs.Datum;
import com.POJOs.ResponsePOJO;
import com.POJOs.createDataPOJO;
import com.Utilities.Constants;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Assessment {
@Test
	public void getData() {
			
			Response response = RestAssured
									.given()
										.contentType(ContentType.JSON)
									.when()
										.get(Constants.read_Data);

			response.then().statusCode(200);
			ResponsePOJO datas =response.as(ResponsePOJO.class);
			
			System.out.println("total"+ datas.getStatus());
			
			//Iterator<Datum> data = datas.getData().iterator();
			System.out.println(datas.getData().size());
			
			//System.out.println("datas"+data);
			
			//response.prettyPrint();
			String actual = response.body().jsonPath().getString("status");
			Assert.assertEquals(actual, "success");
			//System.out.println("Status :"+ status);
//			int noOfRecords = response.body().jsonPath().getList("data").size();			
//			System.out.println("noOfRecords "+noOfRecords);
//			
		}
	
@Test
public String createData() {
		createDataPOJO createData = new createDataPOJO();
		createData.setName("Kowsalya");
		createData.setSalary("42134");
		createData.setAge("34");
		
		Response response = RestAssured
								.given()
									.contentType(ContentType.JSON)
									.body(createData)
								.when()
									.post(Constants.add_Data);
		System.out.println(response.body().jsonPath().prettyPrint()+"*********path");
		String dataList= response.body().jsonPath().get("data").toString();
		System.out.println("Datas "+dataList);
		String idValue= response.body().jsonPath().get("data.id").toString();
		System.out.println("id value "+idValue);
		response.then().statusCode(200);
		String actual = response.body().jsonPath().getString("status");
		String expec = "success";
		Assert.assertEquals(actual, expec);
		return idValue;
	}


@Test(priority = 2)
public void deleteData(){
	String id = createData();
	//int id = 2380;
	//System.out.println("success"+id);
		Response response = RestAssured
								.given()
									.pathParam("id",id)
									.contentType(ContentType.JSON)
									
								.when()
									.delete(Constants.delete_Data);
		
		response
			.then()
				.assertThat().statusCode(200);
		
	}
//
//@Test(priority = 3)
//public void deleteParticularData() {
//	int id = 0;
//	Response response = RestAssured
//			.given()
//				.pathParam("id",id)
//				.contentType(ContentType.JSON)
//				
//			.when()
//				.delete(Constants.delete_Data);
//response
//.then()
//.assertThat().statusCode(200);
//String res = response.body().jsonPath().get("");
//System.out.println("result "+res);
//
//}
//
//@Test(priority = 4)
//public void getParticularData() {
//	
//	
//	Response response = RestAssured
//			.given()
//				//.pathParam("id",id)
//				.contentType(ContentType.JSON)
//				
//			.when()
//				.get(Constants.get_Particular_Data);
//	ResponsePOJO[] data =response.as(ResponsePOJO[].class);
//	System.out.println(data[2].getId());
//response
//	.then()
//	.assertThat().statusCode(200);
////responsepojo.getId();
//
//response.getBody().toString();
//List<Object> idList = response.body().jsonPath().getList("findAll {it.id == 2}.id");
//String res = response.body().jsonPath().get("data");
//System.out.println("result "+res+"$$$$$$"+idList);
//}
}
