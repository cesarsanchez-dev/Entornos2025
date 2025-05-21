
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class SistemaReservasDeportivasTest {
	static SistemaReservasDeportivas sistemaReservas;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		sistemaReservas = new SistemaReservasDeportivas();
	}

	@Test
	void testReservaPista() {
		assertTrue(sistemaReservas.reservarPista(0, "2021-03-01", 1));
		assertTrue(sistemaReservas.reservarPista(1, "2021-03-01", 1));
		assertFalse(sistemaReservas.reservarPista(0, "2021-03-01", 1));
		assertFalse(sistemaReservas.reservarPista(0, "2021-03-01", 2));
		assertFalse(sistemaReservas.reservarPista(0, "2021-03-02", 1));
	}

}
