package unit.tsw.produto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ProdutoNovoTest { 
	ProdutoNovo produto = new ProdutoNovo(1, "Blusa", 50);

	@Before
	public void setUp() throws Exception {
		produto.producao(1000);
	}

	@Test
	public void testProducao() {
		int estoqueAtualizado = produto.producao(100);
		assertEquals(1100, estoqueAtualizado);
	}

	@Test
	public void testSaida() {
		boolean estoqueBaixado = produto.saida(1000);
		//assertEquals(true,estoqueBaixado);
		assertTrue(true == estoqueBaixado);
	}

}
