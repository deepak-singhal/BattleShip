package com.tw.battleship.to;

public class BattleShip {

	private Character type;
	private Integer width;
	private Character height;
	private Integer xCoordinate;
	private Character yCoordinate;

	public BattleShip() {
	}

	public BattleShip(Character type, Integer width, Character height,
			Integer xCoordinate, Character yCoordinate) {
		super();
		this.type = type;
		this.width = width;
		this.height = height;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}

	public Character getType() {
		return type;
	}

	public void setType(Character type) {
		this.type = type;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Character getHeight() {
		return height;
	}

	public void setHeight(Character height) {
		this.height = height;
	}

	public Integer getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(Integer xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public Character getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(Character yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

}
