/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decarona;

import DeCaronaModel.Transporte;
import DeCaronaModel.PontosTuristicos;
import DeCaronaModel.Caronista;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Aluno
 */
public class DeCarona {

/**
 *
 * @author Aluno
 */
 
    private static ArrayList <Transporte> listaTransporte = new ArrayList<>();
    private static ArrayList <Caronista> listaCaronista = new ArrayList<>();
    private static ArrayList <PontosTuristicos> listaPontos = new ArrayList<>();
    private static ArrayList <Caronista> listaCaronistaTrans = new ArrayList<>();

    
    public ArrayList<Transporte> cadastrarTransporte(int id, String placa, String tipo, double valor, int capacidade,
    int saida, String localSaida, int retorno, String localRetorno) {
        listaTransporte.add(new Transporte(id, placa, tipo, valor, capacidade, saida,
        localSaida, retorno, localRetorno));
        return listaTransporte;
    }
    public ArrayList<Transporte> getlistaTransporte() {
        return listaTransporte;
    }
    public ArrayList<Caronista> getlistaCaronista() {
        return listaCaronista;
    }
    public ArrayList<PontosTuristicos> getlistaPontos() {
        return listaPontos;
    }
    public ArrayList<Caronista> getlistaCaronistaTrans() {
        return listaCaronistaTrans;
    }

    public static int opcao, id, quantPontos;

    public static void main(String[] args) throws IOException {
       String cpf, id1;
       boolean Igualdade = false;
       
       
       do{
            System.out.println("\nBem Vindo");
            System.out.println("+-------------------------------+");
            System.out.println("|0 - SAIR                       |"
                    + "\n+-------------------------------+\n"
                    + "|1 - ATUALIZAÇÃO        |"
                    + "\n+-------------------------------+\n"
                    + "|2 - LISTAGEM           |"
                    + "\n+-------------------------------+\n"
                    + "|3 - CADASTRO           |"
                    );
            System.out.println("+-------------------------------+");
            opcao = Console.readInt();
       
       if(opcao == 1){
           System.out.println("1 - Consultar Caronista;");
           System.out.println("2 - Consultar Transporte;");
           System.out.println("3 - Consutar Ponto Turístico;");
           opcao = Console.readInt();
           switch (opcao) {
                case 1:
                    System.out.println("Digite o CPF que queira consultar: ");
                    cpf = Console.readString();
                        
                   for(int i = 0; i < listaCaronista.size(); i++){
                        Igualdade = listaCaronista.get(i).Testar(cpf);
                        if(Igualdade == true)
                            break;
                    }
                        
                    if(Igualdade == false){
                        System.out.println("NÃ£o foi achado um caronista com esse CPF !!");
                    }
                    break;
                case 2:
                    System.out.println("Digite o ID do Transporte que queira consultar: ");
                    id1 = Console.readString();
                        
                    for(int i = 0; i < listaTransporte.size(); i++){
                        Igualdade = listaTransporte.get(i).Testar(id1);
                        if(Igualdade == true)
                           break;
                    }
                        
                    if(Igualdade == false){
                        System.out.println("NÃ£o foi achado um transporte com esse ID !!");
                     }
                    break;
                case 3:
                    System.out.println("Digite o ID do Ponto Turistico que queira consultar: ");
                    id1 = Console.readString();
                        
                    for(int i = 0; i < listaPontos.size(); i++){
                        Igualdade = listaPontos.get(i).Testar(id1);
                        if(Igualdade == true)
                            break;
                    }
                        
                    if(Igualdade == false){
                        System.out.println("NÃ£o foi achado um Ponto Turistico com esse ID !!");
                    }
                    break;
                default:
                    break;
            }
       }else if(opcao == 2){
            System.out.println("1 - Listagem de Pontos Turísticos de um Bairro");
            System.out.println("2 - Listagem de transportes Pontos Turísticos");
            opcao = Console.readInt();
            
            if(opcao == 1){
                ListarPontos();
            }else if(opcao == 2){
                
            }
       }else if(opcao == 3){
           System.out.println("1 - Registrar Caronista;");
           System.out.println("2 - Registrar Transporte;");
           System.out.println("3 - Registrar Ponto TurÃ­stico");   
           opcao = Console.readInt();
            if(opcao == 1){
                CadastrarCaronista();
            }else if(opcao == 2){
                CadastrarTransporte();
            }else if(opcao == 3){
                CadastrarPonto();
            }
       }
       }while(opcao != 9);
        
    }

    public static void CadastrarCaronista() throws IOException{
        String cpf, rg, nome;
        int idade;   
     
        System.out.println("Digite o cpf: ");
        cpf = Console.readString();
        System.out.println("Digite o rg: ");
        rg = Console.readString();
        System.out.println("Digite o nome: ");
        nome = Console.readString();
        System.out.println("Digite o idade: ");
        idade = Console.readInt();
       
        Caronista caronista =  new Caronista(cpf, rg, nome, idade);
        for (int i = 0; i < listaCaronista.size(); i++) {
            if(listaCaronista.get(i).VerSeJaTem(caronista) == 1){
                System.out.println("Cadastro jÃ¡ Existe");
                return;
            }
        }       
        
        listaCaronista.add(caronista);
        
        System.out.println("Está ligado a algum transporte? [1] SIM e [0] NÃO");
        opcao = Console.readInt();
        
        if(opcao == 1){ 
            ListarPontos(caronista);
        }
    }
    
