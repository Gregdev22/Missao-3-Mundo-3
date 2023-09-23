/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author grego
 */

 public class ConectorBD {
    
    Connection conn = null;     
         
    //Metodo para conectar java con SQLServer
    /*
    public Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLSERVER2019E:1433;databaseName=Loja;encrypt=true;trustServerCertificate=true",
        "loja", "loja");
            JOptionPane.showMessageDialog(null, "Conectado com sucesso");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Um erro ocorreu "+e.getMessage());
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um error SQLException"+e.getMessage());
        }
        return conn;
    } 
    */
     
   
   public Connection getConnection() throws Exception{
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLSERVER2019E:1433;databaseName=Loja;encrypt=true;trustServerCertificate=true",
        "loja", "loja");
    return conn;
    }
    
   
   public void closeConnection()throws Exception{
       getConnection().close();
       //JOptionPane.showMessageDialog(null, "Conexao finalizada");
   }
   /*
   protected Statement getStatement() throws Exception {
        Statement stm = getConnection().createStatement();
        return stm;
   }
   */
   
   public PreparedStatement getPrepared(String sql) throws Exception {
        PreparedStatement ps = getConnection().prepareStatement(sql);
        return ps;
    }
   
   public void closeStatement(String sql)throws Exception{
       getPrepared(sql).close();
       //JOptionPane.showMessageDialog(null, "Statement finalizado");
   }
    
    public ResultSet getSelect(PreparedStatement ps) throws Exception {
        ResultSet rs = ps.executeQuery();
        //ResultSet rs = getConnection().createStatement().executeQuery("");
        return rs;
    }
    
    public void closeResult(PreparedStatement ps)throws Exception{
        getSelect(ps).close();
        //JOptionPane.showMessageDialog(null, "ResultSet finalizado");
    }
   
 }

