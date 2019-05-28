package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "STORAGE")
public class Storage {
    private long id;
    private String formatsSupported;
    private String storageCountry;
    private long storageSize;

    @Id
    @SequenceGenerator(name = "ITEM_S", sequenceName = "ITEM_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_S")
    @Column(name = "ID")
    @JsonProperty("id")
    public long getId() {
        return id;
    }

    @Column(name = "FORMATS_SUPPORTED")
    @JsonProperty("format supported")
    public String getFormatsSupported() {
        return formatsSupported;
    }

    @Column(name = "STORAGE_COUNTRY")
    @JsonProperty("storage_country")
    public String getStorageCountry() {
        return storageCountry;
    }

    @Column(name = "STORAGE_SIZE")
    @JsonProperty("storage size")
    public long getStorageSize() {
        return storageSize;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFormatsSupported(String formatsSupported) {
        this.formatsSupported = formatsSupported;
    }

    public void setStorageCountry(String storageCountry) {
        this.storageCountry = storageCountry;
    }

    public void setStorageSize(long storageSize) {
        this.storageSize = storageSize;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", formatsSupported='" + formatsSupported + '\'' +
                ", storageCountry='" + storageCountry + '\'' +
                ", storageSize=" + storageSize +
                '}';
    }
}
