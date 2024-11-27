import java.util.List;

public class PedidoDeCompra {
    private Fornecedor fornecedor;
    private List<Automatuto> listaPecas;

    public PedidoDeCompra(Fornecedor fornecedor, List<Automatuto> listaPecas) {
        this.fornecedor = fornecedor;
        this.listaPecas = listaPecas;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public List<Automatuto> getListaPecas() {
        return listaPecas;
    }

    @Override
    public String toString() {
        StringBuilder pecasNome = new StringBuilder();
        for (Automatuto peca : listaPecas) {
            pecasNome.append(peca.getNome()).append(", ");
        }
        return "Pedido de Compra para " + fornecedor.getNome() + ": " + pecasNome.toString();
    }
}
