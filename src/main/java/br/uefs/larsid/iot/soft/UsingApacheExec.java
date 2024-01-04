package br.uefs.larsid.iot.soft;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;

public class UsingApacheExec {

  public static void main(String[] args) {
    String line = "python src/main/java/br/uefs/larsid/iot/soft/script.py";
    CommandLine cmdLine = CommandLine.parse(line);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

    DefaultExecutor executor = new DefaultExecutor();
    executor.setStreamHandler(streamHandler);

    try {
      int exitCode = executor.execute(cmdLine);
      
      if (exitCode == 0) {
        System.out.println(outputStream.toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
