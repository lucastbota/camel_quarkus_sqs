package br.com.credit.listener;

import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Acknowledgment;
import org.eclipse.microprofile.reactive.messaging.Acknowledgment.Strategy;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

@ApplicationScoped
public class CreditOneListener {
  private static final Logger LOGGER = Logger.getLogger(CreditOneListener.class);

  @Incoming("company-one")
  @Acknowledgment(Strategy.POST_PROCESSING)
  public void listenToCreditRecharge(String snsTopic) {
    LOGGER.infov("Company one will recharge: {0}", snsTopic);
  }
}
