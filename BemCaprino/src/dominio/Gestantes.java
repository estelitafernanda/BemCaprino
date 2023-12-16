package dominio;

public class Gestantes extends Animais {
    private int SeqGestacao;
    private String TipoGestacao;
    private String DataInicio;
    private int TempoGestacao; 

    public Gestantes(int IdAnimal, String RacaAnimal, int IdadeAnimal, float PesoAnimal, String TipoSanguineo, String GeneroAnimal, int SeqGestacao, String TipoGestacao, String DataInicio, int TempoGestacao) {
        super(IdAnimal, RacaAnimal, IdadeAnimal, PesoAnimal, TipoSanguineo, GeneroAnimal);
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
}
