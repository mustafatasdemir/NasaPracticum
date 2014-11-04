
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object updateBookChapter extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[BookChapterPublication,play.data.Form[BookChapterPublication],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*2.2*/(publication: BookChapterPublication, publicationForm: play.data.Form[BookChapterPublication]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*2.96*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Update Publication")/*6.28*/ {_display_(Seq[Any](format.raw/*6.30*/("""

  """),_display_(Seq[Any](/*8.4*/if(session.get("email"))/*8.28*/{_display_(Seq[Any](format.raw/*8.29*/("""
    <h2>Update existing book chapter publication</h2>

    """),_display_(Seq[Any](/*11.6*/form(routes.BookChapterPublications.update())/*11.51*/ {_display_(Seq[Any](format.raw/*11.53*/("""
      <input name="idHolder" type="hidden" value=""""),_display_(Seq[Any](/*12.52*/publication/*12.63*/.getId())),format.raw/*12.71*/("""">

      """),_display_(Seq[Any](/*14.8*/inputText(publicationForm("paperTitle"), '_label -> "Title"))),format.raw/*14.68*/("""
      """),_display_(Seq[Any](/*15.8*/inputText(publicationForm("paperAuthors"), '_label -> "Authors"))),format.raw/*15.72*/("""
      """),_display_(Seq[Any](/*16.8*/inputText(publicationForm("keywords"), '_label -> "Keywords"))),format.raw/*16.69*/("""
      """),_display_(Seq[Any](/*17.8*/inputText(publicationForm("systemTags"), '_label -> "System Tags"))),format.raw/*17.74*/("""
      """),_display_(Seq[Any](/*18.8*/inputText(publicationForm("crowdTags"), '_label -> "Crowd Tags"))),format.raw/*18.72*/("""
      """),_display_(Seq[Any](/*19.8*/inputText(publicationForm("year"), '_label -> "Year"))),format.raw/*19.61*/("""
      """),_display_(Seq[Any](/*20.8*/inputText(publicationForm("bookName"), '_label -> "Book Name"))),format.raw/*20.70*/("""
      """),_display_(Seq[Any](/*21.8*/inputText(publicationForm("chapter"), '_label -> "Chapter"))),format.raw/*21.67*/("""
      """),_display_(Seq[Any](/*22.8*/inputText(publicationForm("editorNames"), '_label -> "Editor Names"))),format.raw/*22.76*/("""
      """),_display_(Seq[Any](/*23.8*/inputText(publicationForm("time"), '_label -> "Time"))),format.raw/*23.61*/("""

      <div class="actions">
        <input type="submit" class="btn primary" value="Update">
        <a href=""""),_display_(Seq[Any](/*27.19*/routes/*27.25*/.BookChapterPublications.display())),format.raw/*27.59*/("""" class="btn">Cancel</a>
      </div>
    """)))})),format.raw/*29.6*/("""
  """)))}/*30.4*/else/*30.8*/{_display_(Seq[Any](format.raw/*30.9*/("""
    <h2>Please login to update exiting publications</h2>
  """)))})),format.raw/*32.4*/("""
""")))})),format.raw/*33.2*/("""
"""))}
    }
    
    def render(publication:BookChapterPublication,publicationForm:play.data.Form[BookChapterPublication]): play.api.templates.HtmlFormat.Appendable = apply(publication,publicationForm)
    
    def f:((BookChapterPublication,play.data.Form[BookChapterPublication]) => play.api.templates.HtmlFormat.Appendable) = (publication,publicationForm) => apply(publication,publicationForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 03 13:45:35 PST 2014
                    SOURCE: /Users/ironstone/Desktop/PublicationNetworkAnalysis/frontend/app/views/updateBookChapter.scala.html
                    HASH: 87a85a5c03ebe779cfbe207d03b2de0c345f70c5
                    MATRIX: 841->2|1045->96|1073->115|1109->117|1143->143|1182->145|1221->150|1253->174|1291->175|1387->236|1441->281|1481->283|1569->335|1589->346|1619->354|1665->365|1747->425|1790->433|1876->497|1919->505|2002->566|2045->574|2133->640|2176->648|2262->712|2305->720|2380->773|2423->781|2507->843|2550->851|2631->910|2674->918|2764->986|2807->994|2882->1047|3031->1160|3046->1166|3102->1200|3176->1243|3198->1247|3210->1251|3248->1252|3340->1313|3373->1315
                    LINES: 26->2|30->2|32->5|33->6|33->6|33->6|35->8|35->8|35->8|38->11|38->11|38->11|39->12|39->12|39->12|41->14|41->14|42->15|42->15|43->16|43->16|44->17|44->17|45->18|45->18|46->19|46->19|47->20|47->20|48->21|48->21|49->22|49->22|50->23|50->23|54->27|54->27|54->27|56->29|57->30|57->30|57->30|59->32|60->33
                    -- GENERATED --
                */
            