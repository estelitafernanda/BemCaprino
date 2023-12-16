package dominio;

public class Usuario {
	private int IdUsuario;
	private String NomeCompleto; 
	private String CPF;
	private String Email;
	private String Endereco; 
	private String Telefone;
	private String Senha; 
	
	public Usuario(int IdUsuario, String NomeCompleto, String CPF, String Email, String Endereco, String Telefone, String Senha) {
        this.IdUsuario = IdUsuario;
        this.NomeCompleto = NomeCompleto;
        this.CPF = CPF;
        this.Email = Email;
        this.Endereco = Endereco;
        this.Telefone = Telefone;
        this.Senha = Senha;
    }
	
    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getNomeCompleto() {
        return NomeCompleto;
    }

    public void setNomeCompleto(String NomeCompleto) {
        this.NomeCompleto = NomeCompleto;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
}

