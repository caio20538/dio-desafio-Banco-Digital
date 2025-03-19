# 💰 Sistema Bancário em Java

Este é um sistema bancário simples desenvolvido em **Java** utilizando **Programação Orientada a Objetos (POO)**.  
O sistema permite a criação de contas bancárias, depósitos, saques e transferências entre contas.

---

## 📌 Funcionalidades

✅ Criar contas bancárias (**Conta Corrente e Conta Poupança**).  
✅ Associar um **cliente** a uma conta.  
✅ **Depositar** e **sacar** dinheiro da conta.  
✅ **Transferir** dinheiro entre contas.  
✅ **Listar** todas as contas de um banco.  

---

## 🛠 **Tecnologias Utilizadas**

- **Java** (JDK 17+)
- **Paradigma Orientado a Objetos (POO)**
- **Interfaces e Herança**
- **Coleções (List)**

---

## 🏛 **Arquitetura do Sistema**

O sistema é composto por quatro principais entidades:

### 📂 **Banco**
- Gerencia uma lista de contas bancárias.
- Permite adicionar novas contas e listar todas as contas existentes.

### 📂 **Conta (Abstract)**
- Classe base para diferentes tipos de contas.
- Implementa a interface `InterfaceConta`, que define operações bancárias como saque, depósito e transferência.
- Possui atributos comuns: **agência, número da conta, saldo e cliente**.

### 📂 **Conta Corrente (Extende `Conta`)**
- Representa uma conta bancária do tipo corrente.
- Implementa um método específico para imprimir extrato.

### 📂 **Conta Poupança (Extende `Conta`)**
- Representa uma conta bancária do tipo poupança.
- Implementa um método específico para imprimir extrato.

### 📂 **Cliente**
- Representa um cliente do banco.
- Possui um nome e está associado a uma conta.

---

## 📌 **Diagrama UML - Mermaid**

```mermaid
classDiagram
    direction TB

    class Banco {
        - String nome
        - List<Conta> contaList
        + Banco()
        + obterNumeroTotalDeContas()
        + adicionarConta(Conta conta)
        + listarContas()
    }

    class InterfaceConta {
        <<interface>>
        + sacar(double valor)
        + depositar(double valor)
        + transferir(double valor, Conta contaDestino)
        + imprimirExtrato()
    }

    class Conta {
        <<abstract>>
        - int agencia
        - int numero
        - double saldo
        - static final int AGENCIA_PADRAO
        - static int SEQUENCIAL
        - Cliente cliente
        + Conta(Cliente cliente)
        + clienteNome(): String
        + getAgencia(): int
        + getNumero(): int
        + getSaldo(): double
        + sacar(double valor)
        + depositar(double valor)
        + transferir(double valor, Conta contaDestino)
        # imprimirInfosComuns()
    }

    class ContaCorrente {
        + ContaCorrente(Cliente cliente)
        + imprimirExtrato()
    }

    class ContaPoupanca {
        + ContaPoupanca(Cliente cliente)
        + imprimirExtrato()
    }

    class Cliente {
        - String nome
        + Cliente(String nome)
        + getNome(): String
        + setNome(String nome)
    }

    InterfaceConta <|.. Conta
    Conta <|-- ContaCorrente
    Conta <|-- ContaPoupanca
    Cliente "1" --> "1" Conta
    Banco "1" --> "*" Conta
