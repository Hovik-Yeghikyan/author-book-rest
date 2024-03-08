package am.itspace.authorbookrest.service;

import am.itspace.authorbookrest.dto.BookDto;
import am.itspace.authorbookrest.dto.SaveBookDto;
import am.itspace.authorbookrest.entity.Book;

import java.util.List;

public interface BookService {
    BookDto create(SaveBookDto book);

    List<BookDto> getAll();

    BookDto getById(int id);

    BookDto update(int id, SaveBookDto book);

    void deleteById(int id);

    BookDto save(SaveBookDto saveBookDto);
}
