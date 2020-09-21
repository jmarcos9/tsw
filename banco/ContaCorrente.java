package banco;

/* 
 * Uma conta corrente tem uma agencia, um número, saldo e limite. 
 * Por ocasião do cadastro da conta deve ser realizado um deposito inicial. 
   A conta pode ser normal ou especial (N ou E).
   Conta normal o limite será sempre 0.
   
   Em operaçao de saque:
   
   Em conta corrente normal o saldo não poderá ficar negativa.
   
   Em conta corrente especial o saldo poderá ficar negativo até o valor do limite.

   O método sacar retorna true se a operação de saque foi realizada com sucesso.

   Implementa a classe ContaCorrente utilizando a metodologia TDD (registre em prints de tela as etapas do TDD).
 */

public class ContaCorrente {
	
	private String agencia;
	private String numeroConta;
	private String tipo;
	private float saldo;
	private float limite;
	
	public ContaCorrente(String agencia, String numeroConta, String tipo, float saldo, float limite) {
		super();
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.tipo = tipo;
		this.saldo = saldo;
		this.limite = limite;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getSaldo() {
		return saldo;
	}
	
	public float getLimite() {
		return limite;
	}
	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	public float depositar(float valorFornecido) {		
		saldo += valorFornecido;		
		return saldo;		
	}
	
	public boolean sacar(float valorFornecido) {		
		double limite = this.limite + saldo;
		
		if(saldo >= valorFornecido) {
			saldo-=valorFornecido;
			return true;
		} else {
			if(limite >= valorFornecido) {
				saldo -= valorFornecido;
				return true;
			} else {
				return false;
			}
		}
	}

}
