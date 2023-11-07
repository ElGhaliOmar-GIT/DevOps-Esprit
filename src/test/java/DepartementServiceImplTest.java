
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.services.DepartementServiceImpl;

import java.util.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DepartementServiceImplTest {
    @InjectMocks
    private DepartementServiceImpl departementService;

    @Mock
    private DepartementRepository departementRepository;

    @Test
    public void RetrieveAlDepartements() {
        List<Departement> uniList = new ArrayList<Departement>() {
            {
                add(new Departement(1, "DRH"));
                add(new Departement(4, "informatique"));
                add(new Departement(7, "marketing"));
            }
        };
        when(departementRepository.findAll()).thenReturn(uniList);
        List<Departement> unis = departementService.retrieveAllDepartements();
        Assertions.assertEquals(3, unis.size());
    }

        @Test
        public void testaddDepartement() {

            Departement dep = new Departement(2, "finance");
            when(departementRepository.save(dep)).thenReturn(dep);
            Assertions.assertEquals(dep, departementService.addDepartement(dep));
        }

    @Test
    public void testRetrieveDepartement() {

        Departement departementEntity = new Departement(1, "DRH");
        when(departementRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(departementEntity));
        Departement departement = departementService.retrieveDepartement(1);
        Assertions.assertNotNull(departement);

        Assertions.assertEquals(departementEntity.getIdDepart(), departement.getIdDepart());
        Assertions.assertEquals(departementEntity.getNomDepart(), departement.getNomDepart());
    }



    @Test
    public void testDeleteDepartement() {
        // Créez un objet Departement fictif
        Departement departement = new Departement(10, "Informatique");

        // Définissez le comportement de departementRepository.findById
        when(departementRepository.findById(10)).thenReturn(Optional.of(departement));

        // Appelez la méthode du service pour supprimer le département par son identifiant
        departementService.deleteDepartement(10);

        // Vérifiez que la méthode delete a été appelée avec le bon département
        Mockito.verify(departementRepository, Mockito.times(1)).delete(departement);
    }

    @Test
    public void testUpdateDepartement() {
        Departement dep = new Departement(2, "finance");
        when(departementRepository.save(dep)).thenReturn(dep);
        Departement updatedep = departementService.updateDepartement(dep);
        Assertions.assertNotNull(updatedep);
        Assertions.assertEquals(2, updatedep.getIdDepart().intValue());
    }



}
