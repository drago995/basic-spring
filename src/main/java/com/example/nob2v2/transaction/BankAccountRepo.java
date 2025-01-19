package com.example.nob2v2.transaction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepo extends JpaRepository<BankAccount, String> {
}
