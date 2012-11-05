package com.softlogia.framework.model.exception;
/**
 * 
 * @author Pablo Marquez
 *
 */
public class CreateException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	@Override
	public void printStackTrace(){
		
	}

    public CreateException(Throwable cause) {
        super(cause.getMessage(), cause);
    }
    
    public CreateException(IllegalStateException e) {
        super(e);
    }

    public CreateException(String message, Exception ex) {
        super(message, ex);
    }

    public CreateException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateException(String message) {
        super(message);
    }

	public CreateException(){
		
	}
    
}
