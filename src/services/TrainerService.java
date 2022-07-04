package services;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
<<<<<<< HEAD
import javax.ws.rs.core.MediaType;

import beans.Trainer;
import dao.TrainerDao;

@Path("/trainers")
public class TrainerService extends BaseService{
    TrainerDao trainerDao = new TrainerDao();

    @SuppressWarnings("unused")
    public void init() {
        if (ctx.getAttribute("trainers") == null) {
            String contextPath = ctx.getRealPath("");
            ctx.setAttribute("trainers", new TrainerService());
        }
    }
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Trainer> getAllTrainers() {
        trainerDao.setBasePath(getContext());
        return trainerDao.getAllToList();
    }
    
    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void createTrainer(Trainer trainer) {
        trainerDao.setBasePath(getContext());
        trainerDao.create(trainer);
    }


}
