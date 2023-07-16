package org.bedu.proyecto.model;

import org.bedu.proyecto.Interviewer;

import java.util.ArrayList;

public class Interview {

    public static ArrayList<Interview> data;

    public int id;
    Candidate candidate;
    Discipline discipline;
    InterviewType type;
    Technology technology;
    Interviewer interviewer;

    public Interview(Candidate candidate, Discipline discipline, InterviewType type, Technology technology, Interviewer interviewer) {
        this.id= data.size()+1;
        this.candidate = candidate;
        this.discipline = discipline;
        this.type = type;
        this.technology = technology;
        this.interviewer = interviewer;
    }

    public Interview add(){
        data.add(this);
        return this;
    }

    public void save(
        Candidate candidate,
        Discipline discipline,
        InterviewType type,
        Technology technology,
        Interviewer interviewer
    ) {
        try {
            this.delete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        if (candidate != null && !candidate.equals(this.candidate))
            this.candidate = candidate;

        if (discipline != null && !discipline.equals(this.discipline))
            this.discipline = discipline;

        if (type != null && !type.equals(this.type))
            this.type = type;

        if (technology != null && !technology.equals(this.technology))
            this.technology = technology;

        if (interviewer != null && !interviewer.equals(this.interviewer))
            this.interviewer = interviewer;
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
}
