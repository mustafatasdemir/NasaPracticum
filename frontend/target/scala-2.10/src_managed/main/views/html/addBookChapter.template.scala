
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
object addBookChapter extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[play.data.Form[BookChapterPublication],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*2.2*/(publicationForm: play.data.Form[BookChapterPublication]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*2.59*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Add Publication")/*6.25*/ {_display_(Seq[Any](format.raw/*6.27*/("""

  """),_display_(Seq[Any](/*8.4*/if(session.get("email"))/*8.28*/{_display_(Seq[Any](format.raw/*8.29*/("""
    <h2>Add a new book chapter publication</h2>

    <div class="dropdown">
      <button class="btn btn-default dropdown-toggle" type="button" id="publicationChannel" data-toggle="dropdown">
        Book Chapter Publication 
        <span class="caret"></span>
      </button>
      <ul class="dropdown-menu" role="menu" aria-labelledby="publicationChannel">
        <li role="presentation" class="dropdown-header">Publication Channel</li>
        <li role="presentation" class="divider"></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*19.73*/routes/*19.79*/.JournalPublications.addPage())),format.raw/*19.109*/("""">Journal Publication</a></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*20.73*/routes/*20.79*/.ConferencePublications.addPage())),format.raw/*20.112*/("""">Conference Publication</a></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*21.73*/routes/*21.79*/.WebPagePublications.addPage())),format.raw/*21.109*/("""">Web Page Publication</a></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*22.73*/routes/*22.79*/.BookPublications.addPage())),format.raw/*22.106*/("""">Book Publication</a></li>
        <li role="presentation" class="disabled"><a role="menuitem" tabindex="-1" href="#">Book Chapter Publication</a></li>
      </ul>
    </div>

    """),_display_(Seq[Any](/*27.6*/form(routes.BookChapterPublications.add())/*27.48*/ {_display_(Seq[Any](format.raw/*27.50*/("""
      """),_display_(Seq[Any](/*28.8*/inputText(publicationForm("paperTitle"),'_label -> "Title"))),format.raw/*28.67*/("""
      """),_display_(Seq[Any](/*29.8*/inputText(publicationForm("paperAuthors"), '_label -> "Authors", 'placeholder-> "Author1, Author2, ..."))),format.raw/*29.112*/("""
      """),_display_(Seq[Any](/*30.8*/inputText(publicationForm("keywords"), '_label -> "Keywords", 'placeholder-> "Keyword1, Keyword2, ..."))),format.raw/*30.111*/("""
      """),_display_(Seq[Any](/*31.8*/inputText(publicationForm("systemTags"), '_label -> "System Tags", 'placeholder-> "Tag1, Tag2, ..."))),format.raw/*31.108*/("""
      """),_display_(Seq[Any](/*32.8*/inputText(publicationForm("crowdTags"), '_label -> "Crowd Tags", 'placeholder-> "Tag1, Tag2, ..."))),format.raw/*32.106*/("""
      """),_display_(Seq[Any](/*33.8*/inputText(publicationForm("year"), '_label -> "Year"))),format.raw/*33.61*/("""
      """),_display_(Seq[Any](/*34.8*/inputText(publicationForm("bookName"), '_label -> "Book Name"))),format.raw/*34.70*/("""
      """),_display_(Seq[Any](/*35.8*/inputText(publicationForm("chapter"), '_label -> "Chapter Number"))),format.raw/*35.74*/("""
      """),_display_(Seq[Any](/*36.8*/inputText(publicationForm("editorNames"), '_label -> "Editor Names", 'placeholder-> "Editor1, Editor2, ..."))),format.raw/*36.116*/("""
      """),_display_(Seq[Any](/*37.8*/inputText(publicationForm("time"), '_label -> "Time"))),format.raw/*37.61*/("""

      <div class="actions">
        <input type="submit" class="btn primary" value="Add">
        <a href=""""),_display_(Seq[Any](/*41.19*/routes/*41.25*/.BookChapterPublications.addPage())),format.raw/*41.59*/("""" class="btn">Cancel</a>
      </div>
    """)))})),format.raw/*43.6*/("""
  """)))}/*44.4*/else/*44.8*/{_display_(Seq[Any](format.raw/*44.9*/("""
    <h2>Please login to add a new publications</h2>
  """)))})),format.raw/*46.4*/("""
""")))})),format.raw/*47.2*/("""
"""))}
    }
    
    def render(publicationForm:play.data.Form[BookChapterPublication]): play.api.templates.HtmlFormat.Appendable = apply(publicationForm)
    
    def f:((play.data.Form[BookChapterPublication]) => play.api.templates.HtmlFormat.Appendable) = (publicationForm) => apply(publicationForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 03 13:45:35 PST 2014
                    SOURCE: /Users/ironstone/Desktop/PublicationNetworkAnalysis/frontend/app/views/addBookChapter.scala.html
                    HASH: 59201e043655ed51a4fbd464ab00b7a15f422240
                    MATRIX: 815->2|982->59|1010->78|1046->80|1077->103|1116->105|1155->110|1187->134|1225->135|1829->703|1844->709|1897->739|2036->842|2051->848|2107->881|2249->987|2264->993|2317->1023|2457->1127|2472->1133|2522->1160|2739->1342|2790->1384|2830->1386|2873->1394|2954->1453|2997->1461|3124->1565|3167->1573|3293->1676|3336->1684|3459->1784|3502->1792|3623->1890|3666->1898|3741->1951|3784->1959|3868->2021|3911->2029|3999->2095|4042->2103|4173->2211|4216->2219|4291->2272|4437->2382|4452->2388|4508->2422|4582->2465|4604->2469|4616->2473|4654->2474|4741->2530|4774->2532
                    LINES: 26->2|30->2|32->5|33->6|33->6|33->6|35->8|35->8|35->8|46->19|46->19|46->19|47->20|47->20|47->20|48->21|48->21|48->21|49->22|49->22|49->22|54->27|54->27|54->27|55->28|55->28|56->29|56->29|57->30|57->30|58->31|58->31|59->32|59->32|60->33|60->33|61->34|61->34|62->35|62->35|63->36|63->36|64->37|64->37|68->41|68->41|68->41|70->43|71->44|71->44|71->44|73->46|74->47
                    -- GENERATED --
                */
            