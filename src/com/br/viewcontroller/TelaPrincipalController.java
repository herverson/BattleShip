package com.br.viewcontroller;

import java.io.Externalizable;

import com.br.Battleship.Jogador;
import com.br.Battleship.Localizacao;
import com.br.Exceptions.AguaException;
import com.br.Exceptions.PreenchidoException;
import com.br.Exceptions.TamanhoNavioException;
import com.br.model.BatalhaMinada;

public class TelaPrincipalController
{
	private BatalhaMinada model;
	private TelaPrincipal view;
	private Jogador jogador;
	public TelaPrincipalController(BatalhaMinada model, TelaPrincipal view) {
		this.model = model;
		this.view = view;
	}

	public void selecionaAcao(int opcao) throws TamanhoNavioException, PreenchidoException {
		
		switch (opcao) {
    		case 1: view.jogar();
    				break;
    		case 2: view.atirar();
    				break;
    		case 3: view.distribuirMinasJogador();
				break;
    		case 4: view.distribuirMinas();
    				break;
    		case 5: view.distribuirMaquina();
    			break;
    	    case 6: view.atirarMaquina();
    				break;
   		}
	}
	
	public void controllerAddElemento(Localizacao coord, Object elemento, int player) throws TamanhoNavioException, PreenchidoException
	{
		try 
		{
			model.addElemento(coord, elemento, player);
		} 
		catch (PreenchidoException e) 
		{
			System.out.println(e);
			view.exibeMenu();
		}
	}
	public void controllerMeterBala(Localizacao coord, int player) throws TamanhoNavioException, PreenchidoException
	{
		try
		{
			model.meterBala(coord, player);
		}
		catch (AguaException e)
		{
			System.out.println(e);
			view.exibeMenu();
		}
	}
	public void controllerMeterBalaMaquina(Localizacao coord, int player) throws TamanhoNavioException, PreenchidoException
	{
		try
		{
			model.meterBala(coord, player);
		}
		catch (AguaException e)
		{
			System.out.println(e);
			view.exibeMenu();
		}
	}
}
