package agendadinamica;

import java.util.Scanner;

public class MenuPrincipal {

    public static void MostrarMenuPrincipal() {
        System.out.println("==========AGENDA DE CONTATOS==========");
        System.out.println("Menu principal:\n1- Adicionar contato\n2- Pesquisar contato\n3- Sair");
        System.out.println("======================================");
    }

    public static boolean ObterOpcaoMenu(Scanner scan, Agenda agenda) {
        int opcao = Integer.parseInt(scan.nextLine());
        if(opcao == 1) {
            if(!agenda.isAgendaCheia()) {
                String nomeContato = leInformacao(scan, "Insira nome para cadastro: ");
                String telefoneContato = leInformacao(scan, "Insira telefone do contato: ");
                String emailContato = leInformacao(scan, "Insira email do contato: ");

                Contato contato = new Contato(nomeContato, telefoneContato, emailContato);

                try {
                    agenda.adicionarContato(contato);
                } catch (AgendaCheiaException error) {
                    System.out.println(error.getMessage());
                }
            }
            else {
                System.out.println("Agenda já está lotada.");
                System.out.println("Contatos na agenda: \n" + agenda);
            }
        }
        else if(opcao == 2) {
            String nomeContato = leInformacao(scan, "Insira nome a ser pesquisado na agenda:");
            try {
                agenda.consultarContato(nomeContato);
            } catch (ContatoNaoExisteException error) {
                System.out.println(error.getMessage());
            }
        }
        else if(opcao == 3){
            System.out.println("Saindo do sistema...");
            System.exit(0);
        }
        else {
            System.out.println("Opção inválida!");
        }
        return true;
    }

    public static String leInformacao(Scanner scan, String msg) {
        System.out.println(msg);
        String s = scan.nextLine();
        return s;
    }
}