// @SOURCE:/Users/ironstone/Desktop/PublicationNetworkAnalysis/backend/conf/routes
// @HASH:f5937c979d9667d589457908fd2b5e331920b3ee
// @DATE:Mon Nov 03 13:43:40 PST 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:43
// @LINE:39
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:8
// @LINE:6
package controllers {

// @LINE:43
class ReverseAssets {
    

// @LINE:43
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:39
class ReverseUsers {
    

// @LINE:39
def getUser(email:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "getUser/" + implicitly[PathBindable[String]].unbind("email", dynamicString(email)))
}
                                                
    
}
                          

// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:8
class ReversePublications {
    

// @LINE:12
def delete(id:String): Call = {
   Call("DELETE", _prefix + { _defaultPrefix } + "deletePublication/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                                                

// @LINE:11
def getAll(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "getAllPublications")
}
                                                

// @LINE:8
def test(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "test")
}
                                                

// @LINE:10
def get(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "getPublication/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                                                
    
}
                          

// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
class ReverseBookPublications {
    

// @LINE:22
def update(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "updateBookPublication")
}
                                                

// @LINE:20
def getAll(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "getAllBookPublications")
}
                                                

// @LINE:21
def add(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "addBookPublication")
}
                                                

// @LINE:19
def get(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "getBookPublication/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                                                
    
}
                          

// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
class ReverseWebPagePublications {
    

// @LINE:37
def update(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "updateWebPagePublication")
}
                                                

// @LINE:35
def getAll(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "getAllWebPagePublications")
}
                                                

// @LINE:36
def add(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "addWebPagePublication")
}
                                                

// @LINE:34
def get(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "getWebPagePublication/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                                                
    
}
                          

// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
class ReverseConferencePublications {
    

// @LINE:32
def update(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "updateConferencePublication")
}
                                                

// @LINE:30
def getAll(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "getAllConferencePublications")
}
                                                

// @LINE:31
def add(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "addConferencePublication")
}
                                                

// @LINE:29
def get(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "getConferencePublication/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                                                
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
class ReverseJournalPublications {
    

// @LINE:17
def update(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "updateJournalPublication")
}
                                                

// @LINE:15
def getAll(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "getAllJournalPublications")
}
                                                

// @LINE:16
def add(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "addJournalPublication")
}
                                                

// @LINE:14
def get(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "getJournalPublication/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                                                
    
}
                          

// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
class ReverseBookChapterPublications {
    

// @LINE:27
def update(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "updateBookChapterPublication")
}
                                                

// @LINE:25
def getAll(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "getAllBookChapterPublications")
}
                                                

// @LINE:26
def add(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "addBookChapterPublication")
}
                                                

// @LINE:24
def get(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "getBookChapterPublication/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                                                
    
}
                          
}
                  


// @LINE:43
// @LINE:39
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:8
// @LINE:6
package controllers.javascript {

// @LINE:43
class ReverseAssets {
    

// @LINE:43
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:39
class ReverseUsers {
    

// @LINE:39
def getUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Users.getUser",
   """
      function(email) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getUser/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("email", encodeURIComponent(email))})
      }
   """
)
                        
    
}
              

// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:8
class ReversePublications {
    

// @LINE:12
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Publications.delete",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "deletePublication/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:11
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Publications.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllPublications"})
      }
   """
)
                        

// @LINE:8
def test : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Publications.test",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "test"})
      }
   """
)
                        

// @LINE:10
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Publications.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getPublication/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        
    
}
              

// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
class ReverseBookPublications {
    

// @LINE:22
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.BookPublications.update",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateBookPublication"})
      }
   """
)
                        

// @LINE:20
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.BookPublications.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllBookPublications"})
      }
   """
)
                        

// @LINE:21
def add : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.BookPublications.add",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addBookPublication"})
      }
   """
)
                        

// @LINE:19
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.BookPublications.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getBookPublication/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        
    
}
              

// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
class ReverseWebPagePublications {
    

// @LINE:37
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.WebPagePublications.update",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateWebPagePublication"})
      }
   """
)
                        

