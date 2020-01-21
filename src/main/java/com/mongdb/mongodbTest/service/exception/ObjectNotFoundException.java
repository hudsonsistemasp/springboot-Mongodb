package com.mongdb.mongodbTest.service.exception;
/*RuntimeException = O  compilador NÃO exige que eu a trate.  
  Exception = O compilador EXIGE que eu a trate. */

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String message) {
		super(message);
	}
	
}
