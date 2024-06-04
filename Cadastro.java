package br.com.fiap.bean;

import java.time.LocalDate;
import java.time.Period;

import javax.swing.JOptionPane;

public class Cadastro {

    private String nome, user, email, senha, telefone;
    private long cpf;
    private LocalDate dataNascimento;
    private int pontos = 0;
    		
    public Cadastro() {}

    public Cadastro(String nome, long cpf, String user, String email, String senha, String telefone, LocalDate dataNascimento, int pontos) {
        this.nome = nome;
        setCpf(cpf);
        this.user = user;
        this.email = email;
        setSenha(senha);
        this.telefone = telefone;
        setDataNascimento(dataNascimento);
        this.pontos = pontos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        try {
        	if (String.valueOf(cpf).length() == 11) {
        		this.cpf = cpf;
        	} else {
        		throw new Exception("CPF inválido! (O CPF deve possuir 11 dígitos!)");
        	}
        }catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(0); //Encerra o programa após o erro
		}
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        try{
        	if (senha.length() >= 8) {
        		this.senha = senha;
        	} else {
        		throw new Exception("Senha inválida! (Por segurança, a senha deve possuir no mínimo 8 dígitos!)");}
        }catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(0); //Encerra o programa após o erro
		}
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        LocalDate limite = LocalDate.parse("1899-12-31");
        LocalDate atual = LocalDate.now();
        try {
	        if (dataNascimento.isAfter(limite) && dataNascimento.isBefore(atual)) {
	            this.dataNascimento = dataNascimento;
	        } else {
	            JOptionPane.showMessageDialog(null, "Data Fora da faixa permitida");
	            System.exit(0); // Encerra o programa após o erro
	        }
        }catch(Exception e){
        	JOptionPane.showMessageDialog(null, e.getMessage());
    		System.exit(0); //Encerra o programa após o erro
        }
    }
    
    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    // Métodos
    public int calculaIdade() {
        LocalDate dataAtual = LocalDate.now();
        Period idade = Period.between(dataNascimento, dataAtual);
        return idade.getYears();
    }

    public int calculaPontos() {
        // Verifica se o email foi inserido
        if (email.length() > 0) {
            setPontos(100);
        }

        // Verifica se o número de telefone foi inserido
        if (telefone.length() > 0) {
            if (telefone.length() == 9) {
            	setPontos(100);
            } else {
                JOptionPane.showMessageDialog(null, "Número inválido! O telefone deve possuir 9 dígitos!");
            }
        }

        // Multiplica os pontos por 2 se ambos os campos foram preenchidos
        if (email.length() > 0 && telefone.length() > 0) {
            if (telefone.length() == 9) {
            	setPontos(300);
            }
        }

        return pontos;
    }

}
