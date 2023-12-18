package Dominio;

public class Usuario {
	
	private String Nome;
	private String Email;
	private String Senha;
	
	public Usuario () {
		
	}
	
	public Usuario( String Nome, String Email, String Senha) {
       this.Nome = Nome;
       this.Email = Email;
       this.Senha = Senha;
   }
	
   public String getNome() {
       return Nome;
   }
   public void setNomeCompleto(String Nome) {
       this.Nome = Nome;
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