package br.com.credit.service.sns;

import java.util.Map;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.credit.dto.RechargeDTO;
import br.com.credit.enums.CompanyEnum;
import br.com.credit.service.EventService;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.MessageAttributeValue;

@Dependent
public class SnsEventService implements EventService {
  private static final Logger LOGGER = Logger.getLogger(SnsEventService.class);
  private final SnsClient snsClient;
  private final ObjectMapper objectMapper;
  private final String topicArn;

  @Inject
  public SnsEventService(SnsClient snsClient, ObjectMapper objectMapper,
      @ConfigProperty(name = "credit.topic.arn") String topicArn) {
    this.snsClient = snsClient;
    this.objectMapper = objectMapper;
    this.topicArn = topicArn;
  }

  @Override
  public void send(RechargeDTO rechargeDTO, CompanyEnum typeEnum) throws JsonProcessingException  {
    var message = objectMapper.writeValueAsString(rechargeDTO);
    var response = snsClient
        .publish(
            t -> t.message(message).topicArn(topicArn)
                .messageAttributes(Map.of("company",
                    MessageAttributeValue.builder()
                        .stringValue(typeEnum.getAcronym())
                        .build()))
                .build());
    
    LOGGER.infof("Response: %s", response.messageId());
  }
}
