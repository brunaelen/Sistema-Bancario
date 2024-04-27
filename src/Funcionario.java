/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author Bruna
 */
public class Funcionario extends Thread{
    private Conta salarioLoja;
    private Conta contaInvestimento;
    private Conta conta;
    private final double salario = 1400;
    private int id;

    public Funcionario(int id,Conta salarioLoja, Conta contaInvestimento) {
        this.id = id;
        this.salarioLoja = salarioLoja;
        this.contaInvestimento = contaInvestimento;
        this.conta = conta;
    }

    @Override
    public void run() {
        salarioLoja.sacar(salario);
        double valorInvestimento = salario * 0.2;
        contaInvestimento.depositar(valorInvestimento);
        System.out.println("Funcionario " + id + " ---> recebeu o salario de R$" + salario +" e investiu R$ " + valorInvestimento);
    }
    
    public synchronized void depositarSalario(double valor) {
        conta.depositar(valor);
    }
}
