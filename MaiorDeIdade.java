package br.com.fiap.bean;

import javax.swing.JOptionPane;

public class MaiorDeIdade extends Cadastro{

	private int comprovanteAjuda ;
	
	
	// Construtores
    public MaiorDeIdade() {}

    public MaiorDeIdade(int comprovanteAjuda) {
        this.comprovanteAjuda = comprovanteAjuda;
    }


    //gets e sets

	public int getComprovanteAjuda() {
		return comprovanteAjuda;
	}

	public void setComprovanteAjuda(int comprovanteAjuda) {
		this.comprovanteAjuda = comprovanteAjuda;
	}

	//método com sobrescrita
	public int calculaPontos() {

		// Variável para armazenar o total de pontos
	    int totalPontos = 0;
	    
	    // Crie uma variável para armazenar o código de validação
	    String escolha = JOptionPane.showInputDialog("Deseja inserir código de comprovante de ajuda?");
	    while (escolha.equalsIgnoreCase("sim")) {
			String aux = JOptionPane.showInputDialog("Insira o código de validação:");
		    int codigoValidacao = Integer.parseInt(aux);
	
		    // Verifique se o código de validação foi inserido
		    if (codigoValidacao == 99880) {
		        int pontosDaAjuda = (int)(Math.random() * 101);
		     // Adicione os pontos ganhos ao total
                totalPontos += pontosDaAjuda;
		        super.setPontos(totalPontos);
		        JOptionPane.showMessageDialog(null, "Você conseguiu mais " + pontosDaAjuda + "\n"
		                + " pontos por ter ajudado!");
		    } else {
		        // Código inválido, exiba mensagem de erro e retorne 0 pontos
		        JOptionPane.showMessageDialog(null, "Código de validação inválido!");
		        return 0;
		    }
		    escolha = JOptionPane.showInputDialog("Deseja inserir outro código de comprovante de ajuda?");
		}
		// Retorne o valor de pontos modificado
		    return super.getPontos();
	}


}
