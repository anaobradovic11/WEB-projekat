package beans;

import java.util.Date;

public class TrainingHistory {
	private String id;
	private Date trainingDate;
	private Date dateAndTimeOfSign;
	private String trainingId;
	private String customerId;
	private String trainerId;
	private boolean deleted;
	
	public TrainingHistory() {}
	
	public TrainingHistory(String id, Date trainingDate, Date dateAndTime, String trainingId, String customerId, String trainerId, boolean deleted) {
		super();
		this.id = id;
		this.trainingDate = trainingDate;
		this.dateAndTimeOfSign = dateAndTime;
		this.trainingId = trainingId;
		this.customerId = customerId;
		this.trainerId = trainerId;
		this.deleted = deleted;
	}
	
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getTrainingDate() {
		return trainingDate;
	}
	public void setTrainingDate(Date trainingDate) {
		this.trainingDate = trainingDate;
	}
	public Date getDateAndTimeOfSign() {
		return dateAndTimeOfSign;
	}
	public void setDateAndTimeOfSign(Date dateAndTime) {
		this.dateAndTimeOfSign = dateAndTime;
	}
	public String getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(String trainingId) {
		this.trainingId = trainingId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}
}
