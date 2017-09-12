package com.tw.battleship.utils;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.tw.battleship.to.BattleShip;
import com.tw.battleship.to.Player;


public class PlayerShipSetupTests {

	private Player player;
	private PlayerShipSetup playerShipSetup;
	private List<BattleShip> listOfShips = new ArrayList<BattleShip>();
	
	@Before
	public void setup(){
		playerShipSetup = new PlayerShipSetupImpl();
		player = Mockito.mock(Player.class);
		BattleShip ship1 = new BattleShip('P', 2, 'B', 4, 'D');
		BattleShip ship2 = new BattleShip('Q', 1, '1', 1, 'A');
		
		listOfShips.add(ship1);
		listOfShips.add(ship2);
	}
	
	@Test
	public void preparePlayerShipsTest(){
		when(player.getBattleships()).thenReturn(listOfShips);
		Map<String, Character> playerShipsMap = playerShipSetup.preparePlayerShips(player);
		assertEquals(5,playerShipsMap.size());
	}
}
