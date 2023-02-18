package agendadinamica;

public class Agenda {
    Contato[] contatos = new Contato[2];
    private boolean agendaCheia;

    public Agenda() {
        this.agendaCheia = false;
    }

    @Override
    public String toString() {
        String s = "";
        for (Contato contato : contatos) {
            s += "[Id: " + contato.getIdContato() +
                    ", Nome: " + contato.getNome() +
                    ", Telefone: " + contato.getTelefone() +
                    ", Email: " + contato.getEmail() +
                    "]\n";
        }
        return "Agenda{" + s +
                '}';
    }

    public boolean isAgendaCheia() {
        return agendaCheia;
    }

    public void setAgendaCheia(boolean agendaCheia) {
        this.agendaCheia = agendaCheia;
    }

    public boolean adicionarContato(Contato contato) throws AgendaCheiaException {
        for(int i = 0; i < contatos.length; i++) {
            if (contatos[i] == null) {
                contatos[i] = contato;
                this.setAgendaCheia((contatos.length - 1) == i);
                System.out.println(contato.getNome() + " adicionado à agenda.");
                return true;
            }
        }
        if(this.isAgendaCheia()) {
            throw new AgendaCheiaException();
        }
        return false;
    }

    public boolean consultarContato(String nome) throws ContatoNaoExisteException {
        for (int i = 0; i < contatos.length; i++) {
            if(contatos[i] != null) {
                if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                    System.out.println("Contato de nome " + nome + " já existe na agenda.");
                    return true;
                }
            }
        }
        throw new ContatoNaoExisteException(nome);
    }
}