package com.br.Battleship;

public class Mina
{
	private Localizacao loc;

	public Localizacao getLoc()
	{
		return loc;
	}

	public void setLoc(Localizacao loc)
	{
		this.loc = loc;
	}

	@Override
	public String toString()
	{
		return "Mina [loc=" + loc + "]";
	}
	
}
