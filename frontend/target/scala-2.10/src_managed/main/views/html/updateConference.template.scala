
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
object updateConference extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[ConferencePublication,play.data.Form[ConferencePublication],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*2.2*/(publication: ConferencePublication, publicationForm: play.data.Form[ConferencePublication]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*2.94*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Update Publication")/*6.28*/ {_display_(Seq[Any](format.raw/*6.30*/("""

  """),_display_(Seq[Any](/*8.4*/if(session.get("email"))/*8.28*/{_display_(Seq[Any](format.raw/*8.29*/("""
    <h2>Update existing conference publication</h2>

    """),_display_(Seq[Any](/*11.6*/form(routes.ConferencePublications.update())/*11.50*/ {_display_(Seq[Any](format.raw/*11.52*/("""
      <input name="idHolder" type="hidden" value=""""),_display_(Seq[Any](/*12.52*/publication/*12.63*/.getId())),format.raw/*12.71*/("""">

      """),_display_(Seq[Any](/*14.8*/inputText(publicationForm("paperTitle"), '_label -> "Title"))),format.raw/*14.68*/("""
      """),_display_(Seq[Any](/*15.8*/inputText(publicationForm("paperAuthors"), '_label -> "Authors"))),format.raw/*15.72*/("""
      """),_display_(Seq[Any](/*16.8*/inputText(publicationForm("keywords"), '_label -> "Keywords"))),format.raw/*16.69*/("""
      """),_display_(Seq[Any](/*17.8*/inputText(publicationForm("systemTags"), '_label -> "System Tags"))),format.raw/*17.74*/("""
      """),_display_(Seq[Any](/*18.8*/inputText(publicationForm("crowdTags"), '_label -> "Crowd Tags"))),format.raw/*18.72*/("""
      """),_display_(Seq[Any](/*19.8*/inputText(publicationForm("year"), '_label -> "Year"))),format.raw/*19.61*/("""
      """),_display_(Seq[Any](/*20.8*/inputText(publicationForm("conferenceName"), '_label -> "Conference Name"))),format.raw/*20.82*/("""
      """),_display_(Seq[Any](/*21.8*/inputText(publicationForm("conferenceLocation"), '_label -> "Conference Location"))),format.raw/*21.90*/("""
      """),_display_(Seq[Any](/*22.8*/inputText(publicationForm("time"), '_label -> "Time"))),format.raw/*22.61*/("""
      """),_display_(Seq[Any](/*23.8*/inputText(publicationForm("pages"), '_label -> "Pages"))),format.raw/*23.63*/("""

      <div class="actions">
        <input type="submit" class="btn primary" value="Update">
        <a href=""""),_display_(Seq[Any](/*27.19*/routes/*27.25*/.ConferencePublications.display())),format.raw/*27.58*/("""" class="btn">Cancel</a>
      </div>
    """)))})),format.raw/*29.6*/("""
  """)))}/*30.4*/else/*30.8*/{_display_(Seq[Any](format.raw/*30.9*/("""
    <h2>Please login to update exiting publications</h2>
  """)))})),format.raw/*32.4*/("""
""")))})),format.raw/*33.2*/("""
"""))}
    }
    
    def render(publication:ConferencePublication,publicationForm:play.data.Form[ConferencePublication]): play.api.templates.HtmlFormat.Appendable = apply(publication,publicationForm)
    
    def f:((ConferencePublication,play.data.Form[ConferencePublication]) => play.api.templates.HtmlFormat.Appendable) = (publication,publicationForm) => apply(publication,publicationForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 03 13:45:35 PST 2014
                    SOURCE: /Users/ironstone/Desktop/PublicationNetworkAnalysis/frontend/app/views/updateConference.scala.html
                    HASH: c15335dccfe191d2084c14e0da77eea356d0b3e2
                    MATRIX: 838->2|1040->94|1068->113|1104->115|1138->141|1177->143|1216->148|1248->172|1286->173|1380->232|1433->276|1473->278|1561->330|1581->341|1611->349|1657->360|1739->420|1782->428|1868->492|1911->500|1994->561|2037->569|2125->635|2168->643|2254->707|2297->715|2372->768|2415->776|2511->850|2554->858|2658->940|2701->948|2776->1001|2819->1009|2896->1064|3045->1177|3060->1183|3115->1216|3189->1259|3211->1263|3223->1267|3261->1268|3353->1329|3386->1331
                    LINES: 26->2|30->2|32->5|33->6|33->6|33->6|35->8|35->8|35->8|38->11|38->11|38->11|39->12|39->12|39->12|41->14|41->14|42->15|42->15|43->16|43->16|44->17|44->17|45->18|45->18|46->19|46->19|47->20|47->20|48->21|48->21|49->22|49->22|50->23|50->23|54->27|54->27|54->27|56->29|57->30|57->30|57->30|59->32|60->33
                    -- GENERATED --
                */
            