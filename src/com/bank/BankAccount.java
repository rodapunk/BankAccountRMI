/*
 * Interface remota que declara os métodos
 * que podem ser invocados remotamente.
 */

package com.bank;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BankAccount extends Remote {
    void deposit(double amount) throws RemoteException;
    void withdraw(double amount) throws RemoteException, InsufficientFundsException;
    double getBalance() throws RemoteException;
}