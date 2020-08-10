package br.com.slotticorp.projetofinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.slotticorp.projetofinal.dao.UsuarioDAO;
import br.com.slotticorp.projetofinal.model.Usuario;

/* criei minha classe RESTController para que ela possa atender URL
 * 
 * Só que essa classe vai acessar bancos de dados
 */
@RestController
public class UsuarioController {
	
	/* injecao de dependência
	 * 
	 * definicao: na prática não sou eu (programador) que faço a instanciação do objeto (eu não dou NEW)
	 * mas delego esta tarefa para a máquina virtual Java
	 * 
	 * Porém eu tenho um agravante aqui: eu não defini nenhuma classe que implementa a interface
	 * UsuarioDAO. A "mágica" é que o próprio SpringBoot cria uma implementação em tempo real
	 * desta interface (na prática o JPA pega a definição do objeto Usuário e cria em tempo
	 * de execução as string SQL que irão inserir/recuperar/alterar etc a tabel)
	 */
	@Autowired
	private UsuarioDAO dao;
	
	@GetMapping("/usuarios")
	public ArrayList<Usuario> getAll(){
		
		ArrayList<Usuario> lista;
		// consultei do banco (único detalhe: o findAll não retorna ArrayList, mas retorna uma interface compatível,
		//                     bastando apenas converter)
		lista = (ArrayList<Usuario>)dao.findAll();
		
		for (Usuario u: lista) {
			u.setSenha("******");
		}
		
		return lista;	
		}
		
		@GetMapping("/usuarios/{id}")
		public ResponseEntity<Usuario> getUsuarioPeloId(@PathVariable int id) {
			Usuario resultado = dao.findById(id).orElse(null);
			if (resultado != null) {
				return ResponseEntity.ok(resultado);
		}
			else {
				return ResponseEntity.status(401).build();
			}
			
		}
}