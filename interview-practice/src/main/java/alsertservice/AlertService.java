package alsertservice;

import java.util.Date;
import java.util.UUID;

public class AlertService {

    private AlertDAO alertDAO;

    public AlertService(AlertDAO alertDAO) {
        this.alertDAO = alertDAO;
    }

    public UUID raiseAlert() {
        return this.alertDAO.addAlert(new Date());
    }

    public Date getAlertTime(UUID id) {
        return this.alertDAO.getAlert(id);
    }
}
