package banco;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContaCorrenteTest {
	//ContaCorrente contaCorrente = new ContaCorrente("0001", "1234", "E", 1000, 500);

	@Test
	public void testDepositar() {
		ContaCorrente contaCorrente = new ContaCorrente("0001", "1234", "N", 1000, 0);
		float depositar = contaCorrente.depositar(1000);
		assertTrue(2000 == depositar);
		
	}

	@Test
	public void testSacarContaNormal() {
		ContaCorrente contaCorrente = new ContaCorrente("0001", "1234", "N", 1000, 0);
		boolean saque = contaCorrente.sacar(1000);
		assertEquals(true, saque);
		
	}
	
	@Test
	public void testSacarContaEspecial() {
		ContaCorrente contaCorrente = new ContaCorrente("0001", "1234", "E", 1000, 500);
		boolean saque = contaCorrente.sacar(1400);
		assertEquals(true, saque);
		
	}

}
