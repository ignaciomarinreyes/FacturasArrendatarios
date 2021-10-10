package model;

import java.time.LocalDate;

public class NotificationContract {

    private String lessee;
    private String property;
    private LocalDate expirationDate;

    public NotificationContract(String lessee, String property, LocalDate expirationDate) {
        this.lessee = lessee;
        this.property = property;
        this.expirationDate = expirationDate;
    }

    public String getLessee() {
        return lessee;
    }

    public String getProperty() {
        return property;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

}
