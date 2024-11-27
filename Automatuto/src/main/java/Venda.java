import com.mycompany.automatuto.Cliente;
import java.util.List;

public class Venda {
    private Cliente cliente;
    private List<Automatuto> listaPecas;
    private double total;

    public Venda(Cliente cliente, List<Automatuto> listaPecas) {
        this.cliente = cliente;
        this.listaPecas = listaPecas;
        this.total = calcularTotal();
    }

    private double calcularTotal() {
        double total = 0.0;
        for (Automatuto peca : listaPecas) {
            total += peca.getPreco();
        }
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Automatuto> getListaPecas() {
        return listaPecas;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        StringBuilder pecasNome = new StringBuilder();
        for (Automatuto peca : listaPecas) {
            pecasNome.append(peca.getNome()).append(", ");
        }
        return "Venda para " + cliente.getNome() + ": " + pecasNome.toString() + " | Total: R$ " + total;
    }
}
