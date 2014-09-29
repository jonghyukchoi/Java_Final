package Bowling_Final;

public class FrameOfFrame extends FrameScore {

	int total = 0;
	int count = 0;
	
	void setScore(int score, int nthFrame) {
		count++;
		if(nthFrame == 0){
			firstTurnScore = score;
			return;
		}
		secondTurnScore = score;
		return;
	}
	
}