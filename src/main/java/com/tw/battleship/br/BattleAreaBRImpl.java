package com.tw.battleship.br;

import com.tw.battleship.constants.GlobalConstants;
import com.tw.battleship.to.BattleArea;
import com.tw.battleship.utils.BattleshipException;

public class BattleAreaBRImpl implements BattleAreaBR {

	public void checkBattleDimensions(BattleArea battleArea) throws BattleshipException {
		Integer width = battleArea.getWidthM();
		Character height = battleArea.getHeightN();
		if (width < 1 
				|| width > 9
				|| !Character.isUpperCase(height) 
				|| !Character.isLetter(height))
			throw new BattleshipException(GlobalConstants.EXCEPTION_INVALID_AREA_DIMENSION.getValue());
	}

}
