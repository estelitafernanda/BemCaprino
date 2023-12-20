package Dominio;

public class Gestantes extends Animal implements AnimalFilho {
    private int SeqGestacao;
    private String TipoGestacao;
    private String DataInicio;
    private int TempoGestacao; 
    
    public Gestantes() {
    	
    	
    }

    public Gestantes(int IdAnimal, String RacaAnimal, double PesoAnimal, String GeneroAnimal, int SeqGestacao, String TipoGestacao, String DataInicio, int TempoGestacao) {
        super(IdAnimal, RacaAnimal, PesoAnimal, GeneroAnimal);
        this.SeqGestacao = SeqGestacao;
        this.TipoGestacao = TipoGestacao;
        this.DataInicio = DataInicio;
        this.TempoGestacao = TempoGestacao; 
    }
    public Gestantes (int IdAnimal, int SeqGestacao, String TipoGestacao, String DataInicio, int TempoGestacao) {
    	 this.SeqGestacao = SeqGestacao;
         this.TipoGestacao = TipoGestacao;
         this.DataInicio = DataInicio;
         this.TempoGestacao = TempoGestacao; 
    }

    public int getSeqGestacao() {
        return SeqGestacao;
    }

    public void setSeqGestacao(int SeqGestacao) {
        this.SeqGestacao = SeqGestacao;
    }

    public String getTipoGestacao() {
        return TipoGestacao;
    }

    public void setTipoGestacao(String TipoGestacao) {
        this.TipoGestacao = TipoGestacao;
    }

    public String getDataInicio() {
        return DataInicio;
    }

    public void setDataInicio(String DataInicio) {
        this.DataInicio = DataInicio;
    }

    public int getTempoGestacao() {
        return TempoGestacao;
    }

    public void setTempoGestacao(int TempoGestacao) {
        this.TempoGestacao = TempoGestacao;
    }
     public void realizarAcao() {
        System.out.println("A gestante com ID " + getIdAnimal() + " está passando por uma gestação do tipo " + TipoGestacao);
    }
    public boolean teveFilho() {
        return true;
    }

    public void vacinarFilhote() {
        System.out.println("Filhote vacinado");
    }

    public void verificarSaudeFilhote() {
        System.out.println("Saúde do filhote verificada");
    }
}

