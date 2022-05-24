package br.com.credit.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import br.com.credit.dto.RechargeDTO;
import br.com.credit.enums.CompanyEnum;

public interface EventService {

  void send(RechargeDTO rechargeDTO, CompanyEnum typeEnum) throws JsonProcessingException ;
}
