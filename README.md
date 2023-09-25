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
  
  ```
* Classe SequenceManager

``` java

```
* Classe PessoaFisicaDAO

```java

```
* Classe PessoaJuridicaDAO

``` java

```
* Classe CadastroBDTeste

``` java

```
<br>
[Procedimento 2: Alimentando a Base](https://github.com/Gregdev22/Missao-3-Mundo-3/tree/main/Procedimento2/CadastroBD).

<hr>


