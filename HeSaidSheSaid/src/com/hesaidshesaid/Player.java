package com.hesaidshesaid;

public class Player {

	private String playerName;
	private int playerScore = 0;
	private int playerRank = 0;
	private boolean isHost = false;
	private String answer;
	private boolean hasAnswered = false;
	
	
	public Player(String name)
	{
		playerName = name;
	}
	
	public void resetPlayer()
	{
		isHost = false;
		answer = "";
		hasAnswered = false;
	}
	
	public String getPlayerName()
	{
		return playerName;
	}
	
	public int getPlayerScore()
	{
		return playerScore;
	}
	
	public int getPlayerRank()
	{
		return playerRank;
	}
	
	public boolean isPlayerHost()
	{
		return isHost;
	}
	
	public void setPlayerName(String name)
	{
		playerName = name;
	}
	
	public void setPlayerScore(int score)
	{
		playerScore = score;
	}
	
	public void setPlayerRank(int rank)
	{
		playerRank = rank;
	}
	
	public void setHost(boolean host)
	{
		isHost = host;
	}
	
	public void addPoint()
	{
		playerScore++;
	}
	
	public void addAnswer(String maybe)
	{
		answer = maybe;
		hasAnswered = true;
	}
	
	public String getAnswer()
	{
		return answer;
	}
}
