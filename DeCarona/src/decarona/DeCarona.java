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
//Declaração e criação das listas
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
       
//       Inicializção do menu principal
       do{
            System.out.println("\nBem Vindo");
            System.out.println("+-------------------------------+");
            System.out.println("|0 - SAIR                       |"
                    + "\n+-------------------------------+\n"
                    + "|1 - CONSULTA                |"
                    + "\n+-------------------------------+\n"
                    + "|2 - LISTAGEM                   |"
                    + "\n+-------------------------------+\n"
                    + "|3 - CADASTRO                   |"
                    );
            System.out.println("+-------------------------------+");
            opcao = Console.readInt();
//       Submenu para consulta dos itens
       if(opcao == 1){
           System.out.println("1 - Consultar Caronista;");
           System.out.println("+-------------------------------+");
           System.out.println("2 - Consultar Transporte;");
           System.out.println("+-------------------------------+");
           System.out.println("3 - Consutar Ponto Turístico;");
           System.out.println("+-------------------------------+");
           opcao = Console.readInt();
//           Switch para verificação das informações a serem exibidas
           switch (opcao) {
                case 1:
                    System.out.println("Digite o CPF que queira consultar: ");
                    cpf = Console.readString();
                        
                   for(Caronista C: listaCaronista){ //For utilizado para percorrer a lista de caronista e verificar se já existe
                        Igualdade = C.Testar(cpf);
                        if(Igualdade == true)
                            break;
                    }
                        
                    if(Igualdade == false){
                        System.out.println("Caronista não encontrado !!");
                    }
                    break;
                case 2:
                    System.out.println("Digite o ID do Transporte: ");
                    id1 = Console.readString();
                        
                    for(Transporte t: listaTransporte){ //For utilizado para percorrer a lista de transporte e verificar se já existe
                        Igualdade = t.Testar(id1);
                        if(Igualdade == true)
                           break;
                    }
                        
                    if(Igualdade == false){
                        System.out.println("Transporte não encontrado!!");
                     }
                    break;
                case 3:
                    System.out.println("Digite o ID do Ponto Turistico: ");
                    id1 = Console.readString();
                        
                    for(PontosTuristicos pt: listaPontos){ //For utilizado para percorrer a lista de pontos turisticos e verificar se já existe
                        Igualdade = pt.Testar(id1);
                        if(Igualdade == true)
                            break;
                    }
                        
                    if(Igualdade == false){
                        System.out.println("Ponto Turistico não encontrado !!");
                    }
                    break;
                default:
                    break;
            }
       }else if(opcao == 2){
            System.out.println("1 - Listagem de Pontos Turísticos de um Bairro");
            System.out.println("+---------------------------------------------+");
            System.out.println("2 - Listagem de transportes Pontos Turísticos");
            System.out.println("+---------------------------------------------+");
            opcao = Console.readInt();
            
            if(opcao == 1){
                ListarPontos();//Método usado para exibir todos pontos turísticos
            }else if(opcao == 2){
                
            }
       }else if(opcao == 3){
           System.out.println("1 - Registrar Caronista;");
           System.out.println("+---------------------------------------------+");
           System.out.println("2 - Registrar Transporte;");
           System.out.println("+---------------------------------------------+");
           System.out.println("3 - Registrar Ponto Turístico"); 
           System.out.println("+---------------------------------------------+");
           opcao = Console.readInt();
            if(opcao == 1){
                CadastrarCaronista();//Método usado para cadastrar caronista
            }else if(opcao == 2){
                CadastrarTransporte(); //Método usado para cadastrar transporte
            }else if(opcao == 3){
                CadastrarPonto(); //Método usado para cadastrar pontos
            }
       }
       }while(opcao != 9);
        
    }
