package org.bedu.proyecto.model;

import org.bedu.proyecto.Interviewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class InterviewTest {
    static Candidate existingCandidate = new Candidate(
            "Juanito",
            "Robinson",
            "juan@email.com",
            true
    );
    static Discipline existingDiscipline = new Discipline(
            "Karate",
            "slug",
            "Deporte karate"
    );
    static InterviewType existingInterviewType = new InterviewType(
            "open",
            "slug",
            "open"
    );
    static  Technology existingTechnology = new Technology(
            "Java",
            "slug",
            "java for jrs"
    );

    static Interviewer existingInterviewer = new Interviewer(
            "Ramon",
            "Lopez",
            "ramon@email.com",
            true
    );

    @BeforeEach
    public void setUp() throws Exception {
        Interview.data = new ArrayList<>();
        Interview.data.add(new Interview(
                existingCandidate,
                existingDiscipline,
                existingInterviewType,
                existingTechnology,
                existingInterviewer
        ));
    }

    @Test
    @DisplayName("Agregamos una entrevista nueva y probamos el metodo add")
    public void add(){
        Interview interview = new Interview(
                existingCandidate,
                existingDiscipline,
                existingInterviewType,
                existingTechnology,
                existingInterviewer
        );

        interview.add();

        int expectedId = Interview.data.size();
        assertEquals(
                expectedId,
                interview.getId(),
                "Interview ID should be the new List's size"
        );

    }

    @Test
    @DisplayName("Verificamos que se puedan hacer cambios metodo save")
    public void save(){
        int originalListSize = Interview.data.size();
        Candidate expectedCandidate = new Candidate(
                "Sopas",
                "Extremo",
                "extremo@email.com",
                false
        );

        Interview existingInterview = Interview.data.get(0);
        existingInterview.save(expectedCandidate,null,null,null,null);

        int newListSize = Interview.data.size();
        int lastInterviewIndex = newListSize -1;
        Interview latestInterview = Interview.data.get(lastInterviewIndex);

        assertEquals(originalListSize,newListSize,"La lista se modificia y no se agrega");
        assertEquals(expectedCandidate,latestInterview.candidate,"Se modificó el candidato");
        assertEquals(existingInterview.candidate,latestInterview.candidate,"Nada cambió");

    }




    @Test
    @DisplayName("Eliminamos una entrevista")
    public void delete() {
        Interview existingInterview = Interview.data.get(0);

        int expectedSize = Interview.data.size() - 1;

        try {
            existingInterview.delete();
        } catch (Exception e) {
            fail("Unexpected Exception received: " + e.getMessage());
        }

        int actualSize = Interview.data.size();

        Assertions.assertEquals(
                expectedSize,
                actualSize,
                "List should be smaller"
        );
    }



}