    private static void CadastrarTransporte() throws IOException{
        String placa, tipo, localSaida, localRetorno;
        int capacidade, saida, retorno, id;
        double valor;
        Random r = new Random();
         
        System.out.println("Digite a sua placa: ");
        placa = Console.readString();
        System.out.println("Digite o tipo de transporte: ");
        tipo = Console.readString();
        System.out.println("Digite o valor: ");
        valor = Console.readDouble();
        System.out.println("Digite o limite de passageiros: ");
        capacidade = Console.readInt();
        System.out.println("Digite o hora e local de saida: ");
        saida = Console.readInt();
        localSaida = Console.readString();
        System.out.println("Digite o hora e local de retorno: ");
        retorno = Console.readInt();
        localRetorno = Console.readString(); 
        
        id = r.nextInt(100);
        
        Transporte transporte =  new Transporte(id, placa, tipo, valor, capacidade, saida, localSaida, retorno, localRetorno);
        for (int i = 0; i < listaTransporte.size(); i++) {
            if(listaTransporte.get(i).VerSeJaTem(transporte) == 1){
                System.out.println("Cadastro jÃ¡ Existe");
                return;
            }
        }
        listaTransporte.add(transporte);        
        
        System.out.println("Deseja se cadastrar em algum Ponto Turistico ?");
        opcao = Console.readInt();
        
        if(opcao == 1){ 
            for (int i = 0; i < listaPontos.size(); i++) {
                listaPontos.get(i).PrintDados();
                System.out.println("Deseja se registrar nesse ponto turÃ­stico");
                opcao = Console.readInt();
                
                if(opcao == 1){
                    listaPontos.get(i).CadastrarNoPonto(transporte);
                    break;
                }
            }
            
        }else if( opcao != 1) {
        }

    }
     
    private static void CadastrarPonto() throws IOException{
        int abertura, fechamento, id;
        String nome, local;
        
        Random r = new Random();
        
        System.out.println("Digite o nome do Ponto turistico: ");
        nome = Console.readString();
        System.out.println("Digite o local (Bairro) do Ponto Turistico: ");
        local = Console.readString();
        System.out.println("Digite a hora de Abertura: ");
        abertura = Console.readInt();
        System.out.println("Digite a hora de fechamento: ");
        fechamento = Console.readInt();
        
        id = r.nextInt(100);
        quantPontos++;
        
        PontosTuristicos ponto = new PontosTuristicos(id, nome, local, abertura, fechamento);
        for (int i = 0; i < listaPontos.size(); i++) {
            if(listaPontos.get(i).VerSeJaTem(ponto) == 1){
                System.out.println("Cadastro jÃ¡ Existe");
                return;
            }
        }
        listaPontos.add(ponto);
    }

    private static void ListarPontos() throws IOException{
        String bairro;
        int hora, quantTotal = 0;
        
        System.out.println("Digite o nome do Bairro que deseja listar: ");
        bairro = Console.readString();
        System.out.println("Digite o o horÃ¡rio atual: ");
        hora = Console.readInt();
        
        System.out.println("Pontos TurÃ­sticos localizado no bairro " + bairro + ":");
        for(int i = 0; i < listaPontos.size(); i++){
            listaPontos.get(i).ListarPonto(bairro, hora);
        }
    }
    
    private static void ListarPontos(Caronista c) throws IOException{
        String bairro, nome;
        int hora;
        
        System.out.println("Deseja pesquisar todos os pontos da cidade[1], Via Bairro[2] ou Via Nome especifico[3]");
        int resp = Console.readInt();
        if(resp == 2){
          System.out.println("Digite o nome do Bairro que deseja listar: ");
          bairro = Console.readString();
          System.out.println("Digite a hora atual: ");
          hora = Console.readInt();

          System.out.println("Pontos TurÃ­sticos localizado no bairro " + bairro + ":");
          for(int i = 0; i < listaPontos.size(); i++){
              if(bairro.equals(listaPontos.get(i).getLocal()))
                  listaPontos.get(i).ListarPonto(bairro, hora, c);
            }  
        }else if( resp == 1){
            System.out.println("Digite a hora atual: ");
            hora = Console.readInt();
            
            for(int i = 0; i < listaPontos.size(); i++){      
                listaPontos.get(i).ListarPonto("", hora, c);
             }             
        }else if(resp == 3){
            System.out.println("Digite o nome do local Turistico");
            nome = Console.readString();
            System.out.println("Digite a hora atual: ");
            hora = Console.readInt();
            
            for(int i = 0; i < listaPontos.size(); i++){   
                if(nome.equals(listaPontos.get(i).getNome()))
                    listaPontos.get(i).ListarPonto("", hora, c);
            }                
            
        }

    }
 
}
