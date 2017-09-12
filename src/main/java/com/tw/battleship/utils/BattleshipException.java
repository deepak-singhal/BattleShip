package com.tw.battleship.utils;

public class BattleshipException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public BattleshipException(String message){
		super(message);
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
