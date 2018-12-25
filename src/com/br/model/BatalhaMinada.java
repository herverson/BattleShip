package com.br.model;
import java.util.*;

import com.br.Battleship.Localizacao;
import com.br.Battleship.Mina;
import com.br.Battleship.Navio;
import com.br.Exceptions.AguaException;
import com.br.Exceptions.DirecaoException;
import com.br.Exceptions.PreenchidoException;

public class BatalhaMinada
{
	private ArrayList<Observer> observers = new ArrayList<>();
	private ArrayList marDeGuerra01[][] = new ArrayList[20][20];
	private ArrayList marDeGuerra02[][] = new ArrayList[20][20];
	private int player;
	
	public void navegar(Navio navio, Localizacao coord, int player)
	{
		boolean contem = false;
		ArrayList[][] marDeGuerra = getMarDeGuerra(player);
		for (int i = 0; i < navio.getAcertouMiserave().length; i++)
			if (marDeGuerra[coord.getCoordX()][coord.getCoordY()+i] != null)
			for (int k = 0; k < marDeGuerra[coord.getCoordX()][coord.getCoordY()+i].size(); k++)
			{
				if(marDeGuerra[coord.getCoordX()][coord.getCoordY()].get(k) instanceof Mina)
				{
					contem = true;
				}
			}
		if (!contem)
		{
        		for (int i = 0; i < navio.getAcertouMiserave().length; i++)
        		{
            		if (marDeGuerra[coord.getCoordX()][coord.getCoordY() + i] == null)
            		{
            			marDeGuerra[coord.getCoordX()][coord.getCoordY() + i] = new ArrayList();
            		}     		
        		}
        		marDeGuerra[coord.getCoordX()][coord.getCoordY()] = null;
		}
		else
		{
			System.out.println("Contem");
		}
    }
	public boolean contem(int x, int y, int player, ArrayList[][] marDeGuerra, Navio navio)
	{
		boolean contem = false;
		if (marDeGuerra[x][y] != null)
     	   for (int i = 0; i < marDeGuerra[x][y].size(); i++)
            {
     		   if (marDeGuerra[x][y] == null)
     		   {
     			   contem = false;
     			   break;      		
     		   }
     		   if (marDeGuerra[x][y].get(i) instanceof Navio)
     		   {
     			   if ((Navio) marDeGuerra[x][y].get(i) == navio)
     			   {
     				   contem = true;
     			   }
     		   }
     		   else if(marDeGuerra[x][y].get(i) instanceof Mina)
     		   {
     			   continue;
     		   }
            }
     	
		return contem;
	}
	
	public void meterBala(Localizacao loc, int player) throws AguaException
	{
		    
	   ArrayList[][] marDeGuerra = getMarDeGuerra(player);
       Navio navio = getNavio(loc, player);
       boolean contem = false;
       int k = 0;
       if (navio != null)
       {
    	   if (marDeGuerra[loc.getCoordX()][loc.getCoordY()] != null)
           {
               for (int i = 0; i < marDeGuerra[loc.getCoordX()][loc.getCoordY()].size(); i++)
               {
            	   if (marDeGuerra[loc.getCoordX()][loc.getCoordY()].get(i) instanceof Navio
            			   && (Navio) marDeGuerra[loc.getCoordX()][loc.getCoordY()].get(i) == navio)   
            	   {
                    	k = 0;
                    	while(contem(loc.getCoordX(), loc.getCoordY() + k, player, marDeGuerra, navio))
                    	   k++;
            	     
                    	int tamanho = navio.getAcertouMiserave().length - 1;
                    	navio.setAcertouMiserave(true, tamanho - (k-1));
                    	marDeGuerra[loc.getCoordX()][loc.getCoordY()].add(new Boolean(true));
                    	notificaObservers();
            	   }
               }
           }
           else
           {
        	   throw new AguaException();
           }
        	   
       }
       else
       {
    	   throw new AguaException();
       }
	}

	public Navio getNavio(Localizacao loc, int player)
	{
		ArrayList marDeGuerra[][];
        Navio navio = null;	
        marDeGuerra = getMarDeGuerra(player);
        if (marDeGuerra[loc.getCoordX()][loc.getCoordY()] != null)
        {
        	for (int i = 0; i < marDeGuerra[loc.getCoordX()][loc.getCoordY()].size(); i++)
        	{
        		if (marDeGuerra[loc.getCoordX()][loc.getCoordY()].get(i) instanceof Navio)
        		{
        			navio = (Navio) marDeGuerra[loc.getCoordX()][loc.getCoordY()].get(i);
        			break;
        		}
        			
        	}
        }
        return navio;
	}

