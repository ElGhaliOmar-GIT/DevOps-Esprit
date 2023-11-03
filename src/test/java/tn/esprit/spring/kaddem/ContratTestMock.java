package tn.esprit.spring.kaddem;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Specialite;
import tn.esprit.spring.kaddem.repositories.ContratRepository;
import tn.esprit.spring.kaddem.services.ContratServiceImpl;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)   //indique à JUnit d'utiliser le runner MockitoJUnitRunner
public class ContratTestMock {

    @Mock
    ContratRepository contratRepository;

    @InjectMocks
    ContratServiceImpl contratServiceimpl;



//intialisation des objets a tester
    Contrat c1 = new Contrat( 1,Specialite.CLOUD, 250);
    Contrat c2 = new Contrat(2, Specialite.RESEAUX, 320);
    Contrat c3 = new Contrat( 3,Specialite.IA, 280);

    List<Contrat> listContrat = new ArrayList<Contrat>() {
        {
            add(c1);
            add(new Contrat( 4,Specialite.CLOUD, 800));
            add(new Contrat(4, Specialite.SECURITE, 900));

        }
    };



    @Test
    public void testfindAllContrat() {
        Mockito.when(contratRepository.findAll()).thenReturn(listContrat);
        List<Contrat> listContrat = contratServiceimpl.retrieveAllContrats();
        assertEquals(3, listContrat .size());
        System.out.println("test test");
    }




    @Test
    public void testAddContrat() {

        Mockito.when(contratRepository.save(c1)).thenReturn(c1);
       Contrat contrat1 = contratServiceimpl.addContrat(c1);
        Mockito.verify(contratRepository, times(1)).save(Mockito.any(Contrat.class));
        System.out.println("test add");
    }



    @Test
    public void testdeleteContrat(){
        contratServiceimpl.removeContrat(1);
        Mockito.verify(contratRepository, times(1)).deleteById(1);
        System.out.println("test delete");
    }



    @Test
    public void testupdateContrat(){
        Mockito.when(contratRepository.save(c1)).thenReturn(c1);
        Contrat contrat1 = contratServiceimpl.updateContrat(c1);
        Mockito.verify(contratRepository, times(1)).save(Mockito.any(Contrat.class));
        System.out.println("test update");
    }



}
