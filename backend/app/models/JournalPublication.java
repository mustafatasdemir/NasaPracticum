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
public class JournalPublication extends Publication {

  private String journalName;
  private String volume;
  private String column;
  private String pages;

  public JournalPublication(String paperTitle, String[] paperAuthors, String[] keywords,
                            String[] systemTags, String[] crowdTags, int year,
                            String journalName, String volume, String column, String pages) {

    super(paperTitle, paperAuthors, keywords, systemTags, crowdTags, Channel.Journal, year);
    this.journalName = journalName;
    this.volume = volume;
    this.column = column;
    this.pages = pages;
  }

  public String getJournalName() {
    return this.journalName;
  }

  public void setJournalName(String journalName) {
    this.journalName = journalName;
  }

  public String getVolume() {
    return this.volume;
  }

  public void setVolume(String volume) {
    this.volume = volume;
  }

  public String getColumn() {
    return this.column;
  }

  public void setColumn(String column) {
    this.column = column;
  }

  public String getPages() {
    return this.pages;
  }

  public void setPages(String pages) {
    this.pages = pages;
  }

  public static JournalPublication get(String id) {
    Query query = Publication.queryById(id);
    JournalPublication jpublication = mongoOps.findOne(query, JournalPublication.class);

    if (jpublication == null) {
      return null;
    }

    return jpublication;
  }

  public static List<JournalPublication> getAll() {
    Query query = new Query(Criteria.where("publicationChannel").is(Channel.Journal));
    List<JournalPublication> jpublications = mongoOps.find(query, JournalPublication.class);
    return jpublications;
  }

  public static JournalPublication add(String paperTitle, String[] paperAuthors, String[] keywords,
                                       String[] systemTags, String[] crowdTags, int year,
                                       String journalName, String volume, String column, String pages) {
    JournalPublication jpublication = new JournalPublication(paperTitle, paperAuthors, keywords,
                                                             systemTags, crowdTags, year,
                                                             journalName, volume, column, pages);
    mongoOps.save(jpublication);
    return jpublication;
  }

  public static JournalPublication update(JournalPublication update) {
    JournalPublication jpublication = JournalPublication.get(update.getId());

    if (jpublication == null) {
      return null;
    }

    jpublication.setTitle(update.getTitle());
    jpublication.setAuthors(update.getAuthors());
    jpublication.setKeywords(update.getKeywords());
    jpublication.setSystemTags(update.getSystemTags());
    jpublication.setCrowdTags(update.getCrowdTags());
    jpublication.setYear(update.getYear());
    jpublication.setJournalName(update.getJournalName());
    jpublication.setVolume(update.getVolume());
    jpublication.setColumn(update.getColumn());
    jpublication.setPages(update.getPages());

    mongoOps.save(jpublication);
    return jpublication;
  }
}

