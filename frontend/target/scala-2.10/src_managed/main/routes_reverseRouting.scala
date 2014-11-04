// @SOURCE:/Users/ironstone/Desktop/PublicationNetworkAnalysis/frontend/conf/routes
// @HASH:e279bf350d7e60ea5611797d78ba83617cba0131
// @DATE:Mon Nov 03 13:45:34 PST 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:49
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:16
// @LINE:15
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:6
package controllers {

// @LINE:49
class ReverseAssets {
    

// @LINE:49
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:16
// @LINE:15
class ReversePublications {
    

// @LINE:15
def display(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "publications")
}
                                                

// @LINE:16
def delete(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "deletePublication")
}
                                                
    
}
                          

// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
class ReverseBookPublications {
    

// @LINE:39
def updatePage(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "update/bookPublication")
}
                                                

// @LINE:38
def add(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "addBookPublication")
}
                                                

// @LINE:36
def display(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "bookPublications")
}
                                                

// @LINE:40
def update(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "updateBookPublication")
}
                                                

// @LINE:37
def addPage(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "add/bookPublication")
}
                                                
    
}
                          

// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
class ReverseWebPagePublications {
    

// @LINE:33
def updatePage(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "update/webPagePublication")
}
                                                

// @LINE:32
def add(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "addWebPagePublication")
}
                                                

// @LINE:30
def display(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "webPagePublications")
}
                                                

// @LINE:34
def update(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "updateWebPagePublication")
}
                                                

// @LINE:31
def addPage(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "add/webPagePublication")
}
                                                
    
}
                          

// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
class ReverseConferencePublications {
    

// @LINE:27
def updatePage(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "update/conferencePublication")
}
                                                

// @LINE:26
def add(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "addConferencePublication")
}
                                                

// @LINE:24
def display(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "conferencePublications")
}
                                                

// @LINE:28
def update(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "updateConferencePublication")
}
                                                

// @LINE:25
def addPage(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "add/conferencePublication")
}
                                                
    
}
                          

// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:6
class ReverseApplication {
    

// @LINE:12
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:11
def authenticate(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                                                

// @LINE:10
def login(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                                                
    
}
                          

// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
class ReverseJournalPublications {
    

// @LINE:21
def updatePage(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "update/journalPublication")
}
                                                

// @LINE:20
def add(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "addJournalPublication")
}
                                                

// @LINE:18
def display(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "journalPublications")
}
                                                

// @LINE:22
def update(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "updateJournalPublication")
}
                                                

// @LINE:19
def addPage(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "add/journalPublication")
}
                                                
    
}
                          

// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
class ReverseBookChapterPublications {
    

// @LINE:45
def updatePage(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "update/bookChapterPublication")
}
                                                

// @LINE:44
def add(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "addBookChapterPublication")
}
                                                

// @LINE:42
def display(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "bookChapterPublications")
}
                                                

// @LINE:46
def update(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "updateBookChapterPublication")
}
                                                

// @LINE:43
def addPage(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "add/bookChapterPublication")
}
                                                
    
}
                          
}
                  


// @LINE:49
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:16
// @LINE:15
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:6
package controllers.javascript {

// @LINE:49
class ReverseAssets {
    

// @LINE:49
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:16
// @LINE:15
class ReversePublications {
    

// @LINE:15
def display : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Publications.display",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "publications"})
      }
   """
)
                        

// @LINE:16
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Publications.delete",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deletePublication"})
      }
   """
)
                        
    
}
              

// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
class ReverseBookPublications {
    

// @LINE:39
def updatePage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.BookPublications.updatePage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "update/bookPublication"})
      }
   """
)
                        

// @LINE:38
def add : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.BookPublications.add",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addBookPublication"})
      }
   """
)
                        

// @LINE:36
def display : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.BookPublications.display",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "bookPublications"})
      }
   """
)
                        

// @LINE:40
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.BookPublications.update",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateBookPublication"})
      }
   """
)
                        

// @LINE:37
def addPage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.BookPublications.addPage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "add/bookPublication"})
      }
   """
)
                        
    
}
              

// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
class ReverseWebPagePublications {
    

// @LINE:33
def updatePage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.WebPagePublications.updatePage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "update/webPagePublication"})
      }
   """
)
                        

// @LINE:32
def add : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.WebPagePublications.add",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addWebPagePublication"})
      }
   """
)
                        

// @LINE:30
def display : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.WebPagePublications.display",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "webPagePublications"})
      }
   """
)
                        

