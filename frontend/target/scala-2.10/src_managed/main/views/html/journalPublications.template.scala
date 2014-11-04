
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
object journalPublications extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[JournalPublication],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*2.2*/(publications: List[JournalPublication]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*2.42*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Journal Publications")/*6.30*/ {_display_(Seq[Any](format.raw/*6.32*/("""

  <h1>"""),_display_(Seq[Any](/*8.8*/publications/*8.20*/.size())),format.raw/*8.27*/(""" Journal Publications</h1>
  <table class="table table-striped table-bordered table-condensed">
    <tr>
      <td>Title</td>
      <td>Authors</td>
      <td>Keywords</td>
      <td>Tags</td>
      <td>Journal</td>
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
        <td class="journalName">"""),_display_(Seq[Any](/*27.34*/publication/*27.45*/.getJournalName())),format.raw/*27.62*/("""</td>

        """),_display_(Seq[Any](/*29.10*/if(session.get("email"))/*29.34*/{_display_(Seq[Any](format.raw/*29.35*/("""
        <td class="operation">
          """),_display_(Seq[Any](/*31.12*/form(routes.JournalPublications.updatePage())/*31.57*/ {_display_(Seq[Any](format.raw/*31.59*/("""
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
    
    def render(publications:List[JournalPublication]): play.api.templates.HtmlFormat.Appendable = apply(publications)
    
    def f:((List[JournalPublication]) => play.api.templates.HtmlFormat.Appendable) = (publications) => apply(publications)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 03 13:45:35 PST 2014
                    SOURCE: /Users/ironstone/Desktop/PublicationNetworkAnalysis/frontend/app/views/journalPublications.scala.html
                    HASH: 4fc1dd6f8e4f7355b9296a7b9fb6b7b8f949d84e
                    MATRIX: 806->2|956->42|984->61|1020->63|1056->91|1095->93|1138->102|1158->114|1186->121|1444->344|1477->368|1516->369|1580->402|1632->419|1680->451|1720->453|1772->469|1792->480|1822->488|1920->550|1940->561|1973->572|2055->618|2075->629|2141->673|2224->720|2244->731|2311->776|2390->819|2410->830|2478->876|2553->915|2573->926|2612->943|2664->959|2697->983|2736->984|2815->1027|2869->1072|2909->1074|3003->1132|3023->1143|3053->1151|3172->1238|3220->1250|3263->1284|3302->1285|3396->1343|3416->1354|3446->1362|3636->1520|3692->1544|3741->1562|3785->1575
                    LINES: 26->2|30->2|32->5|33->6|33->6|33->6|35->8|35->8|35->8|43->16|43->16|43->16|45->18|48->21|48->21|48->21|49->22|49->22|49->22|50->23|50->23|50->23|51->24|51->24|51->24|52->25|52->25|52->25|53->26|53->26|53->26|54->27|54->27|54->27|56->29|56->29|56->29|58->31|58->31|58->31|59->32|59->32|59->32|61->34|62->35|62->35|62->35|63->36|63->36|63->36|65->38|67->40|69->42|71->44
                    -- GENERATED --
                */
            