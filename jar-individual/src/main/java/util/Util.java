package util;

public class Util {
    
    public void imprimirLogin(){
        System.out.println("-- Aplicação Java AutoTech --"
                + "\n\nInsira o seu Login: ");
    }
    
    public void imprimirSenha(){
        System.out.println("Insira a sua Senha: ");
    }
    
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
