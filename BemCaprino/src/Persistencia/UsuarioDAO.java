package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dominio.Usuario;


public class UsuarioDAO {
	
	String INCLUIR = "INSERT INTO usuario (nome , email , senha) VALUES (?, ?, ?)";
	String BUSCARCADASTRO = "SELECT * FROM \"usuario\" WHERE \"email\" = ? AND \"senha\" = ?";
	String BUSCAREMAIL = "SELECT * FROM \"usuario\" WHERE \"email\" = ?";
	
	public void inclusao(Usuario password){
        try{
        	Conexao.conectar();
            
        	PreparedStatement instrucao = Conexao.getConexao().prepareStatement(INCLUIR);
            
            instrucao.setString(1, password.getNomeCompleto());
            instrucao.setString(2, password.getEmail());
            instrucao.setString(3, password.getSenha());
            instrucao.execute();
            instrucao.close();
            Conexao.desconectar();
        }catch(SQLException e){
            System.out.println("Erro na inclus�o: "+e.getMessage());
        }
    }
	
	public Usuario buscarCadastro(String email, String senha) {
	    Usuario s = null;
	    try {
	        Conexao.conectar();
	        PreparedStatement instrucao = Conexao.getConexao().prepareStatement(BUSCARCADASTRO);
	        instrucao.setString(1, email);
	        instrucao.setString(2, senha);

	        ResultSet resultado = instrucao.executeQuery();

	        if (resultado.next()) {
	            s = new Usuario(
	                resultado.getString("Nome"),
	                resultado.getString("Email"),
	                resultado.getString("Senha")
	            );
	        }

	        resultado.close();
	        instrucao.close();
	        Conexao.desconectar();
	    } catch (SQLException e) {
	        System.out.println("Erro na busca: " + e.getMessage());
	    }
	    return s;
	}
	
	public String buscarEmail(String email) {
	    String emailEncontrado = null;

	    try {
	        Conexao.conectar();
	        try (PreparedStatement instrucao = Conexao.getConexao().prepareStatement(BUSCAREMAIL)) {
	            instrucao.setString(1, email);

	            try (ResultSet resultado = instrucao.executeQuery()) {
	                if (resultado.next()) {
	                    emailEncontrado = resultado.getString("email");
	                }
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro na busca: " + e.getMessage());
	    } finally {
	        Conexao.desconectar();
	    }

	    return emailEncontrado;
	}
}