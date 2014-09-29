package Bowling_Final;

import java.util.ArrayList;

public class SumWhenSpare implements Calculator {
	
	static void calculateSum(int nowNthFrame, ArrayList<FrameOfFrame> frameList) {
		FrameOfFrame nowTable = frameList.get(nowNthFrame);
		FrameOfFrame afterTable = frameList.get(nowNthFrame + 1);
		nowTable.count++;
		if(nowNthFrame == 0) {
			nowTable.total = nowTable.firstTurnScore + nowTable.secondTurnScore + afterTable.firstTurnScore;
			return;
		}
		FrameOfFrame beforeTable = frameList.get(nowNthFrame - 1);
		nowTable.total = beforeTable.total + nowTable.firstTurnScore + nowTable.secondTurnScore + afterTable.firstTurnScore;
		return;
	}
}