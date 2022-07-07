package services;

import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;

import javax.ws.rs.core.MediaType;

import beans.Gender;
import beans.Manager;
import beans.UserRole;
import dao.ManagerDao;
import dto.ManagerDTO;


@Path("/managers")
public class ManagerService extends BaseService {
	
	ManagerDao managerDao = new ManagerDao();

	@SuppressWarnings("unused")
	public void init() {
		System.out.println("Manager Service init void");
		if (ctx.getAttribute("managers") == null) {
			System.out.println("ManagerService");
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("managers", new ManagerService());
		}
	}


	@POST
	@Path("/")	
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createManger(ManagerDTO managerDTO) {
		managerDao.setBasePath(getContext());
		
		Manager manager = new Manager();
		int year, day, month;
	    String[] parts = managerDTO.getBirthdate().split("-");
	    year = Integer.parseInt(parts[0]);
	    month = Integer.parseInt(parts[1]);
	    day = Integer.parseInt(parts[2]);               
	
	    @SuppressWarnings("deprecation")
	    Date date = new Date(year - 1900, month - 1, day);
	    manager.setName(managerDTO.getName());
	    manager.setSurname(managerDTO.getSurname());
	    manager.setUsername(managerDTO.getUsername());
	    manager.setPassword(managerDTO.getPassword());
	    manager.setGender(Gender.valueOf(managerDTO.getGender().toUpperCase()));
	    manager.setUserRole(UserRole.valueOf(managerDTO.getUserRole()));
	    manager.setDeleted(managerDTO.isDeleted());
	    manager.setBanned(managerDTO.isBanned());
	    manager.setBirthdate(date);
	    manager.setSportFacilityId(managerDTO.getSportFacilityId());
	    
	    managerDao.create(manager);
	}
	
	@GET
	@Path("/getManagerById/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Manager getManagerById(@PathParam("userId") String userId) {
		managerDao.setBasePath(getContext());
		return managerDao.getById(userId);
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Manager> getAllMangers() {
		managerDao.setBasePath(getContext());
		return managerDao.getAllToList();
	}
	
	@PUT
	@Path("/")	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateManager(Manager manager) {
		managerDao.setBasePath(getContext());
		managerDao.update(manager);
	}
}
