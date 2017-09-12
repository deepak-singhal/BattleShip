package com.tw.battleship.br;

import com.tw.battleship.constants.GlobalConstants;
import com.tw.battleship.to.BattleArea;
import com.tw.battleship.to.Player;
import com.tw.battleship.utils.BattleshipException;

public class PlayerBRImpl implements PlayerBR {

	public void checkNumberOfShips(Player player, BattleArea battleArea) throws BattleshipException {
		Integer numberOfShips = player.getNumberOfShips();
		Integer widthBoard = battleArea.getWidthM();
		Character heightBoard = battleArea.getHeightN();
		Integer area = widthBoard * (heightBoard - 64);

		if (numberOfShips < 1 || numberOfShips > area) {
			throw new BattleshipException(GlobalConstants.EXCEPTION_INVALID_PLAYER_NUMBER_SHIPS.getValue());
		}
	}
}
