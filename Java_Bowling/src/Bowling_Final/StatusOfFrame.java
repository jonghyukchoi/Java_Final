package Bowling_Final;

public class StatusOfFrame {
	
	static boolean isSpare(FrameScore trueOrFalse) {
		return ((trueOrFalse.firstTurnScore + trueOrFalse.secondTurnScore) == 10) && (trueOrFalse.firstTurnScore != 10);
	}
	
	static boolean isStrike(FrameScore trueOrFalse) {
		return trueOrFalse.firstTurnScore == 10;
	}
	
	static boolean isNormal(FrameScore trueOrFalse) {
		return !(isSpare(trueOrFalse) || isStrike(trueOrFalse));
	}
	
	static boolean isSpareOrStrike(FrameScore trueOrFalse) {
		return isSpare(trueOrFalse) || isStrike(trueOrFalse);
	}
	
	static boolean isStartOfFrame(int nthTurn) {
		return nthTurn % 2 == 1;
	}
}