	public Mina getMina(Localizacao loc, int player)
	{
		ArrayList marDeGuerra[][];
		
        Mina mina = null;	
        marDeGuerra = getMarDeGuerra(player);
        if (marDeGuerra[loc.getCoordX()][loc.getCoordY()] != null)
        {
        	for (int i = 0; i < marDeGuerra[loc.getCoordX()][loc.getCoordY()].size(); i++)
        	{
        		if (marDeGuerra[loc.getCoordX()][loc.getCoordY()].get(i) instanceof Mina)
        		{
        			mina = (Mina) marDeGuerra[loc.getCoordX()][loc.getCoordY()].get(i);
        			break;
        		}
        			
        	}
        }
        return mina;
	}
	
	
	public ArrayList[][] getMarDeGuerra(int player)
	{
		ArrayList marDeGuerra[][] = null;
		if (player == 1)
		{
			marDeGuerra = marDeGuerra01;
		}
		else 
		{
			marDeGuerra = marDeGuerra02;
		}
		
		return marDeGuerra;
	}
	
	public void addElemento(Localizacao coord, Object elemento, int player) throws PreenchidoException
	{
		
		ArrayList marDeGuerra[][];
		String sentido;
		marDeGuerra = getMarDeGuerra(player);
		if ((coord != null) && (elemento != null)) 
		{
			if (marDeGuerra[coord.getCoordX()][coord.getCoordY()] == null)
				marDeGuerra[coord.getCoordX()][coord.getCoordY()] = new ArrayList();
			
			if (elemento instanceof Navio)
			{
    			if (!(getNavio(coord, player) instanceof Navio))
    			{
    				Navio navio = (Navio) elemento;
    				if (navio.getDirecao() == 'H' || navio.getDirecao() == 'h')
    				{
        				for (int i = 0; i < navio.getAcertouMiserave().length; i++)
        				{
        					try
        					{
            					if (marDeGuerra[coord.getCoordX()][coord.getCoordY() + i] == null)
            					{
            						marDeGuerra[coord.getCoordX()][coord.getCoordY() + i] = new ArrayList();
            					}
                				 marDeGuerra[coord.getCoordX()][coord.getCoordY() + i].add(elemento);
                				 
        					
        					}
        					catch (ArrayIndexOutOfBoundsException e) {
							}
        					
        				}
        				notificaObservers();
        				
    				}
    				else if (navio.getDirecao() == 'v' || navio.getDirecao() == 'V')
    				{
    					for (int i = 0; i < navio.getAcertouMiserave().length; i++)
        				{
    						try
    						{
            					if (marDeGuerra[coord.getCoordX() + i][coord.getCoordY()] == null)
            					{
            						marDeGuerra[coord.getCoordX() + i][coord.getCoordY()] = new ArrayList();
            					}
                				 marDeGuerra[coord.getCoordX() + i][coord.getCoordY()].add(elemento);	 
    						}
    						catch (Exception e) {
								// TODO: handle exception
							}
        			
        				}
    					notificaObservers();
    				}
    				else
    				{
    					throw new PreenchidoException("Direção inválida");
    				}
				}
    			else
    			{
    				throw new PreenchidoException("Coordena já possui um navio");
    			}
    				
    		
			}
			else if (elemento instanceof Mina)
			{
    			if (!(getMina(coord, player) instanceof Mina))
    			{
    				if (marDeGuerra[coord.getCoordX()][coord.getCoordY()] == null)
    					marDeGuerra[coord.getCoordX()][coord.getCoordY()] = new ArrayList();
				
    				marDeGuerra[coord.getCoordX()][coord.getCoordY()].add(elemento);
    				notificaObservers();
    			}
    			else
    			{
    				throw new PreenchidoException("Coordena já possui uma mina");
    			}
    		}
			
				
		}
		
	}
	
	public int getPlayer()
	{
		return player;
	}
	public void setPlayer(int player)
	{
		if (player >= 1 && player <= 2) this.player = player;
	}
	
	public void registraObserver(Observer observer) 
	{
		observers.add(observer);
	}
	
	public void removeObserver(Observer observer) 
	{
		// faz a remo��o do ArrayList
	}
	
	public void notificaObservers() 
	{
		for(Observer observer : observers)
		{
			observer.update();
		}
	}
}