// @LINE:34
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.WebPagePublications.update",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateWebPagePublication"})
      }
   """
)
                        

// @LINE:31
def addPage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.WebPagePublications.addPage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "add/webPagePublication"})
      }
   """
)
                        
    
}
              

// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
class ReverseConferencePublications {
    

// @LINE:27
def updatePage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ConferencePublications.updatePage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "update/conferencePublication"})
      }
   """
)
                        

// @LINE:26
def add : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ConferencePublications.add",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addConferencePublication"})
      }
   """
)
                        

// @LINE:24
def display : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ConferencePublications.display",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "conferencePublications"})
      }
   """
)
                        

// @LINE:28
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ConferencePublications.update",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateConferencePublication"})
      }
   """
)
                        

// @LINE:25
def addPage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ConferencePublications.addPage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "add/conferencePublication"})
      }
   """
)
                        
    
}
              

// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:6
class ReverseApplication {
    

// @LINE:12
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:11
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:10
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        
    
}
              

// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
class ReverseJournalPublications {
    

// @LINE:21
def updatePage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.JournalPublications.updatePage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "update/journalPublication"})
      }
   """
)
                        

// @LINE:20
def add : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.JournalPublications.add",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addJournalPublication"})
      }
   """
)
                        

// @LINE:18
def display : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.JournalPublications.display",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "journalPublications"})
      }
   """
)
                        

// @LINE:22
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.JournalPublications.update",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateJournalPublication"})
      }
   """
)
                        

// @LINE:19
def addPage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.JournalPublications.addPage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "add/journalPublication"})
      }
   """
)
                        
    
}
              

// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
class ReverseBookChapterPublications {
    

// @LINE:45
def updatePage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.BookChapterPublications.updatePage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "update/bookChapterPublication"})
      }
   """
)
                        

// @LINE:44
def add : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.BookChapterPublications.add",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addBookChapterPublication"})
      }
   """
)
                        

// @LINE:42
def display : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.BookChapterPublications.display",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "bookChapterPublications"})
      }
   """
)
                        

// @LINE:46
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.BookChapterPublications.update",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateBookChapterPublication"})
      }
   """
)
                        

// @LINE:43
def addPage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.BookChapterPublications.addPage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "add/bookChapterPublication"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:49
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:16
// @LINE:15
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:6
package controllers.ref {


// @LINE:49
class ReverseAssets {
    

// @LINE:49
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:16
// @LINE:15
class ReversePublications {
    

// @LINE:15
def display(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Publications.display(), HandlerDef(this, "controllers.Publications", "display", Seq(), "GET", """ Publications""", _prefix + """publications""")
)
                      

// @LINE:16
def delete(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Publications.delete(), HandlerDef(this, "controllers.Publications", "delete", Seq(), "POST", """""", _prefix + """deletePublication""")
)
                      
    
}
                          

// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
class ReverseBookPublications {
    

// @LINE:39
def updatePage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.BookPublications.updatePage(), HandlerDef(this, "controllers.BookPublications", "updatePage", Seq(), "GET", """""", _prefix + """update/bookPublication""")
)
                      

// @LINE:38
def add(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.BookPublications.add(), HandlerDef(this, "controllers.BookPublications", "add", Seq(), "POST", """""", _prefix + """addBookPublication""")
)
                      

// @LINE:36
def display(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.BookPublications.display(), HandlerDef(this, "controllers.BookPublications", "display", Seq(), "GET", """""", _prefix + """bookPublications""")
)
                      

// @LINE:40
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.BookPublications.update(), HandlerDef(this, "controllers.BookPublications", "update", Seq(), "POST", """""", _prefix + """updateBookPublication""")
)
                      

// @LINE:37
def addPage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.BookPublications.addPage(), HandlerDef(this, "controllers.BookPublications", "addPage", Seq(), "GET", """""", _prefix + """add/bookPublication""")
)
                      
    
}
                          

// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
class ReverseWebPagePublications {
    

// @LINE:33
def updatePage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.WebPagePublications.updatePage(), HandlerDef(this, "controllers.WebPagePublications", "updatePage", Seq(), "GET", """""", _prefix + """update/webPagePublication""")
)
                      

// @LINE:32
def add(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.WebPagePublications.add(), HandlerDef(this, "controllers.WebPagePublications", "add", Seq(), "POST", """""", _prefix + """addWebPagePublication""")
)
                      

