package seminars.fourth.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class InMemoryBookRepositoryTest {

    InMemoryBookRepository inMemory;

    @BeforeEach
    void setUp () {
        inMemory = new InMemoryBookRepository();
    }

    @Test
    void checkfindByIdInMemoryBookRepositoryGetId() {

        String one = inMemory.findById("1").getId();
        assertThat(one).isEqualTo("1");

    }

    @Test
    void checkfindByIdInMemoryBookRepositoryGetTitle() {

        String one = inMemory.findById("1").getTitle();
        assertThat(one).isEqualTo("Book1");

    }

    @Test
    void checkfindByIdInMemoryBookRepositoryGetAuthor() {

        String one = inMemory.findById("1").getAuthor();
        assertThat(one).isEqualTo("Author1");

    }

    @Test
    void checkFindAllInMemoryBookRepositorySize() {

        List<Book> ourBooks = inMemory.findAll();
        assertThat(ourBooks).isNotEmpty().hasSize(2);
    }
}
