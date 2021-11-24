/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programacaoconcorrente;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Vector;

/**
 *
 * @author danie
 */
public class ProduzMensagens implements Runnable	{
    private int	comeco;
    private int	fim;
    private LinkedList<String> mensagens;
    
    public ProduzMensagens(int comeco,	int	fim,	LinkedList<String>	mensagens) {
        this.comeco = comeco;
        this.fim = fim;
        this.mensagens	= mensagens;
    }
    public  void run() {
        for (int i = comeco; i < fim; i++){
            synchronized(mensagens){
            mensagens.add("Mensagem "+ i);
        }
        }
    }

    public int getComeco() {
        return comeco;
    }

    public int getFim() {
        return fim;
    }

    public Collection<String> getMensagens() {
        return mensagens;
    }
    
}