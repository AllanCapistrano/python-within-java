package br.uefs.larsid.iot.soft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UsingProcessBuilder {

  public static void main(String[] args) {
    // String fileContent = PythonHandler.lerArquivo(
    //   "src/main/java/br/uefs/larsid/iot/soft/script.py"
    // );
    // System.out.println(fileContent);

    ProcessBuilder processBuilder = new ProcessBuilder("python", "src/main/java/br/uefs/larsid/iot/soft/script.py");
    processBuilder.redirectErrorStream(true);

    try {
      Process process = processBuilder.start();
      System.out.println(lerInputStream(process.getInputStream()));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    // List<String> results = readProcessOutput(process.getInputStream());
  }

  public static String lerInputStream(InputStream inputStream) {
        StringBuilder conteudo = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String linha;

            // Use o BufferedReader para ler o conteúdo do InputStream linha por linha
            while ((linha = reader.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
        } catch (IOException e) {
            // Trate a exceção se houver um erro de leitura
            e.printStackTrace();
        }

        // Retorne a String contendo o conteúdo lido do InputStream
        return conteudo.toString();
    }
}
