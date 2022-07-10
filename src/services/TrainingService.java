package services;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


import beans.Training;

import dao.TrainingDao;
import dto.TrainingDTO;


@Path("/trainings")
public class TrainingService {

	TrainingDao trainingDao = new TrainingDao();
    
    @Context
    ServletContext ctx;
    
    @SuppressWarnings("unused")
    public void init() {
        if (ctx.getAttribute("trainings") == null) {
            String contextPath = ctx.getRealPath("");
            ctx.setAttribute("trainings", new TrainingService());
        }
    }
    
    public String getContext() {
        return (ctx.getRealPath("") + "WEB-INF" + File.separator + "classes" + File.separator + "json"
                + File.separator);
    }
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Training> getAllTrainings() {
    	trainingDao.setBasePath(getContext());
        return trainingDao.getAllToList();
    }
    
    @GET
	@Path("/getTrainingById/{trainingId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Training getTrainingById(@PathParam("trainingId") String trainingId) {
		trainingDao.setBasePath(getContext());
		return trainingDao.getById(trainingId);
	}
    
    @GET
    @Path("/getTrainingsByTrainingType/{trainingType}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Training> getTrainingsByTrainingType(@PathParam("trainingType") String trainingType) {
    	trainingDao.setBasePath(getContext());
    	
    	ArrayList<Training> treningsToFill = new ArrayList<Training>();
    	ArrayList<Training> trainings = trainingDao.getAllToList();
    	for(Training t : trainings) {
    		if(t.getType().equals(trainingType)) {
    			treningsToFill.add(t);
    		}
    	}
        return treningsToFill;
    }
    
    @GET
    @Path("/getTrainingsByTrainerId/{trainerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Training> getTrainingsByTrainerId(@PathParam("trainerId") String trainerId) {
    	trainingDao.setBasePath(getContext());
    	
    	ArrayList<Training> treningsToFill = new ArrayList<Training>();
    	ArrayList<Training> trainings = trainingDao.getAllToList();
    	for(Training t : trainings) {
    		if(t.getTrainerId().equals(trainerId)) {
    			treningsToFill.add(t);
    		}
    	}
        return treningsToFill;
    }
    
    @GET
    @Path("/getTrainingsByFacilityId/{sportFacilityId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Training> getTrainingsByFacilityId(@PathParam("sportFacilityId") String sportFacilityId) {
    	trainingDao.setBasePath(getContext());
    	
    	ArrayList<Training> treningsToFill = new ArrayList<Training>();
    	ArrayList<Training> trainings = trainingDao.getAllToList();
    	for(Training t : trainings) {
    		if(t.getSportFacilityId().equals(sportFacilityId)) {
    			treningsToFill.add(t);
    		}
    	}
        return treningsToFill;
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void createTraining(TrainingDTO trainingDTO) {
    	trainingDao.setBasePath(getContext());
    	
    	Training training = new Training();
    	training.setDeleted(trainingDTO.isDeleted());
    	training.setDescription(trainingDTO.getDescription());
    	training.setImageName(trainingDTO.getImageName());
    	training.setName(trainingDTO.getName());
    	training.setSportFacilityId(trainingDTO.getSportFacilityId());
    	training.setTrainerId(trainingDTO.getTrainerId());
    	training.setType(trainingDTO.getType());
		training.setDurationInMinutes(Integer.parseInt(trainingDTO.getDurationInMinutes()));
        
    	trainingDao.create(training);
    }
    
    @POST
    @Path("/noDTOtraining")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void createNoDTOTraining(Training training) {
    	trainingDao.setBasePath(getContext());     
    	trainingDao.create(training);
    }
}
