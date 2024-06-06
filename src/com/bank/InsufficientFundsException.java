/*
 * Exceção personalizada para representar
 * uma situação de fundos insuficientes.
 */

package com.bank;

public class InsufficientFundsException extends Exception {
	private static final long serialVersionUID = 1L;

	public InsufficientFundsException(String message) {
        super(message);
    }
}