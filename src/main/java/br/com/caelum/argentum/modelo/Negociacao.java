package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public class Negociacao {

	private final double preco;
	
	private final int quantidade;
	
	private final Calendar data;

	public Negociacao(double preco, int quantidade, Calendar data) {
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	public double getVolume() {
		return this.quantidade * this.preco;
	}
	
	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		return data;
	}

}
