package tn.esprit.spring.kaddem.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Etudiant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class EtudiantTest {

    @Mock
    private Departement mockedDepartement;

    private Etudiant etudiant;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        etudiant = new Etudiant();
    }

    @Test
    public void testGettersAndSetters() {
        etudiant.setIdEtudiant(1);
        etudiant.setNomE("John");
        etudiant.setPrenomE("Doe");
        etudiant.setOp(Option.GAMIX);

        assertEquals(1, etudiant.getIdEtudiant());
        assertEquals("John", etudiant.getNomE());
        assertEquals("Doe", etudiant.getPrenomE());
        assertEquals(Option.GAMIX, etudiant.getOp());
    }

    @Test
    public void testContrats() {
        Set<Contrat> contrats = new HashSet<>();
        Contrat contrat = new Contrat(); // You should create an instance of Contrat
        contrats.add(contrat);

        etudiant.setContrats(contrats);
        assertEquals(1, etudiant.getContrats().size());
    }

   /* @Test
    public void testDepartement() {
        etudiant.setDepartement(mockedDepartement);
        assertNotNull(etudiant.getDepartement());

        // Verify that the departement object was set and accessed
        verify(mockedDepartement, times(1)).getEtudiants();
    }*/

    @Test
    public void testEquipes() {
        List<Equipe> equipes = new ArrayList<>();

        // Create instances of Equipe and add them to the list
        Equipe equipe1 = new Equipe();
        Equipe equipe2 = new Equipe();
        equipes.add(equipe1);
        equipes.add(equipe2);

        etudiant.setEquipes(equipes);

        // Check the size of the equipes list
        assertEquals(2, etudiant.getEquipes().size());
    }

}
