package com.tw.battleship.utils;

import java.util.HashMap;
import java.util.Map;

import com.tw.battleship.to.BattleShip;
import com.tw.battleship.to.Player;

public class PlayerShipSetupImpl implements PlayerShipSetup {
	public Map<String, Character> preparePlayerShips(Player player) {
		HashMap<String, Character> playerShipsMap = new HashMap<String, Character>();

		for (BattleShip battleShip : player.getBattleships()) {
			Integer xCoordinate = battleShip.getxCoordinate();
			Character yCoordinate = battleShip.getyCoordinate();

			Integer width = battleShip.getWidth();
			Integer height = (battleShip.getHeight() - 64);

			int i = 0;
			int j = 0;
			for (i = xCoordinate; i < xCoordinate + width; i++) {
				for (j = yCoordinate; j < yCoordinate + height; j++) {
					playerShipsMap.put((char) j + "" + i, battleShip.getType());
				}
				j--;
				playerShipsMap.put((char) j + "" + i, battleShip.getType());
			}
		}

		return playerShipsMap;
	}
}
