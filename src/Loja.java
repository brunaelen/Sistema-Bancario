/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author Bruna
 */
public class Loja {
    private Conta conta;

    public Loja(Conta conta) {
        this.conta = conta;
    }

    public void pagarFuncionario(Conta contaFuncionario) {
        double saldoLoja = conta.getSaldo();
        if (saldoLoja >= 1400) {
            conta.sacar(1400);
            contaFuncionario.depositar(1400);
            System.out.println("Loja pagou um funcionario");
        } else {
            System.out.println("Saldo insuficiente na loja para pagar o funcionário");
        }
    }
}
