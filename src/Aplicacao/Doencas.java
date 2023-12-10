package Aplicacao;

public class Doencas extends Animal {
	  private String nome;
	    private String tratamento;
	    private String descricao;
	    private String gravidade;
	    private String dataDes;

	    public Doencas(int idade, double peso, String genero, String raca, String tipos,
	                     String nome, String tratamento, String descricao, String gravidade, String dataDes) {
	        super(idade, peso, genero, raca, tipos);
	        this.nome = nome;
	        this.tratamento = tratamento;
	        this.descricao = descricao;
	        this.gravidade = gravidade;
	        this.dataDes = dataDes;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public String getTratamento() {
	        return tratamento;
	    }

	    public String getDescricao() {
	        return descricao;
	    }

	    public String getGravidade() {
	        return gravidade;
	    }

	    public String getDataDes() {
	        return dataDes;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public void setTratamento(String tratamento) {
	        this.tratamento = tratamento;
	    }

	    public void setDescricao(String descricao) {
	        this.descricao = descricao;
	    }

	    public void setGravidade(String gravidade) {
	        this.gravidade = gravidade;
	    }

	    public void setDataDes(String dataDes) {
	        this.dataDes = dataDes;
	    }
}
