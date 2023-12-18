package Dominio;

public class Animais {

	private int IdAnimal;
	private String RacaAnimal;
	private float PesoAnimal;
	private String GeneroAnimal;
	
	public Animais() {
		
	}
	public Animais(int IdAnimal, String RacaAnimal, float PesoAnimal, String GeneroAnimal) {
		this.IdAnimal = IdAnimal;
		this.RacaAnimal = RacaAnimal;
		this.PesoAnimal = PesoAnimal;
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

	 public float getPesoAnimal() {
	     return PesoAnimal;
	 }

	 public void setPesoAnimal(float PesoAnimal) {
	     this.PesoAnimal = PesoAnimal;
	 }

	 public String getGeneroAnimal() {
	     return GeneroAnimal;
	 }

	 public void setGeneroAnimal(String GeneroAnimal) {
	     this.GeneroAnimal = GeneroAnimal;
	 }
}
