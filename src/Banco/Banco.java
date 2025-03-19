package Banco;

import Cliente.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contaList;

    public Banco() {
        this.contaList = new ArrayList<>();
    }

    public void obterNumeroTotalDeContas(){
        System.out.println("numero total de contas " + contaList.size());
    }

    public void adicionarConta(Conta conta) {
        contaList.add(conta);
    }

    public void listarContas() {
        for (Conta conta : contaList) {
            System.out.println(conta);
        }
    }

    public void pesquisarContaCorrentePorNome(String nome){
        List<Conta> pesquisarConta = contaList;
//        if (contaList.isEmpty()){
//            System.out.println("Não há nenhuma conta no sistema");
//        } else {
//            for (Conta c : contaList){
//                if (c.clienteNome().equalsIgnoreCase(nome)){
//                    pesquisarConta.add(c);
//                }
//            }
//        }
//        return pesquisarConta;

        pesquisarConta.stream()
                .filter(conta -> conta.clienteNome().equalsIgnoreCase(nome))
                .forEach(System.out::println);
    }


}
