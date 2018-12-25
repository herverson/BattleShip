package com.br.viewcontroller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.br.Battleship.Localizacao;
import com.br.Battleship.Mina;
import com.br.Battleship.Navio;
import com.br.Exceptions.PreenchidoException;
import com.br.Exceptions.TamanhoNavioException;
import com.br.model.BatalhaMinada;
import com.br.model.Observer;

public class TelaPrincipal implements Observer
{
	Scanner sc = new Scanner(System.in);
	private BatalhaMinada model;
	private TelaPrincipalController controller;
	private Localizacao loc;
	private int player;
	private Mina mina;
	Navio navio;
	public Localizacao getLoc()
	{
		return loc;
	}
	public void setLoc(Localizacao loc)
	{
		this.loc = loc;
	}
	public int getPlayer()
	{
		return player;
	}
	public void setPlayer(int player)
	{
		this.player = player;
	}
	public Mina getMina()
	{
		return mina;
	}
	public void setMina(Mina mina)
	{
		this.mina = mina;
	}
	public Navio getNavio()
	{
		return navio;
	}
	public void setNavio(Navio navio)
	{
		this.navio = navio;
	}
	@Override
	public void update()
	{
		ArrayList[][] marDeGuerra, marDeGuerraMq;
		marDeGuerra = model.getMarDeGuerra(1);
		marDeGuerraMq = model.getMarDeGuerra(2);
		for (int i = 0; i < 20; i++)
		{
			for (int j = 0; j < 20; j++)
			{
				if (marDeGuerra[i][j] == null)
				{
					System.out.print("[ ]");
				}
				else 
				{
					boolean contem = false;
					for (int k = 0; k < marDeGuerra[i][j].size(); k++)
		               {
		            	   if (marDeGuerra[i][j].get(k) instanceof Boolean)
		            	   {
		            		   contem = true;
		            		   break;
		            	   }
		               }
					if (contem)
						System.out.print("[*]");
					else
						System.out.print("[" + marDeGuerra[i][j].size() + "]");
				}				
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		for (int i = 0; i < 20; i++)
		{
			for (int j = 0; j < 20; j++)
			{
				if (marDeGuerraMq[i][j] == null)
				{
					System.out.print("[ ]");
				}
				else 
				{
					boolean contem = false;
					for (int k = 0; k < marDeGuerraMq[i][j].size(); k++)
		               {
		            	   if (marDeGuerraMq[i][j].get(k) instanceof Boolean)
		            	   {
		            		   contem = true;
		            		   break;
		            	   }
		               }
					if (contem)
						System.out.print("[*]");
					else
						System.out.print("[" + marDeGuerraMq[i][j].size() + "]");
				}				
			}
			System.out.println();
		}
		try
		{
			exibeMenu();
		} 
		catch (TamanhoNavioException e)
		{
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (PreenchidoException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public TelaPrincipal(BatalhaMinada model) throws TamanhoNavioException, PreenchidoException {
		this.model = model;
		this.controller = new TelaPrincipalController(model, this);
		model.registraObserver(this);
		exibeMenu();
	}
	public void exibeMenu() throws TamanhoNavioException, PreenchidoException
	{
		System.out.println("Batalha Naval");

		int opcao;
		System.out.println(" MENU               -");
		System.out.println("1 - jogar             ");
		System.out.println("2 - atirar             ");
		System.out.println("3 - distribuir minas");
		System.out.println("4 - distribuir minas máquina ");
		System.out.println("5 - distribuir navios máquina ");
		System.out.println("6 - máquina atirar ");
		System.out.println("7 - Sair");
		
		opcao = sc.nextInt();
		controller.selecionaAcao(opcao);
		
	}
	public void atirar() throws TamanhoNavioException, PreenchidoException
	{
		Localizacao loc = new Localizacao();
		System.out.println("Informe as coordenadas");
		System.out.println("Linha");
		loc.setCoordX(sc.nextInt()-1);
		System.out.println("coluna");
		loc.setCoordY(sc.nextInt()-1);
		controller.controllerMeterBala(loc, 2);
	}
	public void atirarMaquina() throws TamanhoNavioException, PreenchidoException
	{
		Random gerador = new Random(); 
		loc = new Localizacao();
		loc.setCoordX(gerador.nextInt(19));
		loc.setCoordY(gerador.nextInt(19));
		controller.controllerMeterBala(loc, 1);
	}
	public void distribuirMaquina() throws TamanhoNavioException, PreenchidoException
	{
		
		for (int i = 0; i < 1; i++)
		{	
		Random gerador = new Random(); 
			
    		
				navio =  new Navio(gerador.nextInt(4)+1);
    		
        		loc = new Localizacao();
        		loc.setCoordX(gerador.nextInt(19));
        		loc.setCoordY(gerador.nextInt(19));
        		if (gerador.nextInt(2) + 1 == 1)
        			navio.setDirecao('h');
        		else
        			navio.setDirecao('v');
        		setPlayer(2);
        		controller.controllerAddElemento(getLoc(), getNavio(), getPlayer());
        		
   		   
			}   	
    	
	}
	public void jogar() throws TamanhoNavioException, PreenchidoException
	{	
		try
		{
		 for (int i = 0; i < 1; i++)
		 {
			 
    		 loc = new Localizacao();
    		 System.out.println("Digite o nome do seu navio:");//+(i+1));
    		 String nome = sc.next();
    		 System.out.println("Digite o tamanho  do seu navio: ");//+(i+1));
    		 int tamanho = (sc.nextInt());
    		 System.out.println("Digite a coordenada do navio");
    		 System.out.println("linha:");
    		 loc.setCoordX(sc.nextInt()-1);
    		 System.out.println("Coluna");
    		 loc.setCoordY(sc.nextInt()-1);
    		 System.out.println("Digite a direcao seu navio( H- Horizontal| V- Vertical:");//+(i+1));
    		 char direcao = (sc.next().charAt(0));
    		 navio = new Navio(tamanho);
    		 navio.setNome(nome);
    		 navio.setDirecao(direcao);
    		 setPlayer(1);
    		 // coordenadas;
    		 
    		controller.controllerAddElemento(getLoc(), getNavio(), getPlayer());	
    		// controller.selecionaAcao(4);
		 }
		}
		catch (Exception e) {
			System.out.println(e);
		}
		 
	}
	public void distribuirMinas() throws TamanhoNavioException, PreenchidoException
	{
		Random gerador = new Random(); 
		 loc = new Localizacao();
 		loc.setCoordX(gerador.nextInt(19));
 		loc.setCoordY(gerador.nextInt(19));
 		Mina mina =  new Mina();
 		controller.controllerAddElemento(getLoc(), mina, 1);
	}
	public void distribuirMinasJogador() throws TamanhoNavioException, PreenchidoException
	{
		loc = new Localizacao();
		 System.out.println("Digite a coordenada da mina");
		 System.out.println("linha:");
		 loc.setCoordX(sc.nextInt()-1);
		 System.out.println("Coluna");
		 loc.setCoordY(sc.nextInt()-1);
		 setPlayer(2);
		 Mina mina = new Mina();
		 
		controller.controllerAddElemento(getLoc(), mina, getPlayer());
	}
}
