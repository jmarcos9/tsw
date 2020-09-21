package execIMC;

import static org.junit.Assert.*;

import org.junit.Test;

public class PessoaTest {
	
	Pessoa pessoa = new Pessoa(80f, 1.80f);	

	@Test
	public void testCalcularImc() {
		Pessoa pessoa = new Pessoa(80f, 1.80f);
		float valor = (float)(Math.round(pessoa.calcularImc()*100.0f)/100f);
		assertTrue(24.69f == valor);
	}	
	@Test
	public void testCalcularPesoIdealMin() {
		Pessoa pessoa = new Pessoa(80f, 1.80f);
		float pesoMin = (Math.round(pessoa.calcularPesoIdeal("Min")* 100f) / 100f);
		assertTrue(59.94f == pesoMin);	
	}	
	@Test
	public void testCalcularPesoIdealMed() {
		Pessoa pessoa = new Pessoa(80f, 1.80f);
		float pesoMed = (float)(Math.round(pessoa.calcularPesoIdeal("Med")* 100.f) / 100.f);
		assertTrue(70.47f == pesoMed);	
	}	
	@Test
	public void testCalcularPesoIdealMax() {
		Pessoa pessoa = new Pessoa(80f, 1.80f);
		float pesoMax = (Math.round(pessoa.calcularPesoIdeal("Max")* 100f) / 100f);
		assertTrue(81f == pesoMax);				
	}	
	@Test
	public void testCalcularPesoIdealZerado() {
		Pessoa pessoa = new Pessoa(80f, 1.80f);
		float pesoZzz = (Math.round(pessoa.calcularPesoIdeal("zzz")* 100f) / 100f);
		assertTrue(0 == pesoZzz);				
	}

}
