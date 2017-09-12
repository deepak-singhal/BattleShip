package com.tw.battleship.br;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import com.tw.battleship.constants.GlobalConstants;
import com.tw.battleship.to.BattleArea;
import com.tw.battleship.to.BattleShip;
import com.tw.battleship.utils.BattleshipException;

public class BattleShipBRTests {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	private BattleShipBR battleShipBR;
	private BattleArea battleArea;
	private BattleShip battleShip;

	@Before
	public void setup() {
		battleShip = Mockito.mock(BattleShip.class);
		battleShipBR = new BattleShipBRImpl();
		battleArea = new BattleArea(5, 'E');
	}

	@Test
	public void negativeWidthBattleShipDimensionsTest() throws BattleshipException {
		expectedException.expect(BattleshipException.class);
		expectedException.expectMessage(GlobalConstants.EXCEPTION_INVALID_SHIP_DIMENSION.getValue());

		when(battleShip.getHeight()).thenReturn('D');
		when(battleShip.getWidth()).thenReturn(-4);

		battleShipBR.checkBattleShipDimensions(battleShip, battleArea);
	}

	@Test
	public void overflownWidthBattleShipDimensionsTest() throws BattleshipException {
		expectedException.expect(BattleshipException.class);
		expectedException.expectMessage(GlobalConstants.EXCEPTION_INVALID_SHIP_DIMENSION.getValue());

		when(battleShip.getHeight()).thenReturn('D');
		when(battleShip.getWidth()).thenReturn(8);

		battleShipBR.checkBattleShipDimensions(battleShip, battleArea);
	}

	@Test
	public void lessHeightBattleShipDimensionsTest() throws BattleshipException {
		expectedException.expect(BattleshipException.class);
		expectedException.expectMessage(GlobalConstants.EXCEPTION_INVALID_SHIP_DIMENSION.getValue());

		when(battleShip.getHeight()).thenReturn(((char) 64));
		when(battleShip.getWidth()).thenReturn(2);

		battleShipBR.checkBattleShipDimensions(battleShip, battleArea);
	}

	@Test
	public void overflownHeightBattleShipDimensionsTest() throws BattleshipException {
		expectedException.expect(BattleshipException.class);
		expectedException.expectMessage(GlobalConstants.EXCEPTION_INVALID_SHIP_DIMENSION.getValue());

		when(battleShip.getHeight()).thenReturn(((char) 100));
		when(battleShip.getWidth()).thenReturn(2);

		battleShipBR.checkBattleShipDimensions(battleShip, battleArea);
	}

	@Test
	public void validSizeBattleShipDimensionsTest() throws BattleshipException {
		when(battleShip.getHeight()).thenReturn('A');
		when(battleShip.getWidth()).thenReturn(2);
		when(battleShip.getxCoordinate()).thenReturn(2);
		when(battleShip.getyCoordinate()).thenReturn('A');

		battleShipBR.checkBattleShipDimensions(battleShip, battleArea);
	}

	@Test
	public void overflownWidthSizeBattleShipDimensionsTest() throws BattleshipException {
		expectedException.expect(BattleshipException.class);
		expectedException.expectMessage(GlobalConstants.EXCEPTION_INVALID_SHIP_DIMENSION.getValue());

		when(battleShip.getHeight()).thenReturn('A');
		when(battleShip.getWidth()).thenReturn(2);
		when(battleShip.getxCoordinate()).thenReturn(5);
		when(battleShip.getyCoordinate()).thenReturn('A');

		battleShipBR.checkBattleShipDimensions(battleShip, battleArea);
	}

	@Test
	public void overflownHeightSizeBattleShipDimensionsTest() throws BattleshipException {
		expectedException.expect(BattleshipException.class);
		expectedException.expectMessage(GlobalConstants.EXCEPTION_INVALID_SHIP_DIMENSION.getValue());

		when(battleShip.getHeight()).thenReturn('B');
		when(battleShip.getWidth()).thenReturn(2);
		when(battleShip.getxCoordinate()).thenReturn(1);
		when(battleShip.getyCoordinate()).thenReturn('E');

		battleShipBR.checkBattleShipDimensions(battleShip, battleArea);
	}

	@Test
	public void negativeXBattleShipCoordinatesTest() throws BattleshipException {
		expectedException.expect(BattleshipException.class);
		expectedException.expectMessage(GlobalConstants.EXCEPTION_INVALID_SHIP_COORDINATES.getValue());

		when(battleShip.getxCoordinate()).thenReturn(-1);
		when(battleShip.getyCoordinate()).thenReturn('D');

		battleShipBR.checkCoordinatesOfShip(battleShip, battleArea);
	}

	@Test
	public void overflownXBattleShipCoordinatesTest() throws BattleshipException {
		expectedException.expect(BattleshipException.class);
		expectedException.expectMessage(GlobalConstants.EXCEPTION_INVALID_SHIP_COORDINATES.getValue());

		when(battleShip.getxCoordinate()).thenReturn(9);
		when(battleShip.getyCoordinate()).thenReturn('D');

		battleShipBR.checkCoordinatesOfShip(battleShip, battleArea);
	}

	@Test
	public void smallYBattleShipCoordinatesTest() throws BattleshipException {
		expectedException.expect(BattleshipException.class);
		expectedException.expectMessage(GlobalConstants.EXCEPTION_INVALID_SHIP_COORDINATES.getValue());

		when(battleShip.getxCoordinate()).thenReturn(2);
		when(battleShip.getyCoordinate()).thenReturn(((char) 64));

		battleShipBR.checkCoordinatesOfShip(battleShip, battleArea);
	}

	@Test
	public void bigYBattleShipCoordinatesTest() throws BattleshipException {
		expectedException.expect(BattleshipException.class);
		expectedException.expectMessage(GlobalConstants.EXCEPTION_INVALID_SHIP_COORDINATES.getValue());

		when(battleShip.getxCoordinate()).thenReturn(2);
		when(battleShip.getyCoordinate()).thenReturn(((char) 100));

		battleShipBR.checkCoordinatesOfShip(battleShip, battleArea);
	}

	@Test
	public void validBattleShipCoordinatesTest() throws BattleshipException {
		when(battleShip.getxCoordinate()).thenReturn(5);
		when(battleShip.getyCoordinate()).thenReturn('E');

		battleShipBR.checkCoordinatesOfShip(battleShip, battleArea);
	}

	@Test
	public void invalidBattleShipTypeTest() throws BattleshipException {
		expectedException.expect(BattleshipException.class);
		expectedException.expectMessage(GlobalConstants.EXCEPTION_INVALID_SHIP_TYPE.getValue());

		when(battleShip.getType()).thenReturn('Z');

		battleShipBR.checkTypeOfShip(battleShip);
	}

	@Test
	public void validBattleShipPTypeTest() throws BattleshipException {
		when(battleShip.getType()).thenReturn('P');
		battleShipBR.checkTypeOfShip(battleShip);
	}

	@Test
	public void validBattleShipQTypeTest() throws BattleshipException {
		when(battleShip.getType()).thenReturn('Q');
		battleShipBR.checkTypeOfShip(battleShip);
	}

}
