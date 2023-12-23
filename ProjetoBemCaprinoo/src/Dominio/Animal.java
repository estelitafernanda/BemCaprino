package Dominio;

import javafx.beans.property.SimpleIntegerProperty;

public class Animal extends AcaoAnimal {
	private int IdAnimal;
	private String RacaAnimal;
	private Double PesoAnimal;
	private String GeneroAnimal;
	
	public Animal() {
		
	}
	public Animal(int IdAnimal, String RacaAnimal, Double PesoAnimal, String GeneroAnimal) {
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

	 public Double getPesoAnimal() {
	     return PesoAnimal;
	 }

	 public void setPesoAnimal(Double PesoAnimal) {
	     this.PesoAnimal = PesoAnimal;
	 }

	 public String getGeneroAnimal() {
	     return GeneroAnimal;
	 }

	 public void setGeneroAnimal(String GeneroAnimal) {
	     this.GeneroAnimal = GeneroAnimal;
	 }
	 public SimpleIntegerProperty idAnimalProperty() {
	        return new SimpleIntegerProperty(IdAnimal);
	    }
	 public void realizarAcao() {
	        System.out.println("O animal com ID " + IdAnimal + " está realizando uma ação genérica.");
	 }
	
}