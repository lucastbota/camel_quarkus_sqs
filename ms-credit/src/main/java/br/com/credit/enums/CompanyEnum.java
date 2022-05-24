package br.com.credit.enums;

public enum CompanyEnum {
  COMPANY_ONE("O"), COMPANY_TWO("T");

  CompanyEnum(String acronym) {
    this.acronym = acronym;
  }

  private final String acronym;

  public String getAcronym() {
    return this.acronym;
  }
}
