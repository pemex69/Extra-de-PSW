package Model;

public class Consultation {

    private int vetId;
    private int petId;
    private String consultationDate;
    private String consultationNotes;
    private String consultationTreatment;

    public int getVetId() {
        return vetId;
    }

    public void setVetId(int vetId) {
        this.vetId = vetId;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(String consultationDate) {
        this.consultationDate = consultationDate;
    }

    public String getConsultationNotes() {
        return consultationNotes;
    }

    public void setConsultationNotes(String consultationNotes) {
        this.consultationNotes = consultationNotes;
    }

    public String getConsultationTreatment() {
        return consultationTreatment;
    }

    public void setConsultationTreatment(String consultationTreatment) {
        this.consultationTreatment = consultationTreatment;
    }
}
