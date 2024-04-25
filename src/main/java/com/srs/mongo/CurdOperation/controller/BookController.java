package com.srs.mongo.CurdOperation.controller;

import com.srs.mongo.CurdOperation.model.Book;
import com.srs.mongo.CurdOperation.repository.MongoDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.PageRanges;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private MongoDBRepository repo;

    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book) {
        repo.save(book);
        System.out.println("testing");
        return "Added Successfully";
    }

    @GetMapping("/findAllBooks")
    public List<Book> getBooks() {

        return repo.findAll();
    }

    @GetMapping("/findBooks/{id}")
    public Book getBooks(@PathVariable("id") int id) {

        return (Book) repo.findById(id).get();
    }

    @GetMapping("/findBooks")
    public List<Book> getBookByAddress(@RequestParam("city") String city) {

        return repo.getBookByAddress(city);
    }
    @GetMapping("/findBooksUsingLike")
    public List<Book> getBookByAddressUsingLike(@RequestParam("city") String city) {
        return repo.getBookByAddressUsingLike(city);
    }

    @GetMapping("/findBooksUsingStartWith")
    public List<Book> getBookByAddressUsingStartWith(@RequestParam("city") String city) {
        return repo.getBookByAddressUsingStartWith(city);
    }

    @GetMapping("/findBooksByName")
    public List<Book> getBooksByName(@RequestParam("name") String name) {
        return repo.findByBookName(name);
    }

    @GetMapping("/findBooksBySorting")
    public List<Book> getBooksBySorting(@RequestParam("name") String name) {
        Sort s = Sort.by(Sort.Direction.ASC, name);
        System.out.println("Test...123...");
        //   Sort s = Sort.by(Sort.Direction.ASC, "name","email",...);
        return repo.findAll(s);
    }

    @GetMapping("/findBooksByBookNameOrAuthorName")
    public List<Book> getBooksByBookNameOrAuthorName(@RequestParam("bookName") String bookName, @RequestParam("authorName") String authorName) {
        return repo.findByBookNameOrAuthorName(bookName, authorName);
    }

    @GetMapping("/findBooksByBookNameAndAuthorName")
    public List<Book> getBooksByBookNameAndAuthorName(@RequestParam("bookName") String bookName, @RequestParam("authorName") String authorName) {
        return repo.findByBookNameAndAuthorName(bookName, authorName);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        System.out.println("Test...");
        repo.deleteById(id);

        return "Deleted Successfully";
    }

    @GetMapping("/getBooksByPagination")
    public List<Book> getBooksByPagination(@RequestParam("pageNo") int pageNo, @RequestParam("pageLimit") int size) {
        Pageable page = PageRequest.of(pageNo, size);
        return repo.findAll(page).getContent();
    }

    @GetMapping("/getBooks")
    public List<Book> getBooks(@RequestParam("authorName") String name) {

        return repo.getBook(name);
    }
    // @GetMapping("/getBookByAddress")
    /*public List<Book> getBookByAddress(@RequestParam("cityName") String name) {

        return repo.getBookByAddress(name);
    }*/
}
