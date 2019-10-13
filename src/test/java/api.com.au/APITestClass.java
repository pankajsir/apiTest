package api.com.au;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.io.IOException;
import java.lang.String;
import java.nio.file.Files;
import java.nio.file.Paths;
import static io.restassured.RestAssured.*;

public class APITestClass {

	public String station[] = new String[2];
	public String baseURL = "http://api.openweathermap.org/data/3.0/stations";
	public String appID = "e3f5977090c4df78f715647538153c93";
	Response response = null;
	String requestBody;
	
	@Test
	public void test1APIIDIsMissingStatus401() throws IOException  {	        
	   
		RestAssured.baseURI = baseURL +"?id=524901";	      
		
		given()
        .header("Content-Type", "application/json")
        .when().post(baseURI)
        .then().assertThat().statusCode(401);
        
	}
	 
	@Test
	public void test2StationsRegisteredSuccessStatus201() throws IOException {
	        
		RestAssured.baseURI = baseURL +"?id=524901&APPID=" + appID;
		String stationinfo;
		for (int i=0;i<2;i++) {
		stationinfo = "station"+ (i+1); 	
		
		requestBody = generateStringFromResource("src/main/resources/"+ stationinfo + ".json");        

        try {
            response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(baseURI);     

        System.out.println("Response :" + response.asString());
        String ar[] = response.asString().split(":");
        String stationRecord[] = ar[1].toString().split(",");
        
        String stationID = stationRecord[0];
        System.out.println("Registered Station :" +  stationID); 
        station[i] = stationID;
        
        } catch (Exception e) {
            e.printStackTrace();
        	}
		}
                      
        System.out.println("Status Code :" + response.getStatusCode());
        System.out.println("Does Reponse contains 201? :" + response.asString().contains("201"));        
        //Verify the station registration
        assertEquals(201, response.getStatusCode(), "Station is not registered successfully.");   
	        
	}	
	
	@Test
	public void test3GetRegistredStationSuccessStatus200() throws IOException
	{
		
		for (int i=0; i<2; i++ ) {				
		
		String getStationURL = (baseURL +"/"+ station[i] +"?APPID=" + appID).replace("\"", "");					
				
		RestAssured.baseURI = getStationURL;	       

        try {
            response = RestAssured.given()
                .contentType(ContentType.JSON)
                .get(baseURI);    
		
		System.out.println("Status Code: " + response.getStatusCode() + "Station"+ (1+i) + " Successfully retrived from DB." );
		assertEquals(200, response.getStatusCode(), "Station is not retrived successfully.");
		
        } catch (Exception e) {
            e.printStackTrace();
        	}
		}
	}


	@Test
	public void test4StationOnDeletionStatus204()
	{
		//String station[] = {"5d9fef536c634e000115a014", "5d9fef536c634e000115a015"};
		
		for (int i=0; i<2; i++ ) {				
		
		String deleteStationURL = (baseURL +"/"+ station[i] +"?APPID=" + appID).replace("\"", "");					
				
		RestAssured.baseURI = deleteStationURL;
		
		given().
			when().
			delete(baseURI).
			then().assertThat(). 
			statusCode(204).and().
			extract().
			response().asString();

		System.out.println("Deleted station \t"+ station[i]);
		}
	}
	
	@Test
	public void test5GetDeletedStationStatus404() throws IOException
	{
		String station[] = {"5d9febad6c634e000115a00f", "5d9febae6c634e000115a010"};
		
		for (int i=0; i<2; i++ ) {				
		
		String getStationURL = (baseURL +"/"+ station[i] +"?APPID=" + appID).replace("\"", "");					
				
		RestAssured.baseURI = getStationURL;	       

        try {
            response = RestAssured.given()
                .contentType(ContentType.JSON)
                .get(baseURI);    
		
		System.out.println("test5GetDeletedStationStatus404 Status Code: " + response.getStatusCode() + " Station"+ (1+i));
		assertEquals(404, response.getStatusCode(), "Status is not correct as expected.");
		
        } catch (Exception e) {
            e.printStackTrace();
        	}
		}
	}
	public String generateStringFromResource(String path) throws IOException {

	    return new String(Files.readAllBytes(Paths.get(path)));

	}

}
