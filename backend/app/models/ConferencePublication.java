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
public class ConferencePublication extends Publication {

  private String conferenceName;
  private String conferenceLocation;
  private String time;
  private String pages;

  public ConferencePublication(String paperTitle, String[] paperAuthors, String[] keywords,
                               String[] systemTags, String[] crowdTags, int year,
                               String conferenceName, String conferenceLocation, String time, String pages) {

    super(paperTitle, paperAuthors, keywords, systemTags, crowdTags, Channel.Conference, year);
    this.conferenceName = conferenceName;
    this.conferenceLocation = conferenceLocation;
    this.time = time;
    this.pages = pages;
  }

  public String getConferenceName() {
    return this.conferenceName;
  }

  public void setConferenceName(String conferenceName) {
    this.conferenceName = conferenceName;
  }

  public String getConferenceLocation() {
    return this.conferenceLocation;
  }

  public void setConferenceLocation(String conferenceLocation) {
    this.conferenceLocation = conferenceLocation;
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

  public static ConferencePublication get(String id) {
    Query query = Publication.queryById(id);
    ConferencePublication cpublication = mongoOps.findOne(query, ConferencePublication.class);

    if (cpublication == null) {
      return null;
    }

    return cpublication;
  }

  public static List<ConferencePublication> getAll() {
    Query query = new Query(Criteria.where("publicationChannel").is(Channel.Conference));
    List<ConferencePublication> cpublications = mongoOps.find(query, ConferencePublication.class);
    return cpublications;
  }

  public static ConferencePublication add(String paperTitle, String[] paperAuthors, String[] keywords,
                                          String[] systemTags, String[] crowdTags, int year,
                                          String conferenceName, String conferenceLocation, String time, String pages) {
    ConferencePublication cpublication = new ConferencePublication(paperTitle, paperAuthors, keywords,
                                                                   systemTags, crowdTags, year,
                                                                   conferenceName, conferenceLocation, time, pages);
    mongoOps.save(cpublication);
    return cpublication;
  }

  public static ConferencePublication update(ConferencePublication update) {
    ConferencePublication cpublication = ConferencePublication.get(update.getId());

    if (cpublication == null) {
      return null;
    }

    cpublication.setTitle(update.getTitle());
    cpublication.setAuthors(update.getAuthors());
    cpublication.setKeywords(update.getKeywords());
    cpublication.setSystemTags(update.getSystemTags());
    cpublication.setCrowdTags(update.getCrowdTags());
    cpublication.setYear(update.getYear());
    cpublication.setConferenceName(update.getConferenceName());
    cpublication.setConferenceLocation(update.getConferenceLocation());
    cpublication.setTime(update.getTime());
    cpublication.setPages(update.getPages());

    mongoOps.save(cpublication);
    return cpublication;
  }
}

