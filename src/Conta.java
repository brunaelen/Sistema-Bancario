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
public class Conta {
    private double saldo;
    private final Lock lock = new ReentrantLock();

    public Conta(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        lock.lock();
        try {
            saldo += valor;
        } finally {
            lock.unlock();
        }
    }

    public void sacar(double valor) {
        lock.lock();
        try {
            if (saldo >= valor) {
                saldo -= valor;
            } else {
                System.out.println("O saldo na conta e insuficiente para o pagamento de salario!");
            }
        } finally {
            lock.unlock();
        }
    }

    public double getSaldo() {
        return saldo;
    }
}

