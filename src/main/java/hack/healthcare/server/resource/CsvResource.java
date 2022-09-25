package hack.healthcare.server.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import hack.healthcare.server.model.Doctor;
import hack.healthcare.server.service.CsvService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("csv")
public class CsvResource {
	
	@GET
	@Produces
	public Response storePediatersToDb() {
		try {
			CsvService csvService = new CsvService();
			List<Doctor> doctors = csvService.storePediatersToDb();
			return Response.status(HttpServletResponse.SC_OK).entity(doctors).build();
		} catch (Exception e) {
			return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GET
	@Path("lieky")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createLieky() {
		try {
			CsvService service = new CsvService();
			service.createLieky();
			return Response.status(HttpServletResponse.SC_OK).build();
		} catch (Exception e) {
			return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).entity(e).build();
		}
	}

}
