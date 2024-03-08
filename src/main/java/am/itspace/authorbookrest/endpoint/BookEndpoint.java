package am.itspace.authorbookrest.endpoint;

import am.itspace.authorbookrest.dto.AuthorResponseDto;
import am.itspace.authorbookrest.dto.BookDto;
import am.itspace.authorbookrest.dto.SaveAuthorDto;
import am.itspace.authorbookrest.dto.SaveBookDto;
import am.itspace.authorbookrest.entity.Book;
import am.itspace.authorbookrest.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/books")
public class BookEndpoint {
    private final BookService bookService;

    @PostMapping
    public BookDto create(@RequestBody SaveBookDto saveBookDto){
        return bookService.save(saveBookDto);
    }

    @GetMapping
    public List<BookDto> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getById(@PathVariable("id") int id) {
        BookDto book = bookService.getById(id);

        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDto> update(@PathVariable("id") int id, @RequestBody SaveBookDto saveBookDto) {
        BookDto byId = bookService.getById(id);
        if (byId == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookService.update(id, saveBookDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookDto> deleteById(@PathVariable("id") int id) {
        BookDto byId = bookService.getById(id);
        if (byId == null) {
            return ResponseEntity.notFound().build();
        }
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
