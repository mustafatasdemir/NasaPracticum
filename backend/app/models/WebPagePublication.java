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
public class WebPagePublication extends Publication {

  private String URL;
  private Date date;

  public WebPagePublication(String paperTitle, String[] paperAuthors, String[] keywords,
                            String[] systemTags, String[] crowdTags, int year,
                            String URL, Date date) {

    super(paperTitle, paperAuthors, keywords, systemTags, crowdTags, Channel.WebPage, year);
    this.URL = URL;
    this.date = date;
  }
  
  public String getURL() {
    return this.URL;
  }

  public void setURL(String URL) {
    this.URL = URL;
  }

  public Date getDate() {
    return this.date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public static WebPagePublication get(String id) {
    Query query = Publication.queryById(id);
    WebPagePublication wpublication = mongoOps.findOne(query, WebPagePublication.class);

    if (wpublication == null) {
      return null;
    }

    return wpublication;
  }

  public static List<WebPagePublication> getAll() {
    Query query = new Query(Criteria.where("publicationChannel").is(Channel.WebPage));
    List<WebPagePublication> wpublications = mongoOps.find(query, WebPagePublication.class);
    return wpublications;
  }

  public static WebPagePublication add(String paperTitle, String[] paperAuthors, String[] keywords,
                                       String[] systemTags, String[] crowdTags, int year,
                                       String URL, Date date) {
    WebPagePublication wpublication = new WebPagePublication(paperTitle, paperAuthors, keywords,
                                                             systemTags, crowdTags, year,
                                                             URL, date);
    mongoOps.save(wpublication);
    return wpublication;
  }

  public static WebPagePublication update(WebPagePublication update) {
    WebPagePublication wpublication = WebPagePublication.get(update.getId());

    if (wpublication == null) {
      return null;
    }

    wpublication.setTitle(update.getTitle());
    wpublication.setAuthors(update.getAuthors());
    wpublication.setKeywords(update.getKeywords());
    wpublication.setSystemTags(update.getSystemTags());
    wpublication.setCrowdTags(update.getCrowdTags());
    wpublication.setYear(update.getYear());
    wpublication.setURL(update.getURL());
    wpublication.setDate(update.getDate());

    mongoOps.save(wpublication);
    return wpublication;
  }
}

