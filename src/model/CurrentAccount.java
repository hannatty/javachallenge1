package model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import interfaces.Pix;
import utils.DataUtil;

public class CurrentAccount extends Account implements Pix{

   // Lista para armazenar as chaves PIX do usuário
   private List<String> userKeys = new ArrayList<>();

  public CurrentAccount(String agency, String accountNumber, Integer digit, Double openingBalance){
    super(agency, accountNumber, digit, openingBalance);
  }

  @Override
  public void printTransaction() {
    System.out.println("***********************************");
    System.out.println("*******EXTRATO CONTA CORRENTE******");
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

  //#region Pix Methods
 
  @Override
  public void registerKey(String key) {
      // Verifica se a chave já está registrada antes de adicioná-la à lista
      if (!userKeys.contains(key)) {
          userKeys.add(key);
          System.out.println("Chave registrada com sucesso!");
      } else {
          System.out.println("Esta chave já está registrada!");
      }
  }


  @Override
  public void showUserKeys() {
      if (!userKeys.isEmpty()) {
          System.out.println("Chaves PIX registradas pelo usuário:");
          for (String key : userKeys) {
              System.out.println(key);
          }
      } else {
          System.out.println("Nenhuma chave PIX registrada ainda.");
      }
  }
  //#endregion
}