package br.com.fiap.main;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import br.com.fiap.bean.Cadastro;

public class Teste {

    public static void main(String[] args) {

        Cadastro p1 = new Cadastro();
        String nome, cpf, user, email, senha, telefone, dataNasc, aux;
        LocalDate minhaData;

        try {
            nome = JOptionPane.showInputDialog("Digite seu nome:");
            p1.setNome(nome);
            cpf = JOptionPane.showInputDialog("Digite seu cpf:");
            p1.setCpf(cpf);
            user = JOptionPane.showInputDialog("Escolha um nome de usuário:");
            p1.setUser(user);
            email = JOptionPane.showInputDialog("Digite seu email para receber novidades:");
            p1.setEmail(email);
            telefone = JOptionPane.showInputDialog("Digite seu telefone para receber novidades:");
            p1.setTelefone(telefone);
            senha = JOptionPane.showInputDialog("Digite uma senha:");
            p1.setSenha(senha);

            aux = JOptionPane.showInputDialog("Digite sua data de Nascimento:");
            dataNasc = aux.substring(6, 10);
            dataNasc += "-" + aux.substring(3, 5);
            dataNasc += "-" + aux.substring(0, 2);

            minhaData = LocalDate.parse(dataNasc);
            p1.setDataNascimento(minhaData);

            JOptionPane.showMessageDialog(null, "Dados Pessoais: "
                    + "\nNome: " + p1.getNome()
                    + "\ncpf: " + p1.getCpf()
                    + "\nuser: " + p1.getUser()
                    + "\nIdade: " + p1.calculaIdade() + " anos");
            JOptionPane.showMessageDialog(null, "Parabéns, você conseguiu " + p1.calculaPontos() + " pontos\n"
            		+ "por ter cadastrado seu email e/ou telefone!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}