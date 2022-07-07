package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.FacilityType;
import beans.SportFacility;
import dao.SportFacilityDao;
import dto.SportFacilityDTO;


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
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createSportFacility(SportFacilityDTO sportFacilityDTO) {
        sportFacilityDao.setBasePath(getContext());
        
        SportFacility sportFacility = new SportFacility();
        String[] partsOpen = sportFacilityDTO.getOpenTime().split(":");
        int hoursOpen = Integer.parseInt(partsOpen[0]);
        int minutesOpen = Integer.parseInt(partsOpen[1]);
        @SuppressWarnings("deprecation")
		Date openTime = new Date(2022 - 1900, 1 - 1, 1, hoursOpen, minutesOpen);
        
        String[] partsClose = sportFacilityDTO.getCloseTime().split(":");
        int hoursClose = Integer.parseInt(partsClose[0]);
        int minutesClose = Integer.parseInt(partsClose[1]);
        @SuppressWarnings("deprecation")
		Date closeTime = new Date(2022 - 1900, 1 - 1, 1, hoursClose, minutesClose);
        
        sportFacility.setSportFacilityId(sportFacilityDTO.getSportFacilityId());
        sportFacility.setName(sportFacilityDTO.getName());
        sportFacility.setType(FacilityType.valueOf(sportFacilityDTO.getType()));
        sportFacility.setWorking(Boolean.valueOf(sportFacilityDTO.getIsWorking()));
        sportFacility.setLocation(sportFacilityDTO.getLocation());
        sportFacility.setFacilityContent(sportFacilityDTO.getFacilityContent());
        sportFacility.setAverageGrade(sportFacilityDTO.getAverageGrade());
        sportFacility.setOpenTime(openTime);
        sportFacility.setCloseTime(closeTime);
        
        sportFacilityDao.create(sportFacility);
    }
	
}
