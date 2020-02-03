package com.mongdb.mongodbTest.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mongdb.mongodbTest.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	List<Post> findByTitleContaining(String text);
	
	//Esse é um método personalizado e posso dar o nome que eu quiser: https://docs.mongodb.com/manual/reference/operator/query/regex/
	//Essa éa notação e o Json que devo passar: @Query("{ <field>: { $regex: /pattern/, $options: '<options>' } }")
	/* a) <field> = Campo que quero consultar
	   b) /pattern/ = aponto para os parâmetros que estão vindo na assinatura do método: se for o 1° coloco ?0, 2° coloco ?1 e assim por diante
	   c) '<options>' = olhar a tabela no link acima, mas o 'i' terá comportamento de case INsensitive  */
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> serarchTitle(String text);
	
	List<Post> fullSearchPost(String text, Date minDate, Date maxDate);
	
}
