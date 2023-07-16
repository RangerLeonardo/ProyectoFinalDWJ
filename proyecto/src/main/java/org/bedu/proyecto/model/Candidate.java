package org.bedu.proyecto.model;

import org.bedu.proyecto.Interviewer;

public class Candidate extends Interviewer {
    public Candidate(String name, String lastName, String email, Boolean isActive) {
        super(name, lastName, email, isActive);
    }
}
