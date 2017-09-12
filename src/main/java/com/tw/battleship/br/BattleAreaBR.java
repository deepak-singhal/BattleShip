package com.tw.battleship.br;

import com.tw.battleship.to.BattleArea;
import com.tw.battleship.utils.BattleshipException;

public interface BattleAreaBR {

	public void checkBattleDimensions(BattleArea battleArea) throws BattleshipException;

}
