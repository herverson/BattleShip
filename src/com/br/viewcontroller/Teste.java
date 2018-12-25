package com.br.viewcontroller;
import java.util.ArrayList;

import com.br.Battleship.Localizacao;
import com.br.Battleship.Mina;
import com.br.Battleship.Navio;
import com.br.Exceptions.AguaException;
import com.br.model.BatalhaMinada;

public class Teste
{
	public static void main(String[] args)
	{
		/* Criando um novo jogo da BatalhaMinada */
		BatalhaMinada batMin = new BatalhaMinada();
				
		/* Criando um navio para ser adicionado na matriz */
		try
		{
    		Navio nav1 = new Navio(4);
    		nav1.setNome("São Paulo");
		
		/* Criando outro navio para ser adicionado na matriz */
    		Navio nav2 = new Navio(4);
    		nav1.setNome("Dragão do Mar");
    		Navio nav3 = new Navio(3);
    		nav3.setNome("São Paulo2");
		
		/* Criando uma coordenada para adicionar elemento na matriz */
		Localizacao coord1 = new Localizacao();
		coord1.setCoordX(0);
		coord1.setCoordY(0);

		/* Criando outra coordenada para adicionar elemento na matriz */
		Localizacao coord2 = new Localizacao();
		
		coord2.setCoordX(1);
		coord2.setCoordY(1);
		Localizacao coord4 = new Localizacao();
		
		coord4.setCoordX(0);
		coord4.setCoordY(2);
		
		Localizacao coord3 = new Localizacao();
		
		coord3.setCoordX(0);
		coord3.setCoordY(2);
		Mina min1 = new Mina();

		/* Adicionando os dois navios na matriz. Na mesma coordenada */
		
			batMin.addElemento(coord1, nav1, 1);
			//batMin.addElemento(coord4, nav3, 1);
			batMin.addElemento(coord2, nav2, 2);
			batMin.addElemento(coord3, min1, 1);
			//batMin.setPlayer(1);
			//batMin.navegar(nav1, coord1);

		/* Adicionando um Object na matriz, poderia ser a mina */
//		batMin.addElemento(coord2, new Object(), 2);
		
		/* Exibindo a matriz indicando quantos elementos existem em
		   cada coordenada da matriz
		*/
		int i;
		ArrayList[][] marDeGuerra = batMin.getMarDeGuerra(1);
		for (i = 0; i < 20; i++)
		{
			for (int j = 0; j < 20; j++)
			{
				if (marDeGuerra[i][j] == null)
				{
					System.out.print("[ ]");
				}
				
				else
				{	
					System.out.print("[" + marDeGuerra[i][j].size() + "]");
				}
			}
			System.out.println();
		}
		
		System.out.println();
		marDeGuerra = batMin.getMarDeGuerra(2);
		for (i = 0; i < 20; i++)
		{
			for (int j = 0; j < 20; j++)
			{
				if (marDeGuerra[i][j] == null)
				{
					System.out.print("[ ]");
				}
				else 
				{
					System.out.print("[" + marDeGuerra[i][j].size() + "]");
				}				
			}
			System.out.println();
		}
		
		//Localizacao coord3 = new Localizacao();
		coord3.setCoordX(0);
		coord3.setCoordY(1);
		try
		{
			batMin.meterBala(coord3, 1);
			batMin.meterBala(coord2, 2);
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		for (i = 0; i < nav1.getAcertouMiserave().length; i++)
		{
			System.out.println(nav1.getAcertouMiserave()[i]);
		}
//		
//		for (i = 0; i < nav2.getAcertouMiserave().length; i++)
//		{
//			System.out.println(nav2.getAcertouMiserave()[i]);
//		}
//		
		marDeGuerra = batMin.getMarDeGuerra(1);
		for (i = 0; i < 20; i++)
		{
			for (int j = 0; j < 20; j++)
			{
				if (marDeGuerra[i][j] == null)
				{
					System.out.print("[ ]");
				}
	
				else
					System.out.print("[" + marDeGuerra[i][j].size() + "]");
			}
			System.out.println();
		}
		}
    	catch (Exception e) {
			System.out.println(e);
		}
	}
}
