package seminars.fourth.book;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Java6Assertions.*;

public class BookTest {
    Book book;

    @BeforeEach
    void setUp () {
        book = new Book("1", "Story", "Writer");
    }

    @Test
    void checkSetterId() {
        book.setId("2");
        assertThat(book.getId()).isEqualTo("2");
    }
    @Test
    void checkSetterTitle() {
        book.setTitle("Letter");
        assertThat(book.getTitle()).isEqualTo("Letter");
    }

    @Test
    void checkSetterAuthor() {
        book.setAuthor("Novelist");
        assertThat(book.getAuthor()).isEqualTo("Novelist");
    }

    @Test
    void checkBookIdConstructor() {
        Book book1 = new Book("10");
        assertThat(book1.getId()).isEqualTo("10");
        assertThat(book1.getAuthor()).isEqualTo(null);
        assertThat(book1.getTitle()).isEqualTo(null);
    }

}
