package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    
	private static final String url = "jdbc:postgresql://localhost:5432/bemcaprino";
	private static final String user = "postgres";
	private static final String password = "1234567";
	
private static Connection conn;
	
	public static void conectar(){
        try{
            Class.forName("org.postgresql.Driver"); 
            conn = DriverManager.getConnection(url, user, password); 
        }catch(Exception e){
            System.out.println("Erro na conex�o: "+e.getMessage());
        }
    }
	public static void desconectar(){
        try{
        	conn.close();
        }catch(Exception e){
            System.out.println("Erro na desconex�o: "+e.getMessage());
        }
    }
    public static Connection getConexao(){
        return conn;
    }
}