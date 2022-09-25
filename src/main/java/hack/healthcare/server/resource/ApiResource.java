package hack.healthcare.server.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import hack.healthcare.server.model.Aps;
import hack.healthcare.server.model.Lekaren;
import hack.healthcare.server.model.Liek;
import hack.healthcare.server.model.ZilinaAbsencie;
import hack.healthcare.server.model.ZilinaData;
import hack.healthcare.server.pojos.LiekResponse;
import hack.healthcare.server.pojos.SearchRequest;
import hack.healthcare.server.pojos.SearchResponse;
import hack.healthcare.server.pojos.ZilinaAbsencieResponse;
import hack.healthcare.server.pojos.ZilinaDataResponse2;
import hack.healthcare.server.service.ApiService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
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
	
	@GET
	@Consumes
	@Path("aps")
	public Response getAllAps() {
		try {
			ApiService service = new ApiService();
			List<Aps> data = service.getAllAps();
			return Response.status(HttpServletResponse.SC_OK).entity(data).build();
		} catch (Exception e) {
			return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).entity(e).build();
					
		}
	}
	
	@GET
	@Path("lekaren")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getLakerenByOkres(@QueryParam("id") Integer id) {
		try {
			ApiService apiService = new ApiService();
			List<Lekaren> lekarens = apiService.getLekarenByOkres(id);
			return Response.status(HttpServletResponse.SC_OK).entity(lekarens).build();
		} catch (Exception e) {
			return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).entity(e).build();
		}
	}
	
	@GET
	@Path("detail")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getDoctorDetail(@QueryParam("id") Integer id) {
		try {
			ApiService service = new ApiService();
			ZilinaDataResponse2 zilinaData = service.getDoctorDetail(id);
			return Response.status(HttpServletResponse.SC_OK).entity(zilinaData).build();
		} catch (Exception e) {
			return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).entity(e).build();
		}
	}
	
	@GET
	@Path("absencie")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAbsencie(@QueryParam("id") Integer id) {
		
		try {
			ApiService service = new ApiService();
			List<ZilinaAbsencieResponse> absencie = service.getAbsencieByDoctorId(id);
			return Response.status(HttpServletResponse.SC_OK).entity(absencie).build();
		} catch (Exception e) {
			return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).entity(e).build();
		}
		
	}
	
	@GET
	@Path("lieky")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchLieky(@QueryParam("key") String key) {
		try {
			ApiService service = new ApiService();
			List<LiekResponse> lieky = service.getLieky(key);
			return Response.status(HttpServletResponse.SC_OK).entity(lieky).build();
		} catch (Exception e) {
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
