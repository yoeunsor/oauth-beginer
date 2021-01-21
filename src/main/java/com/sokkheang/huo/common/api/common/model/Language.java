package com.sokkheang.huo.common.api.common.model;

public class Language {
    private int id;
    private String language;
    private String statuscode;

    public Language() {
    }

    public Language(int id, String language, String statuscode) {
        this.id = id;
        this.language = language;
        this.statuscode = statuscode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(String statuscode) {
        this.statuscode = statuscode;
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", statuscode='" + statuscode + '\'' +
                '}';
    }
}
