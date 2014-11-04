
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*2.2*/main("DblpFrontend")/*2.16*/{_display_(Seq[Any](format.raw/*2.17*/("""

  <div class="jumbotron">
    <div class="row">
      <div class="col-lg-6">

        <img src='"""),_display_(Seq[Any](/*8.20*/routes/*8.26*/.Assets.at("images/network.png"))),format.raw/*8.58*/("""' style="padding-bottom: 0;">

      </div>
      <div class="col-lg-6">
        <h1>Research Community Service Platform</h1>
        <p>A data driven service to recommend papers and network collaborators for the research community</p>
        <!-- TODO -->
        <a class="btn btn-lg btn-default" href="/">Get Started &raquo;</a>
      </div>
    </div>
  </div>

""")))})),format.raw/*20.2*/("""
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 03 13:45:35 PST 2014
                    SOURCE: /Users/ironstone/Desktop/PublicationNetworkAnalysis/frontend/app/views/index.scala.html
                    HASH: 4c54772732e05bca5f9d5c974bcd612335dcab1f
                    MATRIX: 864->2|886->16|924->17|1058->116|1072->122|1125->154|1524->522
                    LINES: 29->2|29->2|29->2|35->8|35->8|35->8|47->20
                    -- GENERATED --
                */
            