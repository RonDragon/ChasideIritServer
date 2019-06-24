package server.main.beans;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import server.main.enums.DeliveryStatus;
import server.main.enums.FamilyStatus;

@Entity
public class Family {		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int familyId;
	private String familyName;
	private int numOfPerInFam;
	private String currentAddres;
	private String urlAddres;
	private String famPhoneNum;
	private String socialWorker;
	private boolean madePhoneCall;
	@Enumerated(EnumType.STRING)
	private FamilyStatus familyStatus;
	@Enumerated(EnumType.STRING)
	private DeliveryStatus deliveryStatus;
	@ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "volunteer")
	private List<Volunteer> volunteer = new ArrayList<>();
	private String managerNote;
	private String volunteerNote;
	private Date startDeliveryDate;
	private Date endDeliveryDate;
	// const
	public Family() {}
	public Family(int familyId, String familyName, int numOfPerInFam, String currentAddres, String urlAddres,
			String famPhoneNum, String socialWorker, boolean madePhoneCall, FamilyStatus familyStatus,
			DeliveryStatus deliveryStatus, List<Volunteer> volunteer, String managerNote, String volunteerNote,
			Date startDeliveryDate, Date endDeliveryDate) {
		this.familyId = familyId;
		this.familyName = familyName;
		this.numOfPerInFam = numOfPerInFam;
		this.currentAddres = currentAddres;
		this.urlAddres = urlAddres;
		this.famPhoneNum = famPhoneNum;
		this.socialWorker = socialWorker;
		this.madePhoneCall = madePhoneCall;
		this.familyStatus = familyStatus;
		this.deliveryStatus = deliveryStatus;
		this.volunteer = volunteer;
		this.managerNote = managerNote;
		this.volunteerNote = volunteerNote;
		this.startDeliveryDate = startDeliveryDate;
		this.endDeliveryDate = endDeliveryDate;
	}
	public Family( String familyName, int numOfPerInFam, String currentAddres, String urlAddres,
			String famPhoneNum, String socialWorker, boolean madePhoneCall, FamilyStatus familyStatus,
			DeliveryStatus deliveryStatus, List<Volunteer> volunteer, String managerNote, String volunteerNote,
			Date startDeliveryDate, Date endDeliveryDate) {
		this.familyName = familyName;
		this.numOfPerInFam = numOfPerInFam;
		this.currentAddres = currentAddres;
		this.urlAddres = urlAddres;
		this.famPhoneNum = famPhoneNum;
		this.socialWorker = socialWorker;
		this.madePhoneCall = madePhoneCall;
		this.familyStatus = familyStatus;
		this.deliveryStatus = deliveryStatus;
		this.volunteer = volunteer;
		this.managerNote = managerNote;
		this.volunteerNote = volunteerNote;
		this.startDeliveryDate = startDeliveryDate;
		this.endDeliveryDate = endDeliveryDate;
	}
	// get&set
	public int getFamilyId() {
		return familyId;
	}
	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public int getNumOfPerInFam() {
		return numOfPerInFam;
	}
	public void setNumOfPerInFam(int numOfPerInFam) {
		this.numOfPerInFam = numOfPerInFam;
	}
	public String getCurrentAddres() {
		return currentAddres;
	}
	public void setCurrentAddres(String currentAddres) {
		this.currentAddres = currentAddres;
	}
	public String getUrlAddres() {
		return urlAddres;
	}
	public void setUrlAddres(String urlAddres) {
		this.urlAddres = urlAddres;
	}
	public String getFamPhoneNum() {
		return famPhoneNum;
	}
	public void setFamPhoneNum(String famPhoneNum) {
		this.famPhoneNum = famPhoneNum;
	}
	public String getSocialWorker() {
		return socialWorker;
	}
	public void setSocialWorker(String socialWorker) {
		this.socialWorker = socialWorker;
	}
	public boolean isMadePhoneCall() {
		return madePhoneCall;
	}
	public void setMadePhoneCall(boolean madePhoneCall) {
		this.madePhoneCall = madePhoneCall;
	}
	public FamilyStatus getFamilyStatus() {
		return familyStatus;
	}
	public void setFamilyStatus(FamilyStatus familyStatus) {
		this.familyStatus = familyStatus;
	}
	public DeliveryStatus getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public List<Volunteer> getVolunteer() {
		return volunteer;
	}
	public void setVolunteer(List<Volunteer> volunteer) {
		this.volunteer = volunteer;
	}
	public String getManagerNote() {
		return managerNote;
	}
	public void setManagerNote(String managerNote) {
		this.managerNote = managerNote;
	}
	public String getVolunteerNote() {
		return volunteerNote;
	}
	public void setVolunteerNote(String volunteerNote) {
		this.volunteerNote = volunteerNote;
	}
	public Date getStartDeliveryDate() {
		return startDeliveryDate;
	}
	public void setStartDeliveryDate(Date startDeliveryDate) {
		this.startDeliveryDate = startDeliveryDate;
	}
	public Date getEndDeliveryDate() {
		return endDeliveryDate;
	}
	public void setEndDeliveryDate(Date endDeliveryDate) {
		this.endDeliveryDate = endDeliveryDate;
	}
	@Override
	public String toString() {
		return "Family [familyId=" + familyId + ", familyName=" + familyName + ", numOfPerInFam=" + numOfPerInFam
				+ ", currentAddres=" + currentAddres + ", urlAddres=" + urlAddres + ", famPhoneNum=" + famPhoneNum
				+ ", socialWorker=" + socialWorker + ", madePhoneCall=" + madePhoneCall + ", familyStatus="
				+ familyStatus + ", deliveryStatus=" + deliveryStatus + ", volunteer=" + volunteer + ", managerNote="
				+ managerNote + ", volunteerNote=" + volunteerNote + ", startDeliveryDate=" + startDeliveryDate
				+ ", endDeliveryDate=" + endDeliveryDate + "]";
	}
	
}
