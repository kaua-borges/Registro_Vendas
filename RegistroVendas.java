import java.util.Locale;
import java.util.Scanner;

public class RegistroVendas {

    public static void main(String[] args) {
        // Configura o ponto como separador decimal para o Scanner (ex: 10.50)
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Informe a quantidade de vendas do dia: ");
        int quantidadeVendas = scanner.nextInt();

        if (quantidadeVendas <= 0) {
            System.out.println("Nenhuma venda registrada.");
            scanner.close();
            return;
        }

        double totalVendido = 0.0;
        double maiorVenda = Double.MIN_VALUE;
        double menorVenda = Double.MAX_VALUE;
        int vendasAcima500 = 0;

        // Leitura do valor de cada venda
        for (int i = 1; i <= quantidadeVendas; i++) {
            System.out.printf("Informe o valor da venda %d (R$): ", i);
            double valorVenda = scanner.nextDouble();

            totalVendido += valorVenda;

            if (valorVenda > maiorVenda) {
                maiorVenda = valorVenda;
            }

            if (valorVenda < menorVenda) {
                menorVenda = valorVenda;
            }

            if (valorVenda > 500.0) {
                vendasAcima500++;
            }
        }

        // Cálculos finais
        double mediaVendas = totalVendido / quantidadeVendas;
        double percentualComissao = calcularPercentualComissao(totalVendido);
        double valorComissao = totalVendido * percentualComissao;

        // Exibição dos resultados
        System.out.println("\n----------------------------------------");
        System.out.println("          RESUMO DAS VENDAS DO DIA      ");
        System.out.println("----------------------------------------");
        System.out.printf("Quantidade total de vendas: %d%n", quantidadeVendas);
        System.out.printf("Valor total vendido:        R$ %.2f%n", totalVendido);
        System.out.printf("Maior venda:                R$ %.2f%n", maiorVenda);
        System.out.printf("Menor venda:                R$ %.2f%n", menorVenda);
        System.out.printf("Média por venda:            R$ %.2f%n", mediaVendas);
        System.out.printf("Vendas acima de R$ 500,00:  %d%n", vendasAcima500);
        System.out.println("----------------------------------------");
        System.out.printf("Taxa de comissao aplicada:  %.0f%%%n", percentualComissao * 100);
        System.out.printf("Comissao a receber:         R$ %.2f%n", valorComissao);
        System.out.println("----------------------------------------");

        scanner.close();
    }

    private static double calcularPercentualComissao(double totalVendido) {
        if (totalVendido <= 1000.0) {
            return 0.03; // 3%
        } else if (totalVendido <= 5000.0) {
            return 0.05; // 5%
        } else {
            return 0.08; // 8%
        }
    }
}