
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
object webPagePublications extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[WebPagePublication],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*2.2*/(publications: List[WebPagePublication]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*2.42*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Web Page Publications")/*6.31*/ {_display_(Seq[Any](format.raw/*6.33*/("""

  <h1>"""),_display_(Seq[Any](/*8.8*/publications/*8.20*/.size())),format.raw/*8.27*/(""" Web Page Publications</h1>
  <table class="table table-striped table-bordered table-condensed">
    <tr>
      <td>Title</td>
      <td>Authors</td>
      <td>Keywords</td>
      <td>Tags</td>
      <td>URL</td>
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
        <td class="URL">"""),_display_(Seq[Any](/*27.26*/publication/*27.37*/.getURL())),format.raw/*27.46*/("""</td>

        """),_display_(Seq[Any](/*29.10*/if(session.get("email"))/*29.34*/{_display_(Seq[Any](format.raw/*29.35*/("""
        <td class="operation">
          """),_display_(Seq[Any](/*31.12*/form(routes.WebPagePublications.updatePage())/*31.57*/ {_display_(Seq[Any](format.raw/*31.59*/("""
            <input name="idHolder" type="hidden" value=""""),_display_(Seq[Any](/*32.58*/publication/*32.69*/.getId())),format.raw/*32.77*/("""">
            <input type="submit" class="btn btn-primary" value="Update">
          """)))})),format.raw/*34.12*/("""
          """),_display_(Seq[Any](/*35.12*/form(routes.Publications.delete())/*35.46*/{_display_(Seq[Any](format.raw/*35.47*/("""
            <input name="idHolder" type="hidden" value=""""),_display_(Seq[Any](/*36.58*/publication/*36.69*/.getId())),format.raw/*36.77*/("""">
            <input type="submit"  class="btn btn-danger" value="Delete" onclick="return confirm('Are you sure you want to delete this item?')">
          """)))})),format.raw/*38.12*/("""
        </td>
        """)))})),format.raw/*40.10*/("""
      </tr>
    """)))})),format.raw/*42.6*/("""
  </table>
""")))})),format.raw/*44.2*/("""
"""))}
    }
    
    def render(publications:List[WebPagePublication]): play.api.templates.HtmlFormat.Appendable = apply(publications)
    
    def f:((List[WebPagePublication]) => play.api.templates.HtmlFormat.Appendable) = (publications) => apply(publications)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 03 13:45:35 PST 2014
                    SOURCE: /Users/ironstone/Desktop/PublicationNetworkAnalysis/frontend/app/views/webPagePublications.scala.html
                    HASH: c6f3d435639215b88523393f4e8b9751904bc9a5
                    MATRIX: 806->2|956->42|984->61|1020->63|1057->92|1096->94|1139->103|1159->115|1187->122|1442->342|1475->366|1514->367|1578->400|1630->417|1678->449|1718->451|1770->467|1790->478|1820->486|1918->548|1938->559|1971->570|2053->616|2073->627|2139->671|2222->718|2242->729|2309->774|2388->817|2408->828|2476->874|2543->905|2563->916|2594->925|2646->941|2679->965|2718->966|2797->1009|2851->1054|2891->1056|2985->1114|3005->1125|3035->1133|3154->1220|3202->1232|3245->1266|3284->1267|3378->1325|3398->1336|3428->1344|3618->1502|3674->1526|3723->1544|3767->1557
                    LINES: 26->2|30->2|32->5|33->6|33->6|33->6|35->8|35->8|35->8|43->16|43->16|43->16|45->18|48->21|48->21|48->21|49->22|49->22|49->22|50->23|50->23|50->23|51->24|51->24|51->24|52->25|52->25|52->25|53->26|53->26|53->26|54->27|54->27|54->27|56->29|56->29|56->29|58->31|58->31|58->31|59->32|59->32|59->32|61->34|62->35|62->35|62->35|63->36|63->36|63->36|65->38|67->40|69->42|71->44
                    -- GENERATED --
                */
            