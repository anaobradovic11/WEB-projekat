package services;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Admin;
import dao.AdminDao;

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
    public void createAdmin(Admin admin) {
    	adminDao.setBasePath(getContext());
    	adminDao.create(admin);
    }


}