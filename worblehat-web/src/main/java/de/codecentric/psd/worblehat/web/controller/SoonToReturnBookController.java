package de.codecentric.psd.worblehat.web.controller;

import de.codecentric.psd.worblehat.domain.Book;
import de.codecentric.psd.worblehat.domain.Borrowing;
import de.codecentric.psd.worblehat.domain.BorrowingService;
import de.codecentric.psd.worblehat.web.formdata.ReturnAllBooksFormData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller class for the WB-112
 */
@Controller
@RequestMapping("/soonReturnAllBooks")
public class SoonToReturnBookController {

    @RequestMapping(method = RequestMethod.GET)
    public String prepareView(ModelMap modelMap) {

        ReturnAllBooksFormData data = new ReturnAllBooksFormData();
        data.setEmailAddress("testy@test.me");

        List<Borrowing> borrowingList = borrowingService.borrowingsByUserOrderedByReturndate(data.getEmailAddress());
        List<Book> books = borrowingList.stream().map(b -> b.getBorrowedBook()).collect(Collectors.toList());

        modelMap.put("books", books);
        return "soonReturnAllBooks";
    }

    private BorrowingService borrowingService;

    @Autowired
    public SoonToReturnBookController(BorrowingService bookService) {
        this.borrowingService = bookService;
    }

}
