package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.Animal;
import Dominio.Doentes;

public class DoentesDAO {

		String INCLUIR = "INSERT INTO doentes (NomeDoenca, Tratamento, Descricao , animalid) VALUES (?, ?, ? , ?)";
		String BUSCARDOENTE = "SELECT * FROM \"doentes\" WHERE \"animalid\" = ?";
		String REL = "SELECT animalid , nomedoenca, tratamento, descricao FROM doentes";
		String VERIFICAR_EXISTENCIA = "SELECT COUNT(*) FROM animais WHERE idanimal = ?";


		public void INCLUSAO(Doentes password) {
		    try {
		        Conexao.conectar();

		        PreparedStatement verificacao = Conexao.getConexao().prepareStatement(VERIFICAR_EXISTENCIA);
		        verificacao.setInt(1, password.getIdAnimal());
		        ResultSet resultado = verificacao.executeQuery();

		        if (resultado.next() && resultado.getInt(1) > 0) {
		            PreparedStatement instrucao = Conexao.getConexao().prepareStatement(INCLUIR);
		            instrucao.setString(1, password.getNomeDoenca());
		            instrucao.setString(2, password.getTratamento());
		            instrucao.setString(3, password.getDescricao());
		            instrucao.setInt(4, password.getIdAnimal());
		            instrucao.execute();
		            instrucao.close();
		        } else {
		            System.out.println("AnimalId não existe na tabela animais. Faça o tratamento apropriado.");
		        }

		        verificacao.close();
		        Conexao.desconectar();
		    } catch (SQLException e) {
		        System.out.println("Erro na inclusão: " + e.getMessage());
		    }
		}


		public ArrayList<Doentes> RELATORIODoentes() {
		    ArrayList<Doentes> lista = new ArrayList<>();

		    try {
		        Conexao.conectar();
		        Statement instrucao = Conexao.getConexao().createStatement();
		        ResultSet rs = instrucao.executeQuery(REL);

		        while (rs.next()) {
		        	int idAnimal = rs.getInt("animalid");
		            String doencaNome = rs.getString("NomeDoenca");
		            String tratamento = rs.getString("Tratamento");
		            String descricao = rs.getString("Descricao");

		            Doentes doente = new Doentes(idAnimal, doencaNome, tratamento, descricao);
		            lista.add(doente);
		        }

		        Conexao.desconectar();
		    } catch (SQLException e) {
		        System.out.println("Erro no relatório: " + e.getMessage());
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
			        e.printStackTrace();
			        System.out.println("Erro na busca: " + e.getMessage());
			    }
			    return idencontrado;
			}
}
