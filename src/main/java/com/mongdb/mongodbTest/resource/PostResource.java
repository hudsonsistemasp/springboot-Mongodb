package com.mongdb.mongodbTest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongdb.mongodbTest.domain.Post;
import com.mongdb.mongodbTest.resource.util.URL;
import com.mongdb.mongodbTest.service.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService postService;
	
	/*@PathVariable= O formato da requisição fica com uma variável de URL: endpoint= http://localhost:8080/posts/titlesearch/bom dia  */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = postService.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	/*endpoint= http://localhost:8080/posts/titlesearch?text=bom dia - Mas esse espaço da frase tem que ser encodado 
	  pra nao dar erro de caracteres especiais, ex: "bom dia" = "Bom%20dia". Para isso criar a classe UTIL para encodar essa.
	  A notação @RequestParam= nos faz mudar a sintaxe para a requisição e final fica assim:
	   endpoint= http://localhost:8080/posts/titlesearch?text=bom%20dia - 
	   a variável "text" está sendo referida no "value=" abaixo e se nada for informado adotará o "default" */ 
	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text ){
		text = URL.decodeParam(text);/*1° decodificar o texto para não ir caracter especial, espaços e etc causam erro na consulta do endpoint*/
		List<Post> list = postService.serchTitleByRegexCaseInsentive(text);
		return ResponseEntity.ok().body(list);
	}

}
