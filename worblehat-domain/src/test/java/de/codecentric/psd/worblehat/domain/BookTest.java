package de.codecentric.psd.worblehat.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class BookTest {

    private static final String TITLE = "title";

    private static final String AUTHOR = "author";

    private static final String EDITION = "2";

    private static final String ISBN = "isbn";

    private static final String DESCRIPTION = "description";

    private static final int YEAR_OF_PUBLICATION = 2016;

    private Book demoBook;

    private Book createDemoBook() {
        return new Book(TITLE, AUTHOR, EDITION, ISBN, YEAR_OF_PUBLICATION, DESCRIPTION);
    }

    @Before
    public void setUp() throws Exception {
        demoBook = createDemoBook();
    }

    @Test
    public void testConstructorTakesAllArguments() throws Exception {
        assertNotNull(demoBook);
    }

    @Test
    public void testBookHasDescription() throws Exception {
        String title = demoBook.getDescription();
        assertThat(title, is(DESCRIPTION));
    }

    @Test
    public void shouldTakeDescription() throws Exception {
        String expectedDescription = "A new Description";
        demoBook.setDescription(expectedDescription);
        String actualDescription = demoBook.getDescription();
        assertThat(actualDescription, is(expectedDescription));
    }
}
