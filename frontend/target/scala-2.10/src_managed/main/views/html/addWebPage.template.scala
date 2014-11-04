
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
object addWebPage extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[play.data.Form[WebPagePublication],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*2.2*/(publicationForm: play.data.Form[WebPagePublication]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*2.55*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Add Publication")/*6.25*/ {_display_(Seq[Any](format.raw/*6.27*/("""

  """),_display_(Seq[Any](/*8.4*/if(session.get("email"))/*8.28*/{_display_(Seq[Any](format.raw/*8.29*/("""
    <h2>Add a new web page publication</h2>

    <div class="dropdown">
      <button class="btn btn-default dropdown-toggle" type="button" id="publicationChannel" data-toggle="dropdown">
        Web Page Publication 
        <span class="caret"></span>
      </button>
      <ul class="dropdown-menu" role="menu" aria-labelledby="publicationChannel">
        <li role="presentation" class="dropdown-header">Publication Channel</li>
        <li role="presentation" class="divider"></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*19.73*/routes/*19.79*/.JournalPublications.addPage())),format.raw/*19.109*/("""">Journal Publication</a></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*20.73*/routes/*20.79*/.ConferencePublications.addPage())),format.raw/*20.112*/("""">Conference Publication</a></li>
        <li role="presentation" class="disabled"><a role="menuitem" tabindex="-1" href="#">Web Page Publication</a></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*22.73*/routes/*22.79*/.BookPublications.addPage())),format.raw/*22.106*/("""">Book Publication</a></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*23.73*/routes/*23.79*/.BookChapterPublications.addPage())),format.raw/*23.113*/("""">Book Chapter Publication</a></li>
      </ul>
    </div>

    """),_display_(Seq[Any](/*27.6*/form(routes.WebPagePublications.add())/*27.44*/ {_display_(Seq[Any](format.raw/*27.46*/("""
      """),_display_(Seq[Any](/*28.8*/inputText(publicationForm("paperTitle"),'_label -> "Title"))),format.raw/*28.67*/("""
      """),_display_(Seq[Any](/*29.8*/inputText(publicationForm("paperAuthors"), '_label -> "Authors", 'placeholder-> "Author1, Author2, ..."))),format.raw/*29.112*/("""
      """),_display_(Seq[Any](/*30.8*/inputText(publicationForm("keywords"), '_label -> "Keywords", 'placeholder-> "Keyword1, Keyword2, ..."))),format.raw/*30.111*/("""
      """),_display_(Seq[Any](/*31.8*/inputText(publicationForm("systemTags"), '_label -> "System Tags", 'placeholder-> "Tag1, Tag2, ..."))),format.raw/*31.108*/("""
      """),_display_(Seq[Any](/*32.8*/inputText(publicationForm("crowdTags"), '_label -> "Crowd Tags", 'placeholder-> "Tag1, Tag2, ..."))),format.raw/*32.106*/("""
      """),_display_(Seq[Any](/*33.8*/inputText(publicationForm("year"), '_label -> "Year"))),format.raw/*33.61*/("""
      """),_display_(Seq[Any](/*34.8*/inputText(publicationForm("URL"), '_label -> "URL"))),format.raw/*34.59*/("""
      """),_display_(Seq[Any](/*35.8*/inputText(publicationForm("date"), '_label -> "Date", 'placeholder-> "yyyy-mm-dd"))),format.raw/*35.90*/("""

      <div class="actions">
        <input type="submit" class="btn primary" value="Add">
        <a href=""""),_display_(Seq[Any](/*39.19*/routes/*39.25*/.BookChapterPublications.addPage())),format.raw/*39.59*/("""" class="btn">Cancel</a>
      </div>
    """)))})),format.raw/*41.6*/("""
  """)))}/*42.4*/else/*42.8*/{_display_(Seq[Any](format.raw/*42.9*/("""
    <h2>Please login to add a new publications</h2>
  """)))})),format.raw/*44.4*/("""
""")))})),format.raw/*45.2*/("""
"""))}
    }
    
    def render(publicationForm:play.data.Form[WebPagePublication]): play.api.templates.HtmlFormat.Appendable = apply(publicationForm)
    
    def f:((play.data.Form[WebPagePublication]) => play.api.templates.HtmlFormat.Appendable) = (publicationForm) => apply(publicationForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 03 13:45:35 PST 2014
                    SOURCE: /Users/ironstone/Desktop/PublicationNetworkAnalysis/frontend/app/views/addWebPage.scala.html
                    HASH: 638fcdb1db10b34a68aa45bed0a934ded4947572
                    MATRIX: 807->2|970->55|998->74|1034->76|1065->99|1104->101|1143->106|1175->130|1213->131|1809->691|1824->697|1877->727|2016->830|2031->836|2087->869|2350->1096|2365->1102|2415->1129|2551->1229|2566->1235|2623->1269|2723->1334|2770->1372|2810->1374|2853->1382|2934->1441|2977->1449|3104->1553|3147->1561|3273->1664|3316->1672|3439->1772|3482->1780|3603->1878|3646->1886|3721->1939|3764->1947|3837->1998|3880->2006|3984->2088|4130->2198|4145->2204|4201->2238|4275->2281|4297->2285|4309->2289|4347->2290|4434->2346|4467->2348
                    LINES: 26->2|30->2|32->5|33->6|33->6|33->6|35->8|35->8|35->8|46->19|46->19|46->19|47->20|47->20|47->20|49->22|49->22|49->22|50->23|50->23|50->23|54->27|54->27|54->27|55->28|55->28|56->29|56->29|57->30|57->30|58->31|58->31|59->32|59->32|60->33|60->33|61->34|61->34|62->35|62->35|66->39|66->39|66->39|68->41|69->42|69->42|69->42|71->44|72->45
                    -- GENERATED --
                */
            