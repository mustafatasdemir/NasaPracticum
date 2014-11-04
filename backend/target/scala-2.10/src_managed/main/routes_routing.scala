// @SOURCE:/Users/ironstone/Desktop/PublicationNetworkAnalysis/backend/conf/routes
// @HASH:f5937c979d9667d589457908fd2b5e331920b3ee
// @DATE:Mon Nov 03 13:43:40 PST 2014


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
        

// @LINE:8
private[this] lazy val controllers_Publications_test1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("test"))))
        

// @LINE:10
private[this] lazy val controllers_Publications_get2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getPublication/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:11
private[this] lazy val controllers_Publications_getAll3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getAllPublications"))))
        

// @LINE:12
private[this] lazy val controllers_Publications_delete4 = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deletePublication/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:14
private[this] lazy val controllers_JournalPublications_get5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getJournalPublication/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:15
private[this] lazy val controllers_JournalPublications_getAll6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getAllJournalPublications"))))
        

// @LINE:16
private[this] lazy val controllers_JournalPublications_add7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addJournalPublication"))))
        

// @LINE:17
private[this] lazy val controllers_JournalPublications_update8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("updateJournalPublication"))))
        

// @LINE:19
private[this] lazy val controllers_BookPublications_get9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getBookPublication/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:20
private[this] lazy val controllers_BookPublications_getAll10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getAllBookPublications"))))
        

// @LINE:21
private[this] lazy val controllers_BookPublications_add11 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addBookPublication"))))
        

// @LINE:22
private[this] lazy val controllers_BookPublications_update12 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("updateBookPublication"))))
        

// @LINE:24
private[this] lazy val controllers_BookChapterPublications_get13 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getBookChapterPublication/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:25
private[this] lazy val controllers_BookChapterPublications_getAll14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getAllBookChapterPublications"))))
        

// @LINE:26
private[this] lazy val controllers_BookChapterPublications_add15 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addBookChapterPublication"))))
        

// @LINE:27
private[this] lazy val controllers_BookChapterPublications_update16 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("updateBookChapterPublication"))))
        

// @LINE:29
private[this] lazy val controllers_ConferencePublications_get17 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getConferencePublication/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:30
private[this] lazy val controllers_ConferencePublications_getAll18 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getAllConferencePublications"))))
        

// @LINE:31
private[this] lazy val controllers_ConferencePublications_add19 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addConferencePublication"))))
        

// @LINE:32
private[this] lazy val controllers_ConferencePublications_update20 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("updateConferencePublication"))))
        

// @LINE:34
private[this] lazy val controllers_WebPagePublications_get21 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getWebPagePublication/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:35
private[this] lazy val controllers_WebPagePublications_getAll22 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getAllWebPagePublications"))))
        

// @LINE:36
private[this] lazy val controllers_WebPagePublications_add23 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addWebPagePublication"))))
        

// @LINE:37
private[this] lazy val controllers_WebPagePublications_update24 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("updateWebPagePublication"))))
        

