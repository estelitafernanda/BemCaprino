package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.Animais;

public class AnimaisDAO {
	
	String INCLUIR = "INSERT INTO ANIMAIS (IDANIMAL , RACAANIMAL , PESOANIMAL, GENEROANIMAL) VALUES (?, ?, ?, ?)";
	String BUSCARANIMAL = "SELECT * FROM \"ANIMAIS\" WHERE \"IDANIMAL\" = ?";
	String REL = "SELECT * FROM \"ANIMAIS\"";
	public AnimaisDAO() {
		
	}

	public void inclusao(Animais password){
        try{
        	Conexao.conectar();
            
        	PreparedStatement instrucao = Conexao.getConexao().prepareStatement(INCLUIR);
            
            instrucao.setInt(1, password.getIdAnimal());
            instrucao.setString(2, password.getRacaAnimal());
            instrucao.setFloat(3, password.getPesoAnimal());
            instrucao.setString(4, password.getGeneroAnimal());
            instrucao.execute();
            instrucao.close();
            Conexao.desconectar();
        }catch(SQLException e){
            System.out.println("Erro na inclus�o: "+e.getMessage());
        }
    }
	 public ArrayList<Animais> RELATORIO(){
	        ArrayList<Animais> lista = new ArrayList<>();
	        try{
	            Conexao.conectar();
	            Statement instrucao = Conexao.getConexao().createStatement();
	            ResultSet rs = instrucao.executeQuery(REL);
	            while(rs.next()){
	                Animais s = new Animais(rs.getInt("IdAnimal"), rs.getString("RacaAnimal"),
	                                    rs.getFloat("PesoAnimal"), rs.getString("RacaAnimal"));
	                lista.add(s);
	            }
	            Conexao.desconectar();
	        }catch(SQLException e){
	            System.out.println("Erro no relat�rio: "+e.getMessage());
	        }
	        return lista;
	    }
	 public Animais BUSCARANIMAL (int id) {
		    Animais password = null;
		    try {
		        Conexao.conectar();
		        PreparedStatement instrucao = Conexao.getConexao().prepareStatement(BUSCARANIMAL);
		        instrucao.setInt(1, id);
		        

		        ResultSet resultado = instrucao.executeQuery();

		        if(resultado.next()){
	                password = new Animais(resultado.getInt("IdAnimal"),resultado.getString("RacaAnimal"),resultado.getFloat("PesoAnimal"), resultado.getString("GeneroAnimal"));
	            }

		        Conexao.desconectar();
		    } catch (SQLException e) {
		        System.out.println("Erro na busca: " + e.getMessage());
		    }
		    return password;
	 }
}
