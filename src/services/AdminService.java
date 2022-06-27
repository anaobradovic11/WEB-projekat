package services;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.Admin;
import dao.AdminDao;

@Path("admins")
public class AdminService {
    AdminDao adminDao = new AdminDao();

    @Context
    ServletContext ctx;
    @SuppressWarnings("unused")
    public void init() {
        if (ctx.getAttribute("admins") == null) {
            String contextPath = ctx.getRealPath("");
            ctx.setAttribute("admins", new AdminService());
        }
    }
    public String getContext() {
        return (ctx.getRealPath("") + "WEB-INF" + File.separator + "classes" + File.separator + "json"
                + File.separator);
    }
    @GET
    @Path("/getAllAdmins")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Admin> getAllCustomers() {
        adminDao.setBasePath(getContext());
        return adminDao.getAllToList();
    }
    @POST
    @Path("/createAdmin")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void createCustomer(Admin admin) {
    	adminDao.setBasePath(getContext());
    	adminDao.create(admin);
    }


}