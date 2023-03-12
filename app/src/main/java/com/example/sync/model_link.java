package com.example.sync;

public class model_link {
    String username;
    Boolean attached;
    int company;

    public model_link(int company, String username, Boolean attached) {
        this.company = company;
        this.username = username;
        this.attached = attached;
    }

    public int getCompany() {
        return company;
    }

    public void setCompany(int company) {
        this.company = company;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getAttached() {
        return attached;
    }

    public void setAttached(Boolean attached) {
        this.attached = attached;
    }
}
