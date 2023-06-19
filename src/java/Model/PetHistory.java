package Model;

public class PetHistory {

    private int historyId;
    private int petId;
    private String consultationDate;
    private String consultationNotes;
    private String consultationTreatment;
    private String petLabHistory;

    public PetHistory(int historyId, int petId, String consultationDate, String consultationNotes,
            String consultationTreatment, String petLabHistory) {
        this.historyId = historyId;
        this.petId = petId;
        this.consultationDate = consultationDate;
        this.consultationNotes = consultationNotes;
        this.consultationTreatment = consultationTreatment;
        this.petLabHistory = petLabHistory;
    }

    public PetHistory() {
        //
    }

    public int getHistoryId() {
        return historyId;
    }

    public int getPetId() {
        return petId;
    }

    public String getConsultationDate() {
        return consultationDate;
    }

    public String getConsultationNotes() {
        return consultationNotes;
    }

    public String getConsultationTreatment() {
        return consultationTreatment;
    }

    public String getPetLabHistory() {
        return petLabHistory;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public void setConsultationDate(String consultationDate) {
        this.consultationDate = consultationDate;
    }

    public void setConsultationNotes(String consultationNotes) {
        this.consultationNotes = consultationNotes;
    }

    public void setConsultationTreatment(String consultationTreatment) {
        this.consultationTreatment = consultationTreatment;
    }

    public void setPetLabHistory(String petLabHistory) {
        this.petLabHistory = petLabHistory;
    }
    
}
