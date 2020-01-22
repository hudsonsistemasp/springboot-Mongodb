package com.mongdb.mongodbTest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongdb.mongodbTest.domain.User;
import com.mongdb.mongodbTest.dto.UserDTO;
import com.mongdb.mongodbTest.repository.UserRepository;
import com.mongdb.mongodbTest.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		List<User> user = userRepository.findAll();
		return user;
	}
	
	public User findById(String id) {
		Optional<User> objUser = userRepository.findById(id);
		return objUser.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
	}
	
	public User insert(User user) {
		return userRepository.insert(user);
	}
	
	public void delete(String id) {
		findById(id); //Usar o método acima, pois assim se não encontrar o id, já gera a exceção pra gente
		userRepository.deleteById(id);
	}
	
	
	/*Fez a implementação do DTO aqui, por que essa classe já acesso banco de dados direto e fica mais estratégico usar na Resource.
	 Mas é correto desenhar na classe DTO também, tudo vai da estratégia momentâena.*/
	
	public User fromDTO(UserDTO objUserDTO) {
		System.out.println(objUserDTO.getId() + " " + objUserDTO.getName() + " " + objUserDTO.getEmail());
		return new User(objUserDTO.getId(),objUserDTO.getName(),objUserDTO.getEmail(),"password Padrao");
	}
	
}
