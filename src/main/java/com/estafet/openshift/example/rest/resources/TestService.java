package com.estafet.openshift.example.rest.resources;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class TestService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String ping() {
		String result = "No connection";
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://172.17.0.5:5432/", "test", "test");
		} catch (Exception e) {
		}

		if (connection != null) {
			result = "Connection OK!";
		}

		return result;
	}
}
