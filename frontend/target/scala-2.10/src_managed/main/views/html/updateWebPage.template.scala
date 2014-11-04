
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
object updateWebPage extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[WebPagePublication,play.data.Form[WebPagePublication],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*2.2*/(publication: WebPagePublication, publicationForm: play.data.Form[WebPagePublication]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*2.88*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Update Publication")/*6.28*/ {_display_(Seq[Any](format.raw/*6.30*/("""

  """),_display_(Seq[Any](/*8.4*/if(session.get("email"))/*8.28*/{_display_(Seq[Any](format.raw/*8.29*/("""
    <h2>Update existing web page publication</h2>

    """),_display_(Seq[Any](/*11.6*/form(routes.WebPagePublications.update())/*11.47*/ {_display_(Seq[Any](format.raw/*11.49*/("""
      <input name="idHolder" type="hidden" value=""""),_display_(Seq[Any](/*12.52*/publication/*12.63*/.getId())),format.raw/*12.71*/("""">

      """),_display_(Seq[Any](/*14.8*/inputText(publicationForm("paperTitle"), '_label -> "Title"))),format.raw/*14.68*/("""
      """),_display_(Seq[Any](/*15.8*/inputText(publicationForm("paperAuthors"), '_label -> "Authors"))),format.raw/*15.72*/("""
      """),_display_(Seq[Any](/*16.8*/inputText(publicationForm("keywords"), '_label -> "Keywords"))),format.raw/*16.69*/("""
      """),_display_(Seq[Any](/*17.8*/inputText(publicationForm("systemTags"), '_label -> "System Tags"))),format.raw/*17.74*/("""
      """),_display_(Seq[Any](/*18.8*/inputText(publicationForm("crowdTags"), '_label -> "Crowd Tags"))),format.raw/*18.72*/("""
      """),_display_(Seq[Any](/*19.8*/inputText(publicationForm("year"), '_label -> "Year"))),format.raw/*19.61*/("""
      """),_display_(Seq[Any](/*20.8*/inputText(publicationForm("URL"), '_label -> "URL"))),format.raw/*20.59*/("""
      """),_display_(Seq[Any](/*21.8*/inputText(publicationForm("date"), '_label -> "Date", 'placeholder-> "yyyy-mm-dd"))),format.raw/*21.90*/("""

      <div class="actions">
        <input type="submit" class="btn primary" value="Update">
        <a href=""""),_display_(Seq[Any](/*25.19*/routes/*25.25*/.WebPagePublications.display())),format.raw/*25.55*/("""" class="btn">Cancel</a>
      </div>
    """)))})),format.raw/*27.6*/("""
  """)))}/*28.4*/else/*28.8*/{_display_(Seq[Any](format.raw/*28.9*/("""
    <h2>Please login to update exiting publications</h2>
  """)))})),format.raw/*30.4*/("""
""")))})),format.raw/*31.2*/("""
"""))}
    }
    
    def render(publication:WebPagePublication,publicationForm:play.data.Form[WebPagePublication]): play.api.templates.HtmlFormat.Appendable = apply(publication,publicationForm)
    
    def f:((WebPagePublication,play.data.Form[WebPagePublication]) => play.api.templates.HtmlFormat.Appendable) = (publication,publicationForm) => apply(publication,publicationForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 03 13:45:35 PST 2014
                    SOURCE: /Users/ironstone/Desktop/PublicationNetworkAnalysis/frontend/app/views/updateWebPage.scala.html
                    HASH: 096a389cd3b769ec443611816bc25ded0abc788d
                    MATRIX: 829->2|1025->88|1053->107|1089->109|1123->135|1162->137|1201->142|1233->166|1271->167|1363->224|1413->265|1453->267|1541->319|1561->330|1591->338|1637->349|1719->409|1762->417|1848->481|1891->489|1974->550|2017->558|2105->624|2148->632|2234->696|2277->704|2352->757|2395->765|2468->816|2511->824|2615->906|2764->1019|2779->1025|2831->1055|2905->1098|2927->1102|2939->1106|2977->1107|3069->1168|3102->1170
                    LINES: 26->2|30->2|32->5|33->6|33->6|33->6|35->8|35->8|35->8|38->11|38->11|38->11|39->12|39->12|39->12|41->14|41->14|42->15|42->15|43->16|43->16|44->17|44->17|45->18|45->18|46->19|46->19|47->20|47->20|48->21|48->21|52->25|52->25|52->25|54->27|55->28|55->28|55->28|57->30|58->31
                    -- GENERATED --
                */
            