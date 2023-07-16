package org.bedu.proyecto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class InterviewTypeTest {
    static String existingInterviewTypeName="Psychometric";
    static String existingInterviewTypeSlug="Slug";
    static String existingInterviewTypeDescription="Interview of insanes";

    @BeforeEach
    public void setUp() throws Exception {
        InterviewType.data = new ArrayList<>();

//        Insert of user for testing
        InterviewType.data.add(new InterviewType(
                existingInterviewTypeName,
                existingInterviewTypeSlug,
                existingInterviewTypeDescription
        ));
    }

    @Test
    @DisplayName("new interviewType added successfully")
    public void add(){
        InterviewType interviewType = new InterviewType(
                "behavioral",
                "Slug",
                "interview for behavior"
        );
        interviewType.add();
        int expectedId = InterviewType.data.size();
        assertEquals(expectedId, interviewType.getId(),
                "Se agregó correctamente y es el mismo id que el tamaño de lista");
    }

    @Test
    @DisplayName("we modify the data of a interviewType")
    public void save(){
        int listSize = InterviewType.data.size();
        String expectedName="behavioral";

        InterviewType existingTechnology = (InterviewType) InterviewType.data.get(0);
        existingTechnology.save(expectedName,"","");

        int newListSize = InterviewType.data.size();
        int lastTechnologyIndex = newListSize -1;
        InterviewType latestTechnology = (InterviewType) InterviewType.data.get(lastTechnologyIndex);

        assertEquals(listSize, newListSize, "Las listas deben ser el mismo tamaño");
        assertEquals(expectedName,latestTechnology.getName(),"Los nombres debieron haber cambiado");
        assertEquals(existingTechnology.getName(),latestTechnology.getName(),"Los nombres no cambiaron");

    }

    @Test
    @DisplayName("We delete a interviewType")
    public void delete(){
        InterviewType existingInterviewType = (InterviewType) InterviewType.data.get(0);
        int expectedSize = InterviewType.data.size() -1;

        try {
            existingInterviewType.delete();
        }catch (Exception e){
            fail("Error deleting interviewType: " +e.getMessage());
        }
        int actualSize = InterviewType.data.size();

        assertEquals(expectedSize, actualSize, "La lista es menor en tamaño");

    }
}
