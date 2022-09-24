package hack.healthcare.server.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import hack.healthcare.server.pojos.SearchRequest;
import hack.healthcare.server.pojos.SearchResponse;
import hack.healthcare.server.service.ApiService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("webapi")
public class ApiResource {

	@POST
	@Path("search")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response search(SearchRequest request) {
		try {
			ApiService service = new ApiService();
			List<SearchResponse> responses = service.search(request);
			return Response.status(HttpServletResponse.SC_OK).entity(responses).build();
		} catch (IllegalArgumentException e) {
			return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity(e).build();
		}catch (Exception e) {
			return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).entity(e).build();
		}
	}
	
	/*
	 * 
	 * // Endpoint APS mapa - GET /.../{okres-ID}   všetky APS ktoré majú daný okres 
[
  {
    "name": "Name",
    "address": "address",
    "lng": 0,
    "lat": 0,
  }
]*/
	
	
}
