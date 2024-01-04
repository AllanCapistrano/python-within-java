package br.uefs.larsid.iot.soft;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PythonHandler {
  // private final String filePath;


  // public PythonHandler(String filePath) {
  //   this.filePath = filePath;
  // }

  public static String lerArquivo(String caminho) {
    StringBuilder conteudo = new StringBuilder();

    try {
      // Crie um objeto Scanner para ler o arquivo
      Scanner scanner = new Scanner(new File(caminho));

      // Use o Scanner para ler o conteúdo do arquivo linha por linha
      while (scanner.hasNextLine()) {
        conteudo.append(scanner.nextLine()).append("\n");
      }

      // Feche o Scanner para liberar os recursos
      scanner.close();
    } catch (FileNotFoundException e) {
      // Trate a exceção se o arquivo não for encontrado
      System.err.println("Arquivo não encontrado: " + caminho);
      e.printStackTrace();
    }

    // Retorne a String contendo o conteúdo do arquivo
    return conteudo.toString();
  }
}
