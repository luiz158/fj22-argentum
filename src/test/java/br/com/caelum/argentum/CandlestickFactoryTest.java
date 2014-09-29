package br.com.caelum.argentum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negociacao;

public class CandlestickFactoryTest {

	@Test
	public void sequenciaSimplesDeNegociacoes() throws Exception {
		Calendar hoje = Calendar.getInstance();
		
		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
		Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2,
				negociacao3, negociacao4);
		
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
		
		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(42.3, candle.getFechamento(), 0.00001);
		Assert.assertEquals(39.8, candle.getMinimo(), 0.00001);
		Assert.assertEquals(45.0, candle.getMaximo(), 0.00001);
		Assert.assertEquals(16760.0, candle.getVolume(), 0.00001);
	}
	
	@Test
	public void semNegociacoesGeraCandleComZeros() throws Exception {
		Calendar hoje = Calendar.getInstance();
		
		List<Negociacao> negociacoes = new ArrayList<>();
		
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candlestick = fabrica.constroiCandleParaData(hoje, negociacoes);
		
		Assert.assertEquals(0.0, candlestick.getVolume(), 0);
	}

	@Test
	public void apenasUmaNegociacaoGeraCandleComValoresIguais() {
		Calendar hoje = Calendar.getInstance();
		
		List<Negociacao> negociacoes = new ArrayList<>();
		negociacoes.add(new Negociacao(100, 2, hoje));
		
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candlestick = fabrica.constroiCandleParaData(hoje, negociacoes);
		
		Assert.assertEquals(100.0, candlestick.getAbertura(), 0);
		Assert.assertEquals(100.0, candlestick.getFechamento(), 0);
		Assert.assertEquals(100.0, candlestick.getMinimo(), 0);
		Assert.assertEquals(100.0, candlestick.getMaximo(), 0);
		Assert.assertEquals(200.0, candlestick.getVolume(), 0);
	}
}
