package com.tan.chicken.exception;

public class ChickenNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChickenNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public ChickenNotFoundException(String arg0) {
		super(arg0);
		System.out.println("Chicken is not found with "+arg0);
	}

	public ChickenNotFoundException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ChickenNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public ChickenNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
