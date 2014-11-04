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
public class BookChapterPublication extends Publication {

  private String bookName;
  private int chapter;
  private String[] editorNames;
  private String time;

  public BookChapterPublication(String paperTitle, String[] paperAuthors, String[] keywords,
                                String[] systemTags, String[] crowdTags, int year,
                                String bookName, int chapter, String[] editorNames, String time) {

    super(paperTitle, paperAuthors, keywords, systemTags, crowdTags, Channel.BookChapter, year);
    this.bookName = bookName;
    this.chapter = chapter;
    this.editorNames = editorNames;
    this.time = time;
  }

  public String getBookName() {
    return this.bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  public int getChapter() {
    return this.chapter;
  }
  
  public void setChapter(int chapter) {
    this.chapter = chapter;
  }

  public String[] getEditorNames() {
    return this.editorNames;
  }
  
  public void setEditorNames(String[] editorNames) {
    this.editorNames = editorNames;
  }

  public String getTime() {
    return this.time;
  }

  public void setTime(String time) {
    this.time = time;
  }
  
  public static BookChapterPublication get(String id) {
    Query query = Publication.queryById(id);
    BookChapterPublication bcpublication = mongoOps.findOne(query, BookChapterPublication.class);

    if (bcpublication == null) {
      return null;
    }

    return bcpublication;
  }
  
  public static List<BookChapterPublication> getAll() {
    Query query = new Query(Criteria.where("publicationChannel").is(Channel.BookChapter));
    List<BookChapterPublication> bcpublications = mongoOps.find(query, BookChapterPublication.class);
    return bcpublications;
  }

  public static BookChapterPublication add(String paperTitle, String[] paperAuthors, String[] keywords,
                                           String[] systemTags, String[] crowdTags, int year,
                                           String bookName, int chapter, String[] editorNames, String time) {
    BookChapterPublication bcpublication = new BookChapterPublication(paperTitle, paperAuthors, keywords,
                                                                      systemTags, crowdTags, year,
                                                                      bookName, chapter, editorNames, time);
    mongoOps.save(bcpublication);
    return bcpublication;
  }
  
  public static BookChapterPublication update(BookChapterPublication update) {
    BookChapterPublication bcpublication = BookChapterPublication.get(update.getId());

    if (bcpublication == null) {
      return null;
    }

    bcpublication.setTitle(update.getTitle());
    bcpublication.setAuthors(update.getAuthors());
    bcpublication.setKeywords(update.getKeywords());
    bcpublication.setSystemTags(update.getSystemTags());
    bcpublication.setCrowdTags(update.getCrowdTags());
    bcpublication.setYear(update.getYear());
    bcpublication.setBookName(update.getBookName());
    bcpublication.setChapter(update.getChapter());
    bcpublication.setEditorNames(update.getEditorNames());
    bcpublication.setTime(update.getTime());

    mongoOps.save(bcpublication);
    return bcpublication;
  }
}

