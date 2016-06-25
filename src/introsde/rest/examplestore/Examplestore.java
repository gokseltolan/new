package introsde.rest.examplestore;

import introsde.assignment.soap.ws.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.List;

import javax.ejb.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


import org.json.*;



@Stateless // will work only inside a Java EE application
@LocalBean // will work only inside a Java EE application
@Path("/examplestore")
public class Examplestore {
	
	
	@GET
    @Produces({MediaType.APPLICATION_JSON })
    @Path("/getMeasureTypes")
    public Response getMeasureTypes() throws ClientProtocolException, IOException {
        PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
        List<MeasureTypes> measurelist = people.getMeasureList();
         return Response.status(200).entity(measurelist).build();
    }
           
	      
   
}

