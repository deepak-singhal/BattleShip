package com.tw.battleship.constants;

public enum GlobalConstants {
	FILENAME("C:\\Users\\deepak\\Desktop\\battleShip\\src\\InputFile"), 
	
	PLAYER_ONE("Player 1"), 
	PLAYER_TWO("Player 2"), 
	PLAYER_NONE("NOBODY"),
	
	EXCEPTION_INVALID_AREA_DIMENSION ("ERROR : Incorrect Dimensions of Battle Area . . ."),
	EXCEPTION_INVALID_PLAYER_NUMBER_SHIPS ("ERROR : Invalid Number of Ships"),
	EXCEPTION_INVALID_SHIP_DIMENSION ("ERROR : Invalid Dimensions of Ship"),
	EXCEPTION_INVALID_SHIP_TYPE ("ERROR : Incorrect Type of BattleShip mentioned"),
	EXCEPTION_INVALID_SHIP_COORDINATES ("ERROR : Invalid Coordinates given for Ship"), 
	EXCEPTION_INVALID_FILE("ERROR : Input file provided is INVALID");
	

	private final String value;

	GlobalConstants(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
