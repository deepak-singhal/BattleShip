package com.tw.battleship.br;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import com.tw.battleship.constants.GlobalConstants;
import com.tw.battleship.to.BattleArea;
import com.tw.battleship.to.Player;
import com.tw.battleship.utils.BattleshipException;

public class PlayerBRTests {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	private Player player;
	private PlayerBR playerBR;
	private BattleArea battleArea;

	@Before
	public void setup() {
		player = Mockito.mock(Player.class);
		playerBR = new PlayerBRImpl();
		battleArea = new BattleArea(10, 'J');
	}

	@Test
	public void invalidPlayerNumberOfShipsTest() throws BattleshipException {
		expectedException.expect(BattleshipException.class);
		expectedException.expectMessage(GlobalConstants.EXCEPTION_INVALID_PLAYER_NUMBER_SHIPS.getValue());
		when(player.getNumberOfShips()).thenReturn(200);
		playerBR.checkNumberOfShips(player, battleArea);
	}

	@Test
	public void negativePlayerNumberOfShipsTest() throws BattleshipException {
		expectedException.expect(BattleshipException.class);
		expectedException.expectMessage(GlobalConstants.EXCEPTION_INVALID_PLAYER_NUMBER_SHIPS.getValue());
		when(player.getNumberOfShips()).thenReturn(-1);
		playerBR.checkNumberOfShips(player, battleArea);
	}

	@Test
	public void validPlayerNumberOfShipsTest() throws BattleshipException {
		when(player.getNumberOfShips()).thenReturn(80);
		playerBR.checkNumberOfShips(player, battleArea);
	}

}
