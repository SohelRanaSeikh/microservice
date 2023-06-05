package com.srs.mongo.CurdOperation.repository;

import com.srs.mongo.CurdOperation.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoDBRepository extends MongoRepository<Book, Integer> {

    List<Book> findByBookName(String name);

    List<Book> findByBookNameOrAuthorName(String bookName, String authorName);

    List<Book> findByBookNameAndAuthorName(String bookName, String authorName);

    /*List<Book> findByBookNameIsLikes(String name);*/

    @Query("{ authorName: ?0}")
    List<Book> getBook(String name);

//    @Query("{ address.street:abc}")
//    List<Book> getBookByAddress(String cityName);
   /* List<Book> findByBookNameIsLikes(String name);
    List<Book> findByBookNameIsLikes(String name);
    List<Book> findByBookNameIsLikes(String name);*/
}
