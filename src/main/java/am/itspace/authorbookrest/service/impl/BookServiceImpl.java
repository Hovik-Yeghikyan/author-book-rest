package am.itspace.authorbookrest.service.impl;

import am.itspace.authorbookrest.dto.BookDto;
import am.itspace.authorbookrest.dto.SaveBookDto;
import am.itspace.authorbookrest.entity.Author;
import am.itspace.authorbookrest.entity.Book;
import am.itspace.authorbookrest.mapper.BookMapper;
import am.itspace.authorbookrest.repository.AuthorRepository;
import am.itspace.authorbookrest.repository.BookRepository;
import am.itspace.authorbookrest.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AuthorRepository authorRepository;



    @Override
    public BookDto create(SaveBookDto saveBookDto) {
        Book bookEntity = bookMapper.map(saveBookDto);
        return bookMapper.map(bookRepository.save(bookEntity));
    }

    @Override
    public List<BookDto> getAll() {
        List<Book> all = bookRepository.findAll();
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book : all) {
            bookDtos.add(bookMapper.map(book));
        }
        return bookDtos;
    }

    @Override
    public BookDto getById(int id) {
        Book book = bookRepository.findById(id)
                .orElse(null);
        if (book == null) {
            return null;
        }
        return bookMapper.map(book);

    }

    @Override
    public BookDto update(int id, SaveBookDto saveBookDto) {
        Book savedBook = bookMapper.map(saveBookDto);
        savedBook.setId(id);
        bookRepository.save(savedBook);
        return bookMapper.map(savedBook);
    }




    @Override
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto save(SaveBookDto saveBookDto) {
        Book book = bookMapper.map(saveBookDto);
        book.setAuthor(authorRepository.findById(saveBookDto.getAuthorId()).orElse(null));
        bookRepository.save(book);
        return null;
    }
}