// @LINE:39
private[this] lazy val controllers_Users_getUser25 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getUser/"),DynamicPart("email", """[^/]+""",true))))
        

// @LINE:43
private[this] lazy val controllers_Assets_at26 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """test""","""controllers.Publications.test()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getPublication/$id<[^/]+>""","""controllers.Publications.get(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getAllPublications""","""controllers.Publications.getAll()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deletePublication/$id<[^/]+>""","""controllers.Publications.delete(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getJournalPublication/$id<[^/]+>""","""controllers.JournalPublications.get(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getAllJournalPublications""","""controllers.JournalPublications.getAll()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addJournalPublication""","""controllers.JournalPublications.add()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """updateJournalPublication""","""controllers.JournalPublications.update()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getBookPublication/$id<[^/]+>""","""controllers.BookPublications.get(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getAllBookPublications""","""controllers.BookPublications.getAll()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addBookPublication""","""controllers.BookPublications.add()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """updateBookPublication""","""controllers.BookPublications.update()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getBookChapterPublication/$id<[^/]+>""","""controllers.BookChapterPublications.get(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getAllBookChapterPublications""","""controllers.BookChapterPublications.getAll()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addBookChapterPublication""","""controllers.BookChapterPublications.add()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """updateBookChapterPublication""","""controllers.BookChapterPublications.update()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getConferencePublication/$id<[^/]+>""","""controllers.ConferencePublications.get(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getAllConferencePublications""","""controllers.ConferencePublications.getAll()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addConferencePublication""","""controllers.ConferencePublications.add()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """updateConferencePublication""","""controllers.ConferencePublications.update()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getWebPagePublication/$id<[^/]+>""","""controllers.WebPagePublications.get(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getAllWebPagePublications""","""controllers.WebPagePublications.getAll()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addWebPagePublication""","""controllers.WebPagePublications.add()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """updateWebPagePublication""","""controllers.WebPagePublications.update()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getUser/$email<[^/]+>""","""controllers.Users.getUser(email:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
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
        

// @LINE:8
case controllers_Publications_test1(params) => {
   call { 
        invokeHandler(controllers.Publications.test(), HandlerDef(this, "controllers.Publications", "test", Nil,"GET", """""", Routes.prefix + """test"""))
   }
}
        

// @LINE:10
case controllers_Publications_get2(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.Publications.get(id), HandlerDef(this, "controllers.Publications", "get", Seq(classOf[String]),"GET", """""", Routes.prefix + """getPublication/$id<[^/]+>"""))
   }
}
        

// @LINE:11
case controllers_Publications_getAll3(params) => {
   call { 
        invokeHandler(controllers.Publications.getAll(), HandlerDef(this, "controllers.Publications", "getAll", Nil,"GET", """""", Routes.prefix + """getAllPublications"""))
   }
}
        

// @LINE:12
case controllers_Publications_delete4(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.Publications.delete(id), HandlerDef(this, "controllers.Publications", "delete", Seq(classOf[String]),"DELETE", """""", Routes.prefix + """deletePublication/$id<[^/]+>"""))
   }
}
        

// @LINE:14
case controllers_JournalPublications_get5(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.JournalPublications.get(id), HandlerDef(this, "controllers.JournalPublications", "get", Seq(classOf[String]),"GET", """""", Routes.prefix + """getJournalPublication/$id<[^/]+>"""))
   }
}
        

// @LINE:15
case controllers_JournalPublications_getAll6(params) => {
   call { 
        invokeHandler(controllers.JournalPublications.getAll(), HandlerDef(this, "controllers.JournalPublications", "getAll", Nil,"GET", """""", Routes.prefix + """getAllJournalPublications"""))
   }
}
        

// @LINE:16
case controllers_JournalPublications_add7(params) => {
   call { 
        invokeHandler(controllers.JournalPublications.add(), HandlerDef(this, "controllers.JournalPublications", "add", Nil,"POST", """""", Routes.prefix + """addJournalPublication"""))
   }
}
        

// @LINE:17
case controllers_JournalPublications_update8(params) => {
   call { 
        invokeHandler(controllers.JournalPublications.update(), HandlerDef(this, "controllers.JournalPublications", "update", Nil,"POST", """""", Routes.prefix + """updateJournalPublication"""))
   }
}
        

// @LINE:19
case controllers_BookPublications_get9(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.BookPublications.get(id), HandlerDef(this, "controllers.BookPublications", "get", Seq(classOf[String]),"GET", """""", Routes.prefix + """getBookPublication/$id<[^/]+>"""))
   }
}
        

// @LINE:20
case controllers_BookPublications_getAll10(params) => {
   call { 
        invokeHandler(controllers.BookPublications.getAll(), HandlerDef(this, "controllers.BookPublications", "getAll", Nil,"GET", """""", Routes.prefix + """getAllBookPublications"""))
   }
}
        

// @LINE:21
case controllers_BookPublications_add11(params) => {
   call { 
        invokeHandler(controllers.BookPublications.add(), HandlerDef(this, "controllers.BookPublications", "add", Nil,"POST", """""", Routes.prefix + """addBookPublication"""))
   }
}
        

// @LINE:22
case controllers_BookPublications_update12(params) => {
   call { 
        invokeHandler(controllers.BookPublications.update(), HandlerDef(this, "controllers.BookPublications", "update", Nil,"POST", """""", Routes.prefix + """updateBookPublication"""))
   }
}
        

// @LINE:24
case controllers_BookChapterPublications_get13(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.BookChapterPublications.get(id), HandlerDef(this, "controllers.BookChapterPublications", "get", Seq(classOf[String]),"GET", """""", Routes.prefix + """getBookChapterPublication/$id<[^/]+>"""))
   }
}
        

// @LINE:25
case controllers_BookChapterPublications_getAll14(params) => {
   call { 
        invokeHandler(controllers.BookChapterPublications.getAll(), HandlerDef(this, "controllers.BookChapterPublications", "getAll", Nil,"GET", """""", Routes.prefix + """getAllBookChapterPublications"""))
   }
}
        

// @LINE:26
case controllers_BookChapterPublications_add15(params) => {
   call { 
        invokeHandler(controllers.BookChapterPublications.add(), HandlerDef(this, "controllers.BookChapterPublications", "add", Nil,"POST", """""", Routes.prefix + """addBookChapterPublication"""))
   }
}
        

// @LINE:27
case controllers_BookChapterPublications_update16(params) => {
   call { 
        invokeHandler(controllers.BookChapterPublications.update(), HandlerDef(this, "controllers.BookChapterPublications", "update", Nil,"POST", """""", Routes.prefix + """updateBookChapterPublication"""))
   }
}
        

// @LINE:29
case controllers_ConferencePublications_get17(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.ConferencePublications.get(id), HandlerDef(this, "controllers.ConferencePublications", "get", Seq(classOf[String]),"GET", """""", Routes.prefix + """getConferencePublication/$id<[^/]+>"""))
   }
}
        

// @LINE:30
case controllers_ConferencePublications_getAll18(params) => {
   call { 
        invokeHandler(controllers.ConferencePublications.getAll(), HandlerDef(this, "controllers.ConferencePublications", "getAll", Nil,"GET", """""", Routes.prefix + """getAllConferencePublications"""))
   }
}
        

// @LINE:31
case controllers_ConferencePublications_add19(params) => {
   call { 
        invokeHandler(controllers.ConferencePublications.add(), HandlerDef(this, "controllers.ConferencePublications", "add", Nil,"POST", """""", Routes.prefix + """addConferencePublication"""))
   }
}
        

// @LINE:32
case controllers_ConferencePublications_update20(params) => {
   call { 
        invokeHandler(controllers.ConferencePublications.update(), HandlerDef(this, "controllers.ConferencePublications", "update", Nil,"POST", """""", Routes.prefix + """updateConferencePublication"""))
   }
}
        

// @LINE:34
case controllers_WebPagePublications_get21(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.WebPagePublications.get(id), HandlerDef(this, "controllers.WebPagePublications", "get", Seq(classOf[String]),"GET", """""", Routes.prefix + """getWebPagePublication/$id<[^/]+>"""))
   }
}
        

// @LINE:35
case controllers_WebPagePublications_getAll22(params) => {
   call { 
        invokeHandler(controllers.WebPagePublications.getAll(), HandlerDef(this, "controllers.WebPagePublications", "getAll", Nil,"GET", """""", Routes.prefix + """getAllWebPagePublications"""))
   }
}
        

// @LINE:36
case controllers_WebPagePublications_add23(params) => {
   call { 
        invokeHandler(controllers.WebPagePublications.add(), HandlerDef(this, "controllers.WebPagePublications", "add", Nil,"POST", """""", Routes.prefix + """addWebPagePublication"""))
   }
}
        

// @LINE:37
case controllers_WebPagePublications_update24(params) => {
   call { 
        invokeHandler(controllers.WebPagePublications.update(), HandlerDef(this, "controllers.WebPagePublications", "update", Nil,"POST", """""", Routes.prefix + """updateWebPagePublication"""))
   }
}
        

// @LINE:39
case controllers_Users_getUser25(params) => {
   call(params.fromPath[String]("email", None)) { (email) =>
        invokeHandler(controllers.Users.getUser(email), HandlerDef(this, "controllers.Users", "getUser", Seq(classOf[String]),"GET", """""", Routes.prefix + """getUser/$email<[^/]+>"""))
   }
}
        

// @LINE:43
case controllers_Assets_at26(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     