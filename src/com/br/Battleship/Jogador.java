package com.br.Battleship;
import com.br.model.BatalhaMinada;

public class Jogador
{
	private BatalhaMinada jogador;
	private String nome;
	private int dinheiro;
	
	public int getDinheiro()
	{
		return dinheiro;
	}
	public void setDinheiro(int dinheiro)
	{
		if (dinheiro > 0) this.dinheiro = dinheiro;
	}
	public BatalhaMinada getMarDeGuerra()
	{
		return jogador;
	}
	public void setMarDeGuerra(BatalhaMinada marDeGuerra)
	{
		this.jogador = marDeGuerra;
	}
	public String getNome()
	{
		return nome;
	}
	public void setNome(String nome)
	{
		if (nome != null) this.nome = nome;
	}	
}
