package ru.borsch.simple.subject;

import ru.borsch.simple.api.ActionContext;

public class OwnerString implements ActionContext {
    private String owner;

    public OwnerString() {}

    public OwnerString(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
