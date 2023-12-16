package dominio;
import java.util.ArrayList;
import java.util.List; 

public class Curral extends Animais {
    private int IdCurral;
    private String Proposito;
    private float Tamanho; 
    private float Capacidade;
    private List<Animais> listaDeAnimais;
    

    public Curral(int IdAnimal, String RacaAnimal, int IdadeAnimal, float PesoAnimal, String TipoSanguineo, String GeneroAnimal, int IdCurral, String Proposito, float Tamanho, 
    float Capacidade) {
        super(IdAnimal, RacaAnimal, IdadeAnimal, PesoAnimal, TipoSanguineo, GeneroAnimal);
        this.IdCurral = IdCurral;
        this.Proposito = Proposito;
        this.Tamanho = Tamanho;
        this.Capacidade = Capacidade;
        this.listaDeAnimais = new ArrayList<>();
    }
    public Curral(int IdCurral, String Proposito, float Tamanho, float Capacidade) {
    	super(0, null, 0, 0, null, null); 
        this.IdCurral = IdCurral;
        this.Proposito = Proposito;
        this.Tamanho = Tamanho;
        this.Capacidade = Capacidade;
        this.listaDeAnimais = new ArrayList<>();
    }
    public void adicionarAnimal(Animais animal) {
    	 listaDeAnimais.add(animal);
         System.out.println("Animal adicionado ao curral com sucesso!");
    }
    public void removerAnimal(Animais animal) {
        if (listaDeAnimais.contains(animal)) {
            listaDeAnimais.remove(animal);
            System.out.println("Animal removido do curral com sucesso!");
        } else {
            System.out.println("O animal não está presente no curral.");
        }
    }
    public static int getTotalCurrais(List<Curral> currais) {
        return currais.size();
    }
    public int getTotalAnimaisNoCurral() {
        return listaDeAnimais.size();
    }
    public int getIdCurral() {
        return IdCurral;
    }
    public void setIdCurral(int IdCurral) {
        this.IdCurral = IdCurral;
    }
    public String getProposito() {
    	return Proposito;
    }
    public void setProposito(String Proposito) {
    	this.Proposito = Proposito;
    }
    public float getTamanho() {
    	return Tamanho;
    }
    public void setTamanho(float Tamanho) {
    	this.Tamanho = Tamanho;
    }
    public float getCapacidade() {
    	return Capacidade;
    }
    public void setCapacidade(float Capacidade) {
    	this.Capacidade = Capacidade;
    }
}
