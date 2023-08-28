package testen;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import domein.Aangifte;
import domein.Boekhouding;
import domein.FactuurMap;

@ExtendWith(MockitoExtension.class)
public class BoekhoudingTest {
	@Mock
	private FactuurMap fmMock;
	
	@InjectMocks
	private Boekhouding bh;
	
	
	private static Stream<Arguments> opsommingGeldigeWaarden(){
		
		return Stream.of(
				Arguments.of(new double[] {	0.0,0.0}, Boekhouding.BELASTINGSCHAAL_0),
				Arguments.of(new double[] {	199.0,0.99}, Boekhouding.BELASTINGSCHAAL_0),
				Arguments.of(new double[] {199.0,1.0}, Boekhouding.BELASTINGSCHAAL_1),
				Arguments.of(new double[] {500.0,129.66}, Boekhouding.BELASTINGSCHAAL_1),
				Arguments.of(new double[] {	150.25, 271.39}, Boekhouding.BELASTINGSCHAAL_1),
				
				Arguments.of(new double[] {	0.0,0.0, 0.0}, Boekhouding.BELASTINGSCHAAL_0),
				Arguments.of(new double[] {	199.0,0.9,0.09}, Boekhouding.BELASTINGSCHAAL_0),
				Arguments.of(new double[] {199.0,0.9,0.1}, Boekhouding.BELASTINGSCHAAL_1),
				Arguments.of(new double[] {500.0,100.45,29.99}, Boekhouding.BELASTINGSCHAAL_1),
				Arguments.of(new double[] {	150.25,  220.89,  50.45}, Boekhouding.BELASTINGSCHAAL_1)
				);
	}
	
	@ParameterizedTest
	@MethodSource("opsommingGeldigeWaarden")
	public void geldigeWaarden(double[] waarden, double belastingschaal) {
		String onderneming = "BE0123456789";
		
		Mockito.when(fmMock.geefBedragen(onderneming)).thenReturn(waarden);
		
		Aangifte a = bh.genereerAangifte(onderneming);
		Assertions.assertEquals(belastingschaal, a.belastingSchaal());
		Assertions.assertArrayEquals(waarden, a.bedragen());
		
		Mockito.verify(fmMock).geefBedragen(onderneming);
	}
	
	@ParameterizedTest
	@ValueSource(strings= {"BE01234567985", "BE012345","NL0123456789", "00123456789"})
	@NullAndEmptySource
	public void ongeldigeOndernemingsnummer(String onderneming) {
		Assertions.assertThrows(IllegalArgumentException.class, ()->bh.genereerAangifte(onderneming));
	}
	
	@ParameterizedTest
	@ValueSource(strings= {"BE0123456789", "BE1234567890","BE1122334455"})
	public void geldigeOndernemingsnummer(String onderneming) {
		Mockito.when(fmMock.geefBedragen(onderneming)).thenReturn(new double[] {0.1,0.2});
		Assertions.assertDoesNotThrow(()->bh.genereerAangifte(onderneming));
	}
}
