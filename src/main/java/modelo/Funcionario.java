
package modelo;
 

public class Funcionario {
    
    private int id_funcionario;
    private String nome;
    private String email;
    private String cargo;
    private String endereco;
    
    
    public Funcionario (){
    
    }
    
    public Funcionario(int id_funcionario, String nome, String email, String cargo, String endereco) {
        this.id_funcionario = id_funcionario;
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
        this.endereco = endereco;
    }
    
    
      public Funcionario(String nome, String email, String cargo, String endereco) {
        super();
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
        this.endereco = endereco;
    }
      
      public int getId (){
      return id_funcionario;
      }
      
      public void setId( int id_funcionario){
        this.id_funcionario = id_funcionario;
      }
      
      public String getNome (){
      return nome;
      }
      
      public void setName (String nome){
      this.nome = nome;
      }
       
      public String getEmail (){
      return email;
      }
      
      public void setEmail (String email){
      this.email = email;
      }
      
      public String getCargo (){
      return cargo;
      }
      
      public void setCargo (String cargo){
      this.cargo = cargo;
      }
      
     public String getEndereco (){
     return endereco;
     }
      
      public void setEndereco (String endereco){
      this.endereco = endereco;
      }
}

