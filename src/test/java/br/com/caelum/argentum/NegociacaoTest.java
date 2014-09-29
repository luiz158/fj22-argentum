package br.com.caelum.argentum;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.argentum.modelo.Negociacao;

public class NegociacaoTest {

	@Test
	public void deveriaRetornarDataDaNegociacaoImutavel() throws Exception {
		Calendar data =  Calendar.getInstance();
		data.set(Calendar.DAY_OF_MONTH, 15);
		
		Negociacao negociacao = new Negociacao(100, 10, data);
		negociacao.getData().set(Calendar.DAY_OF_MONTH, 18);
		
		Assert.assertEquals(15, negociacao.getData().get(Calendar.DAY_OF_MONTH));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula() {
		Negociacao negociacao = new Negociacao(100, 2, null);
		
		Assert.assertNotNull(negociacao.getData());
	}
	
}
