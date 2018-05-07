package ru.tinkoff.demoproject.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Products implements Comparable{

    @Id
    @GeneratedValue
    @Column(name = "application_id", nullable = false)
    private long applicationId;

    @Column(name = "dtCreated", nullable = false)
    private LocalDateTime dateCreated;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "client_id")
    private long clientId;

    public Products(LocalDateTime dateCreated, String productName, long clientId) {
        this.dateCreated = dateCreated;
        this.productName = productName;
        this.clientId = clientId;
    }

    public Products() {
    }

    public long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(long applicationId) {
        this.applicationId = applicationId;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Products{" +
                "applicationId=" + applicationId +
                ", dateCreated=" + dateCreated +
                ", productName='" + productName + '\'' +
                ", clientId=" + clientId +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return ((Products)o).getDateCreated().compareTo(this.getDateCreated());
    }
}
