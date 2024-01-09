package br.uefs.larsid.iot.soft;

import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

/**
 * Hello world!
 *
 */
public class UsingJython {

  public static void main(String[] args) {
    try (PythonInterpreter pyInterp = new PythonInterpreter()) {
      pyInterp.exec("print('Hello World')");
      pyInterp.exec("import sys");
      pyInterp.exec("print sys");
      pyInterp.set("a", new PyInteger(42));
      pyInterp.exec("print a");
      pyInterp.exec("x = 2+2");
      PyObject x = pyInterp.get("x");
      System.out.println("x: " + x);
    }
  }
}
