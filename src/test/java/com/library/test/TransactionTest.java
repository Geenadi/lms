package com.library.test;

import com.library.dao.BookDAO;
import com.library.dao.MemberDAO;
import com.library.dao.TransactionDAO;
import com.library.model.Book;
import com.library.model.Member;
import com.library.model.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransactionTest {
    private TransactionDAO transactionDAO;
    private BookDAO bookDAO;
    private MemberDAO memberDAO;

    @Before
    public void setUp() {
        transactionDAO = new TransactionDAO();
        bookDAO = new BookDAO();
        memberDAO = new MemberDAO();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSaveTransaction() {
        Book book = new Book("Test Book", "Test Author", "Test Category");
        bookDAO.save(book);
        Member member = new Member();
        memberDAO.save(member);

        Transaction transaction = new Transaction(book, member, LocalDate.now(), LocalDate.now().plusDays(14));
        transactionDAO.save(transaction);

        Transaction savedTransaction = transactionDAO.get(transaction.getId());
        assertNotNull(savedTransaction);
        assertEquals(transaction.getBook().getId(), savedTransaction.getBook().getId());
        assertEquals(transaction.getMember().getId(), savedTransaction.getMember().getId());
    }

    @Test
    public void testUpdateTransaction() {
        Book book = new Book("Test Book", "Test Author", "Test Category");
        bookDAO.save(book);
        Member member = new Member();
        memberDAO.save(member);

        Transaction transaction = new Transaction(book, member, LocalDate.now(), LocalDate.now().plusDays(14));
        transactionDAO.save(transaction);

        transaction.setReturnDate(LocalDate.now().plusDays(1));
        transactionDAO.update(transaction);

        Transaction updatedTransaction = transactionDAO.get(transaction.getId());
        assertEquals(LocalDate.now().plusDays(1), updatedTransaction.getReturnDate());
    }

    @Test
    public void testDeleteTransaction() {
        Book book = new Book("Test Book", "Test Author", "Test Category");
        bookDAO.save(book);
        Member member = new Member();
        memberDAO.save(member);

        Transaction transaction = new Transaction(book, member, LocalDate.now(), LocalDate.now().plusDays(14));
        transactionDAO.save(transaction);

        transactionDAO.delete(transaction.getId());
        Transaction deletedTransaction = transactionDAO.get(transaction.getId());
        assertNull(deletedTransaction);
    }
}

