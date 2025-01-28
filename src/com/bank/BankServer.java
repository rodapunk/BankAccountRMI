/*
 * Implementação da interface remota e servidor.
 * O UnicastRemoteObject permite que o objeto
 * seja acessível remotamente. Todos os métodos
 * são synchronized para garantir que as operações
 * no saldo da conta sejam seguras para as threads
 * concorrentes.
 */

package com.bank;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class BankServer extends UnicastRemoteObject implements BankAccount {
	private static final long serialVersionUID = 1L;
	private double balance;

    protected BankServer() throws RemoteException {
        super();
        balance = 0.0;
    }

    @Override
    public synchronized void deposit(double amount) throws RemoteException {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New balance: " + balance);
    }

    @Override
    public synchronized void withdraw(double amount) throws RemoteException, InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
        balance -= amount;
        System.out.println("Withdrew: " + amount + ", New balance: " + balance);
    }

    @Override
    public synchronized double getBalance() throws RemoteException {
        return balance;
    }

    public static void main(String[] args) {
        try {
            BankServer account = new BankServer();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("BankAccount", account);
            System.out.println("BankAccount server ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}