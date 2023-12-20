package Dominio;

public class Doentes extends Animal{ 	
		private String NomeDoenca;
		private String Tratamento; 
		private String Descricao;
		
		public Doentes() {
		
			
		}
		public Doentes (int IdAnimal, String RacaAnimal, double PesoAnimal, String GeneroAnimal, String NomeDoenca, String Tratamento, String Descricao) {
			super (IdAnimal, RacaAnimal, PesoAnimal, GeneroAnimal);
			this.NomeDoenca = NomeDoenca;
			this.Tratamento = Tratamento;
			this.Descricao = Descricao;

			
		}
		public Doentes (int IdAnimal, String NomeDoenca, String Tratamento, String Descricao, String Gravidade ) {
			this.NomeDoenca = NomeDoenca;
			this.Tratamento = Tratamento;
			this.Descricao = Descricao;

		}
		public String getNomeDoenca() {
			return NomeDoenca;
		}
		public void setNomeDoenca(String NomeDoenca){
			this.NomeDoenca = NomeDoenca;
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
		public void realizarAcao() {
	        System.out.println("O animal doente com ID " + getIdAnimal() + " está recebendo tratamento para a doença " + NomeDoenca);
	    	}
}
