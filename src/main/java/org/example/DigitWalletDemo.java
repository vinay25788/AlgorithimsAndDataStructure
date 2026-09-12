package org.example;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class DigitWalletDemo {

    public static void main(String[] args)  {
        DigitalService digitalService = DigitalService.getINSTANCE();

        Wallet wallet= digitalService.createWallet("123");
        try {
            digitalService.deposit(wallet.getId(),BigDecimal.valueOf(100));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(wallet.getBalance());
        try {
            digitalService.deposit(wallet.getId(), BigDecimal.valueOf(100));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(wallet.getBalance());
        try {

            digitalService.withDraw(wallet.getId(), BigDecimal.valueOf(-400));
        }catch (RuntimeException ex)
        {
            System.out.println(ex.getMessage());
        }

       digitalService.getHistory(wallet.getId()).forEach((k)-> System.out.println(k.getWalletId() + " "+ k.getAmount() + " "+k.getType()+" "+k.getTime()));
    }
}

class DigitalService
{
   volatile static DigitalService INSTANCE;

    static DigitalService getINSTANCE()
    {
        if(INSTANCE != null)
              return INSTANCE;

        synchronized (DigitalService.class)
        {
            if(INSTANCE == null){
                INSTANCE = new DigitalService();
            }
        }
        return INSTANCE;

    }
     ConcurrentHashMap<String, Wallet> walletMap = new ConcurrentHashMap<>();

     ConcurrentHashMap<String, ReentrantLock> lockMap = new ConcurrentHashMap<>();

     Wallet createWallet(String id)
     {
          walletMap.computeIfAbsent(id, k->new Wallet(id, BigDecimal.ZERO, new Ledger()));
          return walletMap.get(id);

     }

     public void withDraw(String walletId, BigDecimal amount) throws InsufficientBalance {

         ReentrantLock lock = lockMap.computeIfAbsent(walletId,k-> new ReentrantLock());


         try
         {
             lock.lock();
             Wallet wallet = walletMap.get(walletId);
            validateAmount(amount,wallet);
             wallet.withdraw(amount);
         }
         finally {
             lock.unlock();
         }
     }

     private void validateAmount(BigDecimal amount, Wallet wallet)
     {
         if(amount.compareTo(BigDecimal.ZERO)<=0)
             throw  new RuntimeException("Amount should be positive");
         if (wallet == null) {
             throw new RuntimeException("Wallet not found");
         }
     }

    public BigDecimal deposit(String walletId, BigDecimal amount) throws Exception {

        ReentrantLock lock = lockMap.computeIfAbsent(walletId,k-> new ReentrantLock());

        lock.lock();
        try
        {
            Wallet wallet = walletMap.get(walletId);
            validateAmount(amount,wallet);
            wallet.addDeposit(amount);
            return wallet.getBalance();
        }
        finally {
            lock.unlock();
        }
    }


    public List<Transaction> getHistory(String walletId)  {
        Wallet wallet = walletMap.get(walletId);
        if(wallet == null)
              throw new RuntimeException("Please provide the valid walletId");
        return wallet.getLedge().getTransactionList();
    }

}

final  class Wallet
{
    final private  String id;
     private  BigDecimal balance;
        private    Ledger ledge;

            Wallet(String id, BigDecimal balance, Ledger ledge)
            {
                this.id = id;
                this.balance = balance;
                this.ledge = ledge;
            }

    public BigDecimal getBalance()
    {
        return balance;
    }

    public String getId()
    {
        return this.id;
    }

    public   void addDeposit(BigDecimal amount)
    {


        Transaction transction = new Transaction(TransacitonType.CREDIT, this.id, amount);
        ledge.addTranaction(transction);
        balance = balance.add(amount);
    }

    public   void withdraw(BigDecimal amount) throws  InsufficientBalance
    {

        if(amount.compareTo(balance)>0)
            throw new InsufficientBalance("not enough balance");


        Transaction transction = new Transaction(TransacitonType.DEBIT, this.id, amount);
        ledge.addTranaction(transction);
        balance = balance.subtract(amount);
    }

    public Ledger getLedge()
    {
        return ledge;
    }
}

 class InsufficientBalance  extends RuntimeException
{
    InsufficientBalance(String msg)
    {
        super(msg);
    }
}

final class Ledger
{
    final private  List<Transaction> transactionList;
    final private  String id;

    Ledger()
    {
        id = UUID.randomUUID().toString();
        transactionList = new ArrayList<Transaction>();
    }

    public void addTranaction(Transaction transacton)
    {
        transactionList.add(transacton);
    }

    public List<Transaction> getTransactionList()
    {
        return Collections.unmodifiableList(transactionList);
    }
}

enum TransacitonType
{
    CREDIT,DEBIT;
        }

final class Transaction
{
   final private String id;
    final private TransacitonType type;
    final private BigDecimal amount;
    final private Instant time;
    final private String walletId;

    Transaction(TransacitonType type, String walletId, BigDecimal amount)
    {
        this.type = type;
        this.id = UUID.randomUUID().toString();
        this.walletId = walletId;
        this.amount = amount;
        time =Instant.now();
    }

    public String getId() {
        return id;
    }

    public TransacitonType getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Instant getTime() {
        return time;
    }

    public String getWalletId() {
        return walletId;
    }
}