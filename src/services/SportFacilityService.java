package services;

import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.PostConstruct;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.SportFacility;
import dao.SportFacilityDao;


@Path("/sportFacilities")
public class SportFacilityService extends BaseService {
	
	SportFacilityDao sportFacilityDao = new SportFacilityDao();
	
	@SuppressWarnings("unused")
	public void init() {
		if (ctx.getAttribute("sportFacilities") == null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("sportFacilities", new SportFacilityService());
		}
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<SportFacility> getFacilities() {
		sportFacilityDao.setBasePath(getContext());
		return sportFacilityDao.getAllToList();
	}
}
