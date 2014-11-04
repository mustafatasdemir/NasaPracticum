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
 
@Document(collection = "users")
public class User {

  @Id
  private String id;
  private String email;
  private String pwd;

  private static ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
  private static MongoOperations mongoOps = (MongoOperations) ctx.getBean("mongoTemplate");

  public User(String email, String pwd) {
    this.email = email;
    this.pwd = pwd;
  }

  public static Query userQuery(String email){
    return new Query(Criteria.where("email").is(email));
  }

  public static User getUser(String email){
    Query getUserQuery = User.userQuery(email);
    User result = mongoOps.findOne(getUserQuery, User.class);

    if (result == null) {
      return null;
    }

    return result;
  }

  public static User addUser(String email, String pwd) {
    User user = User.getUser(email);

    if (user != null) {
      return user; //email already exists
    }

    user = new User(email, pwd);
    mongoOps.save(user);
    return user;
  }

  public static User deleteUser(String email) {
    User user = User.getUser(email);

    if (user == null) {
      return null; // email does not exist
    }

    mongoOps.remove(User.userQuery(email), User.class);
    return user;
  }

  public static User updatePassword(String email, String newPwd) {
    User user = User.getUser(email);

    if (user == null ) {
      return null;
    }

    mongoOps.updateFirst(User.userQuery(email), Update.update("pwd", newPwd), User.class);
    return User.getUser(email);
  }
}

