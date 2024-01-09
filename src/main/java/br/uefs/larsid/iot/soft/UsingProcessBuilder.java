package br.uefs.larsid.iot.soft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UsingProcessBuilder {

  public static void main(String[] args) {
    List<Float> nodesCredibility = new ArrayList<>();

    nodesCredibility.add((float) 0.28183499);
    nodesCredibility.add((float) 0.38471779);
    nodesCredibility.add((float) 0.30450052);
    nodesCredibility.add((float) 0.35634024);
    nodesCredibility.add((float) 0.88328644);
    nodesCredibility.add((float) 0.96039498);
    nodesCredibility.add((float) 0.39787825);
    nodesCredibility.add((float) 0.87692179);
    nodesCredibility.add((float) 0.80777235);
    nodesCredibility.add((float) 0.11998001);
    nodesCredibility.add((float) 0.84409202);
    nodesCredibility.add((float) 0.94645712);
    nodesCredibility.add((float) 0.68551824);
    nodesCredibility.add((float) 0.31924441);
    nodesCredibility.add((float) 0.2864198);
    nodesCredibility.add((float) 0.18014661);
    nodesCredibility.add((float) 0.55712999);
    nodesCredibility.add((float) 0.84816832);
    nodesCredibility.add((float) 0.22157936);
    nodesCredibility.add((float) 0.64935416);
    nodesCredibility.add((float) 0.46825506);
    nodesCredibility.add((float) 0.66246562);
    nodesCredibility.add((float) 0.47541294);

    String nodesCredibilityString = nodesCredibility.toString();

    // ProcessBuilder processBuilder = new ProcessBuilder("python", "src/main/java/br/uefs/larsid/iot/soft/script.py");
    ProcessBuilder processBuilder = new ProcessBuilder(
      "python",
      "src/main/java/br/uefs/larsid/iot/soft/scriptArrayArg.py",
      nodesCredibilityString
    );
    processBuilder.redirectErrorStream(true);

    try {
      Process process = processBuilder.start();
      String output = readInputStream(process.getInputStream());

      /* Sanitizando a lista */
      output = output.substring(1, output.length() - 2);
      System.out.println(output);

      /* Convertendo a saída String em uma lista de Floats*/
      List<String> stringList = new ArrayList<String>(
        Arrays.asList(output.split(","))
      );
      List<Float> floats = stringList
        .stream()
        .map(Float::valueOf)
        .collect(Collectors.toList());

      System.out.println(floats.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String readInputStream(InputStream inputStream) {
    StringBuilder content = new StringBuilder();

    try (
      BufferedReader reader = new BufferedReader(
        new InputStreamReader(inputStream)
      )
    ) {
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
