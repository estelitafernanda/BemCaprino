package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.Animais;
import Dominio.Doentes;

public class DoentesDAO {

		String INCLUIR = "INSERT INTO doentes (NomeDoenca, Tratamento, Descricao , animalid) VALUES (?, ?, ? , ?)";
		String BUSCARDOENTE = "SELECT * FROM \"doentes\" WHERE \"AnimalId\" = ?";
		String REL = "SELECT AnimalId , nomedoenca, tratamento, descricao FROM doentes";
		String VERIFICAR_EXISTENCIA = "SELECT COUNT(*) FROM animais WHERE idanimal = ?";
		String ALTERAR = "UPDATE doentes SET nomedoenca = ?, tratamento = ?, descricao = ? WHERE animalid = ?";
		String VERIFICAR = "SELECT * FROM doentes WHERE animalid = ? AND nomedoenca = ?";
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
		        	int idAnimal = rs.getInt("AnimalId");
		            String doencaNome = rs.getString("NomeDoenca");
		            String tratamento = rs.getString("Tratamento");
		            String descricao = rs.getString("Descricao");

		            Doentes doente = new Doentes(idAnimal, doencaNome, tratamento, descricao);
		            lista.add(doente);
		            System.out.println(doente.getIdAnimal());
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
		 public static void excluir(int Animalid, String nomeDoenca) {
			 String EXCLUIR = "DELETE FROM doentes WHERE animalid = ? AND NomeDoenca = ?";
			    try {
			        Conexao.conectar();
			        PreparedStatement instrucao = Conexao.getConexao().prepareStatement(EXCLUIR);
			        instrucao.setInt(1, Animalid);
			        instrucao.setString(2, nomeDoenca);
			        instrucao.execute();
			        instrucao.close();
			        Conexao.desconectar();
			    } catch (SQLException e) {
			        System.out.println("Erro ao excluir: " + e.getMessage());
			    }
		}
		 public boolean verificarExistencia(int idAnimal, String nomeDoenca) {
			    try {
			        Conexao.conectar();
			        PreparedStatement instrucao = Conexao.getConexao().prepareStatement(VERIFICAR);
			        instrucao.setInt(1, idAnimal);
			        instrucao.setString(2, nomeDoenca);

			        ResultSet resultado = instrucao.executeQuery();
			        boolean existeRegistro = resultado.next();

			        resultado.close();
			        instrucao.close();
			        Conexao.desconectar();

			        return existeRegistro;
			    } catch (SQLException e) {
			        System.out.println("Erro ao verificar existência: " + e.getMessage());
			        return false;
			    }
			}
		 public void alterar(Doentes doente) {
			    try {
			        if (verificarExistencia(doente.getIdAnimal(), doente.getNomeDoenca())) {
			            Conexao.conectar();
			            PreparedStatement instrucao = Conexao.getConexao().prepareStatement(ALTERAR);

			            instrucao.setString(1, doente.getNomeDoenca());
			            instrucao.setString(2, doente.getTratamento());
			            instrucao.setString(3, doente.getDescricao());
			            instrucao.setInt(4, doente.getIdAnimal());

			            instrucao.executeUpdate();
			            instrucao.close();
			            Conexao.desconectar();
			        } else {
			            System.out.println("Registro não encontrado. Alteração não realizada.");
			        }
			    } catch (SQLException e) {
			        System.out.println("Erro ao alterar: " + e.getMessage());
			    }
			}
}