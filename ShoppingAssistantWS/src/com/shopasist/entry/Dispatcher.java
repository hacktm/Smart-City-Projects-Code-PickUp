package com.shopasist.entry;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.sa.beans.Item;

@Path("/")
public class Dispatcher {

	@Path("/hello")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "Hello World" + "</title>"
				+ "<body><h1>" + "Hello World" + "</body></h1>" + "</html> ";
	}

	@Path("/send")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response processJSON(InputStream incomingData) {

		JSONObject wholeObj = readJsonFromInput(incomingData);

		System.out.println(wholeObj);

		DbSender send = new DbSender("com/mybatis/config/mybatis-config.xml");

		Item aTestItem = send.doATest();
		
		String result = new Gson().toJson(aTestItem);
		
		return Response.status(200).entity(result).build();
	}

	private JSONObject readJsonFromInput(InputStream incomingData) {
		StringBuilder strBuild = new StringBuilder();

		JSONObject result = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				strBuild.append(line);
			}

			result = new JSONObject(strBuild.toString());

		} catch (Exception e) {
			System.err.println("Error Parsing: - " + e);
		}

		System.out.println("Data Received: " + strBuild.toString());

		return result;
	}
}