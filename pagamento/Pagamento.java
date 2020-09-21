package pagamento;

/*
 * Desenvolva os testes unitários para a classe a seguir e, usando a metodologia TDD, implemente a classe. 

   Classe: Pagamento
   Atributos:
     - valorVenda: float
     - pago: boolean;
   Métodos
    + calcularTroco(float valorFornecido): float
    + registrarPagamento(): void

   O método calcularTroco() retorna o valor do troco, considerando que foi fornecido um valor para pagamento 
   do valor da venda.
   
   O método registrarPagamento deve alterar o estado inicial do atributo pago (false) para o estado (true). 

   A cada etapa de falha e a cada implementação corresponde tire print da tela coloque em um arquivo que deverá 
   ser postado como registro de execução desta atividade.
 */

public class Pagamento {
	
	private float valorVenda;
	private boolean pago;
	
	public Pagamento(float valorVenda, boolean pago) {
		
		this.valorVenda = valorVenda;
		this.pago = false;
	}

	public float getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(float valorVenda) {
		this.valorVenda = valorVenda;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}
	
	
	public float calcularTroco(float pagamento) {
		float troco;		
		troco = pagamento - this.valorVenda;		
		return troco;
	}
	
	public boolean registrarPagamento(boolean pagamento) {
				
		if(pagamento) {
			pago = true;
		}		
		return pago;		
		
	}
	

}
