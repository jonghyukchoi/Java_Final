package Bowling_Final;

import java.util.Scanner;


public class Main {
	
	static int nthFrame = 0;
	static int nthTurn = 0;
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("게임을 시작합니다.");
		Scanner scan = new Scanner(System.in);
		
		// 스윙 결과값 선언. (thirdScore는 정규 프레임 마지막에 보너스로 획득되는 경우에만 쓰임)
		int firstScore;
		int secondScore;
		int thirdScore;
		
		// 프레임 점수 테이블 객체로 선언.
		FrameOfFrame table;
		
		// 정규 프레임 모두 마칠 때까지 반복.
		
		while(nthFrame < 10) {
			
			table = new FrameOfFrame();
			System.out.printf("%d번째 프레임입니다.\n", nthFrame + 1);
			System.out.print("한 번의 스윙에 0점부터 10점까지 득점 가능합니다.\n");
			System.out.print("첫번째 스윙 결과를 입력하세요: ");
			
			try {
				firstScore = Integer.parseInt(scan.nextLine());		
				
				nthTurn++;

				table.setScore(firstScore, 0);
				Score.insertScore(table, nthTurn);
				Score.calculateOnlyOneFrame(nthTurn);
				Print.printBoard(nthTurn);
				
				// 스트라이크인 경우, 바로 다음 프레임으로 넘어감.
				if(firstScore == 10 && nthFrame != 9){
					nthFrame++;
					nthTurn++;
					continue;
				}
				
				// 스트라이크가 아닌 경우.
				System.out.printf("%d번째 프레임입니다.\n", nthFrame + 1);
				System.out.printf("당신에게는 쓰러뜨려야 할 %d개의 핀이 남아있습니다.\n", 10 - firstScore);
				System.out.print("두번째 스윙 결과를 입력하세요: ");
				secondScore = Integer.parseInt(scan.nextLine());
				nthTurn++;
				table.setScore(secondScore, 1);
				Score.insertScore(table, nthTurn);
				System.out.println();
				Score.calculateOnlyOneFrame(nthTurn);
				Print.printBoard(nthTurn);
				nthFrame++;

				// 스페어인 경우.
				if(firstScore + secondScore == 10 && nthFrame != 9) {
					nthTurn++;
					continue;
				}
				
				// 마지막 정규 프레임에서 스페어나 스트라이크를 해서 세번째 스윙 기회를 얻은 경우.
				if((StatusOfFrame.isSpare(table) || StatusOfFrame.isStrike(table)) && nthFrame == 9) {
					nthTurn++;
					System.out.printf("%d번째 프레임입니다.\n", nthFrame);
					System.out.print("세번째 스윙 결과를 입력하세요: ");
					thirdScore = Integer.parseInt(scan.nextLine());
					table.setScore(thirdScore, 0);
					Score.insertScore(table, nthTurn);
					Score.calculateOnlyOneFrame(nthTurn);
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("문자열은 입력할 수 없습니다");
			}
		}
		
		scan.close();		
		System.out.println("게임을 종료합니다.");
	}
	
}