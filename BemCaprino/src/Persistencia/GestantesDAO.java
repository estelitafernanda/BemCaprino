package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.Animais;
import Dominio.Doentes;
import Dominio.Gestantes;

public class GestantesDAO {
	String INCLUIR = "INSERT INTO gestantes (TipoGestacao, DataInicio, TempoGestacao, animalid) VALUES (?, ?, ?, ?)";
	String BUSCARGESTANTE = "SELECT * FROM \"gestantes\" WHERE \"animalid\" = ?";
	String VERIFICAR_EXISTENCIA = "SELECT COUNT(*) FROM animais WHERE idanimal = ?";
	String REL = "SELECT animalid, TipoGestacao, DataInicio, TempoGestacao FROM gestantes";
	String ALTERAR = "UPDATE gestantes SET tipogestacao = ?, datainicio = ?, tempogestacao = ? WHERE animalid = ?";
	String VERIFICAR = "SELECT * FROM gestantes WHERE animalid = ? AND tipogestacao = ?";
	public void INCLUSAO(Gestantes password){
        try{
        	Conexao.conectar();
        	
        	 PreparedStatement verificacao = Conexao.getConexao().prepareStatement(VERIFICAR_EXISTENCIA);
             verificacao.setInt(1, password.getIdAnimal());
             ResultSet resultado = verificacao.executeQuery();

             if (resultado.next() && resultado.getInt(1) > 0) {
            	 
                 PreparedStatement instrucao = Conexao.getConexao().prepareStatement(INCLUIR);
                 instrucao.setString(1, password.getTipoGestacao());
                 instrucao.setString(2, password.getDataInicio());
                 instrucao.setString(3, password.getTempoGestacao());
                 instrucao.setInt(4, password.getIdAnimal());

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
	public ArrayList<Gestantes> RELATORIO(){
        ArrayList<Gestantes> lista = new ArrayList<>(); 
        try{
            Conexao.conectar();
            Statement instrucao = Conexao.getConexao().createStatement();
            ResultSet rs = instrucao.executeQuery(REL);
            
            while(rs.next()){
            int idAnimal = rs.getInt("AnimalId");
            String tipoGestacao = rs.getString("TipoGestacao"); 
            String dataInicio = rs.getString("DataInicio");
            String tempoGestacao =	rs.getString("TempoGestacao");
                Gestantes gestante = new Gestantes(idAnimal, tipoGestacao, dataInicio, tempoGestacao);
                lista.add(gestante);
                System.out.println("id:" + idAnimal);
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
		        PreparedStatement instrucao = Conexao.getConexao().prepareStatement(BUSCARGESTANTE);
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
		}
	 public static void excluir(int Animalid, String tipoGestacao) {
		 String EXCLUIR = "DELETE FROM gestantes WHERE animalid = ? AND tipogestacao = ?";
		    try {
		        Conexao.conectar();
		        PreparedStatement instrucao = Conexao.getConexao().prepareStatement(EXCLUIR);
		        instrucao.setInt(1, Animalid);
		        instrucao.setString(2, tipoGestacao);
		        instrucao.execute();
		        instrucao.close();
		        Conexao.desconectar();
		    } catch (SQLException e) {
		        System.out.println("Erro ao excluir: " + e.getMessage());
		    }
	 }
		    private boolean verificarExistencia(int idAnimal, String tipoGestacao) {
			    try {
			        Conexao.conectar();
			        PreparedStatement instrucao = Conexao.getConexao().prepareStatement(VERIFICAR);
			        instrucao.setInt(1, idAnimal);
			        instrucao.setString(2, tipoGestacao);

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
		    
		    public void alterar(Gestantes gestante) {
			    try {
			    	 if (verificarExistencia(gestante.getIdAnimal(), gestante.getTipoGestacao())) {
			             Conexao.conectar();
			             PreparedStatement instrucao = Conexao.getConexao().prepareStatement(ALTERAR);

			             instrucao.setString(1, gestante.getTipoGestacao());
			             instrucao.setString(2, gestante.getDataInicio());
			             instrucao.setString(3, gestante.getTempoGestacao());
			             instrucao.setInt(4, gestante.getIdAnimal());

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