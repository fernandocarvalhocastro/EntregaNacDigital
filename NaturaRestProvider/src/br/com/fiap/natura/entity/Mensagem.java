package br.com.fiap.natura.entity;

import java.util.Calendar;

/**
 * 
 * @author Fernando C. Castro
 * @since 29/04/2017
 * 
 * Classe de mensagem entre Consultora e Cliente. Simples chat, como se fosse um email direto entre elas. 
 */
public class Mensagem {
	
	private int codigo;
	private String nome;
	private String mensagem;
	private Calendar data;
	private StatusMensagem status;
}
