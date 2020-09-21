package unit.tsw.produto;

public class ProdutoNovo {
	private int codigo;
	private String descricao;
	private float precoCusto;
	private int estoque;

    public ProdutoNovo (int codigo, String descricao, float precoCusto) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.precoCusto = precoCusto;
        this.estoque = 0;
    }

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(float precoCusto) {
		this.precoCusto = precoCusto;
	}

	public int getEstoque() {
		return estoque;
	}

	public int producao(int qtde) {
		estoque += qtde;
		return estoque;
	}
	
	public boolean saida(int qtde) {
		boolean baixou = false;
		
		if(estoque >= qtde) {
			estoque -= qtde;
			baixou = true;
		}
		return baixou;		
	}

}