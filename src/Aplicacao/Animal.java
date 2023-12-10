package Aplicacao;

public class Animal {
	 private static int contador = 0;
	    private int idAnimal;
	    private double pesoAnimal;
	    private int idadeAnimal;
	    private String genero;
	    private String raca;
	    private String tipos;

	    public Animal(int idade, double peso, String genero, String raca, String tipoS) {
	        this.idAnimal = contador++;
	        this.idadeAnimal = idade;
	        this.pesoAnimal = peso;
	        this.genero = genero;
	        this.raca = raca;
	        this.tipos = tipoS;
	    }
	    
	    public int getidAnimal() {
	        return idAnimal;
	    }

	    public double getPesoAnimal() {
	        return pesoAnimal;
	    }

	    public int getIdadeAnimal() {
	        return idadeAnimal;
	    }

	    public String getGenero() {
	        return genero;
	    }

	    public String getRaca() {
	        return raca;
	    }
	    public String getTipoS() {
	        return tipos;
	    }
	    
	    public void setIdAnimal(int idAnimal) {
	        this.idAnimal = idAnimal;
	    }

	    public void setPesoAnimal(double pesoAnimal) {
	        this.pesoAnimal = pesoAnimal;
	    }

	    public void setIdadeAnimal(int idadeAnimal) {
	        this.idadeAnimal = idadeAnimal;
	    }

	    public void setGenero(String genero) {
	        this.genero = genero;
	    }

	    public void setRaca(String raca) {
	        this.raca = raca;
	    }

	    public void setTipoS(String tipoS) {
	        this.tipos = tipoS;
	    }
	
}
