package testen;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import domein.ContinentService;
import persistentie.PersistentieController;

@ExtendWith(MockitoExtension.class)
public class ContinentServiceTest {
	
	private final String CODE = "CODE";
	//mock object
	@Mock
	private PersistentieController persitentieControllerMock;
	
	
	//target object
	@InjectMocks
	private ContinentService cs;
	
	@Test
	public void testGeboorteOverschot() { 
		//trainen mock object
		dummyTrainer(16105399L, 184634L, 135136L);
		//controle
		//aanroep + assert + verify
		controleGeboorteOverschot(3.01);
		
		
	}
	
	@Test
	public void testSterfteOverschot() {
		dummyTrainer(18506500L, 277597L, 333117L);
	}
	
	private void dummyTrainer(long aantaInwoners, long aantalGeboortes, long aantalSterftes) {
		//trainen van mock object
		Mockito.when(persitentieControllerMock.findAantalBewoners(CODE)).thenReturn(aantaInwoners);
		Mockito.when(persitentieControllerMock.findGeboortecijfers(CODE)).thenReturn(aantalGeboortes);
		Mockito.when(persitentieControllerMock.findSterfteCijfer(CODE)).thenReturn(aantalSterftes);
		
	}
	
	private void controleGeboorteOverschot(double verwachteResultaat) {
		//aanroep
		double geboorteOverschot = cs.geefGeboorteOverschot(CODE);
		//bewering
		Assertions.assertEquals(verwachteResultaat, geboorteOverschot,0.01);
		//verify
		Mockito.verify(persitentieControllerMock.findAantalBewoners(CODE));
		Mockito.verify(persitentieControllerMock).findGeboortecijfers(CODE);
		Mockito.verify(persitentieControllerMock).findSterfteCijfer(CODE);
	}
	
}
