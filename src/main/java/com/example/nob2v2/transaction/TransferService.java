package com.example.nob2v2.transaction;

import com.example.nob2v2.Command;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class TransferService implements Command<TransferDTO, String> {
    private final BankAccountRepo bankAccountRepo;

    public TransferService(BankAccountRepo bankAccountRepo) {
        this.bankAccountRepo = bankAccountRepo;
    }

    @Override
    public ResponseEntity<String> execute(TransferDTO transfer) {
        Optional<BankAccount> fromAccount = bankAccountRepo.findById(transfer.getFromUser());
        Optional<BankAccount> toAccount = bankAccountRepo.findById(transfer.getToUser());

        if(fromAccount.isEmpty() || toAccount.isEmpty()){
            throw new RuntimeException("User not found");

        }

        BankAccount from = fromAccount.get();
        BankAccount to = toAccount.get();

        add(to , transfer.getAmount());
        System.out.println("After adding, before deducting");
        System.out.println(bankAccountRepo.findById(to.getName()));
        deduct(from, transfer.getAmount());


        return ResponseEntity.ok("Success");


    }

    private void deduct(BankAccount bankAccount, double amount){
        if(bankAccount.getBalance() < amount){
            throw new RuntimeException("not enough money"); // must be a runtime exception
        }
        bankAccount.setBalance(bankAccount.getBalance() - amount);
    }

    private void add(BankAccount bankAccount, double amount){
        bankAccount.setBalance(bankAccount.getBalance() + amount);

    }
}
