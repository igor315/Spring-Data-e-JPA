package projeto.spring.data.jpa.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projeto.spring.data.jpa.model.UsuarioSpringData;

@Repository
public interface InterfaceSpringDataUser extends CrudRepository<UsuarioSpringData, Long> {

	/*Aqui o metodo retorna onde conter o nome passado no parametro */
	@Transactional(readOnly = true)//readOnly true faz com que esse metodo seja apenas de leitura e nunca efetue uma alteracao no banco de dados
	@Query(value = "select p from UsuarioSpringData p where p.nome like %?1%")
	public List<UsuarioSpringData> buscaPorNome(String nome);

	
	/*Aqui tem que ser examatamente igual o nome passado no parametro*/
	@Transactional(readOnly = true)//readOnly true faz com que esse metodo seja apenas de leitura e nunca efetue uma alteracao no banco de dados
	@Query(value = "select p from UsuarioSpringData p where p.nome = :paranome")
	public UsuarioSpringData buscaPorNomeParam(@Param("paranome") String paranome);
	
	
	/*O metodo delete precisa dessas tres anotacoes para funcionar caso contrario dara erro*/
	@Modifying
	@Transactional
	@Query(value = "delete from UsuarioSpringData u where u.nome = ?1")
	public void deletePorNome(String nome);
	
	
	@Modifying
	@Transactional
	@Query(value = "update UsuarioSpringData u set u.email = ?1 where u.nome = ?2")
	public void updateEmailPorNome(String email, String nome);

}
