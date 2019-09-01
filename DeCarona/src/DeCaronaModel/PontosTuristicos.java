package DeCaronaModel;

import DeCaronaModel.Transporte;
import DeCaronaModel.Caronista;
import decarona.Console;
import decarona.Console;
import java.io.IOException;
import java.util.ArrayList;


public class PontosTuristicos {
    public int id;
    public String nome;
    public String local;
    public int abertura;
    public int fechamento;
    
    private static ArrayList <Transporte> listaTransPonto = new ArrayList<>();

    
    public PontosTuristicos() {
    }

    public PontosTuristicos(int id,String nome, String local, int abertura, int fechamento) {
        this.id = id;
        this.nome = nome;
        this.local = local;
        this.abertura = abertura;
        this.fechamento = fechamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getAbertura() {
        return abertura;
    }

    public void setAbertura(int abertura) {
        this.abertura = abertura;
    }

    public int getFechamento() {
        return fechamento;
    }

    public void setFechamento(int fechamento) {
        this.fechamento = fechamento;
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
    
    public void PrintDados(){
        System.out.println("Nome: " + nome);
        System.out.println("ID: " + id);
        System.out.println("Local: " + local);
        System.out.println("Abertura: " + abertura);
        System.out.println("Fechamento: " + fechamento);
    }
    
    public void ListarPonto(String bairro, int hora, Caronista c) throws IOException{
        int resp;
        
        PrintDados();

        if(hora >= abertura && hora <= fechamento){
            System.out.println("O Estabelecimento estÃ¡ aberto !! ");
        }else{
            System.out.println("O Estabelecimento estÃ¡ fechado no momento ! Tente em outro lugar");
            return;
        }
        
        System.out.println("Deseja registrar nesse transporte ?");    
        resp = Console.readInt();  
        if(resp == 1)
            ListarTransportes(c);
            
        
    }
    
    public void ListarPonto(String bairro, int hora) throws IOException{
        int resp;
        if(local.equals(bairro)){
            System.out.println("Nome: " + nome);
            if(hora >= abertura && hora <= fechamento){
                System.out.println("O Estabelecimento estÃ¡ aberto !! ");
            }
        }
    }
    
    public void CadastrarNoPonto(Transporte t){
        listaTransPonto.add(t);
    }
    
    public void ListarTransportes(Caronista c) throws IOException{
        int resp;
        
        for (int i = 0; i < listaTransPonto.size(); i++) {
            System.out.println("O Carro com a placa " + listaTransPonto.get(i).placa + " estÃ¡ cadastrado. Deseja se cadastrar nele ?");
            System.out.println("Horario e Local de saida: " + listaTransPonto.get(i).saida + " - " + listaTransPonto.get(i).localSaida);
            System.out.println("Horario e Local de retorno: " + listaTransPonto.get(i).retorno + " - " + listaTransPonto.get(i).localRetorno);
            System.out.println("Tipo de Transporte: " + listaTransPonto.get(i).tipo);
            System.out.println("Valor: " + listaTransPonto.get(i).valor);
            System.out.println("Vagas: " + listaTransPonto.get(i).capacidade);
            System.out.println("Deseja se cadastrar nesse veÃ­culo ?");
            System.out.println("1 - SIM e 2 - NÃ‚O");
            resp = Console.readInt();
            
            if(resp == 1){
                listaTransPonto.get(i).CadastrarNoTransporte(c);
            }
        }   
    }
    
    public void ListarTransportes() throws IOException{
        for (int i = 0; i < listaTransPonto.size(); i++) {
            System.out.println("O Carro com a placa " + listaTransPonto.get(i).placa + " estÃ¡ cadastrado");
            System.out.println("Horario e Local de saida: " + listaTransPonto.get(i).saida + " - " + listaTransPonto.get(i).localSaida);
            System.out.println("Horario e Local de retorno: " + listaTransPonto.get(i).retorno + " - " + listaTransPonto.get(i).localRetorno);
            System.out.println("Tipo de Transporte: " + listaTransPonto.get(i).tipo);
            System.out.println("Valor: " + listaTransPonto.get(i).valor);
            System.out.println("Vagas: " + listaTransPonto.get(i).capacidade);
        }   
    }    
    public int VerSeJaTem(PontosTuristicos p){
        int igual;
        
        if(id == p.id){
            igual = 1;
        }else
            igual = 0;
        
        if(nome.equals(p.nome))
            igual = 1;
        else
            igual = 0;
                
        return igual;
    }
}
