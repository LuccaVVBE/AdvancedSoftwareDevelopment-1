package domain;

public class BowlingGame {

	private int score = 0;
	private int spare = 0;
	private int beurt = 0;
	
	private int rolls[] = new int[21];
	private int currentRoll=0;
	
	public void roll(int pins) {
		// TODO Auto-generated method stub
		rolls[currentRoll++] = pins;
			
	}

	private boolean isSpare(int frameIndex) {
		return rolls[frameIndex]+rolls[frameIndex+1]==10;
	}
	
	public int score() {
		// TODO Auto-generated method stub
		int score=0;
		for(int frameIndex=0,frame=0;frame<10;frameIndex+=2,frame++)
			if(isSpare(frameIndex))
				score+=10+spareBonus(frameIndex);
			else
			score+=sumOfPinsInFrame(frameIndex);
		return score;
	}
	
	private int sumOfPinsInFrame(int frameIndex) {
		return rolls[frameIndex]+rolls[frameIndex+1];
	}
	private int spareBonus(int frameIndex) {
		return rolls[frameIndex+2];
	}
	private int strikeBonus() {
		return 0;
	}

}
