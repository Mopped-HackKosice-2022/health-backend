package hack.healthcare.server.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import hack.healthcare.server.pojos.TestResourceRequest;
import hack.healthcare.server.pojos.TestResourceResponse;
import hack.healthcare.server.service.TestService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("test")
public class TestResource {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTest(TestResourceRequest request) {
		try {
			TestService testService = new TestService();
			TestResourceResponse response = testService.createTest(request);
			return Response.status(HttpServletResponse.SC_OK).entity(response).build();
		} catch (Exception e) {
			return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTests() {
		try {
			TestService testService = new TestService();
			List<TestResourceResponse> responses = testService.getTests();
			return Response.status(HttpServletResponse.SC_OK).entity(responses).build();
		} catch (Exception e) {
			return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GET
	@Path("id")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTestById(@QueryParam("id") Integer id) {
		try {
			TestService service = new TestService();
			TestResourceResponse response = service.getTestById(id);
			return Response.status(HttpServletResponse.SC_OK).entity(response).build();
		} catch (Exception e) {
			return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateTest(@QueryParam("id") Integer id, TestResourceRequest request) {
		try {
			TestService service = new TestService();
			TestResourceResponse response = service.updateTestById(id, request);
			return Response.status(HttpServletResponse.SC_OK).entity(response).build();
		} catch (Exception e) {
			return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteTest(@QueryParam("id") Integer id) {
		try {
			TestService service = new TestService();
			boolean result = service.deleteTestById(id);
			return Response.status(HttpServletResponse.SC_OK).entity(result).build();
		} catch (Exception e) {
			return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
		}
	}
	

}
