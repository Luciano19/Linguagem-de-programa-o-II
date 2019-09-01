    //package decarona;
package DeCaronaModel;
import java.io.IOException;

public class Caronista {

   public String cpf;
   public String rg;
   public String nome;
   public int idade;

    public Caronista() {
        
    }

    public Caronista(String cpf, String rg, String nome, int idade) {
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public boolean Testar(String _cpf){
        if(this.cpf.compareTo(_cpf) == 0){
            PrintDados();
            return true;
        }else{
            return false;
        }
    }
    
    public void PrintDados(){
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("RG: " + rg);
        System.out.println("Idade: " + idade);
    }
    
    public int VerSeJaTem(Caronista c){
        int igual;
        if(cpf.equals(c.cpf)){
            igual = 1;
        }else
            igual = 0;
        
        return igual;
    }
}


