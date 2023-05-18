package application;

import java.util.Scanner;
import java.util.Timer;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.TimerTask;
import api.LoocaApi;
import api.SlackApi;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import sql.ConexaoAzure;
import sql.ConexaoMySql;
import util.Log;
import util.Util;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ApplicationAutoTech {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Boolean loginConfirmado = false;
        Util util = new Util();
        ConexaoAzure isExists = new ConexaoAzure();
        ConexaoMySql mysql = new ConexaoMySql();
        String login;
        String senha;
        LoocaApi loocaApi = new LoocaApi();
        
        
        int MAX_FILE_SIZE = 1000000; // Tamanho máximo do arquivo em bytes
        String LOG_DIRECTORY = "/home/nathan/Imagens"; // Diretório de logs
        String LOG_FILE_PREFIX = "logs"; // Prefixo do nome do arquivo de log
        String LOG_FILE_EXTENSION = ".txt"; // Extensão do arquivo de log
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // Formato da data/hora para o log
    
        Log log = new Log();
        String timestamp = dateFormat.format(new Date());
        String fileName = log.getLogFileName(LOG_DIRECTORY, LOG_FILE_PREFIX, LOG_FILE_EXTENSION);
        log.log(Log.LogLevel.START, "Autotech Log " + timestamp, fileName);
        log.log(Log.LogLevel.INFO, "\n" + loocaApi.getSistemaInfo(), fileName);
        
        while(!loginConfirmado){
            util.imprimirLogin();
            login = leitor.nextLine();
            util.imprimirSenha();
            senha = leitor.nextLine();
            
            loginConfirmado = isExists.verificarLogin(login, senha);
            
            if(loginConfirmado){
                System.out.println("Login Realizado com sucesso!");
                log.log(Log.LogLevel.INFO, "Login do usuário " + login + " realizado com sucesso!", fileName);
            }else{
                System.out.println("Login ou senha inválido");
                log.log(Log.LogLevel.ERROR, "Falha ao realizar login!", fileName);
            }
        }
        
        isExists.getInfoComponentes();
        
        util.clearScreen();
        
        System.out.println("-- Aplicação Java AutoTech --");
        System.out.println("Iniciando capturas de dados...");
        
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                util.clearScreen();

                System.out.println("-- Aplicação Java AutoTech --");
                
                System.out.println(String.format("\nPorcentagem de Uso CPU: %.2f", loocaApi.getCpu()));
                System.out.println(String.format("\nPorcentagem de Uso Memória Ram: %.2f", loocaApi.getMemoria()));
                System.out.println(String.format("\nPorcentagem de Uso Disco: %.2f", loocaApi.getDisco()));

                isExists.setRegistros(loocaApi.getCpu(), loocaApi.getMemoria(), loocaApi.getDisco());
                mysql.setRegistro(loocaApi.getCpu(), loocaApi.getMemoria(), loocaApi.getDisco());
                
                if(loocaApi.getMemoria() > 80.0){
                    System.out.println("\nAlerta: Porcentagem de uso da memória ram está muito alto!"
                            + "\nLimpeza está sendo iniciada...");
                    
                }
                
                if(loocaApi.getMemoria() > 80.0 || loocaApi.getCpu() > 80.0 || loocaApi.getDisco() > 80.0){
                    JSONObject json = new JSONObject();
                    String nomeCliente = isExists.getUser().getNome();
                    
                    if(loocaApi.getCpu() > 80.0){
                        json.put("text", nomeCliente + ", o limite de 80% de uso da cpu foi atingido!");
                        log.log(Log.LogLevel.WARNING, "Limite de 80% de uso da cpu foi atingido!", fileName);
                    }
                    
                    if(loocaApi.getMemoria() > 80.0){
                        json.put("text", nomeCliente + ", o limite de 80% de uso da memória foi atingido!");
                        log.log(Log.LogLevel.WARNING, "Limite de 80% de uso da memória foi atingido!", fileName);
                    }
                    
                    if(loocaApi.getDisco() > 80.0){
                        json.put("text", nomeCliente + ", o limite de 80% de uso do disco foi atingido!");
                        log.log(Log.LogLevel.WARNING, "Limite de 80% de uso da disco foi atingido!", fileName);
                    }
                    
                    try {
                        SlackApi.sendMessage(json);
                    } catch (IOException ex) {
                        Logger.getLogger(ApplicationAutoTech.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ApplicationAutoTech.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                }
                   
            }
        }, 0, 5000);
        
    }
}
