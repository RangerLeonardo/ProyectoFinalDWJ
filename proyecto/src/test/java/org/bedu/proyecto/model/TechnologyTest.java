package org.bedu.proyecto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TechnologyTest {
    static String existingTechnologyName="Java";
    static String existingTechnologySlug="Slug";
    static String existingTechnologyDescription="Test for Jr java";

    @BeforeEach
    public void setUp() throws Exception {
        Technology.data = new ArrayList<>();

//        Insert of user for testing
        Technology.data.add(new Technology(
                existingTechnologyName,
                existingTechnologySlug,
                existingTechnologyDescription
        ));
    }

    @Test
    @DisplayName("new technology added successfully")
    public void add(){
        Technology technology = new Technology(
                "Python",
                "Slug",
                "Test for Data Science"
        );
        technology.add();
        int expectedId = Technology.data.size();
        assertEquals(expectedId, technology.getId(),
                "Se agregó correctamente y es el mismo id que el tamaño de lista");
    }

    @Test
    @DisplayName("we modify the data of a technology")
    public void save(){
        int listSize = Technology.data.size();
        String expectedName="Python";

        Technology existingTechnology = (Technology) Technology.data.get(0);
        existingTechnology.save(expectedName,"","");

        int newListSize = Technology.data.size();
        int lastTechnologyIndex = newListSize -1;
        Technology latestTechnology = (Technology) Technology.data.get(lastTechnologyIndex);

        assertEquals(listSize, newListSize, "Las listas deben ser el mismo tamaño");
        assertEquals(expectedName,latestTechnology.getName(),"Los nombres debieron haber cambiado");
        assertEquals(existingTechnology.getName(),latestTechnology.getName(),"Los nombres no cambiaron");

    }

    @Test
    @DisplayName("We delete a technology")
    public void delete(){
        Technology existingTechnology = (Technology) Technology.data.get(0);
        int expectedSize = Technology.data.size() -1;

        try {
            existingTechnology.delete();
        }catch (Exception e){
            fail("Error deleting technology: " +e.getMessage());
        }
        int actualSize = Technology.data.size();

        assertEquals(expectedSize, actualSize, "La lista es menor en tamaño");

    }
}
