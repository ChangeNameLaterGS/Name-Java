package br.com.fiap.main;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import br.com.fiap.bean.Cadastro;
import br.com.fiap.bean.Login;
import br.com.fiap.bean.MaiorDeIdade;

public class Teste {

    public static void main(String[] args) {

        Cadastro cadastro = new Cadastro();
        long cpf, cpfDigitado = 0;
        int opcao;
        String nome, user, email, senha, telefone, dataNasc, aux, userDigitado = null, senhaDigitada = null;
        LocalDate minhaData;

        try {
            //Faz o cadastro do usuário e guarda na classe Cadastro
            nome = JOptionPane.showInputDialog("Digite seu nome:");
            cadastro.setNome(nome);
            
            aux = JOptionPane.showInputDialog("Digite seu cpf:");
            cpf = Long.parseLong(aux);
            cadastro.setCpf(cpf);
            
            user = JOptionPane.showInputDialog("Escolha um nome de usuário:");
            cadastro.setUser(user);
            
            email = JOptionPane.showInputDialog("Digite seu email para receber novidades:");
            cadastro.setEmail(email);
            
            telefone = JOptionPane.showInputDialog("Digite seu telefone para receber novidades:");
            cadastro.setTelefone(telefone);
            
            aux = JOptionPane.showInputDialog("Digite sua data de Nascimento:");
            dataNasc = aux.substring(6, 10);
            dataNasc += "-" + aux.substring(3, 5);
            dataNasc += "-" + aux.substring(0, 2);

            minhaData = LocalDate.parse(dataNasc);
            cadastro.setDataNascimento(minhaData);
            
            senha = JOptionPane.showInputDialog("Digite uma senha:");
            cadastro.setSenha(senha);
            
            
            // Criando um objeto Login com os dados do Cadastro
            Login login = new Login(cadastro.getUser(), cadastro.getCpf(), cadastro.getSenha());

            boolean loginValido = false;

            //Loop continuará até obter um login válido
            while (loginValido == false) {
                // Realizando o login
                aux = JOptionPane.showInputDialog("Deseja logar com User ou CPF?\n(1) User\n(2) CPF");
                opcao = Integer.parseInt(aux);

                if (opcao == 1) {
                    userDigitado = JOptionPane.showInputDialog("Digite o nome do usuário:");
                    senhaDigitada = JOptionPane.showInputDialog("Digite sua senha:");
                    loginValido = login.validaLogin(userDigitado, senhaDigitada);
                } else if (opcao == 2) {
                    aux = JOptionPane.showInputDialog("Digite o número do CPF:");
                    cpfDigitado = Long.parseLong(aux);
                    senhaDigitada = JOptionPane.showInputDialog("Digite sua senha:");
                    loginValido = login.validaLogin(cpfDigitado, senhaDigitada);
                } else {
                    JOptionPane.showMessageDialog(null, "Escolha incorreta. Tente novamente.");
                    //continue;  // Volta para o início do loop se a escolha for incorreta
                }

                if (loginValido == false) {
                    JOptionPane.showMessageDialog(null, "Login inválido. Tente novamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
                }
            }
        
        //Depois de logar mostra as informações da conta
    	JOptionPane.showMessageDialog(null, "Informações da Conta: "
                + "\nNome: " + cadastro.getNome()
                + "\nCPF: " + cadastro.getCpf()
                + "\nUser: " + cadastro.getUser()
                + "\nIdade: " + cadastro.calculaIdade() + " anos");
        JOptionPane.showMessageDialog(null, "Você conseguiu " + cadastro.calculaPontos() + " pontos por ter \n"
                + "cadastrado seu email e/ou telefone! \n"
                + "\nEmail: " + cadastro.getEmail()
                + "\nTelefone: " + cadastro.getTelefone());
        
        MaiorDeIdade maior = new MaiorDeIdade();
        
        JOptionPane.showMessageDialog(null, "Total de Pontos: " + (maior.calculaPontos() + cadastro.calculaPontos()) + " pontos!");
                
        JOptionPane.showMessageDialog(null, "Fim de programa. Volte sempre!");
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
