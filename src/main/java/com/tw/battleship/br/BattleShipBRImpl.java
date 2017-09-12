package com.tw.battleship.br;

import com.tw.battleship.constants.GlobalConstants;
import com.tw.battleship.to.BattleArea;
import com.tw.battleship.to.BattleShip;
import com.tw.battleship.utils.BattleshipException;

public class BattleShipBRImpl implements BattleShipBR {

	public void checkTypeOfShip(BattleShip battleShip) throws BattleshipException {
		if (battleShip.getType() != 'P' && battleShip.getType() != 'Q') {
			throw new BattleshipException(GlobalConstants.EXCEPTION_INVALID_SHIP_TYPE.getValue());
		}
	}

	public void checkBattleShipDimensions(BattleShip battleShip, BattleArea battleArea) throws BattleshipException {
		Integer battleshipWidth = battleShip.getWidth();
		Character battleshipHeight = battleShip.getHeight();

		Integer battleareaWidth = battleArea.getWidthM();
		Character battleareaHeight = battleArea.getHeightN();

		if ((battleshipWidth < 1 || battleshipWidth > battleareaWidth)
				|| (battleshipHeight < 'A' || battleshipHeight > battleareaHeight)
				|| (battleShip.getxCoordinate() + battleshipWidth - 1 > battleareaWidth)
				|| (battleShip.getyCoordinate() + battleshipHeight - 64 - 1 > battleareaHeight)) {
			throw new BattleshipException(GlobalConstants.EXCEPTION_INVALID_SHIP_DIMENSION.getValue());
		}
	}

	public void checkCoordinatesOfShip(BattleShip battleShip, BattleArea battleArea) throws BattleshipException {
		Integer battleshipXCoordinate = battleShip.getxCoordinate();
		Character battleshipYCoordinate = battleShip.getyCoordinate();

		Integer battleareaWidth = battleArea.getWidthM();
		Character battleareaHeight = battleArea.getHeightN();

		if (battleshipXCoordinate < 1
				|| battleshipXCoordinate > battleareaWidth
				|| battleshipYCoordinate < 'A'
				|| battleshipYCoordinate > battleareaHeight) {
			throw new BattleshipException(GlobalConstants.EXCEPTION_INVALID_SHIP_COORDINATES.getValue());
		}
	}
}
