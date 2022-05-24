package br.com.credit.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

public class RechargeDTO implements Serializable {

  private static final long serialVersionUID = 2976592768861512078L;

  private UUID transactionId;
  private Integer customerId;
  private BigDecimal amount;
  private ZonedDateTime transactionData;

  public UUID getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(UUID transactionId) {
    this.transactionId = transactionId;
  }

  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public ZonedDateTime getTransactionData() {
    return transactionData;
  }

  public void setTransactionData(ZonedDateTime transactionData) {
    this.transactionData = transactionData;
  }


}
