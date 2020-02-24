package referanceclass;

import java.io.Serializable;
import java.sql.Timestamp;

public class NormalMassageReference extends AdministrativeMassageReference implements Serializable {
    private String receiver;

    public NormalMassageReference(int idMassage, Timestamp dateCreate, String massage, String sender, String receiver) {
        super(idMassage, dateCreate, massage, sender);
        this.receiver = receiver;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "NormalMassageReference{" +
                "receiver='" + receiver + '\'' +
                '}';
    }
}
