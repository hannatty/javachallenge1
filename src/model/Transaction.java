package model;

import java.util.Date;

import utils.DataUtil;

public class Transaction {
  private String description;
  private Date transactionDate;
  private Double value;

  public Transaction(){}
  public Transaction(String description, Double value){
    this.description = description;
    this.value = value;
    this.transactionDate = new Date();
  }
  

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getTransactionDate() {
    return transactionDate;
  }

  public Double getValue() {
    return value;
  }


  @Override
  public String toString(){
    String formatedDate = DataUtil.formatDate(transactionDate);
    return 
    formatedDate + " - " + this.getDescription() + " - R$:" + this.getValue();
  }

}
