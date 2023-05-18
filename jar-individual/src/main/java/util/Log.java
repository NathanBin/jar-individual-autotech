package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Log {
    private static final int MAX_FILE_SIZE = 1000000; // Tamanho máximo do arquivo em bytes
    private static final String LOG_DIRECTORY = "/home/nathan/Imagens"; // Diretório de logs
    private static final String LOG_FILE_PREFIX = "logs"; // Prefixo do nome do arquivo de log
    private static final String LOG_FILE_EXTENSION = ".txt"; // Extensão do arquivo de log

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // Formato da data/hora para o log
    
    // O método Log recebe o nível de Log (LogLevel) e a mensagem a ser registrada:
    public enum LogLevel {
        DEBUG, INFO, WARNING, ERROR, START
    }

    // O método Log gera uma linha de log formatada usando o método (GetLogFileName) e a grava no arquivo de log atual
    public String getLogFileName(String directory, String prefix, String extension) {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        //return LOG_DIRECTORY + LOG_FILE_PREFIX + timestamp + LOG_FILE_EXTENSION;
        return directory + prefix + "log" + extension;
    }

    public String getLogLine(LogLevel level, String message) {
        String timestamp = dateFormat.format(new Date());
        return "[" + timestamp + "] [" + level + "] " + message;
    }

    public void log(LogLevel level, String message, String fileName) {
        String logLine = getLogLine(level, message);

        // Verifica se o arquivo de log atual está muito grande
        String currentLogFileName = fileName;
        File currentLogFile = new File(currentLogFileName);
        if (currentLogFile.exists() && currentLogFile.length() > MAX_FILE_SIZE) {
            currentLogFileName = fileName;
            currentLogFile = new File(currentLogFileName);
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(currentLogFile, true))) {
            out.println(logLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/*
    public  void main(String[] args) {
        String timestamp = dateFormat.format(new Date());
        log(LogLevel.START, "AutoTech Log " + timestamp);
        
        // Exemplo de uso
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                log(LogLevel.INFO, "Esta é uma mensagem de informação.");
                log(LogLevel.ERROR, "Ocorreu um erro.");
            }
        }, 0, 5000);
    }
*/
}
