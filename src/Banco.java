/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Bruna
 */
public class Banco {
        private static Lock lock = new ReentrantLock();
        
        public static void main(String[] args) {
        Conta contaBanco = new Conta(0);
        Conta contaLoja1 = new Conta(0);
        Conta contaLoja2 = new Conta(0);
        Conta contaInvestimento1 = new Conta(0);
        Conta contaInvestimento2 = new Conta(0);
        
        Cliente[] clientes = new Cliente[5];
        for (int i = 0; i < 5; i++) {
            int id;
            clientes[i] = new Cliente(new Conta(1000), id = i + 1);
            clientes[i].start();
        }

        Funcionario funcionario1 = new Funcionario(1,contaLoja1, contaInvestimento1);
        Funcionario funcionario2 = new Funcionario(2,contaLoja1, contaInvestimento1);
        Funcionario funcionario3 = new Funcionario(3,contaLoja2, contaInvestimento2);
        Funcionario funcionario4 = new Funcionario(4,contaLoja2, contaInvestimento2);

        funcionario1.start();
        funcionario2.start();
        funcionario3.start();
        funcionario4.start();

        }
        
       /*public static void exibirCliente(String mensagem) {
            lock.lock();
            try {
                System.out.println(mensagem);
            } finally {
                lock.unlock();
            }
        }
        
        public static void exibirFuncionario(String mensagem) {
            lock.lock();
            try {
                System.out.println(mensagem);
            }finally {
                lock.unlock();
            }    
        }*/
        
        public static void transferir(Conta origem, Conta destino, double valor) {
            origem.sacar(valor);
            destino.depositar(valor);
            System.out.println("Transferencia de R$ "+ valor + "realizada");
        }
}

