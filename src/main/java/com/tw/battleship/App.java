package com.tw.battleship;

import java.util.HashMap;
import java.util.Map;

import com.tw.battleship.constants.GlobalConstants;
import com.tw.battleship.to.BattleArea;
import com.tw.battleship.to.Player;
import com.tw.battleship.utils.BattleShipUtils;
import com.tw.battleship.utils.BattleShipUtilsImpl;
import com.tw.battleship.utils.BattleshipException;
import com.tw.battleship.utils.PlayerShipSetup;
import com.tw.battleship.utils.PlayerShipSetupImpl;

/**
 * Author - Deepak Singhal Date - 07/09/2017
 */
public class App {
	static Map<String, Character> player1ShipsMap = new HashMap<String, Character>();
	static Map<String, Character> player2ShipsMap = new HashMap<String, Character>();

	static BattleShipUtils battleShipUtils = new BattleShipUtilsImpl();
	static PlayerShipSetup playerShipSetup = new PlayerShipSetupImpl();

	public static void main(String[] args) throws InterruptedException, BattleshipException {
		BattleArea battleArea = new BattleArea();
		Player player1 = new Player();
		Player player2 = new Player();
		
		System.out.println("========== Initializing BattleShip ");
		battleShipUtils.buildTO(battleArea, player1, player2);

		System.out.println("========== Checking Battle Zone ");
		battleShipUtils.validateBattleArea(battleArea);

		System.out.println("========== Setting Up Player 1 ");
		battleShipUtils.validatePlayer(player1, battleArea);
		player1ShipsMap = playerShipSetup.preparePlayerShips(player1);

		System.out.println("========== Setting Up Player 2 ");
		battleShipUtils.validatePlayer(player2, battleArea);
		player2ShipsMap = playerShipSetup.preparePlayerShips(player2);

		System.out.print("LOADING ");
		for (int i = 0; i < 5; i++) {
			Thread.sleep(1000);
			System.out.print(". ");
		}
		System.out.println(" Starting BattleShip . . . Game On ..........");
		playGame(player1, player2, player1ShipsMap, player2ShipsMap);
	}

	private static void playGame(Player player1, Player player2,
			Map<String, Character> player1ShipsMap,
			Map<String, Character> player2ShipsMap) {
		String winner = GlobalConstants.PLAYER_NONE.getValue();
		while (!(player1.getMissileSequence().isEmpty() && player2.getMissileSequence().isEmpty())) {
			Boolean hit = true;
			String target = null;

			while (hit && !player1.getMissileSequence().isEmpty()) {
				target = player1.getMissileSequence().get(0);
				player1.getMissileSequence().remove(0);
				hit = shoot(target, player2ShipsMap);
				System.out.println("Player 1 fires a missile with target "
						+ target + " which got "
						+ (hit ? "hit" : "miss"));
				if (player2ShipsMap.isEmpty()) {
					winner = GlobalConstants.PLAYER_ONE.getValue();
					break;
				}
			}

			hit = true;

			while (hit && !player2.getMissileSequence().isEmpty()) {
				target = player2.getMissileSequence().get(0);
				player2.getMissileSequence().remove(0);
				hit = shoot(target, player1ShipsMap);
				System.out.println("Player 2 fires a missile with target "
						+ target + " which got "
						+ (hit ? "hit" : "miss"));
				if (player1ShipsMap.isEmpty()) {
					winner = GlobalConstants.PLAYER_TWO.getValue();
					break;
				}
			}
		}
		System.out.println("Game Finish - " + winner + " wins !!!");
	}

	private static Boolean shoot(String target,
			Map<String, Character> targetPlayerShipsMap) {
		Character type = targetPlayerShipsMap.get(target);
		if (null == type)
			return false;
		if ('P' == type) {
			targetPlayerShipsMap.remove(target);
			return true;
		} else if ('Q' == type) {
			targetPlayerShipsMap.put(target, 'P');
			return true;
		}
		return false;
	}
}
