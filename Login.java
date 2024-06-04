package br.com.fiap.bean;

public class Login extends Cadastro {

    // Construtores
    public Login() {}

    public Login(String user, long cpf, String senha) {
        super.setUser(user);
        super.setCpf(cpf);
        super.setSenha(senha);
    }
    
    //Sobrecarga de métodos
    
    // Método para validar login usando o usuário
    public boolean validaLogin(String user, String senha) {
        if (super.getUser().equals(user) && super.getSenha().equals(senha)) {
            return true; // Login válido
        } else {;
            return false; // Login inválido
        }
    }

    // Método para validar login usando o CPF
    public boolean validaLogin(long cpf, String senha) {
        if (super.getCpf() == cpf && super.getSenha().equals(senha)) {
            return true; // Login válido
        } else {;
            return false; // Login inválido
        }
    }

}
