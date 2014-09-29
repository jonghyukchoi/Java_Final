package Bowling_Final;

import java.util.*;

public class Score {

	static ArrayList<FrameOfFrame> frameList = new ArrayList<FrameOfFrame>();
	static int lengthOfFrame = -1;

	static void insertScore(FrameOfFrame getScore, int nthTurn) {
		if(StatusOfFrame.isStartOfFrame(nthTurn)) { // 프레임의 시작 턴인지를 확인함.
			frameList.add(getScore);
			lengthOfFrame++;
			return;
		}
	}

	static void calculateOnlyOneFrame(int nthTurn) {
		FrameOfFrame nowTable = frameList.get(lengthOfFrame);		
		if(lengthOfFrame == 0 && (StatusOfFrame.isSpareOrStrike(nowTable))) {
			return;
		}
		if(lengthOfFrame == 0 && StatusOfFrame.isNormal(nowTable)) {
			SumWhenNormal.calculateSum(lengthOfFrame, frameList);
			return;
		}
		FrameOfFrame beforeTable = frameList.get(lengthOfFrame - 1);
		if(StatusOfFrame.isSpare(beforeTable)) {
			SumWhenSpare.calculateSum(lengthOfFrame - 1, frameList);
			return;
		}
		if(StatusOfFrame.isStrike(beforeTable)) {
			SumWhenStrike.calculateSum(lengthOfFrame - 1, frameList);
			return;
		}
		if(StatusOfFrame.isNormal(nowTable)) {
			SumWhenNormal.calculateSum(lengthOfFrame - 1, frameList);
			return;
		}
		if(lengthOfFrame > 1) {
			FrameOfFrame doubleBeforeTable = frameList.get(lengthOfFrame - 2);
			if(StatusOfFrame.isStartOfFrame(nthTurn)
					&& StatusOfFrame.isStrike(beforeTable)
					&& StatusOfFrame.isStrike(doubleBeforeTable)) {
				nowTable.firstTurnScore += doubleBeforeTable.total;
				nowTable.count++;
			}
		}
		return;
	}
}