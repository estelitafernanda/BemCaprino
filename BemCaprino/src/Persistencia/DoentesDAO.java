package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Dominio.Doentes;

public class DoentesDAO {

		String INCLUIR = "INSERT INTO doentes (NomeDoenca , Racaanimal , Pesoanimal, Generoanimal) VALUES (?, ?, ?, ?)";
		String BUSCARDOENTE = "SELECT * FROM \"doentes\" WHERE \"AnimalId\" = ?";
		String VERIFICAR_EXISTENCIA = "SELECT COUNT(*) FROM doentes WHERE IdAnimal = ?";
		String REL = "SELECT AnimalId, NomeDoenca, Tratamento, Descricao FROM \"doentes\"";
		
		public void INCLUSAO(Doentes password){
	        try{
	        	Conexao.conectar();
	        	
	        	 PreparedStatement verificacao = Conexao.getConexao().prepareStatement(VERIFICAR_EXISTENCIA);
	             verificacao.setInt(1, password.getIdAnimal());
	             ResultSet resultado = verificacao.executeQuery();

	             if (resultado.next() && resultado.getInt(1) > 0) {
	            	 
	                 PreparedStatement instrucao = Conexao.getConexao().prepareStatement(INCLUIR);
	                 instrucao.setString(1, password.getNomeDoenca());
	                 instrucao.setString(2, password.getTratamento());
	                 instrucao.setString(3, password.getDescricao());

	                 instrucao.execute();
	                 instrucao.close();
	                 
	             } else {
	                 System.out.println("IdAnimal não existe no banco. Faça o tratamento apropriado.");
	             }

	             verificacao.close();
	             Conexao.desconectar();
	        }catch(SQLException e){
	            System.out.println("Erro na inclus�o: "+e.getMessage());
	        }
	    }
		 public ArrayList<Doentes> RELATORIO(){
		        ArrayList<Doentes> lista = new ArrayList<>();
		        try{
		            Conexao.conectar();
		            Statement instrucao = Conexao.getConexao().createStatement();
		            ResultSet rs = instrucao.executeQuery(REL);
		            while(rs.next()){
		                Doentes doente = new Doentes(rs.getInt("AnimalId"), rs.getString("NomeDoenca"),
		                                    rs.getString("Tratamento"), rs.getString("Descricao"), rs.getString("Gravidade"));
		                lista.add(doente);
		            }
		            Conexao.desconectar();
		        }catch(SQLException e){
		            System.out.println("Erro no relat�rio: "+e.getMessage());
		        }
		        return lista;
		    }
		 public Integer buscarAnimal(int animalid) {
			    Integer idencontrado = null;
			    try {
			        Conexao.conectar();
			        PreparedStatement instrucao = Conexao.getConexao().prepareStatement(BUSCARDOENTE);
			        instrucao.setInt(1, animalid);

			        ResultSet resultado = instrucao.executeQuery();

			        if (resultado.next()) {
			            idencontrado = resultado.getInt("IdAnimal");
			        }

			        Conexao.desconectar();
			    } catch (SQLException e) {
			        System.out.println("Erro na busca: " + e.getMessage());
			    }
			    return idencontrado;
			}}