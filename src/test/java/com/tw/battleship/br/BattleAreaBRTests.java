package com.tw.battleship.br;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import com.tw.battleship.br.BattleAreaBR;
import com.tw.battleship.br.BattleAreaBRImpl;
import com.tw.battleship.constants.GlobalConstants;
import com.tw.battleship.to.BattleArea;
import com.tw.battleship.utils.BattleshipException;

public class BattleAreaBRTests {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	private BattleAreaBR battleAreaBR;
	
	@Before
	public void setup(){
		battleAreaBR = new BattleAreaBRImpl();
	}
	
	@Test
	public void negativeWidthBattleAreaTest() throws BattleshipException{
		BattleArea battleArea = Mockito.mock(BattleArea.class);
		expectedException.expect(BattleshipException.class);
		expectedException.expectMessage(GlobalConstants.EXCEPTION_INVALID_AREA_DIMENSION.getValue());
		
		when(battleArea.getHeightN()).thenReturn('D');
		when(battleArea.getWidthM()).thenReturn(-4);
		
		battleAreaBR.checkBattleDimensions(battleArea);
	}
	
	@Test
	public void overflownWidthBattleAreaTest() throws BattleshipException{
		BattleArea battleArea = Mockito.mock(BattleArea.class);
		expectedException.expect(BattleshipException.class);
		expectedException.expectMessage(GlobalConstants.EXCEPTION_INVALID_AREA_DIMENSION.getValue());
		
		when(battleArea.getHeightN()).thenReturn('D');
		when(battleArea.getWidthM()).thenReturn(11);
		
		battleAreaBR.checkBattleDimensions(battleArea);
	}
	
	@Test
	public void smallCaseHeightBattleAreaTest() throws BattleshipException{
		BattleArea battleArea = Mockito.mock(BattleArea.class);
		expectedException.expect(BattleshipException.class);
		expectedException.expectMessage(GlobalConstants.EXCEPTION_INVALID_AREA_DIMENSION.getValue());
		
		when(battleArea.getHeightN()).thenReturn('m');
		when(battleArea.getWidthM()).thenReturn(8);
		
		battleAreaBR.checkBattleDimensions(battleArea);
	}
	
	@Test
	public void symbolWidthBattleAreaTest() throws BattleshipException{
		BattleArea battleArea = Mockito.mock(BattleArea.class);
		expectedException.expect(BattleshipException.class);
		expectedException.expectMessage(GlobalConstants.EXCEPTION_INVALID_AREA_DIMENSION.getValue());
		
		when(battleArea.getHeightN()).thenReturn('$');
		when(battleArea.getWidthM()).thenReturn(8);
		
		battleAreaBR.checkBattleDimensions(battleArea);
	}
	
	@Test
	public void validBattleAreaTest() throws BattleshipException{
		BattleArea battleArea = Mockito.mock(BattleArea.class);

		when(battleArea.getHeightN()).thenReturn('B');
		when(battleArea.getWidthM()).thenReturn(2);
		
		battleAreaBR.checkBattleDimensions(battleArea);
	}
	
	@Test
	public void invalidBattleAreaTest() throws BattleshipException{
		BattleArea battleArea = Mockito.mock(BattleArea.class);
		expectedException.expect(BattleshipException.class);
		expectedException.expectMessage(GlobalConstants.EXCEPTION_INVALID_AREA_DIMENSION.getValue());
		
		when(battleArea.getHeightN()).thenReturn('1');
		when(battleArea.getWidthM()).thenReturn(2);
		
		battleAreaBR.checkBattleDimensions(battleArea);
	}
}
