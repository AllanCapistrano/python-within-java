package br.uefs.larsid.iot.soft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UsingProcessBuilder {

  public static void main(String[] args) {
    ProcessBuilder processBuilder = new ProcessBuilder("python", "src/main/java/br/uefs/larsid/iot/soft/script.py");
    processBuilder.redirectErrorStream(true);

    try {
      Process process = processBuilder.start();
      System.out.println(readInputStream(process.getInputStream()));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String readInputStream(InputStream inputStream) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }
}
