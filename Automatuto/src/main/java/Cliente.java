public class Cliente {
    private String nome;
    private String email;
    private String telefone;

    public Cliente(String nome, String email1, String email) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return nome + " - " + telefone;
    }
}