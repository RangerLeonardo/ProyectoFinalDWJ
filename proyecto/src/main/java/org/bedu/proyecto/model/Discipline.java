package org.bedu.proyecto.model;

import java.util.ArrayList;

public class Discipline {

    public ArrayList<Discipline> data;
    int id;
    String name;
    String slug;
    String description;

    public Discipline(int id, String name, String slug, String description) {
        this.id = data.size()+1;
        this.name = name;
        this.slug = slug;
        this.description = description;
    }

    public Discipline add(){
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

//
//        if (!name.equals(""))
//            this.name = name;
//
//        if (!lastName.equals(""))
//            this.lastName = lastName;
//
//        if (!email.equals(""))
//            this.email = email;
//
//        this.isActive = isActive;
//
//        data.add(this);
    }

    public void delete() {
        data.remove(this);

    }


}
