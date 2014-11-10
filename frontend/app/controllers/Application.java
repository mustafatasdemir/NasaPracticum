package controllers;

import play.mvc.*;
import play.data.*;
import views.html.*;

public class Application extends Controller {

  public static Result index() {
    return ok(index.render());
  }
  
  public static class Login {
    public String email;
    public String pwd;
     
    public String validate() {
      //if(User.authenticate(email, password) == null) 
      if(!email.equals("admin@admin.com"))
        return "Invalid user or password";
      return null;
    }
  }

  public static Result login() {
    return ok(login.render(Form.form(Login.class)));
  }

  public static Result logout() {
    session().clear();
    flash("success", "You have been logged out");
    return redirect(routes.Application.login());
  }

  public static Result authenticate() {
    Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
    if (loginForm.hasErrors()) {
      return badRequest(login.render(loginForm));
    } else {
      session().clear();
      session("email", loginForm.get().email);
      return redirect(routes.Application.index());
    }
  }
}
