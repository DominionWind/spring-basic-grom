package com.Lesson3.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "FILES")

public class File {
    private long id;
    private String name;
    private String format;
    private long size;
    private Storage storage;

    @Id
    @SequenceGenerator(name = "ITEM_S", sequenceName = "ITEM_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_S")
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "FORMAT")
    public String getFormat() {
        return format;
    }

    @Column(name = "FILE_SIZE")
    public long getSize() {
        return size;
    }

    @ManyToOne
    @JoinColumn(name = "STORAGE_ID", nullable = false)
    public Storage getStorage() {
        return storage;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return id == file.id &&
                Objects.equals(name, file.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", format='" + format + '\'' +
                ", size=" + size +
                ", storage=" + storage +
                '}';
    }
}
