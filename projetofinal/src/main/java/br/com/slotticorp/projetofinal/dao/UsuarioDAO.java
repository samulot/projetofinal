package br.com.slotticorp.projetofinal.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.slotticorp.projetofinal.model.Usuario;


/* apenas o fato de eu fazer esse extends, a interface já me "presenteia" com uma
 *  série de métodos pré-fabricados, dentre eles
 *  
 *  save           - para gravar / Atualizar Objetos
 *  deleteById(id) - para excluir objetos
 *  findById(id)   - para encontrar um determinado objeto pelo seu ID
 *  findAll        - para retornar TODOS os objetos da tabela
 *  count          - para saber quantos registros tem na base
 */

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {

}
