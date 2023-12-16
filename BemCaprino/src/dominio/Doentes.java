package dominio;


public class Doentes extends Animais {
	private String NomeDoenca;
	private String TipoDoenca;
	private String Tratamento; 
	private String Descricao;
	private String DataDescobrimento;
	private String Gravidade;
	
	
	public Doentes (int IdAnimal, String RacaAnimal, int IdadeAnimal, float PesoAnimal, String TipoSanguineo, String GeneroAnimal, String NomeDoenca, String TipoDoenca, String Tratamento, String Descricao, String DataDescobrimento, String Gravidade) {
		super (IdAnimal, RacaAnimal, IdadeAnimal, PesoAnimal, TipoSanguineo, GeneroAnimal);
		this.NomeDoenca = NomeDoenca;
		this.TipoDoenca = TipoDoenca;
		this.Tratamento = Tratamento;
		this.Descricao = Descricao;
		this.DataDescobrimento = DataDescobrimento;
		this.Gravidade = Gravidade;
		
	}
	public String getNomeDoenca() {
		return NomeDoenca;
	}
	public void setNomeDoenca(String NomeDoenca){
		this.NomeDoenca = NomeDoenca;
	}
	public String getTipoDoenca() {
		return TipoDoenca;
	}
	public void setTipoDoenca(String TipoDoenca) {
		this.TipoDoenca = TipoDoenca;
	}
	public String getTratamento() {
		return Tratamento;
	}
	public void setTratamento(String Tratamento) {
		this.Tratamento = Tratamento;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String Descricao) {
		this.Descricao = Descricao;
	}
	public String getDataDescobrimento() {
		return DataDescobrimento;
	}
	public void setDataDescobrimento(String DataDescobrimento) {
		this.DataDescobrimento = DataDescobrimento;
	}
	public String getGravidade() {
		return Gravidade;
	}
	public void setGravidade(String Gravidade) {
		this.Gravidade = Gravidade;
	}
}
