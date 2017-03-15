package br.usjt.arqdesis.projetoppint.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.usjt.arqdesis.projetoppint.model.Usuarios;
import br.usjt.arqdesis.projetoppint.service.UsuariosService;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class UsuariosTest {

	Usuarios usuario, copia;
	UsuariosService usuariosService;
	static int id = 0;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. 
	 * Certifique-se também que sobrecarregou o equals na classe
	 * Cliente. 
	 * Certifique-se que a fixture cliente1 foi criada no banco.
	 * Além disso, a ordem de execução dos testes é importante; por
	 * isso a anotação FixMethodOrder logo acima do nome desta classe
	 */
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		usuario = new Usuarios();
		usuario.setId(id);
		usuario.setNome("Renan");
		usuario.setSobrenome("Dantas");
		usuario.setCpf("0");
		copia = new Usuarios();
		copia.setId(id);
		copia.setNome("Renan");
		copia.setSobrenome("Dantas");
		copia.setCpf("0");
		usuariosService = new UsuariosService();
		System.out.println(usuario);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Consultar() {
		System.out.println("Consultar");	
		Usuarios fixture = new Usuarios();
		fixture.setId(1);
		fixture.setNome("Renan");
		fixture.setSobrenome("Dantas");
		fixture.setCpf("0");
		UsuariosService novoService = new UsuariosService();
		Usuarios novo = novoService.consultar(1);
		assertEquals("testa Consultar", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("Criar");
		id = usuariosService.criar(usuario);
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", usuario, copia);
	}

	@Test
	public void test02Alterar() {
		System.out.println("Alterar");
		usuario.setCpf("1111111111");
		copia.setCpf("1111111111");	
		usuariosService.alterar(usuario);
		usuario = usuariosService.consultar(usuario.getId());
		assertEquals("testa alteracao", usuario, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("Excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setSobrenome(null);
		copia.setCpf(null);
		usuariosService.excluir(id);
		usuario = usuariosService.consultar(id);
		assertEquals("testa exclusao", usuario, copia);
	}
}