// @LINE:35
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.WebPagePublications.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllWebPagePublications"})
      }
   """
)
                        

// @LINE:36
def add : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.WebPagePublications.add",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addWebPagePublication"})
      }
   """
)
                        

// @LINE:34
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.WebPagePublications.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getWebPagePublication/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        
    
}
              

// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
class ReverseConferencePublications {
    

// @LINE:32
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ConferencePublications.update",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateConferencePublication"})
      }
   """
)
                        

// @LINE:30
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ConferencePublications.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllConferencePublications"})
      }
   """
)
                        

// @LINE:31
def add : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ConferencePublications.add",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addConferencePublication"})
      }
   """
)
                        

// @LINE:29
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ConferencePublications.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getConferencePublication/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        
    
}
              

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              

// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
class ReverseJournalPublications {
    

// @LINE:17
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.JournalPublications.update",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateJournalPublication"})
      }
   """
)
                        

// @LINE:15
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.JournalPublications.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllJournalPublications"})
      }
   """
)
                        

// @LINE:16
def add : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.JournalPublications.add",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addJournalPublication"})
      }
   """
)
                        

// @LINE:14
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.JournalPublications.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getJournalPublication/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        
    
}
              

// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
class ReverseBookChapterPublications {
    

// @LINE:27
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.BookChapterPublications.update",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateBookChapterPublication"})
      }
   """
)
                        

// @LINE:25
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.BookChapterPublications.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllBookChapterPublications"})
      }
   """
)
                        

