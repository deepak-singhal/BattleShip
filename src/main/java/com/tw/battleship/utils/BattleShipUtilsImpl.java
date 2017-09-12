package com.tw.battleship.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.tw.battleship.br.BattleAreaBR;
import com.tw.battleship.br.BattleAreaBRImpl;
import com.tw.battleship.br.BattleShipBR;
import com.tw.battleship.br.BattleShipBRImpl;
import com.tw.battleship.br.PlayerBR;
import com.tw.battleship.br.PlayerBRImpl;
import com.tw.battleship.constants.GlobalConstants;
import com.tw.battleship.to.BattleArea;
import com.tw.battleship.to.BattleShip;
import com.tw.battleship.to.Player;

public class BattleShipUtilsImpl implements BattleShipUtils {
	static String FILENAME = GlobalConstants.FILENAME.getValue();

	static BattleAreaBR battleAreaBR = new BattleAreaBRImpl();
	static BattleShipBR battleShipBR = new BattleShipBRImpl();
	static PlayerBR playerBR = new PlayerBRImpl();

	public void buildTO(BattleArea battleArea, Player player1, Player player2) {
		List<BattleShip> list1 = new ArrayList<BattleShip>();
		List<BattleShip> list2 = new ArrayList<BattleShip>();
		Integer numberOfBattleShips = null;
		String player1MissileSequence = null;
		String player2MissileSequence = null;

		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			/*
			 * First Line = Width space " " Height
			 */
			if ((sCurrentLine = br.readLine()) != null) {
				buildBattleAreaTO(battleArea, sCurrentLine);
			}

			/*
			 * Second Line = Number of battleShips each player have.
			 */
			if ((sCurrentLine = br.readLine()) != null) {
				numberOfBattleShips = Integer.parseInt(sCurrentLine);
			}

			/*
			 * Subsequent lines talk about the battleships in the format below :
			 * Q 1 1 A1 B2 -> type shipWidth shipHeight xyCoordiantePlayer1
			 * xyCoordiantePlayer2
			 */
			while ((sCurrentLine = br.readLine()) != null
					&& (sCurrentLine.charAt(0) == 'P' && sCurrentLine.charAt(1) == ' ')
					|| (sCurrentLine.charAt(0) == 'Q' && sCurrentLine.charAt(1) == ' ')) {
				String[] k = sCurrentLine.split(" ");

				Character type = k[0].charAt(0);
				Integer width = Integer.parseInt(k[1]);
				Character height = (char) (64 + Integer.parseInt(k[2]));
				String player1Coordinate = k[3];
				String player2Coordinate = k[4];

				BattleShip battleship1 = new BattleShip(type, width, height,
						Integer.parseInt(player1Coordinate.substring(1)),
						player1Coordinate.charAt(0));
				BattleShip battleship2 = new BattleShip(type, width, height,
						Integer.parseInt(player2Coordinate.substring(1)),
						player2Coordinate.charAt(0));

				list1.add(battleship1);
				list2.add(battleship2);
			}

			/*
			 * Last two lines indicates the missile sequences of each player
			 */
			if (sCurrentLine != null)
				player1MissileSequence = sCurrentLine;
			if ((sCurrentLine = br.readLine()) != null)
				player2MissileSequence = sCurrentLine;

		} catch (IOException e) {
			System.out.println(new BattleshipException(GlobalConstants.EXCEPTION_INVALID_FILE.getValue()) + " "+FILENAME);
			System.exit(-1);
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				System.out.println(new BattleshipException(GlobalConstants.EXCEPTION_INVALID_FILE.getValue()) + " "+FILENAME);
				System.exit(-1);
			}
		}

		player1.setId(1);
		player1.setBattleArea(battleArea);
		player1.setBattleships(list1);
		player1.setNumberOfShips(numberOfBattleShips);
		if(null != player1MissileSequence)
			player1.setMissileSequence(new ArrayList<String>(Arrays.asList(player1MissileSequence.split(" "))));

		player2.setId(2);
		player2.setBattleArea(battleArea);
		player2.setBattleships(list2);
		player2.setNumberOfShips(numberOfBattleShips);
		if(null != player2MissileSequence)
		player2.setMissileSequence(new ArrayList<String>(Arrays.asList(player2MissileSequence.split(" "))));
	}

	public void buildBattleAreaTO(BattleArea battleArea, String battleAreaDimensions) {
		String[] k = battleAreaDimensions.split(" ");
		battleArea.setWidthM(Integer.parseInt(k[0]));
		battleArea.setHeightN(k[1].charAt(0));
	}

	/*
	 * Validation Methods to call for respective Business Rules
	 */
	public void validateBattleArea(BattleArea battleArea) throws BattleshipException {
		battleAreaBR.checkBattleDimensions(battleArea);
	}

	public void validatePlayer(Player player, BattleArea battleArea) throws BattleshipException {
		playerBR.checkNumberOfShips(player, battleArea);
		for (BattleShip battleShip : player.getBattleships()) {
			validateBattleShip(battleShip, battleArea);
		}
	}

	public void validateBattleShip(BattleShip battleShip, BattleArea battleArea) throws BattleshipException {
		battleShipBR.checkTypeOfShip(battleShip);
		battleShipBR.checkBattleShipDimensions(battleShip, battleArea);
		battleShipBR.checkCoordinatesOfShip(battleShip, battleArea);
	}

}
