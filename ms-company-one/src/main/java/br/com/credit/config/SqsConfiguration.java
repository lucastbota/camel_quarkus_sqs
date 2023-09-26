package br.com.credit.config;

import io.quarkus.arc.Unremovable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import software.amazon.awssdk.services.sqs.SqsClient;

@ApplicationScoped
@Unremovable
public class SqsConfiguration {

  @Inject
  SqsClient sqsClient;
}
