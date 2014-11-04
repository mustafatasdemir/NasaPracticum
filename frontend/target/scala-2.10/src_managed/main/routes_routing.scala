// @SOURCE:/Users/ironstone/Desktop/PublicationNetworkAnalysis/frontend/conf/routes
// @HASH:e279bf350d7e60ea5611797d78ba83617cba0131
// @DATE:Mon Nov 03 13:45:34 PST 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:10
private[this] lazy val controllers_Application_login1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:11
private[this] lazy val controllers_Application_authenticate2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:12
private[this] lazy val controllers_Application_logout3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:15
private[this] lazy val controllers_Publications_display4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("publications"))))
        

// @LINE:16
private[this] lazy val controllers_Publications_delete5 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deletePublication"))))
        

// @LINE:18
private[this] lazy val controllers_JournalPublications_display6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("journalPublications"))))
        

// @LINE:19
private[this] lazy val controllers_JournalPublications_addPage7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("add/journalPublication"))))
        

// @LINE:20
private[this] lazy val controllers_JournalPublications_add8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addJournalPublication"))))
        

// @LINE:21
private[this] lazy val controllers_JournalPublications_updatePage9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("update/journalPublication"))))
        

// @LINE:22
private[this] lazy val controllers_JournalPublications_update10 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("updateJournalPublication"))))
        

// @LINE:24
private[this] lazy val controllers_ConferencePublications_display11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("conferencePublications"))))
        

// @LINE:25
private[this] lazy val controllers_ConferencePublications_addPage12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("add/conferencePublication"))))
        

// @LINE:26
private[this] lazy val controllers_ConferencePublications_add13 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addConferencePublication"))))
        

// @LINE:27
private[this] lazy val controllers_ConferencePublications_updatePage14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("update/conferencePublication"))))
        

// @LINE:28
private[this] lazy val controllers_ConferencePublications_update15 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("updateConferencePublication"))))
        

// @LINE:30
private[this] lazy val controllers_WebPagePublications_display16 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("webPagePublications"))))
        

// @LINE:31
private[this] lazy val controllers_WebPagePublications_addPage17 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("add/webPagePublication"))))
        

// @LINE:32
private[this] lazy val controllers_WebPagePublications_add18 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addWebPagePublication"))))
        

// @LINE:33
private[this] lazy val controllers_WebPagePublications_updatePage19 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("update/webPagePublication"))))
        

// @LINE:34
private[this] lazy val controllers_WebPagePublications_update20 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("updateWebPagePublication"))))
        

// @LINE:36
private[this] lazy val controllers_BookPublications_display21 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("bookPublications"))))
        

// @LINE:37
private[this] lazy val controllers_BookPublications_addPage22 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("add/bookPublication"))))
        

// @LINE:38
private[this] lazy val controllers_BookPublications_add23 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addBookPublication"))))
        

// @LINE:39
private[this] lazy val controllers_BookPublications_updatePage24 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("update/bookPublication"))))
        

// @LINE:40
private[this] lazy val controllers_BookPublications_update25 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("updateBookPublication"))))
        

// @LINE:42
private[this] lazy val controllers_BookChapterPublications_display26 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("bookChapterPublications"))))
        

// @LINE:43
private[this] lazy val controllers_BookChapterPublications_addPage27 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("add/bookChapterPublication"))))
        

// @LINE:44
private[this] lazy val controllers_BookChapterPublications_add28 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addBookChapterPublication"))))
        

// @LINE:45
private[this] lazy val controllers_BookChapterPublications_updatePage29 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("update/bookChapterPublication"))))
        

// @LINE:46
private[this] lazy val controllers_BookChapterPublications_update30 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("updateBookChapterPublication"))))
        

