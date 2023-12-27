package Dominio;

public class Gestantes extends Animais implements AnimalFilho {
    private String TipoGestacao;
    private String DataInicio;
    private String TempoGestacao; 
    
    public Gestantes() {
    	
    	
    }

    public Gestantes(int IdAnimal, String RacaAnimal, double PesoAnimal, String GeneroAnimal, String TipoGestacao, String DataInicio, String TempoGestacao) {
        super(IdAnimal, RacaAnimal, PesoAnimal, GeneroAnimal);
        this.TipoGestacao = TipoGestacao;
        this.DataInicio = DataInicio;
        this.TempoGestacao = TempoGestacao; 
    }
    public Gestantes (int IdAnimal, String TipoGestacao, String DataInicio, String TempoGestacao) {
    	 super.setIdAnimal(IdAnimal);
         this.TipoGestacao = TipoGestacao;
         this.DataInicio = DataInicio;
         this.TempoGestacao = TempoGestacao; 
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

    public String getTempoGestacao() {
        return TempoGestacao;
    }

    public void setTempoGestacao(String TempoGestacao) {
        this.TempoGestacao = TempoGestacao;
    }
    public String realizarAcao() {
    	return "A gestante com ID " + getIdAnimal() + " está passando por uma gestação do tipo " + TipoGestacao;
 
    }
    public boolean teveFilho() {
        return true;
    }

    public String vacinarFilhote() {
    	return "Filhote vacinado";
    }

    public String verificarSaudeFilhote() {
    	return "Saúde do filhote verificada";
    }
}
