package com.tw.battleship.br;

import com.tw.battleship.to.BattleArea;
import com.tw.battleship.to.Player;
import com.tw.battleship.utils.BattleshipException;

public interface PlayerBR {

	public void checkNumberOfShips(Player player, BattleArea battleArea) throws BattleshipException;
}
