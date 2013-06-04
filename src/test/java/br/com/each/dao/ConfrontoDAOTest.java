package br.com.each.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.each.infra.PayloadUFCBD;

public class ConfrontoDAOTest {

	@Test
	public void testaMetodoListaConfrontos() {
		assertEquals("Nao trouxe todos os confrontos", 4, new ConfrontoDAO().lista().size());
	}

	@Test
	public void testaMetodoListaConfrontosAbertos() {
		assertEquals("Nao trouxe confrontos abertos", 1, new ConfrontoDAO().abertos().size());
	}

	@Test
	public void testaMetodoListaConfrontosFechado() {
		assertTrue("Nao ha confrontos Fechados, a lista deveria estar vazia", new ConfrontoDAO().fechados().isEmpty());
	}

	@Test
	public void testaMetodoListaConfrontosFinalizados() {
		assertEquals("Nao trouxe os confronto finalizados", 3, new ConfrontoDAO().finalizados().size());
	}

	@Before
	public void setUp() {
		PayloadUFCBD payloadUFCBD = new PayloadUFCBD();
		payloadUFCBD.criaConexao();
		payloadUFCBD.populaBanco();
	}

}
