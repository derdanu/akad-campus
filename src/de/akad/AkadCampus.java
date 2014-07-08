package de.akad;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.client.apache.ApacheHttpClient;
import com.sun.jersey.client.apache.config.ApacheHttpClientConfig;
import com.sun.jersey.client.apache.config.DefaultApacheHttpClientConfig;
/**
 * 
 * @author Daniel Falkner
 * 
 * This file is part of Akad Campus.
 * 
 * Akad Campus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Akad Campus is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Akad Campus. If not, see <http://www.gnu.org/licenses/>.
 *
 */
public class AkadCampus {

	private static String VERSION = "0.1";
	private static String URL = "https://www.akad-campus.de/api/";

	private String username;
	private String password;
	
	public AkadCampus() {
				
	}
	
	public void generateCSV() {
		
					
		ApacheHttpClientConfig config = new DefaultApacheHttpClientConfig();
		config.getProperties().put(ApacheHttpClientConfig.PROPERTY_HANDLE_COOKIES, true);
		config.getProperties().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

		ApacheHttpClient client = ApacheHttpClient.create(config);
						
 
		WebResource webResource = client.resource(URL + "ANONYMOUS/auth/login");
	 
		Credentials c = new Credentials(this.username, this.password);

		ClientResponse response = webResource.type("application/json")
			   .post(ClientResponse.class, c.toString());
	 
			
		if (!response.getEntity(String.class).equals("")) {
			throw new RuntimeException("Fehler: Ungueltiger Benutzer");
		}
			
			
		webResource = client.resource(URL + "ANONYMOUS/auth/whoami");			
		
		response = webResource.type("application/json")
			   .get(ClientResponse.class);

		 
		if (response.getStatus() != 200) {
			throw new RuntimeException("Fehler whoami: HTTP error code : "
					+ response.getStatus());
		}

		String user = response.getEntity(String.class);
			
		webResource = client.resource(URL + user + "/user");			
			
		response = webResource.type("application/json")
			   .get(ClientResponse.class);

		 
		if (response.getStatus() != 200) {
			throw new RuntimeException("Fehler user: HTTP error code : "
					+ response.getStatus());
		}

		User usr = response.getEntity(User.class);
				
		webResource = client.resource(URL + user + "/product/" + usr.getDefaultCurriculumProductId() + "/events/my");			
			
		 response = webResource.type("application/json")
				   .get(ClientResponse.class);

		 
		if (response.getStatus() != 200) {
			throw new RuntimeException("Fehler user: HTTP error code : "
					+ response.getStatus());
		}

		Termine t = response.getEntity(Termine.class);
			
		for (eventGroups g: t.getEventGroups()) {
			for (value v: g.getValue()) {
				System.out.println("\"" + v.getModuleId() + "\";\"" +  v.getBrickId() + "\";\"" + v.getBrickName() + "\";\"" +  v.UnixToDateStringHelper(v.getStartTime()) + "\";\"" +  v.UnixToDateStringHelper(v.getEndTime()) + "\";\"" + v.getLocation() + "\"");	
			}
		}
		
		
	}
	
	public static String getVERSION() {
		return VERSION;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
}