// @LINE:26
def add : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.BookChapterPublications.add",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addBookChapterPublication"})
      }
   """
)
                        

// @LINE:24
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.BookChapterPublications.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getBookChapterPublication/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        
    
}
              
}
        


// @LINE:43
// @LINE:39
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:8
// @LINE:6
package controllers.ref {


// @LINE:43
class ReverseAssets {
    

// @LINE:43
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:39
class ReverseUsers {
    

// @LINE:39
def getUser(email:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Users.getUser(email), HandlerDef(this, "controllers.Users", "getUser", Seq(classOf[String]), "GET", """""", _prefix + """getUser/$email<[^/]+>""")
)
                      
    
}
                          

// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:8
class ReversePublications {
    

// @LINE:12
def delete(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Publications.delete(id), HandlerDef(this, "controllers.Publications", "delete", Seq(classOf[String]), "DELETE", """""", _prefix + """deletePublication/$id<[^/]+>""")
)
                      

// @LINE:11
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Publications.getAll(), HandlerDef(this, "controllers.Publications", "getAll", Seq(), "GET", """""", _prefix + """getAllPublications""")
)
                      

// @LINE:8
def test(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Publications.test(), HandlerDef(this, "controllers.Publications", "test", Seq(), "GET", """""", _prefix + """test""")
)
                      

// @LINE:10
def get(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Publications.get(id), HandlerDef(this, "controllers.Publications", "get", Seq(classOf[String]), "GET", """""", _prefix + """getPublication/$id<[^/]+>""")
)
                      
    
}
                          

// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
class ReverseBookPublications {
    

// @LINE:22
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.BookPublications.update(), HandlerDef(this, "controllers.BookPublications", "update", Seq(), "POST", """""", _prefix + """updateBookPublication""")
)
                      

// @LINE:20
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.BookPublications.getAll(), HandlerDef(this, "controllers.BookPublications", "getAll", Seq(), "GET", """""", _prefix + """getAllBookPublications""")
)
                      

// @LINE:21
def add(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.BookPublications.add(), HandlerDef(this, "controllers.BookPublications", "add", Seq(), "POST", """""", _prefix + """addBookPublication""")
)
                      

// @LINE:19
def get(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.BookPublications.get(id), HandlerDef(this, "controllers.BookPublications", "get", Seq(classOf[String]), "GET", """""", _prefix + """getBookPublication/$id<[^/]+>""")
)
                      
    
}
                          

// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
class ReverseWebPagePublications {
    

// @LINE:37
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.WebPagePublications.update(), HandlerDef(this, "controllers.WebPagePublications", "update", Seq(), "POST", """""", _prefix + """updateWebPagePublication""")
)
                      

// @LINE:35
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.WebPagePublications.getAll(), HandlerDef(this, "controllers.WebPagePublications", "getAll", Seq(), "GET", """""", _prefix + """getAllWebPagePublications""")
)
                      

// @LINE:36
def add(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.WebPagePublications.add(), HandlerDef(this, "controllers.WebPagePublications", "add", Seq(), "POST", """""", _prefix + """addWebPagePublication""")
)
                      

// @LINE:34
def get(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.WebPagePublications.get(id), HandlerDef(this, "controllers.WebPagePublications", "get", Seq(classOf[String]), "GET", """""", _prefix + """getWebPagePublication/$id<[^/]+>""")
)
                      
    
}
                          

// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
class ReverseConferencePublications {
    

// @LINE:32
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ConferencePublications.update(), HandlerDef(this, "controllers.ConferencePublications", "update", Seq(), "POST", """""", _prefix + """updateConferencePublication""")
)
                      

// @LINE:30
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ConferencePublications.getAll(), HandlerDef(this, "controllers.ConferencePublications", "getAll", Seq(), "GET", """""", _prefix + """getAllConferencePublications""")
)
                      

// @LINE:31
def add(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ConferencePublications.add(), HandlerDef(this, "controllers.ConferencePublications", "add", Seq(), "POST", """""", _prefix + """addConferencePublication""")
)
                      

// @LINE:29
def get(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ConferencePublications.get(id), HandlerDef(this, "controllers.ConferencePublications", "get", Seq(classOf[String]), "GET", """""", _prefix + """getConferencePublication/$id<[^/]+>""")
)
                      
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          

// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
class ReverseJournalPublications {
    

// @LINE:17
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.JournalPublications.update(), HandlerDef(this, "controllers.JournalPublications", "update", Seq(), "POST", """""", _prefix + """updateJournalPublication""")
)
                      

// @LINE:15
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.JournalPublications.getAll(), HandlerDef(this, "controllers.JournalPublications", "getAll", Seq(), "GET", """""", _prefix + """getAllJournalPublications""")
)
                      

// @LINE:16
def add(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.JournalPublications.add(), HandlerDef(this, "controllers.JournalPublications", "add", Seq(), "POST", """""", _prefix + """addJournalPublication""")
)
                      

// @LINE:14
def get(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.JournalPublications.get(id), HandlerDef(this, "controllers.JournalPublications", "get", Seq(classOf[String]), "GET", """""", _prefix + """getJournalPublication/$id<[^/]+>""")
)
                      
    
}
                          

// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
class ReverseBookChapterPublications {
    

// @LINE:27
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.BookChapterPublications.update(), HandlerDef(this, "controllers.BookChapterPublications", "update", Seq(), "POST", """""", _prefix + """updateBookChapterPublication""")
)
                      

// @LINE:25
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.BookChapterPublications.getAll(), HandlerDef(this, "controllers.BookChapterPublications", "getAll", Seq(), "GET", """""", _prefix + """getAllBookChapterPublications""")
)
                      

// @LINE:26
def add(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.BookChapterPublications.add(), HandlerDef(this, "controllers.BookChapterPublications", "add", Seq(), "POST", """""", _prefix + """addBookChapterPublication""")
)
                      

// @LINE:24
def get(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.BookChapterPublications.get(id), HandlerDef(this, "controllers.BookChapterPublications", "get", Seq(classOf[String]), "GET", """""", _prefix + """getBookChapterPublication/$id<[^/]+>""")
)
                      
    
}
                          
}
        
    