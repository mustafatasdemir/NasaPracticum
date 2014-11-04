
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
object conferencePublications extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[ConferencePublication],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*2.2*/(publications: List[ConferencePublication]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*2.45*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Conference Publications")/*6.33*/ {_display_(Seq[Any](format.raw/*6.35*/("""

  <h1>"""),_display_(Seq[Any](/*8.8*/publications/*8.20*/.size())),format.raw/*8.27*/(""" Conference Publications</h1>
  <table class="table table-striped table-bordered table-condensed">
    <tr>
      <td>Title</td>
      <td>Authors</td>
      <td>Keywords</td>
      <td>Tags</td>
      <td>Conference</td>
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
        <td class="conferenceName">"""),_display_(Seq[Any](/*27.37*/publication/*27.48*/.getConferenceName())),format.raw/*27.68*/("""</td>

        """),_display_(Seq[Any](/*29.10*/if(session.get("email"))/*29.34*/{_display_(Seq[Any](format.raw/*29.35*/("""
        <td class="operation">
          """),_display_(Seq[Any](/*31.12*/form(routes.ConferencePublications.updatePage())/*31.60*/ {_display_(Seq[Any](format.raw/*31.62*/("""
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
    
    def render(publications:List[ConferencePublication]): play.api.templates.HtmlFormat.Appendable = apply(publications)
    
    def f:((List[ConferencePublication]) => play.api.templates.HtmlFormat.Appendable) = (publications) => apply(publications)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 03 13:45:35 PST 2014
                    SOURCE: /Users/ironstone/Desktop/PublicationNetworkAnalysis/frontend/app/views/conferencePublications.scala.html
                    HASH: 3f9a9c598d8262b51692530edcfeaaa559dde494
                    MATRIX: 812->2|965->45|993->64|1029->66|1068->97|1107->99|1150->108|1170->120|1198->127|1462->356|1495->380|1534->381|1598->414|1650->431|1698->463|1738->465|1790->481|1810->492|1840->500|1938->562|1958->573|1991->584|2073->630|2093->641|2159->685|2242->732|2262->743|2329->788|2408->831|2428->842|2496->888|2574->930|2594->941|2636->961|2688->977|2721->1001|2760->1002|2839->1045|2896->1093|2936->1095|3030->1153|3050->1164|3080->1172|3199->1259|3247->1271|3290->1305|3329->1306|3423->1364|3443->1375|3473->1383|3663->1541|3719->1565|3768->1583|3812->1596
                    LINES: 26->2|30->2|32->5|33->6|33->6|33->6|35->8|35->8|35->8|43->16|43->16|43->16|45->18|48->21|48->21|48->21|49->22|49->22|49->22|50->23|50->23|50->23|51->24|51->24|51->24|52->25|52->25|52->25|53->26|53->26|53->26|54->27|54->27|54->27|56->29|56->29|56->29|58->31|58->31|58->31|59->32|59->32|59->32|61->34|62->35|62->35|62->35|63->36|63->36|63->36|65->38|67->40|69->42|71->44
                    -- GENERATED --
                */
            