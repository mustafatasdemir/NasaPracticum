package models;

import models.SpringMongoConfig;
import models.Publication;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
 
import java.util.*;

@Document(collection = "publications")
public class BookPublication extends Publication {

  private String bookName;
  private String publisherName;
  private String publisherLocation;
  private String time;
  private String pages;

  public BookPublication(String paperTitle, String[] paperAuthors, String[] keywords,
                         String[] systemTags, String[] crowdTags, int year,
                         String bookName, String publisherName, String publisherLocation, String time, String pages) {

    super(paperTitle, paperAuthors, keywords, systemTags, crowdTags, Channel.Book, year);
    this.bookName = bookName;
    this.publisherName = publisherName;
    this.publisherLocation = publisherLocation;
    this.time = time;
    this.pages = pages;
  }

  public String getBookName() {
    return this.bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  public String getPublisherName() {
    return this.publisherName;
  }

  public void setPublisherName(String publisherName) {
    this.publisherName = publisherName;
  }

  public String getPublisherLocation() {
    return this.publisherLocation;
  }

  public void setPublisherLocation(String publisherLocation) {
    this.publisherLocation = publisherLocation;
  }

  public String getTime() {
    return this.time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getPages() {
    return this.pages;
  }

  public void setPages(String pages) {
    this.pages = pages;
  }

  public static BookPublication get(String id) {
    Query query = Publication.queryById(id);
    BookPublication bpublication = mongoOps.findOne(query, BookPublication.class);

    if (bpublication == null) {
      return null;
    }

    return bpublication;
  }

  public static List<BookPublication> getAll() {
    Query query = new Query(Criteria.where("publicationChannel").is(Channel.Book));
    List<BookPublication> bpublications = mongoOps.find(query, BookPublication.class);
    return bpublications;
  }

  public static BookPublication add(String paperTitle, String[] paperAuthors, String[] keywords,
                                    String[] systemTags, String[] crowdTags, int year,
                                    String bookName, String publisherName, String publisherLocation, String time, String pages) {
    BookPublication bpublication = new BookPublication(paperTitle, paperAuthors, keywords,
                                                       systemTags, crowdTags, year,
                                                       bookName, publisherName, publisherLocation, time, pages);
    mongoOps.save(bpublication);
    return bpublication;
  }

  public static BookPublication update(BookPublication update) {
    BookPublication bpublication = BookPublication.get(update.getId());

    if (bpublication == null) {
      return null;
    }

    bpublication.setTitle(update.getTitle());
    bpublication.setAuthors(update.getAuthors());
    bpublication.setKeywords(update.getKeywords());
    bpublication.setSystemTags(update.getSystemTags());
    bpublication.setCrowdTags(update.getCrowdTags());
    bpublication.setYear(update.getYear());
    bpublication.setBookName(update.getBookName());
    bpublication.setPublisherName(update.getPublisherName());
    bpublication.setPublisherLocation(update.getPublisherLocation());
    bpublication.setTime(update.getTime());
    bpublication.setPages(update.getPages());

    mongoOps.save(bpublication);
    return bpublication;
  }
}

