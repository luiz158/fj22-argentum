package br.com.caelum.argentum.testes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negociacao;

public class TestaCandlestickFactoryComAberturaIgualFechamento {

	public static void main(String[] args) {
		Calendar dataDeHoje = Calendar.getInstance();
		
		List<Negociacao> negociacoes = new ArrayList<>();
		negociacoes.add(new Negociacao(100, 2, dataDeHoje));
		negociacoes.add(new Negociacao(100, 3, dataDeHoje));
		
		Candlestick candlestick = new CandlestickFactory().controisCandleParaData(dataDeHoje, negociacoes);
		
		System.out.println(candlestick);
	}
}
