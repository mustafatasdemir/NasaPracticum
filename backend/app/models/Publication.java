package models;

import models.SpringMongoConfig;

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
public class Publication {

  public enum Channel {
    Book, BookChapter, Conference, Journal, WebPage 
  }

  @Id
  private String paperId;
  private String paperTitle;
  private String[] paperAuthors;
  private String[] keywords;
  private String[] systemTags;
  private String[] crowdTags;
  private Channel publicationChannel;
  private int year;

  public static ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
  public static MongoOperations mongoOps = (MongoOperations) ctx.getBean("mongoTemplate");

  public Publication(String paperTitle, String[] paperAuthors, String[] keywords, 
                     String[] systemTags, String[] crowdTags, Channel publicationChannel, int year) {
    this.paperTitle = paperTitle;
    this.paperAuthors = paperAuthors;
    this.keywords = keywords;
    this.systemTags = systemTags;
    this.crowdTags = crowdTags;
    this.publicationChannel = publicationChannel;
    this.year = year;
  }
 
  public String getId() {
    return this.paperId;
  }

  public String getTitle() {
    return this.paperTitle;
  }

  public void setTitle(String title) {
    this.paperTitle = title;
  }

  public String[] getAuthors() {
    return this.paperAuthors;
  }

  public void setAuthors(String[] authors) {
    this.paperAuthors = authors;
  }

  public String[] getKeywords() {
    return this.keywords;
  }

  public void setKeywords(String[] keywords) {
    this.keywords = keywords;
  }

  public String[] getSystemTags() {
    return this.systemTags;
  }

  public void setSystemTags(String[] systemTags) {
    this.systemTags = systemTags;
  }

  public String[] getCrowdTags() {
    return this.crowdTags;
  }

  public void setCrowdTags(String[] crowdTags) {
    this.crowdTags = crowdTags;
  }

  public Channel getChannel() {
    return this.publicationChannel;
  }

  public int getYear() {
    return this.year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public static Query queryById(String id) {
    return new Query(Criteria.where("_id").is(id));
  }

  public static Publication getPublication(String id) {
    Query query = Publication.queryById(id);
    Publication publication = mongoOps.findOne(query, Publication.class);

    if (publication == null) {
      return null;
    }

    return publication;
  }

  public static List<Publication> getAllPublications() {
    List<Publication> publications =  mongoOps.findAll(Publication.class);
    return publications;
  }

  public static Publication deletePublication(String id) {
    Publication publication = Publication.getPublication(id);

    if (publication == null) {
      return null;
    }

    mongoOps.remove(Publication.queryById(id), Publication.class);
    return publication;
  }
}

