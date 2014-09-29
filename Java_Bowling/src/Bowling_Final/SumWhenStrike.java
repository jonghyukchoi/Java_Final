package Bowling_Final;

import java.util.ArrayList;

public class SumWhenStrike implements Calculator {
	
	static void calculateSum(int nowNthFrame, ArrayList<FrameOfFrame> frameList) {
		FrameOfFrame nowTable = frameList.get(nowNthFrame);
		FrameOfFrame afterTable = frameList.get(nowNthFrame + 1);
		nowTable.count++;
		if(nowNthFrame == 0) {
			System.out.println(nowTable.total);
			nowTable.total = nowTable.firstTurnScore + nowTable.secondTurnScore;
			afterTable.total = nowTable.firstTurnScore + nowTable.secondTurnScore + afterTable.firstTurnScore + afterTable.secondTurnScore;
			return;
		}
		FrameOfFrame beforeTable = frameList.get(nowNthFrame - 1);
		afterTable.total = beforeTable.total + nowTable.firstTurnScore + nowTable.secondTurnScore + afterTable.firstTurnScore + afterTable.secondTurnScore;		
		return;
	}
}