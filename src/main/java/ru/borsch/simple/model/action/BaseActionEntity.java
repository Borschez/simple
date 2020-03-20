package ru.borsch.simple.model.action;

import ru.borsch.simple.model.data.VersionableEntity;

import javax.persistence.*;

@MappedSuperclass
public class BaseActionEntity extends VersionableEntity {

    @Column
    private Boolean active;

    @Column(length = 128)
    private String name;
    @Column(length = 1024)
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
