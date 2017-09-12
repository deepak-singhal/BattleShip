package com.tw.battleship.utils;

import com.tw.battleship.to.BattleArea;
import com.tw.battleship.to.BattleShip;
import com.tw.battleship.to.Player;

public interface BattleShipUtils {

	public void buildTO(BattleArea battleArea, Player player1, Player player2);

	public void buildBattleAreaTO(BattleArea battleArea, String battleAreaDimensions);

	public void validateBattleArea(BattleArea battleArea) throws BattleshipException;

	public void validatePlayer(Player player, BattleArea battleArea) throws BattleshipException;

	public void validateBattleShip(BattleShip battleShip, BattleArea battleArea) throws BattleshipException;

}