//Metodo de cadastro e de de adição de caronista
    public static void CadastrarCaronista() throws IOException{
        String cpf, rg, nome;
        int idade;   
     
        System.out.println("Informe o cpf: ");
        cpf = Console.readString();
        System.out.println("informe o rg: ");
        rg = Console.readString();
        System.out.println("Informe o nome: ");
        nome = Console.readString();
        System.out.println("Informe a idade: ");
        idade = Console.readInt();
       
        Caronista caronista =  new Caronista(cpf, rg, nome, idade);
        for (Caronista C: listaCaronista) {
            if(C.VerSeJaTem(caronista) == 1){
                System.out.println("Cadastro já Existênte");
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
    //Metodo de cadastro e de de adição de transporte
    private static void CadastrarTransporte() throws IOException{
        String placa, tipo, localSaida, localRetorno;
        int capacidade, saida, retorno, id;
        double valor;
        int novaMat = DeCarona.listaTransporte.size() + 1;// função para gerar Id
         
        System.out.println("Insira a sua placa: ");
        placa = Console.readString();
        System.out.println("Informe o tipo de transporte: ");
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
        
        id = novaMat;
        
        Transporte transporte =  new Transporte(id, placa, tipo, valor, capacidade, saida, localSaida, retorno, localRetorno);
        for (Transporte T: listaTransporte) {
            if(T.VerSeJaTem(transporte) == 1){
                System.out.println("Cadastro já Existênte");
                return;
            }
        }
        listaTransporte.add(transporte);        
        
        System.out.println("Deseja se cadastrar em algum Ponto Turistico ?");
        opcao = Console.readInt();
        
        if(opcao == 1){ 
            for (PontosTuristicos pt:listaPontos) {
                pt.PrintDados();
                System.out.println("Deseja se registrar nesse ponto turístico");
                opcao = Console.readInt();
                
                if(opcao == 1){
                    pt.CadastrarNoPonto(transporte);
                    break;
                }
            }
            
        }else if( opcao != 1) {
        }

    }
    
     //Metodo de cadastro, de adição de pontos turistico e exibição
    private static void CadastrarPonto() throws IOException{
        int abertura, fechamento, id;
        String nome, local;
        
        int novaMat = DeCarona.listaPontos.size() + 1;
        
        System.out.println("Informe o nome do Ponto turistico: ");
        nome = Console.readString();
        System.out.println("Digite o local (Bairro) do Ponto Turistico: ");
        local = Console.readString();
        System.out.println("Informe o horário de Abertura: ");
        abertura = Console.readInt();
        System.out.println("Insira o horário de fechamento: ");
        fechamento = Console.readInt();
        
        id = novaMat;
        
        PontosTuristicos ponto = new PontosTuristicos(id, nome, local, abertura, fechamento);
        for (PontosTuristicos pt:listaPontos) {
            if(pt.VerSeJaTem(ponto) == 1){
                System.out.println("Cadastro já Existênte");
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
        System.out.println("Digite o o horário atual: ");
        hora = Console.readInt();
        
        System.out.println("Pontos Turísticos localizado no bairro " + bairro + ":");
        for(PontosTuristicos pt:listaPontos){
            pt.ListarPonto(bairro, hora);
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

          System.out.println("Pontos Turísticos localizado no bairro " + bairro + ":");
          for(PontosTuristicos pt:listaPontos){
              if(bairro.equals(pt.getLocal()))
                  pt.ListarPonto(bairro, hora, c);
            }  
        }else if( resp == 1){
            System.out.println("Digite a hora atual: ");
            hora = Console.readInt();
            
            for(PontosTuristicos pt:listaPontos){      
                pt.ListarPonto("", hora, c);
             }             
        }else if(resp == 3){
            System.out.println("Digite o nome do local Turistico");
            nome = Console.readString();
            System.out.println("Digite a hora atual: ");
            hora = Console.readInt();
            
            for(PontosTuristicos pt:listaPontos){   
                if(nome.equals(pt.getNome()))
                    pt.ListarPonto("", hora, c);
            }                
            
        }

    }
    
 
}
