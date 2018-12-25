package com.br.Battleship;

import java.util.Random;

import com.br.Exceptions.PreenchidoException;
import com.br.Exceptions.TamanhoNavioException;
import com.br.model.BatalhaMinada;

public class Maquina extends Jogador
{
	private BatalhaMinada maquina;
	Random  gerador = new Random(); 
	public Maquina() throws TamanhoNavioException, PreenchidoException
	{
		
	}
	public void distribuir() throws TamanhoNavioException, PreenchidoException
	{
		maquina = new BatalhaMinada();

		for (int i = 0; i < 4; i++)
		{
			Navio navio =  new Navio(gerador.nextInt(4));
			Localizacao loc = new Localizacao();
			loc.setCoordX(gerador.nextInt(20));
			loc.setCoordY(gerador.nextInt(20));
			if (gerador.nextInt(2) + 1 == 1)
				navio.setDirecao('h');
			else
				navio.setDirecao('v');
			maquina.addElemento(loc, navio, 2);
		}
		for (int i = 0; i < 4; i++)
		{
			Localizacao loc = new Localizacao();
			loc.setCoordX(gerador.nextInt(20));
			loc.setCoordY(gerador.nextInt(20));
			Mina mina =  new Mina();
			maquina.addElemento(loc, mina, 2);
		}
		

	}
}
