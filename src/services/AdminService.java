package services;

import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

import beans.Admin;
import beans.Gender;
import beans.UserRole;
import dao.AdminDao;
import dto.AdminDTO;

@Path("/admins")
public class AdminService extends BaseService {
    AdminDao adminDao = new AdminDao();

    @SuppressWarnings("unused")
    public void init() {
        if (ctx.getAttribute("admins") == null) {
            String contextPath = ctx.getRealPath("");
            ctx.setAttribute("admins", new AdminService());
        }
    }
    
    @GET
	@Path("/getAdminById/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Admin getManagerById(@PathParam("userId") String userId) {
		adminDao.setBasePath(getContext());
		return adminDao.getById(userId);
	}
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Admin> getAllAdmins() {
        adminDao.setBasePath(getContext());
        return adminDao.getAllToList();
    }
    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void createAdmin(AdminDTO adminDTO) {
    	adminDao.setBasePath(getContext());
    	
    	Admin admin = new Admin();
    	
    	admin.setBanned(adminDTO.isBanned());
    	admin.setDeleted(adminDTO.isDeleted());
    	admin.setGender(Gender.valueOf(adminDTO.getGender()));
    	admin.setName(adminDTO.getName());
    	admin.setPassword(adminDTO.getPassword());
    	admin.setSurname(adminDTO.getSurname());
    	admin.setUsername(adminDTO.getUsername());
    	admin.setUserRole(UserRole.valueOf(adminDTO.getUserRole()));
    	
    	int year, day, month;
	    String[] parts = adminDTO.getBirthdate().split("-");
	    year = Integer.parseInt(parts[0]);
	    month = Integer.parseInt(parts[1]);
	    day = Integer.parseInt(parts[2]);               
	
	    @SuppressWarnings("deprecation")
	    Date date = new Date(year - 1900, month - 1, day);
    	admin.setBirthdate(date);
    	
    	adminDao.create(admin);
    }


}