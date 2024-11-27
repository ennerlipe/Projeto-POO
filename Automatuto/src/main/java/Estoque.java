import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private Map<String, Automatuto> pecas;

    public Estoque() {
        this.pecas = new HashMap<>();
    }

    public void adicionarPeca(Automatuto peca) {
        pecas.put(peca.getCodigo(), peca);
    }

    public Automatuto buscarPeca(String codigo) {
        return pecas.get(codigo);
    }

    public void listarPecas() {
        for (Automatuto peca : pecas.values()) {
            System.out.println(peca);
        }
    }
}