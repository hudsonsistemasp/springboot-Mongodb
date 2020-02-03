package com.mongdb.mongodbTest.resource.util;

import java.io.UnsupportedEncodingException;	
import java.net.URLDecoder;

public class URL {
	
	//Colocar como static para não precisar instanciar do tipo da classe
	public static String decodeParam(String text) {
		try {
			/*endpoint= http://localhost:8080/posts/titlesearch/text=bom dia - Mas esse espaço da frase tem que ser encodado 
			  pra nao dar erro nos caracteres especiais, ex: "bom dia" = "Bom%20dia". Para isso essa classe UTIL irá encodar 
			  o que vem da variável "text". Ex da função do JavaScript que faz isso: encodeURIComponent("Bom dia"); */
			return URLDecoder.decode(text, "UTF-8"); 
		} catch (UnsupportedEncodingException e) {
			return "Sem decodifciação do parâmetro que veio da URI";
		}
		
	}
}
