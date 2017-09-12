package com.tw.battleship.to;

public class BattleArea {
	private Integer widthM;
	private Character heightN;

	public BattleArea() {
	}

	public BattleArea(Integer widthM, Character heightN) {
		super();
		this.widthM = widthM;
		this.heightN = heightN;
	}

	public Integer getWidthM() {
		return widthM;
	}

	public void setWidthM(Integer widthM) {
		this.widthM = widthM;
	}

	public Character getHeightN() {
		return heightN;
	}

	public void setHeightN(Character heightN) {
		this.heightN = heightN;
	}
}
