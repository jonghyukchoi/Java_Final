package Bowling_Final;

public class Print extends Score {

	static void printBoard(int nthTurn){
		System.out.println("#########################################################");
		System.out.print(" Frame");
		System.out.println("  1    2    3    4    5    6    7    8    9    10");
		System.out.println("--------------------------------------------------------");
		System.out.print(" Score");
		printFrame(nthTurn);
		System.out.println("--------------------------------------------------------");
		System.out.print(" Total");
		printSum(nthTurn);
		System.out.println("#########################################################");
	}
	
	static void printFrame(int nthTurn) {
		FrameOfFrame nowFrame;
		for(int i = 0; i< lengthOfFrame; i++) {
			nowFrame = frameList.get(i);
			// 마지막 정규 프레임에서 스트라이크를 했을 경우.
			if(StatusOfFrame.isStrike(nowFrame) && i == 9) { 
				if(nowFrame.firstTurnScore == 10 && nowFrame.secondTurnScore == 10
						&& nowFrame.thirdTurnScore == 10) {
					System.out.print(" " + "X" + " " + "X" + " " + "X");
					break;
				}
				
				if(nowFrame.firstTurnScore == 10 && nowFrame.secondTurnScore == 10
						&& nowFrame.thirdTurnScore != 10){
					System.out.print(" " + "X" + " " + "X" + " " + nowFrame.thirdTurnScore);
					break;
				}
				
				if(nowFrame.firstTurnScore == 10 && nowFrame.secondTurnScore != 10
						&& nowFrame.thirdTurnScore == 10) {
					System.out.print(" " + "X" + " " + nowFrame.secondTurnScore + " " + "X");
					break;
				}
				
				System.out.print(" " + "X" + " " + nowFrame.secondTurnScore + " " + nowFrame.thirdTurnScore);
				
				break;
			}
			
			// 마지막 정규 프레임에서 스페어를 나온 경우.
			if(StatusOfFrame.isSpare(nowFrame) && i == 9) {
				System.out.print(" " + nowFrame.firstTurnScore + " " + "/" + " " + nowFrame.thirdTurnScore);
				break;
			}
			
			if(StatusOfFrame.isStartOfFrame(nthTurn) && i == lengthOfFrame) {
				System.out.print(" " + nowFrame.firstTurnScore + "  " + "  " + " ");
				continue;
			}
			
			if(StatusOfFrame.isSpare(nowFrame)) {
				System.out.print(" " + nowFrame.firstTurnScore + " " + "/" + " ");
				continue;
			}
			
			if(StatusOfFrame.isStrike(nowFrame)) {
				System.out.print(" " + "X" + " " + "-" + " ");
				continue;
			}

			System.out.print(" " + nowFrame.firstTurnScore + " " + nowFrame.secondTurnScore + " ");
		}
		System.out.println();
	}
		
	static void printSum(int nthTurn) {
		for(int i = 0; i < lengthOfFrame; i++) {
			
			FrameOfFrame nowTable = frameList.get(i);
			int total = nowTable.total;
			
			if((StatusOfFrame.isNormal(nowTable) && (i != lengthOfFrame || !StatusOfFrame.isStartOfFrame(nthTurn)))
					|| (StatusOfFrame.isSpare(nowTable) && i!=lengthOfFrame)
					|| (StatusOfFrame.isStrike(nowTable) && (nowTable.count == 3))) {
				System.out.print("  " + total + " ");	
			}
						
			if((StatusOfFrame.isSpare(nowTable) && i == lengthOfFrame) || 
					(StatusOfFrame.isStrike(nowTable) && (nowTable.count < 3))) {
				System.out.print("  " + "  " + " ");
			}
			
		}
		System.out.println();
	}
}
