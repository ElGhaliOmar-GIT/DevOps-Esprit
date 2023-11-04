import org.junit.jupiter.api.Test;
import tn.esprit.spring.kaddem.entities.Departement;
import static org.junit.jupiter.api.Assertions.*;

public class DepartementTest {

    @Test
    public void testConstructor() {
        Departement departement = new Departement();
        assertNotNull(departement);
    }

    @Test
    public void testParameterizedConstructor() {
        String nomDepart = "Informatique";
        Departement departement = new Departement(nomDepart);
        assertNotNull(departement);
        assertEquals(nomDepart, departement.getNomDepart());
    }

    @Test
    public void testGettersAndSetters() {
        Departement departement = new Departement();

        Integer idDepart = 1;
        departement.setIdDepart(idDepart);
        assertEquals(idDepart, departement.getIdDepart());

        String nomDepart = "Mathématiques";
        departement.setNomDepart(nomDepart);
        assertEquals(nomDepart, departement.getNomDepart());


    }
}



