package io.redutan.springboot.inaction.book;

import io.redutan.springboot.inaction.reader.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadingListRepository extends JpaRepository<Book, Integer> {
    List<Book> findByReader(Reader reader);
}
