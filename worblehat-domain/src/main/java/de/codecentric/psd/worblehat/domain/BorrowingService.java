package de.codecentric.psd.worblehat.domain;

import java.util.List;

public interface BorrowingService {
    List<Borrowing> borrowingsByUserOrderedByReturndate(String borrowerEmailAddress);
}
