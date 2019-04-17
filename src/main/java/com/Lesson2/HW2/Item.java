package com.Lesson2.HW2;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ITEM")

public class Item {
    private long id;
    private String name;
    private Date dateCreated;
    private Date lastDateUpdate;
    private String description;

    @Id
    @SequenceGenerator(name = "ITEM_S", sequenceName = "ITEM_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_S")
    @Column(name = "ID")
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @Column(name = "NAME")
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("DateCreated")
    @JsonFormat(pattern = "dd.mm.yyyy")
    @Column(name = "DATE_CREATED")
    public Date getDateCreated() {
        return dateCreated;
    }

    @JsonProperty("LastDateUpdate")
    @JsonFormat(pattern = "dd.mm.yyyy")
    @Column(name = "LAST_DATE_UPDATE")
    public Date getLastDateUpdate() {
        return lastDateUpdate;
    }

    @JsonProperty("Description")
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setLastDateUpdate(Date lastDateUpdate) {
        this.lastDateUpdate = lastDateUpdate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateCreated=" + dateCreated +
                ", lastDateUpdate=" + lastDateUpdate +
                ", description='" + description + '\'' +
                '}';
    }
}
