package hack.healthcare.server.resource;

import javax.servlet.http.HttpServletResponse;

import hack.healthcare.server.service.ZilinaAbsencieService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("absencie")
public class ZilinaAbsencieResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response createZilinaAbsencieData() {
		try {
			ZilinaAbsencieService service = new ZilinaAbsencieService();
			service.createZilinaAbsencieData();
			return Response.status(HttpServletResponse.SC_OK).build();
		} catch (Exception e) {
			return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
