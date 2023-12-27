package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.Animais;

public class AnimaisDAO {
	String INCLUIR = "INSERT INTO animais (idanimal , racaanimal , pesoanimal, generoanimal) VALUES (?, ?, ?, ?)";
	String BUSCARANIMAL = "SELECT * FROM \"animais\" WHERE \"idanimal\" = ?";
	String REL = "SELECT * FROM \"animais\"";
	String EXCLUIR = "DELETE FROM animais WHERE idanimal = ?";
	String ALTERAR = "UPDATE animais SET racaanimal = ?, pesoanimal = ?, generoanimal = ? WHERE idanimal = ?";

	public void incluir(Animais password){
       try{
        	Conexao.conectar();
            
        	PreparedStatement instrucao = Conexao.getConexao().prepareStatement(INCLUIR);
            
            instrucao.setInt(1, password.getIdAnimal());
            instrucao.setString(2, password.getRacaAnimal());
            instrucao.setDouble(3, password.getPesoAnimal());
            instrucao.setString(4, password.getGeneroAnimal());
            instrucao.execute();
            instrucao.close();
            Conexao.desconectar();
        }catch(SQLException e){
            System.out.println("Erro na inclus�o: "+e.getMessage());
        }
    }
	
	public ArrayList<Animais> RELATORIO() {
	    ArrayList<Animais> lista = new ArrayList<>();
	    try {
	        Conexao.conectar();
	        Statement instrucao = Conexao.getConexao().createStatement();
	        ResultSet rs = instrucao.executeQuery(REL);

	        while (rs.next()) {
	            int idAnimal = rs.getInt("IdAnimal");
	            String racaAnimal = rs.getString("RacaAnimal");
	            double pesoAnimal = rs.getDouble("PesoAnimal");
	            String generoAnimal = rs.getString("GeneroAnimal");

	            Animais animal = new Animais(idAnimal, racaAnimal, pesoAnimal, generoAnimal);
	            lista.add(animal);
	        }

	        Conexao.desconectar();
	    } catch (SQLException e) {
	        System.out.println("Erro no relatório: " + e.getMessage());
	    }
	    return lista;
	}

	 
	 public Integer buscarAnimal(int id) {
		    Integer idencontrado = null;
		    try {
		        Conexao.conectar();
		        PreparedStatement instrucao = Conexao.getConexao().prepareStatement(BUSCARANIMAL);
		        instrucao.setInt(1, id);

		        ResultSet resultado = instrucao.executeQuery();

		        if (resultado.next()) {
		            idencontrado = resultado.getInt("IdAnimal");
		        }

		        Conexao.desconectar();
		    } catch (SQLException e) {
		        System.out.println("Erro na busca: " + e.getMessage());
		    }
		    return idencontrado;
		}
	 
	 public void excluir(int idAnimal) {
		    try {
		        Conexao.conectar();
		        PreparedStatement instrucao = Conexao.getConexao().prepareStatement(EXCLUIR);
		        instrucao.setInt(1, idAnimal);
		        instrucao.execute();
		        instrucao.close();
		        Conexao.desconectar();
		    } catch (SQLException e) {
		        System.out.println("Erro ao excluir: " + e.getMessage());
		    }
		}
	 
	 public void alterar(Animais animal) {
		    try {
		        Conexao.conectar();
		        PreparedStatement instrucao = Conexao.getConexao().prepareStatement(ALTERAR);
		        
		        instrucao.setString(1, animal.getRacaAnimal());
		        instrucao.setDouble(2, animal.getPesoAnimal());
		        instrucao.setString(3, animal.getGeneroAnimal());
		        instrucao.setInt(4, animal.getIdAnimal());
		        
		        instrucao.executeUpdate();
		        instrucao.close();
		        Conexao.desconectar();
		    } catch (SQLException e) {
		        System.out.println("Erro ao alterar: " + e.getMessage());
		    }
		}
	 public Animais buscarAnimalId(int id) {
		    Animais animalEncontrado = null;
		    try {
		        Conexao.conectar();
		        PreparedStatement instrucao = Conexao.getConexao().prepareStatement(BUSCARANIMAL);
		        instrucao.setInt(1, id);

		        ResultSet resultado = instrucao.executeQuery();

		        if (resultado.next()) {
		            int idAnimal = resultado.getInt("IdAnimal");
		            String racaAnimal = resultado.getString("RacaAnimal");
		            double pesoAnimal = resultado.getDouble("PesoAnimal");
		            String generoAnimal = resultado.getString("GeneroAnimal");

		            animalEncontrado = new Animais(idAnimal, racaAnimal, pesoAnimal, generoAnimal);
		        }

		        Conexao.desconectar();
		    } catch (SQLException e) {
		        System.out.println("Erro na busca: " + e.getMessage());
		    }
		    return animalEncontrado;
		}

}