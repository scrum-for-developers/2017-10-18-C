package de.codecentric.psd.worblehat.web.controller;

import de.codecentric.psd.worblehat.domain.BookService;
import de.codecentric.psd.worblehat.domain.BorrowingService;
import de.codecentric.psd.worblehat.web.formdata.ReturnAllBooksFormData;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.mock;

public class SoonToReturnBookControllerTest {

    @Test
    public void shouldSetupForm() throws Exception {
        ModelMap modelMap = new ModelMap();
        returnAllBooksController.prepareView(modelMap);

        assertThat(modelMap.get("returnAllBookFormData"), is(not(nullValue())));
    }

    @Before
    public void setUp() throws Exception {
        bookService = mock(BorrowingService.class);
        returnAllBooksController = new SoonToReturnBookController(bookService);
        returnAllBooksFormData = new ReturnAllBooksFormData();
        bindingResult = new MapBindingResult(new HashMap<>(), "");
    }

    private SoonToReturnBookController returnAllBooksController;

    private BorrowingService bookService;

    private ReturnAllBooksFormData returnAllBooksFormData;

    private BindingResult bindingResult;
}
