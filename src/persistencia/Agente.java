package persistencia;

import java.sql.*;

public class Agente {
	
	//instancia del agente.
    protected static Agente mInstancia=null;
    
    //Conexion con la base de datos.
    protected static Connection mBD;
    
	//Identificador ODBC de la base de datos.
    private static String url="jdbc:ucanaccess://SoftProject.mdb";
    
    private Agente()throws Exception {
    	conectar();
    }
    
     public static Agente getAgenteUsuario() throws Exception{
          if (mInstancia==null){
        	  mInstancia=new Agente();
        }
        return mInstancia;
     }
 
    //Metodo para realizar la conexion a la base de datos
     
    private void conectar() throws Exception {
         mBD=DriverManager.getConnection(url);
    }

    //Metodo para desconectar de la base de datos
    public void desconectar() throws Exception{
    	mBD.close();
    }

    //Metodo para realizar una insercion en la base de datos
    public int insert(String SQL) throws SQLException, Exception{ 
     	conectar();
    	PreparedStatement stmt = mBD.prepareStatement(SQL);
    	int res=stmt.executeUpdate();
    	stmt.close();
    	desconectar();
    	return res;
    }
    
    //Metodo para realizar una eliminacion en la base de datos
    public int delete(String SQL) throws SQLException,Exception{
    	conectar();
    	PreparedStatement stmt = mBD.prepareStatement(SQL);
    	int res=stmt.executeUpdate();
    	stmt.close();
    	desconectar();
    	return res;
    }
    
    
    public int update(String SQL) throws SQLException,Exception{
    	conectar();
    	PreparedStatement stmt = mBD.prepareStatement(SQL);
    	int res=stmt.executeUpdate();
    	stmt.close();
    	desconectar();
    	return res;
    }
    
    
    public ResultSet select(String SQL) throws SQLException,Exception{
		
		conectar();
    	PreparedStatement stmt = mBD.prepareStatement(SQL);
    	ResultSet resultado = stmt.executeQuery();

		return resultado;
	
	}
}