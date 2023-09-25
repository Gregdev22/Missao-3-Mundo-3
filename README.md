<!-- PROJECT LOGO -->
<div align="center">
   <a href="https://github.com/othneildrew/Best-README-Template">
      <img src="https://logodownload.org/wp-content/uploads/2014/12/estacio-logo-1-2048x1641.png" alt="estacio logo" width="80"                  height="80">
   </a>
    <h1 align="center"> Universidade Estácio de Sá </h1>
     <hr>
</div> 

* DESENVOLVIMENTO FULL STACK- TURMA 23.3 -9003
* Disciplina: RPG0016  - Back-end Sem Banco Não Tem!
* Semestre Letivo: 2023.2
* Repositorio Git: https://github.com/Gregdev22/Missao-3-Mundo-3/tree/main

<hr>

* [EMERSON GREGORIO ALVES](https://github.com/Gregdev22) - MATRICULA: 2022.0908.4986
<hr>
 <h1 align="center"> Missão Prática | Nível 3 | Mundo 3 </h1>
 <h2 align="left" > Criação de aplicativo Java, com acesso ao banco de dados SQL Server através do middleware JDBC Server. </h2> 
 <h3>Procedimento 1: Mapeamento Objeto-Relacional e DAO </h3>
 <h3>Procedimento 2: Alimentando a Base </h3>
 
 <hr>

 <h2> :clipboard: Objetivos da Prática </h2>

* Implementar persistência com base no middleware JDBC.
* Utilizar o padrão DAO (Data Access Object) no manuseio de dados.
* Implementar o mapeamento objeto-relacional em sistemas Java.
* Criar sistemas cadastrais com persistência em banco relacional.
* No final do exercício, o aluno terá criado um aplicativo cadastral com uso do SQL Server na persistência de dados.
<hr>

<h2> Códigos </h2>

[Procedimento 1: Mapeamento Objeto-Relacional e DAO](https://github.com/Gregdev22/Missao-3-Mundo-3/tree/main/Procedimento1/CadastroBD)

* Classe Pessoa

``` java
package cadastrobd.model;
import java.io.Serializable;


/**
 *
 * @author grego
 */
public class Pessoa implements Serializable{
    private int id;
    private String nome;
    private String logradouro;
    private String cidade;
    private String estado;
    private String telefone;
    private String email;

    public Pessoa(int id, String nome, String logradouro, String cidade, String estado,
            String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
    
    public void exibir(){
        System.out.print("id: "+this.id + "\n" + "Nome: " + this.nome + "\n" + 
        "logradouro: "+this.logradouro+"\n"+"cidade: "+this.cidade+"\n"+
        "estado: "+this.estado+"\n" + "telefone: " +  this.telefone + "\n"+ "email: " + this.email );
    }
}
```
* Classe PessoaFisica

``` java
package cadastrobd.model;
import java.io.Serializable;

/**
 *
 * @author grego
 */
public class PessoaFisica extends Pessoa implements Serializable {

    private String cpf;
    
    public PessoaFisica(int id, String nome, String logradouro, String cidade, String estado,
            String telefone, String email, String cpf){
        super(id, nome, logradouro, cidade, estado, telefone, email);
        this.cpf = cpf;
    }

     public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public void exibir(){
        System.out.print("id: "+ getId()+ "\n" + "Nome: " + getNome() + "\n" + 
        "logradouro: "+getLogradouro()+"\n"+"cidade: "+getCidade()+"\n"+
        "estado: "+getEstado()+"\n" + "telefone: " +  getTelefone() + "\n"+ "email: " + getEmail() + "\n"+
        "CPF: "+this.cpf + "\n");
    }
}
```
* Classe PessoaJuridica

``` java
package cadastrobd.model;
import java.io.Serializable;

/**
 *
 * @author grego
 */
public class PessoaJuridica extends Pessoa implements Serializable{
    
    private String cnpj;
    
    public PessoaJuridica(int id, String nome, String logradouro, String cidade, String estado,
            String telefone, String email, String cnpj){
        super(id, nome, logradouro, cidade, estado, telefone, email);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public void exibir(){
        System.out.print("id: "+ getId()+ "\n" + "Nome: " + getNome() + "\n" + 
        "logradouro: "+getLogradouro()+"\n"+"cidade: "+getCidade()+"\n"+
        "estado: "+getEstado()+"\n" + "telefone: " +  getTelefone() + "\n"+ "email: " + getEmail() + "\n"+
        "CNPJ: "+this.cnpj + "\n");
    }
}
```
* Classe ConectorBD
  
``` java
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
  ```
* Classe SequenceManager

``` java
package cadastro.model.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;


/**
 *
 * @author grego
 */
public class SequenceManager {
        
    public int getValue(String sequencia)throws Exception{
        int resultado = 0;
        Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLSERVER2019E:1433;databaseName=Loja;encrypt=true;trustServerCertificate=true",
        "loja", "loja");
        String sql = "SELECT NEXT VALUE FOR "+sequencia+" as proximoId";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next())
            resultado = rs.getInt("proximoId");
        return resultado;
    } 
}
```
* Classe PessoaFisicaDAO

```java
package cadastro.model;
import cadastrobd.model.PessoaFisica;
import java.util.ArrayList;
import java.util.List;
import cadastro.model.util.ConectorBD;
import com.sun.jdi.connect.spi.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author grego
 */
public class PessoaFisicaDAO {
    
    public ConectorBD connection = new ConectorBD();
    
    public PessoaFisica getPessoa(int id)throws Exception {
        PessoaFisica pessoa = null;
        String sql = "select *\n" +
                      "from pessoa, pessoa_fisica\n" +
                      "where pessoa.idpessoa = "+ id + "AND " +
                      "pessoa.idpessoa = pessoa_fisica.idpessoa;";
            PreparedStatement ps = connection.getPrepared(sql);
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                pessoa = new PessoaFisica(resultado.getInt("idpessoa"),
                resultado.getString("nome"),
                resultado.getString("logradouro"),
                resultado.getString("cidade"),
                resultado.getString("estado"),
                resultado.getString("telefone"),
                resultado.getString("email"),
                resultado.getString("cpf"));
                connection.closeConnection();
                //connection.closeResult(ps);
                connection.closeStatement(sql);
            } return pessoa;  
    } 
    
       
    public List<PessoaFisica> getPessoas() throws Exception{
        List<PessoaFisica> lista = new ArrayList<>();
        String sql = "select *\n" +
                      "from pessoa, pessoa_fisica\n" +
                      "where pessoa.idpessoa = pessoa_fisica.idpessoa;";
            PreparedStatement ps = connection.getPrepared(sql);
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                //System.out.println(resultado.getString(5));
                lista.add(new PessoaFisica(resultado.getInt("idpessoa"),
                resultado.getString("nome"),
                resultado.getString("logradouro"),
                resultado.getString("cidade"),
                resultado.getString("estado"),
                resultado.getString("telefone"),
                resultado.getString("email"),
                resultado.getString("cpf")));
                connection.closeConnection();
                //connection.closeResult(ps);
                connection.closeStatement(sql);
            } return lista;
            
    }       
   
    
    public void incluir(PessoaFisica pessoafisica)throws Exception{
        String sqlfisica  = "insert into pessoa_fisica (idpessoa, cpf) values (?,?)"; 
        String sqlpessoa = "insert into pessoa (idpessoa,nome,logradouro, cidade,"
                + "estado, telefone, email ) values (?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.getPrepared(sqlfisica);
        PreparedStatement ps1 = connection.getPrepared(sqlpessoa);
        //ResultSet resultado = ps.executeQuery();
        ps.setInt(1, pessoafisica.getId());
        ps.setString(2, pessoafisica.getCpf());
        ps1.setInt(1, pessoafisica.getId());
        ps1.setString(2, pessoafisica.getNome());
        ps1.setString(3, pessoafisica.getLogradouro());
        ps1.setString(4, pessoafisica.getCidade());
        ps1.setString(5, pessoafisica.getEstado());
        ps1.setString(6, pessoafisica.getTelefone());
        ps1.setString(7, pessoafisica.getEmail());
        ps1.execute();
        ps.execute();
        connection.closeConnection();
        //connection.closeResult(ps);
        connection.closeStatement(sqlfisica);
    }
    
    public void alterar(int id, String cpf, String nome, String logradouro, 
        String cidade, String estado,String telefone, String email)throws Exception{
        PessoaFisica pessoa = getPessoa(id);
        String sqlfisica = "UPDATE pessoa_fisica SET cpf=? where idpessoa = "+id;
        String sqlpessoa = "UPDATE pessoa SET nome=?, logradouro=?, cidade=?,"
                + "estado=?, telefone=?, email=? WHERE idpessoa= "+id;
        PreparedStatement ps = connection.getPrepared(sqlfisica);
        PreparedStatement ps1 = connection.getPrepared(sqlpessoa);
        if(cpf.equals("")){
           ps.setString(1, pessoa.getCpf());
        } else{
            ps.setString(1, cpf);
        }
        
        if(nome.equals("")){
           ps1.setString(1, pessoa.getNome());
        } else{
            ps1.setString(1, nome);
        } 
        
        if(logradouro.equals("")){
           ps1.setString(2, pessoa.getLogradouro());
        } else{
            ps1.setString(2, logradouro);
        }
        
        if(cidade.equals("")){
           ps1.setString(3, pessoa.getCidade());
        } else{
            ps1.setString(3, cidade);
        }
        
        if(estado.equals("")){
           ps1.setString(4, pessoa.getEstado());
        } else{
            ps1.setString(4, estado);
        }
        
        if(telefone.equals("")){
           ps1.setString(5, pessoa.getTelefone());
        } else{
            ps1.setString(5, telefone);
        }
        if(email.equals("")){
           ps1.setString(6, pessoa.getEmail());
        } else{
            ps1.setString(6, email);
        } 
        ps.execute();
        ps1.execute();
        connection.closeConnection();
        //connection.closeResult(ps);
        connection.closeStatement(sqlfisica);
    }
    
    public void excluir(int id)throws Exception{
        String sqlfisica = "DELETE FROM pessoa_fisica WHERE idpessoa="+id;
        String sqlpessoa = "DELETE FROM pessoa WHERE idpessoa="+id;
        PreparedStatement ps = connection.getPrepared(sqlfisica);
        PreparedStatement ps1 = connection.getPrepared(sqlpessoa);
        ps.execute();
        ps1.execute();
        connection.closeConnection();
        //connection.closeResult(ps);
        connection.closeStatement(sqlfisica);
    }
    
}
```
* Classe PessoaJuridicaDAO

``` java
package cadastro.model;

import cadastro.model.util.ConectorBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import cadastrobd.model.PessoaJuridica;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author grego
 */
public class PessoaJuridicaDAO {
    
    public ConectorBD connection = new ConectorBD();
    
    public PessoaJuridica getPessoa(int id)throws Exception {
        PessoaJuridica pessoa = null;
        String sql = "select *\n" +
                      "from pessoa, pessoa_juridica\n" +
                      "where pessoa.idpessoa = "+ id + "AND " +
                      "pessoa.idpessoa = pessoa_juridica.idpessoa;";
            PreparedStatement ps = connection.getPrepared(sql);
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                pessoa = new PessoaJuridica(resultado.getInt("idpessoa"),
                resultado.getString("nome"),
                resultado.getString("logradouro"),
                resultado.getString("cidade"),
                resultado.getString("estado"),
                resultado.getString("telefone"),
                resultado.getString("email"),
                resultado.getString("cnpj"));
                connection.closeConnection();
                //connection.closeResult(ps);
                connection.closeStatement(sql);
            } return pessoa;  
    } 
    
    public List<PessoaJuridica> getPessoas() throws Exception{
        List<PessoaJuridica> lista = new ArrayList<>();
        String sql = "select *\n" +
                      "from pessoa, pessoa_juridica\n" +
                      "where pessoa.idpessoa = pessoa_juridica.idpessoa;";
            PreparedStatement ps = connection.getPrepared(sql);
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                //System.out.println(resultado.getString(5));
                lista.add(new PessoaJuridica(resultado.getInt("idpessoa"),
                resultado.getString("nome"),
                resultado.getString("logradouro"),
                resultado.getString("cidade"),
                resultado.getString("estado"),
                resultado.getString("telefone"),
                resultado.getString("email"),
                resultado.getString("cnpj")));
                connection.closeConnection();
                //connection.closeResult(ps);
                connection.closeStatement(sql);
            } return lista;
            
    }   

    public void incluir(PessoaJuridica pessoajuridica)throws Exception{
        String sqljuridica  = "insert into pessoa_juridica (idpessoa, cnpj) values (?,?)"; 
        String sqlpessoa = "insert into pessoa (idpessoa,nome,logradouro, cidade,"
                + "estado, telefone, email ) values (?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.getPrepared(sqljuridica);
        PreparedStatement ps1 = connection.getPrepared(sqlpessoa);
        //ResultSet resultado = ps.executeQuery();
        ps.setInt(1, pessoajuridica.getId());
        ps.setString(2, pessoajuridica.getCnpj());
        ps1.setInt(1, pessoajuridica.getId());
        ps1.setString(2, pessoajuridica.getNome());
        ps1.setString(3, pessoajuridica.getLogradouro());
        ps1.setString(4, pessoajuridica.getCidade());
        ps1.setString(5, pessoajuridica.getEstado());
        ps1.setString(6, pessoajuridica.getTelefone());
        ps1.setString(7, pessoajuridica.getEmail());
        ps1.execute();
        ps.execute();
        connection.closeConnection();
        //connection.closeResult(ps);
        connection.closeStatement(sqljuridica);
    }  
    
    public void alterar(int id, String cnpj, String nome, String logradouro, 
        String cidade, String estado,String telefone, String email)throws Exception{
        PessoaJuridica pessoa = getPessoa(id);
        String sqljuridica = "UPDATE pessoa_juridica SET cnpj=? where idpessoa = "+id;
        String sqlpessoa = "UPDATE pessoa SET nome=?, logradouro=?, cidade=?,"
                + "estado=?, telefone=?, email=? WHERE idpessoa= "+id;
        PreparedStatement ps = connection.getPrepared(sqljuridica);
        PreparedStatement ps1 = connection.getPrepared(sqlpessoa);
        if(cnpj.equals("")){
           ps.setString(1, pessoa.getCnpj());
        } else{
            ps.setString(1, cnpj);
        }
        
        if(nome.equals("")){
           ps1.setString(1, pessoa.getNome());
        } else{
            ps1.setString(1, nome);
        } 
        
        if(logradouro.equals("")){
           ps1.setString(2, pessoa.getLogradouro());
        } else{
            ps1.setString(2, logradouro);
        }
        
        if(cidade.equals("")){
           ps1.setString(3, pessoa.getCidade());
        } else{
            ps1.setString(3, cidade);
        }
        
        if(estado.equals("")){
           ps1.setString(4, pessoa.getEstado());
        } else{
            ps1.setString(4, estado);
        }
        
        if(telefone.equals("")){
           ps1.setString(5, pessoa.getTelefone());
        } else{
            ps1.setString(5, telefone);
        }
        if(email.equals("")){
           ps1.setString(6, pessoa.getEmail());
        } else{
            ps1.setString(6, email);
        } 
        ps.execute();
        ps1.execute();
        connection.closeConnection();
        //connection.closeResult(ps);
        connection.closeStatement(sqljuridica);
    }
    
    public void excluir(int id)throws Exception{
        String sqljuridica = "DELETE FROM pessoa_juridica WHERE idpessoa="+id;
        String sqlpessoa = "DELETE FROM pessoa WHERE idpessoa="+id;
        PreparedStatement ps = connection.getPrepared(sqljuridica);
        PreparedStatement ps1 = connection.getPrepared(sqlpessoa);
        ps.execute();
        ps1.execute();
        connection.closeConnection();
        //connection.closeResult(ps);
        connection.closeStatement(sqljuridica);
    }
    
}
```
* Classe CadastroBDTeste

``` java
import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaJuridica;
import cadastro.model.util.ConectorBD;
import cadastro.model.util.SequenceManager;
import cadastro.model.PessoaFisicaDAO;
import cadastro.model.PessoaJuridicaDAO;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author grego
 */
public class CadastroBDTeste {
    
    public static void main(String[] args)throws Exception {
        // a. Instanciar uma pessoa física e persistir no banco de dados    
        //Instanciando a sequencia
        SequenceManager seq = new SequenceManager();
        
        PessoaFisica pessoaIncluir = new PessoaFisica(seq.getValue("seq_Pessoa"),"Gregorio", "Rua 360, Centro", 
        "Recife", "PE", "1212-1212","Gregorio@recife.com","98765432112");
        PessoaFisicaDAO pessoaPF = new PessoaFisicaDAO();
        pessoaPF.incluir(pessoaIncluir);
        
        // b.Alterar os dados da pessoa física no banco.
        // Alterando pessoa e pessoaFisica pelo id--> 3 . Mudando nome, cpf e telefone
       PessoaFisicaDAO pessoaPF1 = new PessoaFisicaDAO();
       pessoaPF1.alterar( 3,  "12345678998",  "Emerson Gregorio",  "", "",  "", "123456789",  "");
              
       // c.Consultar todas as pessoas físicas do banco de dados e listar no console.
       // Retorno de todas as pessoas físicas do banco de dados 
       System.out.println("Pessoas fisicas:");
       PessoaFisicaDAO pessoasPF = new PessoaFisicaDAO();
       List<PessoaFisica> resultado = pessoasPF.getPessoas();
        for (PessoaFisica pessoaFisica : resultado) {
           pessoaFisica.exibir();
        } 
       
      //d. Excluir a pessoa física criada anteriormente no banco.
       // Excluindo pessoaFisica e Pessoa pelo id.
       PessoaFisicaDAO pessoaPF2 = new PessoaFisicaDAO();
       pessoaPF2.excluir(3);
      
      
      // e.Instanciar uma pessoa jurídica e persistir no banco de dados.
      
        
      //Incluir pessoa juridica e pessoa
      PessoaJuridica pessoaIncluir2 = new PessoaJuridica(seq.getValue("seq_Pessoa"),"GREG LTDA",
            "Rua Gregorio, Centro","Maceio", "AL", "9898-9898","GREGLTDA@maceio.com","55555555555555");
      PessoaJuridicaDAO pessoaPJ = new PessoaJuridicaDAO();
      pessoaPJ.incluir(pessoaIncluir2);
      
      
      // f.Alterar os dados da pessoa jurídica no banco.

      
      // Alterando pessoa e pessoaJuridica pelo id--> 4 . Mudando nome e cnpj
      PessoaJuridicaDAO pessoaPJ2 = new PessoaJuridicaDAO();
      pessoaPJ2.alterar( 4,  "99999999999999",  "Gregorio LTDA ",  "", "",  "", "",  "");
      
      
      // g.Consultar todas as pessoas jurídicas do banco e listar no console.
      
      
      // Retorno de todas as pessoas juridicas do banco de dados
       System.out.println("Pessoas juridicas:");    
       PessoaJuridicaDAO pessoasPJ = new PessoaJuridicaDAO();
       List<PessoaJuridica> resultado2 = pessoasPJ.getPessoas();
        for (PessoaJuridica pessoaJuridica : resultado2) {
           pessoaJuridica.exibir();
        } 
      
      
     // h.Excluir a pessoa jurídica criada anteriormente no banco.
     
     
     // Excluindo pessoa juridida e Pessoa pelo id.
      PessoaJuridicaDAO pessoaPJ3 = new PessoaJuridicaDAO();
      pessoaPJ3.excluir(4);
     
    }
}
```
<br>

[Procedimento 2: Alimentando a Base](https://github.com/Gregdev22/Missao-3-Mundo-3/tree/main/Procedimento2/CadastroBD)

<hr>
<h1>Resultados: </h1>
:triangular_flag_on_post: Procedimento 1:

<h2> Instanciar uma pessoa física e persistir no banco de dados </h2>
<img src="https://github.com/Gregdev22/Missao-3-Mundo-3/blob/main/Procedimento1/2%20proc%201.png" alt="resultado 1" width="1280" height="360">

<h2>Alterar os dados da pessoa física no banco </h2>
<img src="https://github.com/Gregdev22/Missao-3-Mundo-3/blob/main/Procedimento1/3%20proc%201.png" alt="resultado 1" width="1280" height="360">

<h2> Consultar todas as pessoas físicas do banco de dados e listar no console </h2>
<img src="https://github.com/Gregdev22/Missao-3-Mundo-3/blob/main/Procedimento1/4%20proc%201.png" alt="resultado 1" width="1280" height="360">

<h2> Excluir a pessoa física criada anteriormente no banco </h2>
<img src="https://github.com/Gregdev22/Missao-3-Mundo-3/blob/main/Procedimento1/5%20proc%201.png" alt="resultado 1" width="1280" height="360">

<h2> Instanciar uma pessoa jurídica e persistir no banco de dados </h2>
<img src="https://github.com/Gregdev22/Missao-3-Mundo-3/blob/main/Procedimento1/6%20proc%201.png" alt="resultado 1" width="1280" height="360">

<h2> Alterar os dados da pessoa jurídica no banco </h2>
<img src="https://github.com/Gregdev22/Missao-3-Mundo-3/blob/main/Procedimento1/7%20proc%201.png" alt="resultado 1" width="1280" height="360">

<h2> Consultar todas as pessoas jurídicas do banco e listar no console </h2>
<img src="https://github.com/Gregdev22/Missao-3-Mundo-3/blob/main/Procedimento1/8%20proc%201.png" alt="resultado 1" width="1280" height="360">

<h2> Excluir a pessoa jurídica criada anteriormente no banco </h2>
<img src="https://github.com/Gregdev22/Missao-3-Mundo-3/blob/main/Procedimento1/9%20proc%201.png" alt="resultado 1" width="1280" height="360">
