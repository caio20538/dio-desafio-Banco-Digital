import Banco.Banco;
import Banco.Conta;
import Banco.ContaCorrente;
import Banco.ContaPoupanca;
import Cliente.Cliente;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNome("Caio");

        Conta cc = new ContaCorrente(cliente);
        Conta cp = new ContaPoupanca(cliente);

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Carlos");

        Conta cc2 = new ContaCorrente(cliente2);
        Conta cp2 = new ContaPoupanca(cliente2);

        cc.depositar(200);
        cp.imprimirExtrato();
        cc.imprimirExtrato();

        System.out.println();
        System.out.println();

        cc.transferir(100, cp);
        cp.imprimirExtrato();
        cc.imprimirExtrato();

        System.out.println();
        System.out.println();

        Banco banco = new Banco();

        banco.adicionarConta(cc);
        banco.adicionarConta(cc2);
        banco.adicionarConta(cc2);

        banco.listarContas();
        banco.obterNumeroTotalDeContas();
        banco.pesquisarContaCorrentePorNome("Caio");
    }
}
