package ru.borsch.simple.subject;

import ru.borsch.simple.api.ActionContext;

public class SubjectString implements ActionContext {

    private String modifiedString;

    public SubjectString() {
        this("");
    }

    public SubjectString(String modifiedString) {
        this.modifiedString = modifiedString;
    }

    public String getModifiedString() {
        return modifiedString;
    }

    public void setModifiedString(String modifiedString) {
        this.modifiedString = modifiedString;
    }
}
