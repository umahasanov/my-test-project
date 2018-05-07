package ru.tinkoff.demoproject.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ClientResponseDto {
    private long contactId;

    private long applicationId;

    @XmlJavaTypeAdapter(value = LocalDateTimeXmlAdapter.class)
    private LocalDateTime dateCreated;

    private String productName;

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
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

    @Override
    public String toString() {
        return "ClientResponseDto{" +
                "contactId=" + contactId +
                ", applicationId=" + applicationId +
                ", dateCreated=" + dateCreated +
                ", productName='" + productName + '\'' +
                '}';
    }
}
