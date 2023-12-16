package dominio;

public class Animais {

	private int IdAnimal;
	private String RacaAnimal;
	private int IdadeAnimal;
	private float PesoAnimal;
	private String TipoSanguineo;
	private String GeneroAnimal;
	
	public Animais(int IdAnimal, String RacaAnimal, int IdadeAnimal, float PesoAnimal, String TipoSanguineo, String GeneroAnimal) {
		this.IdAnimal = IdAnimal;
		this.RacaAnimal = RacaAnimal;
		this.IdadeAnimal = IdadeAnimal;
		this.PesoAnimal = PesoAnimal;
		this.TipoSanguineo = TipoSanguineo;
		this.GeneroAnimal = GeneroAnimal;
	}
	 public int getIdAnimal() {
	     return IdAnimal;
	 }

	 public void setIdAnimal(int IdAnimal) {
	     this.IdAnimal = IdAnimal;
	 }

	 public String getRacaAnimal() {
	     return RacaAnimal;
	 }

	 public void setRacaAnimal(String RacaAnimal) {
	     this.RacaAnimal = RacaAnimal;
	 }

	 public int getIdadeAnimal() {
	     return IdadeAnimal;
	 }

	 public void setIdadeAnimal(int IdadeAnimal) {
	     this.IdadeAnimal = IdadeAnimal;
	 }

	 public float getPesoAnimal() {
	     return PesoAnimal;
	 }

	 public void setPesoAnimal(float PesoAnimal) {
	     this.PesoAnimal = PesoAnimal;
	 }

	 public String getTipoSanguineo() {
	     return TipoSanguineo;
	 }

	 public void setTipoSanguineo(String TipoSanguineo) {
	     this.TipoSanguineo = TipoSanguineo;
	 }

	 public String getGeneroAnimal() {
	     return GeneroAnimal;
	 }

	 public void setGeneroAnimal(String GeneroAnimal) {
	     this.GeneroAnimal = GeneroAnimal;
	 }
}
