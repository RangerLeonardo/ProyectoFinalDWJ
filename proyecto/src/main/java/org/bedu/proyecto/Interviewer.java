package org.bedu.proyecto;

import java.io.Serializable;
import java.util.ArrayList;

public class Interviewer implements Serializable {
    public static ArrayList<Interviewer> data;

    private int id;
    private String name;
    private String lastName;
    private String email;
    private Boolean isActive;

    public Interviewer(
            String name,
            String lastName,
            String email,
            Boolean isActive
    ) {
        this.id = data.size() + 1;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.isActive = isActive;
    }

    public Interviewer add() {
        data.add(this);
        return this;
    }

    public void save(
            String name,
            String lastName,
            String email,
            Boolean isActive
    ) {
        try {
            this.delete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        if (!name.equals(""))
            this.name = name;

        if (!lastName.equals(""))
            this.lastName = lastName;

        if (!email.equals(""))
            this.email = email;

        this.isActive = isActive;

        data.add(this);
    }

    public static Interviewer getByEmail(String email) {
        for (Interviewer interviewer: data) {
            if (interviewer.email.equals(email))
                return interviewer;
        }

        return null;
    }

    @Override
    public String toString() {
        return "\nID: " + this.id +
                "\nName: " + this.name +
                "\nLast Name: " + this.lastName +
                "\nEmail: " + this.email +
                "\nIs Active: " + this.isActive + "\n";
    }


    public void delete() {
        data.remove(this);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}

