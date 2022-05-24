package br.com.credit.listener;

import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Acknowledgment;
import org.eclipse.microprofile.reactive.messaging.Acknowledgment.Strategy;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

@ApplicationScoped
public class CreditTwoListener {
  private static final Logger LOGGER = Logger.getLogger(CreditTwoListener.class);

  @Incoming("company-two")
  @Acknowledgment(Strategy.POST_PROCESSING)
  public void listenToRechar(String snsTopic) {
    LOGGER.infov("Company two will recharge: {0}", snsTopic);
  }
}
