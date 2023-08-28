package testen;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import domein.ContinentService;
import persistentie.PersistentieController;

@ExtendWith(MockitoExtension.class)
public class ContinentServiceTest {
	private final String CODE = "CODE";
	//MOCKobject
	@Mock
	private PersistentieController persistentieControllerMock;
	//target
	@InjectMocks
	private ContinentService continentService;
	
	@Test
	public void geboorteOverschotTest() {
		mockTrainen(16405399L, 184634L, 135136L);
		controleGeboorteOverschot(3.01);
	}
	@Test
	public void sterfteOverschotTest() {
		mockTrainen(18506500L, 277597L, 333117L);
		controleGeboorteOverschot(-3);
		
	}
	private void mockTrainen(long aantalInwoners, long aantalGeboorten, long aantalsterftes) {
		Mockito.when(persistentieControllerMock.findAantalBewoners(CODE))
			   .thenReturn(aantalInwoners);
		Mockito.lenient().when(persistentieControllerMock.findGeboortecijfers(CODE))
		   .thenReturn(aantalGeboorten);
		Mockito.lenient().when(persistentieControllerMock.findSterfteCijfer(CODE))
		   .thenReturn(aantalsterftes);
	}
	private void controleGeboorteOverschot(double verwachte) {
		double geboorteOverschot = continentService.geefGeboorteOverschot(CODE);
		Assertions.assertEquals(verwachte, geboorteOverschot, 0.01);
		Mockito.verify(persistentieControllerMock).findAantalBewoners(CODE);
		Mockito.verify(persistentieControllerMock).findGeboortecijfers(CODE);
		Mockito.verify(persistentieControllerMock).findSterfteCijfer(CODE);
	}
	
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"   "})
	public void lege_spaties_nullContinent(String continent) {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> continentService.geefGeboorteOverschot(continent) );
	}
	
	private static Stream<Arguments> opsommingOngeldigeWaarden(){
		return Stream.of(
				Arguments.of(0L,  184634L, 135136L),
				Arguments.of(-1L, 184634L, 135136L ),
				Arguments.of(20000000L, -1L, 135136L),
				Arguments.of(20000000L, 184634L, -1L)
				);
	}
	@ParameterizedTest
	//@CsvSource({"0L, 184634L, 135136L"}) 
	//--> werkt niet voor L long: failed to convert String to type java.lang.Long
	@MethodSource("opsommingOngeldigeWaarden")
	public void ongeldigeWaardenTest(long aantalInwoner, long aantalGeboortes, long aantalSterfGevallen) {
		mockTrainen(aantalInwoner, aantalGeboortes, aantalSterfGevallen);
		Assertions.assertThrows(IllegalArgumentException.class, 
				() -> continentService.geefGeboorteOverschot(CODE) );
	}
	private static Stream<Arguments> opsommingGeldigeRandWaarden(){
		return Stream.of(
				Arguments.of(1L, 15L, 14L, 1000.0),
				Arguments.of(30000L, 0L, 15020L, -500.66),
				Arguments.of(30000L, 15020L, 0L, 500.66),
				Arguments.of(1, 0L, 0L, 0)
				);
	}
	@ParameterizedTest
	@MethodSource("opsommingGeldigeRandWaarden")
	public void geldigeRandWaardenTest(long aantalInwoner, long aantalGeboortes,
			long aantalSterfGevallen , double verwachteResultaat) {
		mockTrainen(aantalInwoner, aantalGeboortes, aantalSterfGevallen);
		controleGeboorteOverschot(verwachteResultaat);
	}

}