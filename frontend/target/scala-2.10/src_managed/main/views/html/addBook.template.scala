
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
object addBook extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[play.data.Form[BookPublication],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*2.2*/(publicationForm: play.data.Form[BookPublication]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*2.52*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Add Publication")/*6.25*/ {_display_(Seq[Any](format.raw/*6.27*/("""

  """),_display_(Seq[Any](/*8.4*/if(session.get("email"))/*8.28*/{_display_(Seq[Any](format.raw/*8.29*/("""
    <h2>Add a new book publication</h2>

    <div class="dropdown">
      <button class="btn btn-default dropdown-toggle" type="button" id="publicationChannel" data-toggle="dropdown">
        Book Publication 
        <span class="caret"></span>
      </button>
      <ul class="dropdown-menu" role="menu" aria-labelledby="publicationChannel">
        <li role="presentation" class="dropdown-header">Publication Channel</li>
        <li role="presentation" class="divider"></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*19.73*/routes/*19.79*/.JournalPublications.addPage())),format.raw/*19.109*/("""">Journal Publication</a></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*20.73*/routes/*20.79*/.ConferencePublications.addPage())),format.raw/*20.112*/("""">Conference Publication</a></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*21.73*/routes/*21.79*/.WebPagePublications.addPage())),format.raw/*21.109*/("""">Web Page Publication</a></li>
        <li role="presentation" class="disabled"><a role="menuitem" tabindex="-1" href="#">Book Publication</a></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*23.73*/routes/*23.79*/.BookChapterPublications.addPage())),format.raw/*23.113*/("""">Book Chapter Publication</a></li>
      </ul>
    </div>

    """),_display_(Seq[Any](/*27.6*/form(routes.BookPublications.add())/*27.41*/ {_display_(Seq[Any](format.raw/*27.43*/("""
      """),_display_(Seq[Any](/*28.8*/inputText(publicationForm("paperTitle"),'_label -> "Title"))),format.raw/*28.67*/("""
      """),_display_(Seq[Any](/*29.8*/inputText(publicationForm("paperAuthors"), '_label -> "Authors", 'placeholder-> "Author1, Author2, ..."))),format.raw/*29.112*/("""
      """),_display_(Seq[Any](/*30.8*/inputText(publicationForm("keywords"), '_label -> "Keywords", 'placeholder-> "Keyword1, Keyword2, ..."))),format.raw/*30.111*/("""
      """),_display_(Seq[Any](/*31.8*/inputText(publicationForm("systemTags"), '_label -> "System Tags", 'placeholder-> "Tag1, Tag2, ..."))),format.raw/*31.108*/("""
      """),_display_(Seq[Any](/*32.8*/inputText(publicationForm("crowdTags"), '_label -> "Crowd Tags", 'placeholder-> "Tag1, Tag2, ..."))),format.raw/*32.106*/("""
      """),_display_(Seq[Any](/*33.8*/inputText(publicationForm("year"), '_label -> "Year"))),format.raw/*33.61*/("""
      """),_display_(Seq[Any](/*34.8*/inputText(publicationForm("bookName"), '_label -> "Book Name"))),format.raw/*34.70*/("""
      """),_display_(Seq[Any](/*35.8*/inputText(publicationForm("publisherName"), '_label -> "Publisher Name"))),format.raw/*35.80*/("""
      """),_display_(Seq[Any](/*36.8*/inputText(publicationForm("publisherLocation"), '_label -> "Publisher Location"))),format.raw/*36.88*/("""
      """),_display_(Seq[Any](/*37.8*/inputText(publicationForm("time"), '_label -> "Time"))),format.raw/*37.61*/("""
      """),_display_(Seq[Any](/*38.8*/inputText(publicationForm("pages"), '_label -> "Pages"))),format.raw/*38.63*/("""

      <div class="actions">
        <input type="submit" class="btn primary" value="Add">
        <a href=""""),_display_(Seq[Any](/*42.19*/routes/*42.25*/.BookPublications.addPage())),format.raw/*42.52*/("""" class="btn">Cancel</a>
      </div>
    """)))})),format.raw/*44.6*/("""
  """)))}/*45.4*/else/*45.8*/{_display_(Seq[Any](format.raw/*45.9*/("""
    <h2>Please login to add a new publications</h2>
  """)))})),format.raw/*47.4*/("""
""")))})),format.raw/*48.2*/("""
"""))}
    }
    
    def render(publicationForm:play.data.Form[BookPublication]): play.api.templates.HtmlFormat.Appendable = apply(publicationForm)
    
    def f:((play.data.Form[BookPublication]) => play.api.templates.HtmlFormat.Appendable) = (publicationForm) => apply(publicationForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 03 13:45:34 PST 2014
                    SOURCE: /Users/ironstone/Desktop/PublicationNetworkAnalysis/frontend/app/views/addBook.scala.html
                    HASH: ebb26d96228e176339751c52d9d87a114c2f276d
                    MATRIX: 801->2|961->52|989->71|1025->73|1056->96|1095->98|1134->103|1166->127|1204->128|1792->680|1807->686|1860->716|1999->819|2014->825|2070->858|2212->964|2227->970|2280->1000|2537->1221|2552->1227|2609->1261|2709->1326|2753->1361|2793->1363|2836->1371|2917->1430|2960->1438|3087->1542|3130->1550|3256->1653|3299->1661|3422->1761|3465->1769|3586->1867|3629->1875|3704->1928|3747->1936|3831->1998|3874->2006|3968->2078|4011->2086|4113->2166|4156->2174|4231->2227|4274->2235|4351->2290|4497->2400|4512->2406|4561->2433|4635->2476|4657->2480|4669->2484|4707->2485|4794->2541|4827->2543
                    LINES: 26->2|30->2|32->5|33->6|33->6|33->6|35->8|35->8|35->8|46->19|46->19|46->19|47->20|47->20|47->20|48->21|48->21|48->21|50->23|50->23|50->23|54->27|54->27|54->27|55->28|55->28|56->29|56->29|57->30|57->30|58->31|58->31|59->32|59->32|60->33|60->33|61->34|61->34|62->35|62->35|63->36|63->36|64->37|64->37|65->38|65->38|69->42|69->42|69->42|71->44|72->45|72->45|72->45|74->47|75->48
                    -- GENERATED --
                */
            