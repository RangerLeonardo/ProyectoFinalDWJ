package org.bedu.proyecto.model;

import java.util.ArrayList;

public class Discipline {

    public static ArrayList<Discipline> data;
    private int id;
    private String name;
    private String slug;
    private String description;

    public Discipline(String name, String slug, String description) {
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
            String slug,
            String description
    ) {
        try {
            this.delete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }


        if (!name.equals(""))
            this.name = name;

        if (!slug.equals(""))
            this.slug = slug;

        if (!description.equals(""))
            this.description = description;

        data.add(this);
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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
