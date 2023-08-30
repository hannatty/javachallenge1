package model;

import java.util.Date;

import utils.DataUtil;

public class SavingAccount extends Account {
  public SavingAccount(String agency, String accountNumber, Integer digit, Double openingBalance){
    super(agency, accountNumber, digit, openingBalance);
  }

 @Override
  public void printTransaction() {
    System.out.println();
    System.out.println("****EXTRATO CONTA POUPANÇA****");
    System.out.println("***********************************");
    System.out.println("Gerado em: " + DataUtil.formatDate(new Date()));
    System.out.println();

    //Para cada transação dentro de transações, imprima informação
    for (Transaction transaction: this.transactions) {
      System.out.println(transaction);
      System.out.println();
    
    }
    System.out.println();
    System.out.println("***********************************");
  }  
  
}
