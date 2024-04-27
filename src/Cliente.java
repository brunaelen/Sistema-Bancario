/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author Bruna
 */
public class Cliente extends Thread{
    private Conta conta;
    private int id;


    public Cliente(Conta conta, int id) {
        this.conta = conta;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            double valor = Math.random() < 0.5 ? 100 : 200;
            conta.sacar(valor);
            System.out.println("Cliente " + id + " ---> realizou uma compra de R$" + valor);
            if (conta.getSaldo() <= 0) 
                break;
        }
    }
}
