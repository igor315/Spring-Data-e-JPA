package projeto.spring.data.jpa;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.jpa.dao.InterfaceSpringDataUser;
import projeto.spring.data.jpa.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring-config.xml" })
public class AppSpringDataTest {

	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;

	@Test
	public void testeInsert() {

		/* Insancia um novo usuario e seta os dados */
		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
		usuarioSpringData.setEmail("Alexalexsotwaredeveloper@.com");
		usuarioSpringData.setLogin("developer 123");
		usuarioSpringData.setSenha("321");
		usuarioSpringData.setNome("Alex alex alex");

		/* Salvamos todos os dados */
		interfaceSpringDataUser.save(usuarioSpringData);

		/* Conta quantos usuarios estão cadastrados no banco */
		System.out.println("Usuarios Cadastrados " + interfaceSpringDataUser.count());
	}

	@Test
	public void testeConsulta() {

		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(3L);

		System.out.println(usuarioSpringData.get().getId());
		System.out.println(usuarioSpringData.get().getEmail());
		System.out.println(usuarioSpringData.get().getNome());
		System.out.println(usuarioSpringData.get().getLogin());
		System.out.println(usuarioSpringData.get().getSenha());
	}

	@Test
	public void testeConsultaTodos() {

		Iterable<UsuarioSpringData> listausuarios = interfaceSpringDataUser.findAll();

		for (UsuarioSpringData usuarioSpringData : listausuarios) {

			System.out.println(usuarioSpringData.getId());
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getSenha());
		}
	}

	@Test
	public void testeUpdate() {

		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(3L);

		UsuarioSpringData data = usuarioSpringData.get();
		data.setSenha("@martins257");

		interfaceSpringDataUser.save(data);
	}

	@Test
	public void testeDelete() {

		/* pode passar diretamente pelo o id */
		/* interfaceSpringDataUser.deleteById(7L); */

		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(4L);
		interfaceSpringDataUser.delete(usuarioSpringData.get());
	}

	@Test
	public void testeConsultaNome() {

		List<UsuarioSpringData> list = interfaceSpringDataUser.buscaPorNome("Igor");

		for (UsuarioSpringData usuarioSpringData : list) {

			System.out.println(usuarioSpringData.getId());
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getSenha());
		}

	}

	@Test
	public void testeConsultaNomeParam() {
		
		/*A busca tem que ser exatamente igual como esta no banco de dados*/
		UsuarioSpringData usuarioSpringData = interfaceSpringDataUser.buscaPorNomeParam("Joao Gomes");

		System.out.println(usuarioSpringData.getId());
		System.out.println(usuarioSpringData.getEmail());
		System.out.println(usuarioSpringData.getNome());
		System.out.println(usuarioSpringData.getLogin());
		System.out.println(usuarioSpringData.getSenha());

	}
	
	@Test
	public void testeDeletePorNome() {
		
		interfaceSpringDataUser.deletePorNome("Alex alex alex");
		
	}

}
