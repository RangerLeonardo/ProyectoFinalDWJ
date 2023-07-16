package org.bedu.proyecto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DisciplineTest {

    static String existingDisciplineName="Karate";
    static String existingDisciplineSlug="Slug";
    static String existingDisciplineDescription="Para variar un poco";

    @BeforeEach
    public void setUp() throws Exception {
        Discipline.data = new ArrayList<>();

//        Insert of user for testing
        Discipline.data.add(new Discipline(
                existingDisciplineName,
                existingDisciplineSlug,
                existingDisciplineDescription
        ));
    }

    @Test
    @DisplayName("new discipline added successfully")
    public void add(){
        Discipline discipline = new Discipline(
                "Box",
                "Slug",
                "Sé que no hablamos de disciplinas de deportes"
        );
        discipline.add();
        int expectedId = Discipline.data.size();
        assertEquals(expectedId, discipline.getId(),
                "Se agregó correctamente y es el mismo id que el tamaño de lista");
    }

    @Test
    @DisplayName("we modify the data of a discipline")
    public void save(){
        int listSize = Discipline.data.size();
        String expectedName="Karate";
        Discipline existingDiscipline = Discipline.data.get(0);
        existingDiscipline.save(expectedName,"","");

        int newListSize = Discipline.data.size();
        int lastDisciplineIndex = newListSize -1;
        Discipline latestDiscipline = Discipline.data.get(lastDisciplineIndex);

        assertEquals(listSize, newListSize, "Las listas deben ser el mismo tamaño");
        assertEquals(expectedName,latestDiscipline.getName(),"Los nombres debieron haber cambiado");
        assertEquals(existingDiscipline.getName(),latestDiscipline.getName(),"Los nombres no cambiaron");

    }

    @Test
    @DisplayName("We delete a discipline")
    public void deleteDiscipline(){
        Discipline existingDiscipline = Discipline.data.get(0);
        int expectedSize = Discipline.data.size() -1;

        try {
            existingDiscipline.delete();
        }catch (Exception e){
            fail("Error deleting discipline: " +e.getMessage());
        }
        int actualSize = Discipline.data.size();

        assertEquals(expectedSize, actualSize, "La lista es menor en tamaño");

    }


}
