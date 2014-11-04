
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
object addJournal extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[play.data.Form[JournalPublication],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*2.2*/(publicationForm: play.data.Form[JournalPublication]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*2.55*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Add Publication")/*6.25*/ {_display_(Seq[Any](format.raw/*6.27*/("""

  """),_display_(Seq[Any](/*8.4*/if(session.get("email"))/*8.28*/{_display_(Seq[Any](format.raw/*8.29*/("""
    <h2>Add a new journal publication</h2>

    <div class="dropdown">
      <button class="btn btn-default dropdown-toggle" type="button" id="publicationChannel" data-toggle="dropdown">
        Journal Publication 
        <span class="caret"></span>
      </button>
      <ul class="dropdown-menu" role="menu" aria-labelledby="publicationChannel">
        <li role="presentation" class="dropdown-header">Publication Channel</li>
        <li role="presentation" class="divider"></li>
        <li role="presentation" class="disabled"><a role="menuitem" tabindex="-1" href="#">Journal Publication</a></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*20.73*/routes/*20.79*/.ConferencePublications.addPage())),format.raw/*20.112*/("""">Conference Publication</a></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*21.73*/routes/*21.79*/.WebPagePublications.addPage())),format.raw/*21.109*/("""">Web Page Publication</a></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*22.73*/routes/*22.79*/.BookPublications.addPage())),format.raw/*22.106*/("""">Book Publication</a></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*23.73*/routes/*23.79*/.BookChapterPublications.addPage())),format.raw/*23.113*/("""">Book Chapter Publication</a></li>
      </ul>
    </div>

    """),_display_(Seq[Any](/*27.6*/form(routes.JournalPublications.add())/*27.44*/ {_display_(Seq[Any](format.raw/*27.46*/("""
      """),_display_(Seq[Any](/*28.8*/inputText(publicationForm("paperTitle"),'_label -> "Title"))),format.raw/*28.67*/("""
      """),_display_(Seq[Any](/*29.8*/inputText(publicationForm("paperAuthors"), '_label -> "Authors", 'placeholder-> "Author1, Author2, ..."))),format.raw/*29.112*/("""
      """),_display_(Seq[Any](/*30.8*/inputText(publicationForm("keywords"), '_label -> "Keywords", 'placeholder-> "Keyword1, Keyword2, ..."))),format.raw/*30.111*/("""
      """),_display_(Seq[Any](/*31.8*/inputText(publicationForm("systemTags"), '_label -> "System Tags", 'placeholder-> "Tag1, Tag2, ..."))),format.raw/*31.108*/("""
      """),_display_(Seq[Any](/*32.8*/inputText(publicationForm("crowdTags"), '_label -> "Crowd Tags", 'placeholder-> "Tag1, Tag2, ..."))),format.raw/*32.106*/("""
      """),_display_(Seq[Any](/*33.8*/inputText(publicationForm("year"), '_label -> "Year"))),format.raw/*33.61*/("""
      """),_display_(Seq[Any](/*34.8*/inputText(publicationForm("journalName"), '_label -> "Journal Name"))),format.raw/*34.76*/("""
      """),_display_(Seq[Any](/*35.8*/inputText(publicationForm("volume"), '_label -> "Volume"))),format.raw/*35.65*/("""
      """),_display_(Seq[Any](/*36.8*/inputText(publicationForm("column"), '_label -> "Column"))),format.raw/*36.65*/("""
      """),_display_(Seq[Any](/*37.8*/inputText(publicationForm("pages"), '_label -> "Pages"))),format.raw/*37.63*/("""

      <div class="actions">
        <input type="submit" class="btn primary" value="Add">
        <a href=""""),_display_(Seq[Any](/*41.19*/routes/*41.25*/.JournalPublications.addPage())),format.raw/*41.55*/("""" class="btn">Cancel</a>
      </div>
    """)))})),format.raw/*43.6*/("""
  """)))}/*44.4*/else/*44.8*/{_display_(Seq[Any](format.raw/*44.9*/("""
    <h2>Please login to add a new publications</h2>
  """)))})),format.raw/*46.4*/("""
""")))})),format.raw/*47.2*/("""
"""))}
    }
    
    def render(publicationForm:play.data.Form[JournalPublication]): play.api.templates.HtmlFormat.Appendable = apply(publicationForm)
    
    def f:((play.data.Form[JournalPublication]) => play.api.templates.HtmlFormat.Appendable) = (publicationForm) => apply(publicationForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 03 13:45:35 PST 2014
                    SOURCE: /Users/ironstone/Desktop/PublicationNetworkAnalysis/frontend/app/views/addJournal.scala.html
                    HASH: ec73c34c1f994d40dd70b5754d0a7375628b1c8b
                    MATRIX: 807->2|970->55|998->74|1034->76|1065->99|1104->101|1143->106|1175->130|1213->131|1927->809|1942->815|1998->848|2140->954|2155->960|2208->990|2348->1094|2363->1100|2413->1127|2549->1227|2564->1233|2621->1267|2721->1332|2768->1370|2808->1372|2851->1380|2932->1439|2975->1447|3102->1551|3145->1559|3271->1662|3314->1670|3437->1770|3480->1778|3601->1876|3644->1884|3719->1937|3762->1945|3852->2013|3895->2021|3974->2078|4017->2086|4096->2143|4139->2151|4216->2206|4362->2316|4377->2322|4429->2352|4503->2395|4525->2399|4537->2403|4575->2404|4662->2460|4695->2462
                    LINES: 26->2|30->2|32->5|33->6|33->6|33->6|35->8|35->8|35->8|47->20|47->20|47->20|48->21|48->21|48->21|49->22|49->22|49->22|50->23|50->23|50->23|54->27|54->27|54->27|55->28|55->28|56->29|56->29|57->30|57->30|58->31|58->31|59->32|59->32|60->33|60->33|61->34|61->34|62->35|62->35|63->36|63->36|64->37|64->37|68->41|68->41|68->41|70->43|71->44|71->44|71->44|73->46|74->47
                    -- GENERATED --
                */
            