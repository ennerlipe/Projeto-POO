public class Automatuto {
    private String codigo;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidadeEmEstoque;

    public Automatuto(String codigo, String nome, String descricao, double preco, int quantidadeEmEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public boolean vender(int quantidade) {
        if (quantidade <= quantidadeEmEstoque) {
            quantidadeEmEstoque -= quantidade;
            return true;
        }
        return false;
    }

    public void reporEstoque(int quantidade) {
        quantidadeEmEstoque += quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    @Override
    public String toString() {
        return nome + " (" + codigo + ") - " + quantidadeEmEstoque + " em estoque | Preço: R$ " + preco;
    }
}