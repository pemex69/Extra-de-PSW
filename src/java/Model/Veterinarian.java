package Model;

public class Veterinarian {

    private int vetId;
    private String vetName;
    private String vetEmail;
    private String vetPass;
    private String vetLicense;

    public Veterinarian() {
    }

    public int getVetId() {
        return vetId;
    }

    public void setVetId(int vetId) {
        this.vetId = vetId;
    }

    public String getVetName() {
        return vetName;
    }

    public void setVetName(String vetName) {
        this.vetName = vetName;
    }

    public String getVetEmail() {
        return vetEmail;
    }

    public void setVetEmail(String vetEmail) {
        this.vetEmail = vetEmail;
    }

    public String getVetPass() {
        return vetPass;
    }

    public void setVetPass(String vetPass) {
        this.vetPass = vetPass;
    }

    public String getVetLicense() {
        return vetLicense;
    }

    public void setVetLicense(String vetLicense) {
        this.vetLicense = vetLicense;
    }
}
