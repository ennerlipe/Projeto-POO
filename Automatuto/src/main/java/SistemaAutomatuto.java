import com.mycompany.automatuto.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaAutomatuto {
    public static void main(String[] args) {
        // Criando peças
        Automatuto peca1 = new Automatuto("001", "Filtro de Ar", "Filtro de ar para carros modelo X", 50.0, 20);
        Automatuto peca2 = new Automatuto("002", "Bateria", "Bateria automotiva tipo Y", 200.0, 10);
        Automatuto peca3 = new Automatuto("003", "Lanterna", "Lanterna traseira para carro modelo Y", 250.0, 50);

        // Criando o estoque e adicionando as peças
        Estoque estoque = new Estoque();
        estoque.adicionarPeca(peca1);
        estoque.adicionarPeca(peca2);
        estoque.adicionarPeca(peca3);

        // Criando o Scanner para interagir com o cliente
        Scanner scanner = new Scanner(System.in);

        // Menu de opções para cadastro
        System.out.println("Bem-vindo ao Sistema Automatuto!");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Cadastrar Fornecedor");
        System.out.print("Digite a opção desejada: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        if (opcao == 1) {
            // Cadastro de cliente
            System.out.println("Cadastro de Cliente:");
            System.out.print("Digite seu nome: ");
            String nome = scanner.nextLine();

            System.out.print("Digite seu e-mail: ");
            String email = scanner.nextLine();

            System.out.print("Digite seu telefone: ");
            String telefone = scanner.nextLine();

            // Criando o cliente com os dados fornecidos
            Cliente cliente = new Cliente(nome, email, telefone);
            System.out.println("Cliente " + cliente.getNome() + " cadastrado com sucesso!");

            // Mostrando as peças disponíveis para compra
            System.out.println("\nPeças disponíveis:");
            System.out.println("1 - " + peca1.getNome() + " - R$" + peca1.getPreco());
            System.out.println("2 - " + peca2.getNome() + " - R$" + peca2.getPreco());
            System.out.println("3 - " + peca3.getNome() + " - R$" + peca3.getPreco());

            // Perguntando quais peças o cliente deseja comprar
            List<Automatuto> pecasEscolhidas = new ArrayList<>();
            System.out.print("Digite o número da peça que deseja comprar (1, 2 ou 3), ou 0 para finalizar: ");
            int escolha = scanner.nextInt();
            
            while (escolha != 0) {
                if (escolha == 1 && peca1.getQuantidadeEmEstoque() > 0) {
                    pecasEscolhidas.add(peca1);
                    System.out.println(peca1.getNome() + " foi adicionada ao seu carrinho.");
                }else if (escolha == 2 && peca2.getQuantidadeEmEstoque() > 0) {
                    pecasEscolhidas.add(peca2);
                    System.out.println(peca2.getNome() + " foi adicionada ao seu carrinho.");
                }else if (escolha == 3 && peca3.getQuantidadeEmEstoque() > 0) {
                    pecasEscolhidas.add(peca3);
                    System.out.println(peca3.getNome() + " foi adicionada ao seu carrinho.");
                }else {
                    System.out.println("Escolha inválida ou peça fora de estoque.");
                }

                System.out.print("Digite o número da peça que deseja comprar (1, 2 ou 3), ou 0 para finalizar: ");
                escolha = scanner.nextInt();
            }

            // Se o cliente escolheu alguma peça, vamos criar a venda
            if (!pecasEscolhidas.isEmpty()) {
                Venda venda = new Venda(cliente, pecasEscolhidas);
                System.out.println("\nVenda realizada com sucesso!");
                System.out.println(venda);

                // Realizando a venda e atualizando o estoque
                for (Automatuto peca : pecasEscolhidas) {
                    if (peca.vender(1)) {
                        System.out.println(peca.getNome() + " vendida! Novo estoque: " + peca.getQuantidadeEmEstoque());
                    } else {
                        System.out.println("Não há estoque suficiente para vender " + peca.getNome());
                    }
                }
            } else {
                System.out.println("Nenhuma peça foi comprada.");
            }

            // Exibindo o estoque atualizado
            System.out.println("\nEstoque atualizado:");
            estoque.listarPecas();
        } 
        else if (opcao == 2) {
            // Cadastro de fornecedor
            System.out.println("Cadastro de Fornecedor:");
            System.out.print("Digite o nome do fornecedor: ");
            String fornecedorNome = scanner.nextLine();

            System.out.print("Digite o CNPJ do fornecedor: ");
            String fornecedorCnpj = scanner.nextLine();

            System.out.print("Digite o Contato do fornecedor: ");
            String fornecedorEmail = scanner.nextLine();

            // Criando o fornecedor
            Fornecedor fornecedor = new Fornecedor(fornecedorNome, fornecedorCnpj, fornecedorEmail);
            System.out.println("Fornecedor " + fornecedor.getNome() + " cadastrado com sucesso!");

            // Criando um pedido de compra
            PedidoDeCompra pedido = new PedidoDeCompra(fornecedor, new ArrayList<>());
            System.out.println("\nPedido de compra gerado: ");
            System.out.println(pedido);
        } 
        else {
            System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
