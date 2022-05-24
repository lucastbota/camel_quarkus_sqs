package br.com.credit;

import org.apache.camel.quarkus.main.CamelMainApplication;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class ApplicationOneMain {

  public static void main(String... strings) {
    Quarkus.run(CamelMainApplication.class, strings);
  }
}
