
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
object addConference extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[play.data.Form[ConferencePublication],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*2.2*/(publicationForm: play.data.Form[ConferencePublication]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*2.58*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Add Publication")/*6.25*/ {_display_(Seq[Any](format.raw/*6.27*/("""

  """),_display_(Seq[Any](/*8.4*/if(session.get("email"))/*8.28*/{_display_(Seq[Any](format.raw/*8.29*/("""
    <h2>Add a new conference publication</h2>

    <div class="dropdown">
      <button class="btn btn-default dropdown-toggle" type="button" id="publicationChannel" data-toggle="dropdown">
        Conference Publication 
        <span class="caret"></span>
      </button>
      <ul class="dropdown-menu" role="menu" aria-labelledby="publicationChannel">
        <li role="presentation" class="dropdown-header">Publication Channel</li>
        <li role="presentation" class="divider"></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*19.73*/routes/*19.79*/.JournalPublications.addPage())),format.raw/*19.109*/("""">Journal Publication</a></li>
        <li role="presentation" class="disabled"><a role="menuitem" tabindex="-1" href="#">Conference Publication</a></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*21.73*/routes/*21.79*/.WebPagePublications.addPage())),format.raw/*21.109*/("""">Web Page Publication</a></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*22.73*/routes/*22.79*/.BookPublications.addPage())),format.raw/*22.106*/("""">Book Publication</a></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*23.73*/routes/*23.79*/.BookChapterPublications.addPage())),format.raw/*23.113*/("""">Book Chapter Publication</a></li>
      </ul>
    </div>

    """),_display_(Seq[Any](/*27.6*/form(routes.ConferencePublications.add())/*27.47*/ {_display_(Seq[Any](format.raw/*27.49*/("""
      """),_display_(Seq[Any](/*28.8*/inputText(publicationForm("paperTitle"),'_label -> "Title"))),format.raw/*28.67*/("""
      """),_display_(Seq[Any](/*29.8*/inputText(publicationForm("paperAuthors"), '_label -> "Authors", 'placeholder-> "Author1, Author2, ..."))),format.raw/*29.112*/("""
      """),_display_(Seq[Any](/*30.8*/inputText(publicationForm("keywords"), '_label -> "Keywords", 'placeholder-> "Keyword1, Keyword2, ..."))),format.raw/*30.111*/("""
      """),_display_(Seq[Any](/*31.8*/inputText(publicationForm("systemTags"), '_label -> "System Tags", 'placeholder-> "Tag1, Tag2, ..."))),format.raw/*31.108*/("""
      """),_display_(Seq[Any](/*32.8*/inputText(publicationForm("crowdTags"), '_label -> "Crowd Tags", 'placeholder-> "Tag1, Tag2, ..."))),format.raw/*32.106*/("""
      """),_display_(Seq[Any](/*33.8*/inputText(publicationForm("year"), '_label -> "Year"))),format.raw/*33.61*/("""
      """),_display_(Seq[Any](/*34.8*/inputText(publicationForm("conferenceName"), '_label -> "Conference Name"))),format.raw/*34.82*/("""
      """),_display_(Seq[Any](/*35.8*/inputText(publicationForm("conferenceLocation"), '_label -> "Conference Location"))),format.raw/*35.90*/("""
      """),_display_(Seq[Any](/*36.8*/inputText(publicationForm("time"), '_label -> "Time"))),format.raw/*36.61*/("""
      """),_display_(Seq[Any](/*37.8*/inputText(publicationForm("pages"), '_label -> "Pages"))),format.raw/*37.63*/("""

      <div class="actions">
        <input type="submit" class="btn primary" value="Add">
        <a href=""""),_display_(Seq[Any](/*41.19*/routes/*41.25*/.ConferencePublications.addPage())),format.raw/*41.58*/("""" class="btn">Cancel</a>
      </div>
    """)))})),format.raw/*43.6*/("""
  """)))}/*44.4*/else/*44.8*/{_display_(Seq[Any](format.raw/*44.9*/("""
    <h2>Please login to add a new publications</h2>
  """)))})),format.raw/*46.4*/("""
""")))})),format.raw/*47.2*/("""
"""))}
    }
    
    def render(publicationForm:play.data.Form[ConferencePublication]): play.api.templates.HtmlFormat.Appendable = apply(publicationForm)
    
    def f:((play.data.Form[ConferencePublication]) => play.api.templates.HtmlFormat.Appendable) = (publicationForm) => apply(publicationForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 03 13:45:35 PST 2014
                    SOURCE: /Users/ironstone/Desktop/PublicationNetworkAnalysis/frontend/app/views/addConference.scala.html
                    HASH: a86f99ff7b8ed8bab3a9273c6eb60041cde834dc
                    MATRIX: 813->2|979->58|1007->77|1043->79|1074->102|1113->104|1152->109|1184->133|1222->134|1822->698|1837->704|1890->734|2152->960|2167->966|2220->996|2360->1100|2375->1106|2425->1133|2561->1233|2576->1239|2633->1273|2733->1338|2783->1379|2823->1381|2866->1389|2947->1448|2990->1456|3117->1560|3160->1568|3286->1671|3329->1679|3452->1779|3495->1787|3616->1885|3659->1893|3734->1946|3777->1954|3873->2028|3916->2036|4020->2118|4063->2126|4138->2179|4181->2187|4258->2242|4404->2352|4419->2358|4474->2391|4548->2434|4570->2438|4582->2442|4620->2443|4707->2499|4740->2501
                    LINES: 26->2|30->2|32->5|33->6|33->6|33->6|35->8|35->8|35->8|46->19|46->19|46->19|48->21|48->21|48->21|49->22|49->22|49->22|50->23|50->23|50->23|54->27|54->27|54->27|55->28|55->28|56->29|56->29|57->30|57->30|58->31|58->31|59->32|59->32|60->33|60->33|61->34|61->34|62->35|62->35|63->36|63->36|64->37|64->37|68->41|68->41|68->41|70->43|71->44|71->44|71->44|73->46|74->47
                    -- GENERATED --
                */
            