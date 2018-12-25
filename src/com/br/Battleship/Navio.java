package com.br.Battleship;
import com.br.Exceptions.TamanhoNavioException;

public class Navio
{
	private String nome;
	private boolean[] acertouMiserave;
	private Localizacao loc;
	private char direcao;
	private int tamanho;
	
	public Navio(int tamanho) throws TamanhoNavioException
	{
		setTamanho(tamanho);		
	}
	public void navegar(int x, int y)
	{
		this.loc.setCoordX(x);
		this.loc.setCoordX(y);
	}
	public boolean[] getAcertouMiserave()
	{
		return acertouMiserave;
	}
	public void setAcertouMiserave(boolean acertouMiserave, int i)
	{
		this.acertouMiserave[i] = acertouMiserave;
	}
	public void setAcertouMiserave(boolean[] acertouMiserave)
	{
		this.acertouMiserave = acertouMiserave;
	}
	public String getNome()
	{
		return nome;
	}
	public void setNome(String nome)
	{
		if (nome != null) this.nome = nome;
	}
	public boolean[] isAcertouMiserave()
	{
		return acertouMiserave;
	}
	
	public Localizacao getLoc()
	{
		return loc;
	}
	public void setLoc(Localizacao loc)
	{
		if (loc != null) this.loc = loc;
	}
	
	
	public char getDirecao()
	{
		return direcao;
	}
	public void setDirecao(char direcao)
	{
		if (direcao != ' ') this.direcao = direcao;
	}
	public int getTamanho()
	{
		return tamanho;
	}
	public void setTamanho(int tamanho) throws TamanhoNavioException
	{
		if (tamanho >= 1 && tamanho <= 4)
			this.acertouMiserave = new boolean[tamanho];
		else
			throw new TamanhoNavioException();
			
	}
	@Override
	public String toString()
	{
		return "Navio [nome=" + nome + " tamanho :" + getAcertouMiserave().length;
	}
	
	
}
