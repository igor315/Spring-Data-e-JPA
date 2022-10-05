package projeto.spring.data.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import projeto.spring.data.jpa.model.UsuarioSpringData;

@Repository
public interface InterfaceSpringDataUser extends CrudRepository<UsuarioSpringData, Long> {

	/*Aqui o metodo retorna onde conter o nome passado no parametro */
	@Query(value = "select p from UsuarioSpringData p where p.nome like %?1%")
	public List<UsuarioSpringData> buscaPorNome(String nome);

	/*Aqui tem que ser examatamente igual o nome passado no parametro*/
	@Query(value = "select p from UsuarioSpringData p where p.nome = :paranome")
	public UsuarioSpringData buscaPorNomeParam(@Param("paranome") String paranome);

}
