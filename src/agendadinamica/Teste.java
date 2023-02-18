package agendadinamica;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) throws AgendaCheiaException {
        Agenda agenda = new Agenda();

        boolean permanecerMenu = true;
        while(permanecerMenu) {
            MenuPrincipal.MostrarMenuPrincipal();
            try{
                Scanner scan = new Scanner(System.in);
                permanecerMenu = MenuPrincipal.ObterOpcaoMenu(scan, agenda);
            }
            catch (Exception error) {
                System.out.println("Entrada inválida!");
            }
        }
    }
}