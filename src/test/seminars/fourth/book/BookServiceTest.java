package seminars.fourth.book;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {
    static Book book1;
    static Book book2;
    static List<Book> library;

    @BeforeAll
    public static void setUp() {
        book1 = new Book("1", "Ужасы", "Кинг");
        book2 = new Book("2", "Поэзия", "Пушкин");
        library = new ArrayList<>();
        library.add(book1);
        library.add(book2);
    }


    @Test
    void testFindByIdBookService() {
        BookRepository memory = mock(BookRepository.class);
        BookService bookService = new BookService(memory);
        when(memory.findById("1")).thenReturn(book1);

        Book book = bookService.findBookById("1");

        verify(memory).findById("1");
        assertThat(book).isEqualTo(book1);

        assertThat(book.getId()).isEqualTo("1");
        assertThat(book.getTitle()).isEqualTo("Ужасы");
        assertThat(book.getAuthor()).isEqualTo("Кинг");
    }

    @Test
    void testFindAllBookService() {
        BookRepository memory = mock(BookRepository.class);
        BookService bookService = new BookService(memory);
        when(memory.findAll()).thenReturn(library);

        List<Book> ourBooks = bookService.findAllBooks();

        verify(memory).findAll();
        assertThat(ourBooks).isEqualTo(library);
        assertThat(ourBooks.get(1).getId()).isEqualTo("2");
        assertThat(ourBooks.get(1).getTitle()).isEqualTo("Поэзия");
        assertThat(ourBooks.get(1).getAuthor()).isEqualTo("Пушкин");
    }

}