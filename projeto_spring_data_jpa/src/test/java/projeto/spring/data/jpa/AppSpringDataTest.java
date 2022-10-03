package projeto.spring.data.jpa;

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
		
		/*Insancia um novo usuario e seta os dados*/
		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
		usuarioSpringData.setEmail("Alexsotwaredeveloper@.com");
		usuarioSpringData.setLogin("developer 123");
		usuarioSpringData.setSenha("321");
		usuarioSpringData.setNome("Alex Fernando");
		
		/*Salvamos todos os dados*/
		interfaceSpringDataUser.save(usuarioSpringData);
		
		
		/*Conta quantos usuarios estão cadastrados no banco*/
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

}