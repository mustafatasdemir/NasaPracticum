package controllers;

import play.*;
import play.mvc.*;

import views.html.*;
import models.User;

public class Users extends Controller {

  public static Result getUser(String email) {
    return ok("User controller: " + email);
  }

}
