package DeCaronaModel;

import DeCaronaModel.Caronista;
import java.util.ArrayList;

public class Transporte {
    public int id;
    public String placa;
    public String tipo;
    public double valor;
    public int capacidade;
    public int saida;
    public String localSaida;
    public int retorno;
    public String localRetorno;
    
    private int capacidadeAtual;
    private static ArrayList<Caronista> passageiros = new ArrayList<Caronista>();

    public Transporte() {
    }

    public Transporte(int id, String placa, String tipo, double valor, int capacidade, int saida, String localSaida, int retorno, String localRetorno) {
        this.placa = placa;
        this.tipo = tipo;
        this.valor = valor;
        this.capacidade = capacidade;
        this.saida = saida;
        this.localSaida = localSaida;
        this.retorno = retorno;
        this.localRetorno = localRetorno;
        capacidadeAtual = capacidade;
    }

    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getSaida() {
        return saida;
    }

    public void setSaida(int saida) {
        this.saida = saida;
    }

    public String getLocalSaida() {
        return localSaida;
    }

    public void setLocalSaida(String localSaida) {
        this.localSaida = localSaida;
    }

    public int getRetorno() {
        return retorno;
    }

    public void setRetorno(int retorno) {
        this.retorno = retorno;
    }

    public String getLocalRetorno() {
        return localRetorno;
    }

    public void setLocalRetorno(String localRetorno) {
        this.localRetorno = localRetorno;
    }
    
    public boolean Testar(String id2){
        String comparar = Integer.toString(id);
        
        if(comparar.equals(id2)){
            PrintDados();
            return true;            
        }else{
            return false;
        }
    }
    
    private void PrintDados(){
        System.out.println("Id: " + id);
        System.out.println("Placa: " + placa);
        System.out.println("Tipo: " + tipo);
        System.out.println("Valor: " + valor);
        System.out.println("Capacidade Total: " + capacidade);
        System.out.println("Capacidade Atual: " + capacidadeAtual);
        System.out.println("Saida: " + saida);
        System.out.println("Local de Saida: " + localSaida);
        System.out.println("Retorno: " + retorno);
        System.out.println("Local Retorno: " + localRetorno);
    }
    
    public void CadastrarNoTransporte(Caronista c){
        if(capacidadeAtual > 0){
            passageiros.add(c);
            capacidadeAtual--;
        }
        if(capacidadeAtual <= 0)    
            System.out.println("NÃ£o tem mais vaga !");
    }
    
    public int VerSeJaTem(Transporte t){
        int igual;
        if(placa.equals(t.placa)){
            igual = 1;
        }else
            igual = 0;
        
        return igual;
    }
    
    public void ImprimirCaronistas(){
        for (int i = 0; i < passageiros.size(); i++) {
            passageiros.get(i).PrintDados();
        }
    }
}
