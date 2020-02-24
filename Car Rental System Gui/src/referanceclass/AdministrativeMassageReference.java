package referanceclass;

import java.io.Serializable;
import java.sql.Timestamp;

public class AdministrativeMassageReference implements Serializable {
    private int idMassage;
    private Timestamp dateCreate;
    private String massage;
    private String sender;

    public AdministrativeMassageReference(int idMassage, Timestamp dateCreate, String massage, String sender) {
        this.idMassage = idMassage;
        this.dateCreate = dateCreate;
        this.massage = massage;
        this.sender = sender;
    }

    public int getIdMassage() {
        return idMassage;
    }

    public void setIdMassage(int idMassage) {
        this.idMassage = idMassage;
    }

    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "AdministrativeMassageReference{" +
                "idMassage=" + idMassage +
                ", dateCreate=" + dateCreate +
                ", massage='" + massage + '\'' +
                ", sender='" + sender + '\'' +
                '}';
    }
}
