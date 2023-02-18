package agendadinamica;

public class AgendaCheiaException extends Exception {

    public AgendaCheiaException() {
    }

    @Override
    public String getMessage() {
        return "Agenda já está cheia.";
    }
}