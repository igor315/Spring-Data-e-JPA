/**
 * 
 */
package projeto.spring.data.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projeto.spring.data.jpa.model.Telefone;

@Repository
public interface InterfaceTelefone extends CrudRepository<Telefone, Long> {

}
