package com.tw.battleship.br;

import com.tw.battleship.to.BattleArea;
import com.tw.battleship.to.BattleShip;
import com.tw.battleship.utils.BattleshipException;

public interface BattleShipBR {

	public void checkTypeOfShip(BattleShip battleShip) throws BattleshipException;

	public void checkBattleShipDimensions(BattleShip battleShip, BattleArea battleArea) throws BattleshipException;

	public void checkCoordinatesOfShip(BattleShip battleShip, BattleArea battleArea) throws BattleshipException;
}
