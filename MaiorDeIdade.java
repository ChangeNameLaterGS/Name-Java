package br.com.fiap.bean;

import javax.swing.JOptionPane;

public class MaiorDeIdade extends Cadastro{

	//Atributos
	private int comprovanteAjuda, numeroVerificacao;
	
	// Construtores
    	public MaiorDeIdade() {}

   	 public MaiorDeIdade(int comprovanteAjuda, int numeroVerificacao) {
        	this.comprovanteAjuda = comprovanteAjuda;
        	this.numeroVerificacao = numeroVerificacao;
    	}

    //gets e sets

	public int getComprovanteAjuda() {
		return comprovanteAjuda;
	}

	public void setComprovanteAjuda(int comprovanteAjuda) {
		this.comprovanteAjuda = comprovanteAjuda;
	}
	public int getNumeroVerificacao() {
		return numeroVerificacao;
	}
	
	public void setNumeroVerificacao(int numeroVerificacao) {
		this.numeroVerificacao = numeroVerificacao;
	}

	//método com sobrescrita
	public int calculaPontos() {

	    // Variável para armazenar o total de pontos
	    int totalPontos = 0;

	    // Crie uma variável para armazenar o código do comprovante
	    String escolha = JOptionPane.showInputDialog("Deseja inserir código de comprovante de ajuda?");
	    while (escolha.equalsIgnoreCase("sim")) {
	        String aux = JOptionPane.showInputDialog("Insira o código de validação:");
	        if (!aux.isEmpty()) {
	            setComprovanteAjuda(Integer.parseInt(aux));
	        } else {
	            setComprovanteAjuda(0); // Se o usuário não digitar nada, setComprovanteAjuda(0)
	        }

	        // Verifique se o código do comprovante é válido
	        if (getComprovanteAjuda() == 99880) {
	            int pontosDaAjuda = 100;

	            // Pergunta para o numeroVerificacao (opcional)
	            aux = JOptionPane.showInputDialog("Insira agora o numero de Verificacao da sua conta (opcional):");

	            // Verificação se o usuário digitou algo
	            if (!aux.isEmpty()) {
	                // Se digitou algo, converta para int. Caso contrário, mantenha 0.
	                numeroVerificacao = aux.trim().isEmpty() ? 0 : Integer.parseInt(aux);
	            }
	            // Verificação do numeroVerificacao (opcional)
	            if (numeroVerificacao == 97758) {
	                pontosDaAjuda *= 2; // Duplica pontos apenas se numeroVerificacao correto
	            }

	            // Atualizar pontos totais
	            totalPontos += pontosDaAjuda;
	            super.setPontos(totalPontos);

	            // Mensagem de feedback
	            JOptionPane.showMessageDialog(null, "Você conseguiu mais " + pontosDaAjuda + "\n"
	                    + " pontos por ter ajudado!");
	        }
	        escolha = JOptionPane.showInputDialog("Deseja inserir outro código de comprovante de ajuda?");
	    }
	    // Retorne o valor de pontos modificado
	    return super.getPontos();
	}

}
