
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
object publications extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[Publication],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*2.2*/(publications: List[Publication]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*2.35*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Publications")/*6.22*/ {_display_(Seq[Any](format.raw/*6.24*/("""

  <h1>"""),_display_(Seq[Any](/*8.8*/publications/*8.20*/.size())),format.raw/*8.27*/(""" Publications</h1>
  <table class="table table-striped table-bordered table-condensed">
    <tr>
      <td>Title</td>
      <td>Authors</td>
      <td>Keywords</td>
      <td>Tags</td>
      <td>Publication Channel</td>
      """),_display_(Seq[Any](/*16.8*/if(session.get("email"))/*16.32*/{_display_(Seq[Any](format.raw/*16.33*/("""
      <td>Operation</td>
      """)))})),format.raw/*18.8*/("""
    </tr>

    """),_display_(Seq[Any](/*21.6*/for(publication <- publications) yield /*21.38*/ {_display_(Seq[Any](format.raw/*21.40*/("""
      <tr id=""""),_display_(Seq[Any](/*22.16*/publication/*22.27*/.getId())),format.raw/*22.35*/("""" class="publications">
        <td class="publicationTitle">"""),_display_(Seq[Any](/*23.39*/publication/*23.50*/.getTitle())),format.raw/*23.61*/("""</td>
        <td class="publicationAuthors">"""),_display_(Seq[Any](/*24.41*/publication/*24.52*/.formatStringArray(publication.getAuthors()))),format.raw/*24.96*/("""</td>
        <td class="publicationKeywords">"""),_display_(Seq[Any](/*25.42*/publication/*25.53*/.formatStringArray(publication.getKeywords()))),format.raw/*25.98*/("""</td>
        <td class="publicationTags">"""),_display_(Seq[Any](/*26.38*/publication/*26.49*/.formatStringArray(publication.getCrowdTags()))),format.raw/*26.95*/("""</td>
        <td class="publicationChannel">"""),_display_(Seq[Any](/*27.41*/publication/*27.52*/.getChannelString())),format.raw/*27.71*/("""</td>

        """),_display_(Seq[Any](/*29.10*/if(session.get("email"))/*29.34*/{_display_(Seq[Any](format.raw/*29.35*/("""
        <td class="operation">
          """),_display_(Seq[Any](/*31.12*/if(publication.getChannelString() == "Journal")/*31.59*/ {_display_(Seq[Any](format.raw/*31.61*/("""
            """),_display_(Seq[Any](/*32.14*/form(routes.JournalPublications.updatePage())/*32.59*/ {_display_(Seq[Any](format.raw/*32.61*/("""
              <input name="idHolder" type="hidden" value=""""),_display_(Seq[Any](/*33.60*/publication/*33.71*/.getId())),format.raw/*33.79*/("""">
              <input type="submit" class="btn btn-primary" value="Update">
            """)))})),format.raw/*35.14*/("""
          """)))})),format.raw/*36.12*/("""
          """),_display_(Seq[Any](/*37.12*/if(publication.getChannelString() == "Conference")/*37.62*/ {_display_(Seq[Any](format.raw/*37.64*/("""
            """),_display_(Seq[Any](/*38.14*/form(routes.ConferencePublications.updatePage())/*38.62*/ {_display_(Seq[Any](format.raw/*38.64*/("""
              <input name="idHolder" type="hidden" value=""""),_display_(Seq[Any](/*39.60*/publication/*39.71*/.getId())),format.raw/*39.79*/("""">
              <input type="submit" class="btn btn-primary" value="Update">
            """)))})),format.raw/*41.14*/("""
          """)))})),format.raw/*42.12*/("""
          """),_display_(Seq[Any](/*43.12*/if(publication.getChannelString() == "Web Page")/*43.60*/ {_display_(Seq[Any](format.raw/*43.62*/("""
            """),_display_(Seq[Any](/*44.14*/form(routes.WebPagePublications.updatePage())/*44.59*/ {_display_(Seq[Any](format.raw/*44.61*/("""
              <input name="idHolder" type="hidden" value=""""),_display_(Seq[Any](/*45.60*/publication/*45.71*/.getId())),format.raw/*45.79*/("""">
              <input type="submit" class="btn btn-primary" value="Update">
            """)))})),format.raw/*47.14*/("""
          """)))})),format.raw/*48.12*/("""
          """),_display_(Seq[Any](/*49.12*/if(publication.getChannelString() == "Book")/*49.56*/ {_display_(Seq[Any](format.raw/*49.58*/("""
            """),_display_(Seq[Any](/*50.14*/form(routes.BookPublications.updatePage())/*50.56*/ {_display_(Seq[Any](format.raw/*50.58*/("""
              <input name="idHolder" type="hidden" value=""""),_display_(Seq[Any](/*51.60*/publication/*51.71*/.getId())),format.raw/*51.79*/("""">
              <input type="submit" class="btn btn-primary" value="Update">
            """)))})),format.raw/*53.14*/("""
          """)))})),format.raw/*54.12*/("""
          """),_display_(Seq[Any](/*55.12*/if(publication.getChannelString() == "Book Chapter")/*55.64*/ {_display_(Seq[Any](format.raw/*55.66*/("""
            """),_display_(Seq[Any](/*56.14*/form(routes.BookChapterPublications.updatePage())/*56.63*/ {_display_(Seq[Any](format.raw/*56.65*/("""
              <input name="idHolder" type="hidden" value=""""),_display_(Seq[Any](/*57.60*/publication/*57.71*/.getId())),format.raw/*57.79*/("""">
              <input type="submit" class="btn btn-primary" value="Update">
            """)))})),format.raw/*59.14*/("""
          """)))})),format.raw/*60.12*/("""
          """),_display_(Seq[Any](/*61.12*/form(routes.Publications.delete())/*61.46*/ {_display_(Seq[Any](format.raw/*61.48*/("""
            <input name="idHolder" type="hidden" value=""""),_display_(Seq[Any](/*62.58*/publication/*62.69*/.getId())),format.raw/*62.77*/("""">
            <input type="submit"  class="btn btn-danger" value="Delete" onclick="return confirm('Are you sure you want to delete this item?')">
          """)))})),format.raw/*64.12*/("""
        </td>
        """)))})),format.raw/*66.10*/("""
      </tr>
    """)))})),format.raw/*68.6*/("""
  </table>
""")))})),format.raw/*70.2*/("""
"""))}
    }
    
    def render(publications:List[Publication]): play.api.templates.HtmlFormat.Appendable = apply(publications)
    
    def f:((List[Publication]) => play.api.templates.HtmlFormat.Appendable) = (publications) => apply(publications)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 03 13:45:35 PST 2014
                    SOURCE: /Users/ironstone/Desktop/PublicationNetworkAnalysis/frontend/app/views/publications.scala.html
                    HASH: 735854e0afd06b0c6ab7b82432a51004a6acb3d0
                    MATRIX: 792->2|935->35|963->54|999->56|1027->76|1066->78|1109->87|1129->99|1157->106|1419->333|1452->357|1491->358|1555->391|1607->408|1655->440|1695->442|1747->458|1767->469|1797->477|1895->539|1915->550|1948->561|2030->607|2050->618|2116->662|2199->709|2219->720|2286->765|2365->808|2385->819|2453->865|2535->911|2555->922|2596->941|2648->957|2681->981|2720->982|2799->1025|2855->1072|2895->1074|2945->1088|2999->1133|3039->1135|3135->1195|3155->1206|3185->1214|3308->1305|3352->1317|3400->1329|3459->1379|3499->1381|3549->1395|3606->1443|3646->1445|3742->1505|3762->1516|3792->1524|3915->1615|3959->1627|4007->1639|4064->1687|4104->1689|4154->1703|4208->1748|4248->1750|4344->1810|4364->1821|4394->1829|4517->1920|4561->1932|4609->1944|4662->1988|4702->1990|4752->2004|4803->2046|4843->2048|4939->2108|4959->2119|4989->2127|5112->2218|5156->2230|5204->2242|5265->2294|5305->2296|5355->2310|5413->2359|5453->2361|5549->2421|5569->2432|5599->2440|5722->2531|5766->2543|5814->2555|5857->2589|5897->2591|5991->2649|6011->2660|6041->2668|6231->2826|6287->2850|6336->2868|6380->2881
                    LINES: 26->2|30->2|32->5|33->6|33->6|33->6|35->8|35->8|35->8|43->16|43->16|43->16|45->18|48->21|48->21|48->21|49->22|49->22|49->22|50->23|50->23|50->23|51->24|51->24|51->24|52->25|52->25|52->25|53->26|53->26|53->26|54->27|54->27|54->27|56->29|56->29|56->29|58->31|58->31|58->31|59->32|59->32|59->32|60->33|60->33|60->33|62->35|63->36|64->37|64->37|64->37|65->38|65->38|65->38|66->39|66->39|66->39|68->41|69->42|70->43|70->43|70->43|71->44|71->44|71->44|72->45|72->45|72->45|74->47|75->48|76->49|76->49|76->49|77->50|77->50|77->50|78->51|78->51|78->51|80->53|81->54|82->55|82->55|82->55|83->56|83->56|83->56|84->57|84->57|84->57|86->59|87->60|88->61|88->61|88->61|89->62|89->62|89->62|91->64|93->66|95->68|97->70
                    -- GENERATED --
                */
            