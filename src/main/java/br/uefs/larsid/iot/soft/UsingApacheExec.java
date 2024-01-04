package br.uefs.larsid.iot.soft;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;

public class UsingApacheExec {

  public static void main(String[] args) {
    List<Float> nodesCredibility = new ArrayList<>();

    nodesCredibility.add((float) 0.51720076);
    nodesCredibility.add((float) 0.8750231);
    nodesCredibility.add((float) 0.59633187);
    nodesCredibility.add((float) 0.98066132);
    nodesCredibility.add((float) 0.70062445);
    nodesCredibility.add((float) 0.54810414);
    nodesCredibility.add((float) 0.74329332);
    nodesCredibility.add((float) 0.01303828);

    String nodesCredibilityString = nodesCredibility.toString();


    // String line = "python src/main/java/br/uefs/larsid/iot/soft/scriptParams.py 5 2";
    String line = String.format("python src/main/java/br/uefs/larsid/iot/soft/scriptArrayArg.py '%s'", nodesCredibilityString);

    CommandLine cmdLine = CommandLine.parse(line);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

    DefaultExecutor executor = new DefaultExecutor();
    executor.setStreamHandler(streamHandler);

    try {
      int exitCode = executor.execute(cmdLine);

      if (exitCode == 0) {
        System.out.println(outputStream.toString());

        String output = outputStream.toString();
        /* Sanitizando a lista */
        output = output.substring(1, output.length() - 2);
        
        System.out.println(output);

        /* Convertendo a saída String em uma lista de Floats*/
        List<String> stringList = new ArrayList<String>(Arrays.asList(output.split(",")));
        List<Float> floats = stringList.stream().map(Float::valueOf).collect(Collectors.toList());

        System.out.println(floats.toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
