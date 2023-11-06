package tn.esprit.spring.kaddem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.repositories.UniversiteRepository;
import tn.esprit.spring.kaddem.services.UniversiteServiceImpl;

import java.util.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UniversiteTest {
    @InjectMocks
    UniversiteServiceImpl uniService;
    @Mock
    UniversiteRepository uniRepo;
    Universite uniEntity = new Universite(1, "Harvard");
    List<Universite> uniList = new ArrayList<Universite>() {
        {
            add(new Universite(2, "ESPRIT"));
            add(new Universite(3, "Kalvin"));
            add(new Universite(4, "Borsa"));
        }
    };

    @Test
    public void findUniById() {
        Mockito.when(uniRepo.findById(Mockito.anyInt())).thenReturn(Optional.of(uniEntity));
        Universite uni = uniService.retrieveUniversite(1);
        Assertions.assertNotNull(uni);
    }

    @Test
    public void testGetAllUni() {
        Mockito.when(uniRepo.findAll()).thenReturn(uniList);
        List<Universite> unis = uniService.retrieveAllUniversites();
        Assertions.assertEquals(3, unis.size());
    }

    @Test
    public void testAddUni() {
        Universite uni = new Universite(10, "SKD");
        Mockito.when(uniRepo.save(uni)).thenReturn(uni);
        Assertions.assertEquals(uni, uniService.addUniversite(uni));
    }

    @Test
    public void testUpdateUni() {
        Universite uni = new Universite(10, "SKD");
        when(uniRepo.save(uni)).thenReturn(uni);
        Universite updatedUni = uniService.updateUniversite(uni);
        Assertions.assertNotNull(updatedUni);
        Assertions.assertEquals(10, updatedUni.getIdUniv().intValue());
    }

    @Test
    public void testDeleteUni() {
        Universite uni = new Universite(10, "SKD");
        when(uniRepo.findById(10)).thenReturn(Optional.of(uni));
        uniService.deleteUniversite(10);
        Mockito.verify(uniRepo, Mockito.times(1)).delete(uni);
    }
}
