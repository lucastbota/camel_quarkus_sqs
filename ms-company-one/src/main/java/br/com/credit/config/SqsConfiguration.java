package br.com.credit.config;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import io.quarkus.arc.Unremovable;
import software.amazon.awssdk.services.sqs.SqsClient;

@ApplicationScoped
@Unremovable
public class SqsConfiguration {

  @Inject
  SqsClient sqsClient;
}
