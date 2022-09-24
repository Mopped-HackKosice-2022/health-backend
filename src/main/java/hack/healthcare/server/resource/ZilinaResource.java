package hack.healthcare.server.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import hack.healthcare.server.model.ZilinaData;
import hack.healthcare.server.service.ZilinaService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("zilina")
public class ZilinaResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response createZilinaData() {
		try {
			ZilinaService service = new ZilinaService();
			service.createZilinaData();
			return Response.status(HttpServletResponse.SC_OK).build();
		} catch (Exception e) {
			return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("data")
	public Response getAllZilinaData() {
		try {
			ZilinaService service = new ZilinaService();
			List<ZilinaData> datas = service.getAllZilinaData();
			return Response.status(HttpServletResponse.SC_OK).entity(datas).build();
		} catch (Exception e) {
			return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).entity(e).build();
		}
	}
	
	@GET
	@Path("lekarne")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createLekarneData() {
		try {
			ZilinaService service = new ZilinaService();
			service.createLekarneData();
			return Response.status(HttpServletResponse.SC_OK).build();
		} catch (Exception e) {
			return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).entity(e).build();
		}
	}
	
	@GET
	@Path("aps")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createApsData() {
		try {
			ZilinaService service = new ZilinaService();
			service.createApsData();
			return Response.status(HttpServletResponse.SC_OK).build();
		} catch (Exception e) {
			return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).entity(e).build();
		}
	}
	
}
