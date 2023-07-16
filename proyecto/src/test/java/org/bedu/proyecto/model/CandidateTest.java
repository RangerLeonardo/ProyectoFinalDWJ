package org.bedu.proyecto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CandidateTest {
    static String existingCandidateName = "Juanito";
    static String existingCandidateLastName = "Alcachofa";
    static String existingCandidateEmail = "alcachofa@gmail.com";

    @BeforeEach
    public void setUp() throws Exception {
        Candidate.data = new ArrayList<>();

        // We insert a user for testing delete and save
        Candidate.data.add(new Candidate(
                existingCandidateName,
                existingCandidateLastName,
                existingCandidateEmail,
                true
        ));
    }

    @Test
    @DisplayName("new Candidate added successfully")
    public void add() {
        Candidate candidate = new Candidate(
                "Juanito",
                "Alcachofa",
                "Juan@alcachofa.com",
                true
        );

        candidate.add();

        int expectedId = Candidate.data.size();
        assertEquals(
                expectedId,
                candidate.getId(),
                "Candidate ID should be the new List's size"
        );
    }


    @Test
    public void save() {
        int originalListSize = Candidate.data.size();
        String expectedLastName = "Gutierritos";
        String expectedName = "Jefferson";
        String expectedEmail = "jg@email.com";
        Candidate existingCandidate =(Candidate) Candidate.data.get(0);
        existingCandidate.save(expectedName, expectedLastName, expectedEmail, true);

        int newListSize = Candidate.data.size();
        int lastCandidateIndex = newListSize - 1;
        Candidate latestCandidate =(Candidate) Candidate.data.get(lastCandidateIndex);

        assertEquals(originalListSize, newListSize, "List size should be the same");
        assertEquals(
                expectedLastName,
                latestCandidate.getLastName(),
                "Last Name should have been updated"
        );
        assertEquals(
                existingCandidate.getName(),
                latestCandidate.getName(),
                "Name should have not been updated"
        );
    }

    @Test
    public void getByEmail() {
        Candidate result =(Candidate) Candidate.getByEmail(existingCandidateEmail);

        assertNotNull(result, "Candidate should be found");
        assertEquals(
                existingCandidateName,
                result.getName(),
                "Unexpected Candidate Name"
        );
        assertEquals(
                existingCandidateLastName,
                result.getLastName(),
                "Unexpected Candidate Last Name"
        );
    }

    @Test
    public void getByNonExistingEmail() {
        String nonExistingEmail = "nonexisting@email.com";

        Candidate result = (Candidate) Candidate.getByEmail(nonExistingEmail);

        assertNull(result, "Candidate should not be found");
    }

    @Test
    public void delete() {
        Candidate existingCandidate =(Candidate) Candidate.data.get(0);

        int expectedSize = Candidate.data.size() - 1;

        try {
            existingCandidate.delete();
        } catch (Exception e) {
            fail("Unexpected Exception received: " + e.getMessage());
        }

        int actualSize = Candidate.data.size();

        assertEquals(
                expectedSize,
                actualSize,
                "List should be smaller"
        );
    }

}
