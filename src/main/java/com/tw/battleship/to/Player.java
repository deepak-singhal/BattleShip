package com.tw.battleship.to;

import java.util.List;

public class Player {
	private Integer id;
	private BattleArea battleArea;
	private Integer numberOfShips;
	private List<BattleShip> battleships;
	private List<String> missileSequence;

	public Player() {}

	public Player(Integer id, BattleArea battleArea, Integer numberOfShips,
			List<BattleShip> battleships, List<String> missileSequence) {
		super();
		this.id = id;
		this.battleArea = battleArea;
		this.numberOfShips = numberOfShips;
		this.battleships = battleships;
		this.missileSequence = missileSequence;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BattleArea getBattleArea() {
		return battleArea;
	}

	public void setBattleArea(BattleArea battleArea) {
		this.battleArea = battleArea;
	}

	public Integer getNumberOfShips() {
		return numberOfShips;
	}

	public void setNumberOfShips(Integer numberOfShips) {
		this.numberOfShips = numberOfShips;
	}

	public List<BattleShip> getBattleships() {
		return battleships;
	}

	public void setBattleships(List<BattleShip> battleships) {
		this.battleships = battleships;
	}

	public List<String> getMissileSequence() {
		return missileSequence;
	}

	public void setMissileSequence(List<String> missileSequence) {
		this.missileSequence = missileSequence;
	}
}
