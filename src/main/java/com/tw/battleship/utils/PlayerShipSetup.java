package com.tw.battleship.utils;

import java.util.Map;

import com.tw.battleship.to.Player;

public interface PlayerShipSetup {
	public Map<String, Character> preparePlayerShips(Player player);
}
