package de.codecentric.psd.worblehat.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StandardBorrowingService implements BorrowingService {

    @Override
    public List<Borrowing> borrowingsByUserOrderedByReturndate(String borrowerEmailAddress) {
        List<Borrowing> borrowingsByUser = repository.findBorrowingsByBorrowerOrderedByReturndate(borrowerEmailAddress);
        return borrowingsByUser;
    }

    private BorrowingRepository repository;

    @Autowired
    public StandardBorrowingService(BorrowingRepository repository) {
        this.repository = repository;
    }
}
