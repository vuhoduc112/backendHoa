package com.example.hoa.Controller;

import com.example.hoa.Entity.Transaction;
import com.example.hoa.Service.TransactionService;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok().body(transactions);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        Optional<Transaction> transaction = transactionService.getTransactionById(id);
        return transaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction createdTransaction = transactionService.createTransaction(transaction);
        return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction transaction, @PathVariable Long id) {
        Transaction updatedTransaction = transactionService.updateTransaction(transaction, id);
        if (updatedTransaction != null) {
            return ResponseEntity.ok().body(updatedTransaction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/createPayment")
    public ResponseEntity<Payment> createPayment(
            @RequestParam Double total,
            @RequestParam String currency,
            @RequestParam String method,
            @RequestParam String intent,
            @RequestParam String description,
            @RequestParam String cancelUrl,
            @RequestParam String successUrl) {
        try {
            Payment payment = transactionService.createPayment(total, currency, method, intent, description, cancelUrl, successUrl);
            return new ResponseEntity<>(payment, HttpStatus.CREATED);
        } catch (PayPalRESTException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/executePayment")
    public ResponseEntity<Payment> executePayment(@RequestParam String paymentId, @RequestParam String payerId) {
        try {
            Payment payment = transactionService.executePayment(paymentId, payerId);
            return new ResponseEntity<>(payment, HttpStatus.OK);
        } catch (PayPalRESTException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
