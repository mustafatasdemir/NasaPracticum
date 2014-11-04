
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
object bookPublications extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[BookPublication],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*2.2*/(publications: List[BookPublication]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*2.39*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Book Publications")/*6.27*/ {_display_(Seq[Any](format.raw/*6.29*/("""

  <h1>"""),_display_(Seq[Any](/*8.8*/publications/*8.20*/.size())),format.raw/*8.27*/(""" Book Publications</h1>
  <table class="table table-striped table-bordered table-condensed">
    <tr>
      <td>Title</td>
      <td>Authors</td>
      <td>Keywords</td>
      <td>Tags</td>
      <td>Book</td>
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
        <td class="bookName">"""),_display_(Seq[Any](/*27.31*/publication/*27.42*/.getBookName())),format.raw/*27.56*/("""</td>

        """),_display_(Seq[Any](/*29.10*/if(session.get("email"))/*29.34*/{_display_(Seq[Any](format.raw/*29.35*/("""
        <td class="operation">
          """),_display_(Seq[Any](/*31.12*/form(routes.BookPublications.updatePage())/*31.54*/ {_display_(Seq[Any](format.raw/*31.56*/("""
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
    
    def render(publications:List[BookPublication]): play.api.templates.HtmlFormat.Appendable = apply(publications)
    
    def f:((List[BookPublication]) => play.api.templates.HtmlFormat.Appendable) = (publications) => apply(publications)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 03 13:45:35 PST 2014
                    SOURCE: /Users/ironstone/Desktop/PublicationNetworkAnalysis/frontend/app/views/bookPublications.scala.html
                    HASH: bd9676a9288b2950499ecd8077aed977a717395c
                    MATRIX: 800->2|947->39|975->58|1011->60|1044->85|1083->87|1126->96|1146->108|1174->115|1426->332|1459->356|1498->357|1562->390|1614->407|1662->439|1702->441|1754->457|1774->468|1804->476|1902->538|1922->549|1955->560|2037->606|2057->617|2123->661|2206->708|2226->719|2293->764|2372->807|2392->818|2460->864|2532->900|2552->911|2588->925|2640->941|2673->965|2712->966|2791->1009|2842->1051|2882->1053|2976->1111|2996->1122|3026->1130|3145->1217|3193->1229|3236->1263|3275->1264|3369->1322|3389->1333|3419->1341|3609->1499|3665->1523|3714->1541|3758->1554
                    LINES: 26->2|30->2|32->5|33->6|33->6|33->6|35->8|35->8|35->8|43->16|43->16|43->16|45->18|48->21|48->21|48->21|49->22|49->22|49->22|50->23|50->23|50->23|51->24|51->24|51->24|52->25|52->25|52->25|53->26|53->26|53->26|54->27|54->27|54->27|56->29|56->29|56->29|58->31|58->31|58->31|59->32|59->32|59->32|61->34|62->35|62->35|62->35|63->36|63->36|63->36|65->38|67->40|69->42|71->44
                    -- GENERATED --
                */
            