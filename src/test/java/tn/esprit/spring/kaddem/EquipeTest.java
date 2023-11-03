package tn.esprit.spring.kaddem;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.services.EquipeServiceImpl;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class EquipeTest {
    @Mock
    EquipeRepository equipeRepository;

    @InjectMocks
    EquipeServiceImpl equipeService;

    Equipe e1 = new Equipe(1,"equipe1", Niveau.SENIOR);
    Equipe e2 = new Equipe(2,"equipe2",Niveau.JUNIOR);
    List<Equipe> listEquipes = new ArrayList<Equipe>() {
        {
            add(e1);
            add(e2);
        }
    };
    @Test
    public void testretrieveAllEquipes() {
        Mockito.when(equipeRepository.findAll()).thenReturn(listEquipes);
        List<Equipe> listequipe3 = equipeService.retrieveAllEquipes();
        assertEquals(2, listequipe3.size());
        System.out.println("2555");
    }

    @Test
    public void testAddEquipe() {

        Mockito.when(equipeRepository.save(e1)).thenReturn(e1);
        Equipe equipe1 = equipeService.addEquipe(e1);
        Mockito.verify(equipeRepository, times(1)).save(Mockito.any(Equipe.class));
        System.out.println("3");
    }

    @Test
    public void testdeleteEquipe(){
        equipeService.deleteEquipe(2);
        Mockito.verify(equipeRepository, times(1)).deleteById(2);
        System.out.println("4");
    }
    @Test
    public void testupdateEquipe(){
        Mockito.when(equipeRepository.save(e1)).thenReturn(e1);
        Equipe equie1 = equipeService.updateEquipe(e1);
        Mockito.verify(equipeRepository, times(1)).save(Mockito.any(Equipe.class));
        System.out.println("5");
    }

}