// @LINE:30
def display(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.WebPagePublications.display(), HandlerDef(this, "controllers.WebPagePublications", "display", Seq(), "GET", """""", _prefix + """webPagePublications""")
)
                      

// @LINE:34
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.WebPagePublications.update(), HandlerDef(this, "controllers.WebPagePublications", "update", Seq(), "POST", """""", _prefix + """updateWebPagePublication""")
)
                      

// @LINE:31
def addPage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.WebPagePublications.addPage(), HandlerDef(this, "controllers.WebPagePublications", "addPage", Seq(), "GET", """""", _prefix + """add/webPagePublication""")
)
                      
    
}
                          

// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
class ReverseConferencePublications {
    

// @LINE:27
def updatePage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ConferencePublications.updatePage(), HandlerDef(this, "controllers.ConferencePublications", "updatePage", Seq(), "GET", """""", _prefix + """update/conferencePublication""")
)
                      

// @LINE:26
def add(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ConferencePublications.add(), HandlerDef(this, "controllers.ConferencePublications", "add", Seq(), "POST", """""", _prefix + """addConferencePublication""")
)
                      

// @LINE:24
def display(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ConferencePublications.display(), HandlerDef(this, "controllers.ConferencePublications", "display", Seq(), "GET", """""", _prefix + """conferencePublications""")
)
                      

// @LINE:28
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ConferencePublications.update(), HandlerDef(this, "controllers.ConferencePublications", "update", Seq(), "POST", """""", _prefix + """updateConferencePublication""")
)
                      

// @LINE:25
def addPage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ConferencePublications.addPage(), HandlerDef(this, "controllers.ConferencePublications", "addPage", Seq(), "GET", """""", _prefix + """add/conferencePublication""")
)
                      
    
}
                          

// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:6
class ReverseApplication {
    

// @LINE:12
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:11
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Seq(), "POST", """""", _prefix + """login""")
)
                      

// @LINE:10
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Seq(), "GET", """ Login and authentication""", _prefix + """login""")
)
                      
    
}
                          

// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
class ReverseJournalPublications {
    

// @LINE:21
def updatePage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.JournalPublications.updatePage(), HandlerDef(this, "controllers.JournalPublications", "updatePage", Seq(), "GET", """""", _prefix + """update/journalPublication""")
)
                      

// @LINE:20
def add(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.JournalPublications.add(), HandlerDef(this, "controllers.JournalPublications", "add", Seq(), "POST", """""", _prefix + """addJournalPublication""")
)
                      

// @LINE:18
def display(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.JournalPublications.display(), HandlerDef(this, "controllers.JournalPublications", "display", Seq(), "GET", """""", _prefix + """journalPublications""")
)
                      

// @LINE:22
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.JournalPublications.update(), HandlerDef(this, "controllers.JournalPublications", "update", Seq(), "POST", """""", _prefix + """updateJournalPublication""")
)
                      

// @LINE:19
def addPage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.JournalPublications.addPage(), HandlerDef(this, "controllers.JournalPublications", "addPage", Seq(), "GET", """""", _prefix + """add/journalPublication""")
)
                      
    
}
                          

// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
class ReverseBookChapterPublications {
    

// @LINE:45
def updatePage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.BookChapterPublications.updatePage(), HandlerDef(this, "controllers.BookChapterPublications", "updatePage", Seq(), "GET", """""", _prefix + """update/bookChapterPublication""")
)
                      

// @LINE:44
def add(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.BookChapterPublications.add(), HandlerDef(this, "controllers.BookChapterPublications", "add", Seq(), "POST", """""", _prefix + """addBookChapterPublication""")
)
                      

// @LINE:42
def display(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.BookChapterPublications.display(), HandlerDef(this, "controllers.BookChapterPublications", "display", Seq(), "GET", """""", _prefix + """bookChapterPublications""")
)
                      

// @LINE:46
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.BookChapterPublications.update(), HandlerDef(this, "controllers.BookChapterPublications", "update", Seq(), "POST", """""", _prefix + """updateBookChapterPublication""")
)
                      

// @LINE:43
def addPage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.BookChapterPublications.addPage(), HandlerDef(this, "controllers.BookChapterPublications", "addPage", Seq(), "GET", """""", _prefix + """add/bookChapterPublication""")
)
                      
    
}
                          
}
        
    