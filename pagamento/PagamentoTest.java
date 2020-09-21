package pagamento;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PagamentoTest {
	Pagamento pagamento = new Pagamento(100,false);

	@Before
	public void setUp() throws Exception {
		
		
	}

	@Test
	public void testCalcularTroco() {
		Pagamento pagamento = new Pagamento(50, false);
		float trocoEntregue = pagamento.calcularTroco(100);
		assertTrue(50 == trocoEntregue);
	}

	@Test
	public void testRegistrarPagamento() {
		boolean pagamentoEfetuado = pagamento.registrarPagamento(true);
		assertEquals(true, pagamentoEfetuado);
		
		
	}

}
