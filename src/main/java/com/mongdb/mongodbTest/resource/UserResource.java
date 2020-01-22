package com.mongdb.mongodbTest.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mongdb.mongodbTest.domain.User;
import com.mongdb.mongodbTest.dto.UserDTO;
import com.mongdb.mongodbTest.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService userService;

	// @RequestMapping //Funciona a mesma coisa que abaixo
	@RequestMapping(method = RequestMethod.GET) // Isso diz que esse endpoint vai ser um método no caminho citado
												// acima:"/users"
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = userService.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User user = userService.findById(id);
		UserDTO userDTO = new UserDTO(user);
		return ResponseEntity.ok().body(userDTO);
	}
	
	//@PostMapping - funciona como abaixo
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insertUser(@RequestBody UserDTO userDTO){
		User objUser = userService.fromDTO(userDTO);
		User obj = userService.insert(objUser);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();//Traz todo o cabeçalho contendo a localização do novo recurso criado
		return ResponseEntity.created(uri).build();//created retorna o codigo 201
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		userService.delete(id);
		//cod. 204 = Quando se faz uma operação e não precisa trazer uma resposta
		return ResponseEntity.noContent().build();
	}
}
