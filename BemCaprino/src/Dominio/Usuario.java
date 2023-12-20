package Dominio;

public class Usuario {
	
	private String NomeCompleto;
	private String Email;
	private String Senha;
	
	public Usuario () {
		
	}
	
	public Usuario( String NomeCompleto, String Email, String Senha) {
       this.NomeCompleto = NomeCompleto;
       this.Email = Email;
       this.Senha = Senha;
   }
	
   public String getNomeCompleto() {
       return NomeCompleto;
   }
   public void setNomeCompleto(String NomeCompleto) {
       this.NomeCompleto = NomeCompleto;
   }
   public String getEmail() {
       return Email;
   }
   public void setEmail(String Email) {
       this.Email = Email;
   }
   public String getSenha() {
       return Senha;
   }
   public void setSenha(String Senha) {
       this.Senha = Senha;
   }
}