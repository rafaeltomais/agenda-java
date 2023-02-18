package agendadinamica;

public class Contato {
    public static int contadorContato = 0;

    private int idContato;
    private String nome;
    private String telefone;
    private String email;

    public Contato(String nome, String telefone, String email) {
        this.setIdContato(contadorContato);
        this.setNome(nome);
        this.setTelefone(telefone);
        this.setEmail(email);
        contadorContato++;
    }

    public int getIdContato() {
        return idContato;
    }

    public void setIdContato(int idContato) {
        this.idContato = idContato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}