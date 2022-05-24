package br.com.credit.scheduler;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.jboss.logging.Logger;
import com.fasterxml.jackson.core.JsonProcessingException;
import br.com.credit.dto.RechargeDTO;
import br.com.credit.enums.CompanyEnum;
import br.com.credit.service.EventService;
import io.quarkus.scheduler.Scheduled;

@ApplicationScoped
public class EventSender {
  private static final Logger LOGGER = Logger.getLogger(EventSender.class);

  @Inject
  private EventService eventService;

  @Scheduled(every = "5s")
  public void send() {
    var random = ThreadLocalRandom.current().nextInt(1, 300);

    var dto = new RechargeDTO();
    dto.setAmount(BigDecimal.TEN);
    dto.setCustomerId(random);
    dto.setTransactionData(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")));
    dto.setTransactionId(UUID.randomUUID());

    var type = random % 2 == 1 ? CompanyEnum.COMPANY_ONE : CompanyEnum.COMPANY_TWO;

    try {
      eventService.send(dto, type);
    } catch (JsonProcessingException e) {
      LOGGER.error(e);
    }
  }
}
