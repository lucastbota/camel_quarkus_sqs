package br.com.credit;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class ApplicationProducerMain {

  public static void main(String... strings) {
    Quarkus.run(strings);
  }
}
