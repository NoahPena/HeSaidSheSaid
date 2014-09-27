package com.hesaidshesaid;

public class Player {

	private String playerName;
	private int playerScore;
	private int playerRank;
	private boolean isHost;
	
	
	public Player(String name)
	{
		playerName = name;
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
}
