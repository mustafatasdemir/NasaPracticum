
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
object updateJournal extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[JournalPublication,play.data.Form[JournalPublication],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*2.2*/(publication: JournalPublication, publicationForm: play.data.Form[JournalPublication]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*2.88*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Update Publication")/*6.28*/ {_display_(Seq[Any](format.raw/*6.30*/("""

  """),_display_(Seq[Any](/*8.4*/if(session.get("email"))/*8.28*/{_display_(Seq[Any](format.raw/*8.29*/("""
    <h2>Update existing journal publication</h2>

    """),_display_(Seq[Any](/*11.6*/form(routes.JournalPublications.update())/*11.47*/ {_display_(Seq[Any](format.raw/*11.49*/("""
      <input name="idHolder" type="hidden" value=""""),_display_(Seq[Any](/*12.52*/publication/*12.63*/.getId())),format.raw/*12.71*/("""">

      """),_display_(Seq[Any](/*14.8*/inputText(publicationForm("paperTitle"), '_label -> "Title"))),format.raw/*14.68*/("""
      """),_display_(Seq[Any](/*15.8*/inputText(publicationForm("paperAuthors"), '_label -> "Authors"))),format.raw/*15.72*/("""
      """),_display_(Seq[Any](/*16.8*/inputText(publicationForm("keywords"), '_label -> "Keywords"))),format.raw/*16.69*/("""
      """),_display_(Seq[Any](/*17.8*/inputText(publicationForm("systemTags"), '_label -> "System Tags"))),format.raw/*17.74*/("""
      """),_display_(Seq[Any](/*18.8*/inputText(publicationForm("crowdTags"), '_label -> "Crowd Tags"))),format.raw/*18.72*/("""
      """),_display_(Seq[Any](/*19.8*/inputText(publicationForm("year"), '_label -> "Year"))),format.raw/*19.61*/("""
      """),_display_(Seq[Any](/*20.8*/inputText(publicationForm("journalName"), '_label -> "Journal Name"))),format.raw/*20.76*/("""
      """),_display_(Seq[Any](/*21.8*/inputText(publicationForm("volume"), '_label -> "Volume"))),format.raw/*21.65*/("""
      """),_display_(Seq[Any](/*22.8*/inputText(publicationForm("column"), '_label -> "Column"))),format.raw/*22.65*/("""
      """),_display_(Seq[Any](/*23.8*/inputText(publicationForm("pages"), '_label -> "Pages"))),format.raw/*23.63*/("""

      <div class="actions">
        <input type="submit" class="btn primary" value="Update">
        <a href=""""),_display_(Seq[Any](/*27.19*/routes/*27.25*/.JournalPublications.display())),format.raw/*27.55*/("""" class="btn">Cancel</a>
      </div>
    """)))})),format.raw/*29.6*/("""
  """)))}/*30.4*/else/*30.8*/{_display_(Seq[Any](format.raw/*30.9*/("""
    <h2>Please login to update exiting publications</h2>
  """)))})),format.raw/*32.4*/("""
""")))})),format.raw/*33.2*/("""
"""))}
    }
    
    def render(publication:JournalPublication,publicationForm:play.data.Form[JournalPublication]): play.api.templates.HtmlFormat.Appendable = apply(publication,publicationForm)
    
    def f:((JournalPublication,play.data.Form[JournalPublication]) => play.api.templates.HtmlFormat.Appendable) = (publication,publicationForm) => apply(publication,publicationForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 03 13:45:35 PST 2014
                    SOURCE: /Users/ironstone/Desktop/PublicationNetworkAnalysis/frontend/app/views/updateJournal.scala.html
                    HASH: bd8252246d2e98182e94942a19ae0602fe16c9a6
                    MATRIX: 829->2|1025->88|1053->107|1089->109|1123->135|1162->137|1201->142|1233->166|1271->167|1362->223|1412->264|1452->266|1540->318|1560->329|1590->337|1636->348|1718->408|1761->416|1847->480|1890->488|1973->549|2016->557|2104->623|2147->631|2233->695|2276->703|2351->756|2394->764|2484->832|2527->840|2606->897|2649->905|2728->962|2771->970|2848->1025|2997->1138|3012->1144|3064->1174|3138->1217|3160->1221|3172->1225|3210->1226|3302->1287|3335->1289
                    LINES: 26->2|30->2|32->5|33->6|33->6|33->6|35->8|35->8|35->8|38->11|38->11|38->11|39->12|39->12|39->12|41->14|41->14|42->15|42->15|43->16|43->16|44->17|44->17|45->18|45->18|46->19|46->19|47->20|47->20|48->21|48->21|49->22|49->22|50->23|50->23|54->27|54->27|54->27|56->29|57->30|57->30|57->30|59->32|60->33
                    -- GENERATED --
                */
            