// @LINE:49
private[this] lazy val controllers_Assets_at31 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.authenticate()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """publications""","""controllers.Publications.display()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deletePublication""","""controllers.Publications.delete()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """journalPublications""","""controllers.JournalPublications.display()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """add/journalPublication""","""controllers.JournalPublications.addPage()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addJournalPublication""","""controllers.JournalPublications.add()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """update/journalPublication""","""controllers.JournalPublications.updatePage()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """updateJournalPublication""","""controllers.JournalPublications.update()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """conferencePublications""","""controllers.ConferencePublications.display()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """add/conferencePublication""","""controllers.ConferencePublications.addPage()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addConferencePublication""","""controllers.ConferencePublications.add()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """update/conferencePublication""","""controllers.ConferencePublications.updatePage()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """updateConferencePublication""","""controllers.ConferencePublications.update()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """webPagePublications""","""controllers.WebPagePublications.display()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """add/webPagePublication""","""controllers.WebPagePublications.addPage()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addWebPagePublication""","""controllers.WebPagePublications.add()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """update/webPagePublication""","""controllers.WebPagePublications.updatePage()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """updateWebPagePublication""","""controllers.WebPagePublications.update()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """bookPublications""","""controllers.BookPublications.display()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """add/bookPublication""","""controllers.BookPublications.addPage()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addBookPublication""","""controllers.BookPublications.add()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """update/bookPublication""","""controllers.BookPublications.updatePage()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """updateBookPublication""","""controllers.BookPublications.update()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """bookChapterPublications""","""controllers.BookChapterPublications.display()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """add/bookChapterPublication""","""controllers.BookChapterPublications.addPage()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addBookChapterPublication""","""controllers.BookChapterPublications.add()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """update/bookChapterPublication""","""controllers.BookChapterPublications.updatePage()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """updateBookChapterPublication""","""controllers.BookChapterPublications.update()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:10
case controllers_Application_login1(params) => {
   call { 
        invokeHandler(controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Nil,"GET", """ Login and authentication""", Routes.prefix + """login"""))
   }
}
        

// @LINE:11
case controllers_Application_authenticate2(params) => {
   call { 
        invokeHandler(controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Nil,"POST", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:12
case controllers_Application_logout3(params) => {
   call { 
        invokeHandler(controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        

// @LINE:15
case controllers_Publications_display4(params) => {
   call { 
        invokeHandler(controllers.Publications.display(), HandlerDef(this, "controllers.Publications", "display", Nil,"GET", """ Publications""", Routes.prefix + """publications"""))
   }
}
        

// @LINE:16
case controllers_Publications_delete5(params) => {
   call { 
        invokeHandler(controllers.Publications.delete(), HandlerDef(this, "controllers.Publications", "delete", Nil,"POST", """""", Routes.prefix + """deletePublication"""))
   }
}
        

// @LINE:18
case controllers_JournalPublications_display6(params) => {
   call { 
        invokeHandler(controllers.JournalPublications.display(), HandlerDef(this, "controllers.JournalPublications", "display", Nil,"GET", """""", Routes.prefix + """journalPublications"""))
   }
}
        

// @LINE:19
case controllers_JournalPublications_addPage7(params) => {
   call { 
        invokeHandler(controllers.JournalPublications.addPage(), HandlerDef(this, "controllers.JournalPublications", "addPage", Nil,"GET", """""", Routes.prefix + """add/journalPublication"""))
   }
}
        

// @LINE:20
case controllers_JournalPublications_add8(params) => {
   call { 
        invokeHandler(controllers.JournalPublications.add(), HandlerDef(this, "controllers.JournalPublications", "add", Nil,"POST", """""", Routes.prefix + """addJournalPublication"""))
   }
}
        

// @LINE:21
case controllers_JournalPublications_updatePage9(params) => {
   call { 
        invokeHandler(controllers.JournalPublications.updatePage(), HandlerDef(this, "controllers.JournalPublications", "updatePage", Nil,"GET", """""", Routes.prefix + """update/journalPublication"""))
   }
}
        

// @LINE:22
case controllers_JournalPublications_update10(params) => {
   call { 
        invokeHandler(controllers.JournalPublications.update(), HandlerDef(this, "controllers.JournalPublications", "update", Nil,"POST", """""", Routes.prefix + """updateJournalPublication"""))
   }
}
        

// @LINE:24
case controllers_ConferencePublications_display11(params) => {
   call { 
        invokeHandler(controllers.ConferencePublications.display(), HandlerDef(this, "controllers.ConferencePublications", "display", Nil,"GET", """""", Routes.prefix + """conferencePublications"""))
   }
}
        

// @LINE:25
case controllers_ConferencePublications_addPage12(params) => {
   call { 
        invokeHandler(controllers.ConferencePublications.addPage(), HandlerDef(this, "controllers.ConferencePublications", "addPage", Nil,"GET", """""", Routes.prefix + """add/conferencePublication"""))
   }
}
        

// @LINE:26
case controllers_ConferencePublications_add13(params) => {
   call { 
        invokeHandler(controllers.ConferencePublications.add(), HandlerDef(this, "controllers.ConferencePublications", "add", Nil,"POST", """""", Routes.prefix + """addConferencePublication"""))
   }
}
        

// @LINE:27
case controllers_ConferencePublications_updatePage14(params) => {
   call { 
        invokeHandler(controllers.ConferencePublications.updatePage(), HandlerDef(this, "controllers.ConferencePublications", "updatePage", Nil,"GET", """""", Routes.prefix + """update/conferencePublication"""))
   }
}
        

// @LINE:28
case controllers_ConferencePublications_update15(params) => {
   call { 
        invokeHandler(controllers.ConferencePublications.update(), HandlerDef(this, "controllers.ConferencePublications", "update", Nil,"POST", """""", Routes.prefix + """updateConferencePublication"""))
   }
}
        

// @LINE:30
case controllers_WebPagePublications_display16(params) => {
   call { 
        invokeHandler(controllers.WebPagePublications.display(), HandlerDef(this, "controllers.WebPagePublications", "display", Nil,"GET", """""", Routes.prefix + """webPagePublications"""))
   }
}
        

// @LINE:31
case controllers_WebPagePublications_addPage17(params) => {
   call { 
        invokeHandler(controllers.WebPagePublications.addPage(), HandlerDef(this, "controllers.WebPagePublications", "addPage", Nil,"GET", """""", Routes.prefix + """add/webPagePublication"""))
   }
}
        

// @LINE:32
case controllers_WebPagePublications_add18(params) => {
   call { 
        invokeHandler(controllers.WebPagePublications.add(), HandlerDef(this, "controllers.WebPagePublications", "add", Nil,"POST", """""", Routes.prefix + """addWebPagePublication"""))
   }
}
        

// @LINE:33
case controllers_WebPagePublications_updatePage19(params) => {
   call { 
        invokeHandler(controllers.WebPagePublications.updatePage(), HandlerDef(this, "controllers.WebPagePublications", "updatePage", Nil,"GET", """""", Routes.prefix + """update/webPagePublication"""))
   }
}
        

// @LINE:34
case controllers_WebPagePublications_update20(params) => {
   call { 
        invokeHandler(controllers.WebPagePublications.update(), HandlerDef(this, "controllers.WebPagePublications", "update", Nil,"POST", """""", Routes.prefix + """updateWebPagePublication"""))
   }
}
        

// @LINE:36
case controllers_BookPublications_display21(params) => {
   call { 
        invokeHandler(controllers.BookPublications.display(), HandlerDef(this, "controllers.BookPublications", "display", Nil,"GET", """""", Routes.prefix + """bookPublications"""))
   }
}
        

// @LINE:37
case controllers_BookPublications_addPage22(params) => {
   call { 
        invokeHandler(controllers.BookPublications.addPage(), HandlerDef(this, "controllers.BookPublications", "addPage", Nil,"GET", """""", Routes.prefix + """add/bookPublication"""))
   }
}
        

// @LINE:38
case controllers_BookPublications_add23(params) => {
   call { 
        invokeHandler(controllers.BookPublications.add(), HandlerDef(this, "controllers.BookPublications", "add", Nil,"POST", """""", Routes.prefix + """addBookPublication"""))
   }
}
        

// @LINE:39
case controllers_BookPublications_updatePage24(params) => {
   call { 
        invokeHandler(controllers.BookPublications.updatePage(), HandlerDef(this, "controllers.BookPublications", "updatePage", Nil,"GET", """""", Routes.prefix + """update/bookPublication"""))
   }
}
        

// @LINE:40
case controllers_BookPublications_update25(params) => {
   call { 
        invokeHandler(controllers.BookPublications.update(), HandlerDef(this, "controllers.BookPublications", "update", Nil,"POST", """""", Routes.prefix + """updateBookPublication"""))
   }
}
        

// @LINE:42
case controllers_BookChapterPublications_display26(params) => {
   call { 
        invokeHandler(controllers.BookChapterPublications.display(), HandlerDef(this, "controllers.BookChapterPublications", "display", Nil,"GET", """""", Routes.prefix + """bookChapterPublications"""))
   }
}
        

// @LINE:43
case controllers_BookChapterPublications_addPage27(params) => {
   call { 
        invokeHandler(controllers.BookChapterPublications.addPage(), HandlerDef(this, "controllers.BookChapterPublications", "addPage", Nil,"GET", """""", Routes.prefix + """add/bookChapterPublication"""))
   }
}
        

// @LINE:44
case controllers_BookChapterPublications_add28(params) => {
   call { 
        invokeHandler(controllers.BookChapterPublications.add(), HandlerDef(this, "controllers.BookChapterPublications", "add", Nil,"POST", """""", Routes.prefix + """addBookChapterPublication"""))
   }
}
        

// @LINE:45
case controllers_BookChapterPublications_updatePage29(params) => {
   call { 
        invokeHandler(controllers.BookChapterPublications.updatePage(), HandlerDef(this, "controllers.BookChapterPublications", "updatePage", Nil,"GET", """""", Routes.prefix + """update/bookChapterPublication"""))
   }
}
        

// @LINE:46
case controllers_BookChapterPublications_update30(params) => {
   call { 
        invokeHandler(controllers.BookChapterPublications.update(), HandlerDef(this, "controllers.BookChapterPublications", "update", Nil,"POST", """""", Routes.prefix + """updateBookChapterPublication"""))
   }
}
        

// @LINE:49
case controllers_Assets_at31(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     