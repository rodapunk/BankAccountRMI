/*
 * Implementação do cliente e criação de threads para simular acesso
 * remoto concorrente. Embora as threads sejam criadas sequencialmente,
 * elas são executadas concorrentemente, competindo pelos recursos da
 * CPU. Ou seja, a JVM e o sistema operacional determinam quando e em
 * quais núcleos essas threads serão executadas.
 */

package com.bank;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BankClientMultipleLookup {
    public static void main(String[] args) {
        try {
            // Cria e inicia múltiplos threads para simular acesso concorrente
            int numThreads = 5;
            
            for (int i = 0; i < numThreads; i++) {
                new Thread(() -> {
                    try {
                    	// Cada thread faz seu próprio lookup
                        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
                        BankAccount account = (BankAccount) registry.lookup("BankAccount");
                    	
                        // Cada thread realiza operações concorrentes no servidor
                        for (int j = 0; j < 3; j++) {
                            account.deposit(100.0); // Simula depósito de 100.0
                            account.withdraw(50.0); // Simula retirada de 50.0
                            Thread.sleep(1000); 	// Aguarda um segundo entre as operações
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}