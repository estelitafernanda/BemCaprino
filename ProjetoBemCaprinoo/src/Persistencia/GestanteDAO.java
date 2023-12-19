package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.Gestantes;

public class GestanteDAO {
	String INCLUIR = "INSERT INTO gestantes (TipoGestacao, DataInicio, TempoGestacao) VALUES (?, ?, ?)";
	String BUSCARGESTANTE = "SELECT * FROM \"gestantes\" WHERE \"AnimalId\" = ?";
	String VERIFICAR_EXISTENCIA = "SELECT COUNT(*) FROM gestantes WHERE IdAnimal = ?";
	String REL = "SELECT AnimalId, TipoGestacao, DataInicio, TempoGestacao FROM \"gestantes\"";
	
	public void INCLUSAO(Gestantes password){
        try{
        	Conexao.conectar();
        	
        	 PreparedStatement verificacao = Conexao.getConexao().prepareStatement(VERIFICAR_EXISTENCIA);
             verificacao.setInt(1, password.getIdAnimal());
             ResultSet resultado = verificacao.executeQuery();

             if (resultado.next() && resultado.getInt(1) > 0) {
            	 
                 PreparedStatement instrucao = Conexao.getConexao().prepareStatement(INCLUIR);
                 instrucao.setInt(1, password.getSeqGestacao());
                 instrucao.setString(2, password.getTipoGestacao());
                 instrucao.setString(3, password.getDataInicio());
                 instrucao.setInt(4, password.getTempoGestacao());

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
                Gestantes gestante = new Gestantes(rs.getInt("AnimalId"), rs.getInt("SeqGestacao"),
                                    rs.getString("TipoGestacao"), rs.getString("DataInicio"), rs.getInt("TempoGestacao"));
                lista.add(gestante);
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
}
