
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
object header extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*2.2*/():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*2.4*/("""
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" style="padding-bottom: 0;" href="/">
        <img src='"""),_display_(Seq[Any](/*7.20*/routes/*7.26*/.Assets.at("images/logo.png"))),format.raw/*7.55*/("""' style="height: 28px;">
      </a>
    </div>
    <div class="navbar-collapse collapse" style="height:">
      <ul class="nav navbar-nav navbar-right">

        <li><a href=""""),_display_(Seq[Any](/*13.23*/routes/*13.29*/.Application.index())),format.raw/*13.49*/("""">Home</a></li>

        <li class="drowdown"><a href="#" class="drowdown-toggle" data-toggle="dropdown">Publication Data <b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href=""""),_display_(Seq[Any](/*17.27*/routes/*17.33*/.Publications.display())),format.raw/*17.56*/("""">All Publications</a></li>
            <li><a href=""""),_display_(Seq[Any](/*18.27*/routes/*18.33*/.JournalPublications.display())),format.raw/*18.63*/("""">Journal</a></li>
            <li><a href=""""),_display_(Seq[Any](/*19.27*/routes/*19.33*/.ConferencePublications.display())),format.raw/*19.66*/("""">Conference</a></li>
            <li><a href=""""),_display_(Seq[Any](/*20.27*/routes/*20.33*/.WebPagePublications.display())),format.raw/*20.63*/("""">Web Page</a></li>
            <li><a href=""""),_display_(Seq[Any](/*21.27*/routes/*21.33*/.BookPublications.display())),format.raw/*21.60*/("""">Book</a></li>
            <li><a href=""""),_display_(Seq[Any](/*22.27*/routes/*22.33*/.BookChapterPublications.display())),format.raw/*22.67*/("""">Book Chapter</a></li>
          </ul>
        </li>

        """),_display_(Seq[Any](/*26.10*/if(!session.get("email"))/*26.35*/{_display_(Seq[Any](format.raw/*26.36*/("""
        <form class="navbar-form navbar-right" action=""""),_display_(Seq[Any](/*27.57*/routes/*27.63*/.Application.login())),format.raw/*27.83*/("""">
          <button type="submit" class="btn btn-link">Log in</button>
        </form>
        """)))}/*30.10*/else/*30.14*/{_display_(Seq[Any](format.raw/*30.15*/("""
        <li><a href=""""),_display_(Seq[Any](/*31.23*/routes/*31.29*/.JournalPublications.addPage())),format.raw/*31.59*/("""">Add Publication</a></li>

        <form class="navbar-form navbar-right" action=""""),_display_(Seq[Any](/*33.57*/routes/*33.63*/.Application.logout())),format.raw/*33.84*/("""">
          <button type="submit" class="btn btn-link">Log out</button>
        </form>
        """)))})),format.raw/*36.10*/("""

      </ul>
    </div>
  </div>
</div>
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 03 13:45:35 PST 2014
                    SOURCE: /Users/ironstone/Desktop/PublicationNetworkAnalysis/frontend/app/views/header.scala.html
                    HASH: bedb4b53b7fbad9c3e46e087fd27543f5101f8c4
                    MATRIX: 768->2|863->4|1114->220|1128->226|1178->255|1390->431|1405->437|1447->457|1694->668|1709->674|1754->697|1844->751|1859->757|1911->787|1992->832|2007->838|2062->871|2146->919|2161->925|2213->955|2295->1001|2310->1007|2359->1034|2437->1076|2452->1082|2508->1116|2608->1180|2642->1205|2681->1206|2774->1263|2789->1269|2831->1289|2947->1386|2960->1390|2999->1391|3058->1414|3073->1420|3125->1450|3245->1534|3260->1540|3303->1561|3433->1659
                    LINES: 26->2|29->2|34->7|34->7|34->7|40->13|40->13|40->13|44->17|44->17|44->17|45->18|45->18|45->18|46->19|46->19|46->19|47->20|47->20|47->20|48->21|48->21|48->21|49->22|49->22|49->22|53->26|53->26|53->26|54->27|54->27|54->27|57->30|57->30|57->30|58->31|58->31|58->31|60->33|60->33|60->33|63->36
                    -- GENERATED --
                */
            