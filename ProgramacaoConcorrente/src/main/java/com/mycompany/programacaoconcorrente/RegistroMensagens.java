/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programacaoconcorrente;

import java.util.*;

/**
 *
 * @author danie
 */
public class RegistroMensagens {
    public	static	void	main(String[]	args)	throws	InterruptedException {
        LinkedList<String> mensagens =	new	LinkedList<String>();
        Thread	t1 = new Thread(new ProduzMensagens(-1, 10000, mensagens));
        Thread	t2 = new Thread(new ProduzMensagens(10000, 20000, mensagens));
        Thread	t3 = new Thread(new ProduzMensagens(20000, 30000, mensagens));
        
        //inicio do chamamento das threads
        t1.start();
        t2.start();
        t3.start();

        //faz com que a thread morra apenas depois que as threads filhas morram
        // metodo join, ele funciona como uma cascata
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Threads produtoras de mensagens finalizadas!");
        
        // Verifica se todas as	mensagens foram	guardadas:
        
        for	(int i = 0; i < 15000; i++)	{
            if	(!mensagens.contains("Mensagem "+ i))	{
                throw new IllegalStateException("não encontrei a mensagem  "+i);
            }
        }
        
        //	Verifica	se	alguma	mensagem	ficou	nula:
        if	(mensagens.contains(null)){
            throw new IllegalStateException("não devia ter null	aqui dentro!");
        }
        System.out.println("Fim da execucao com sucesso");
    }
    
}
