package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.Animal;

public class AnimalDAO {
	String INCLUIR = "INSERT INTO animais (idanimal , racaanimal , pesoanimal, generoanimal) VALUES (?, ?, ?, ?)";
	String BUSCARANIMAL = "SELECT * FROM \"animais\" WHERE \"idanimal\" = ?";
	String REL = "SELECT * FROM \"animais\"";

	public void incluir(Animal password){
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
	
	 public ArrayList<Animal> RELATORIO(){
	        ArrayList<Animal> lista = new ArrayList<>();
	        try{
	            Conexao.conectar();
	            Statement instrucao = Conexao.getConexao().createStatement();
	            ResultSet rs = instrucao.executeQuery(REL);
	            while(rs.next()){
	                Animal s = new Animal(rs.getInt("IdAnimal"), rs.getString("RacaAnimal"),
	                                    rs.getDouble("PesoAnimal"), rs.getString("RacaAnimal"));
	                lista.add(s);
	            }
	            Conexao.desconectar();
	        }catch(SQLException e){
	            System.out.println("Erro no relat�rio: "+e.getMessage());
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
}

