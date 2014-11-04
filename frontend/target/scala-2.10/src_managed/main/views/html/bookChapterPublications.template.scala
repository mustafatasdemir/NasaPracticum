
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
object bookChapterPublications extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[BookChapterPublication],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*2.2*/(publications: List[BookChapterPublication]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*2.46*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Book Chapter Publications")/*6.35*/ {_display_(Seq[Any](format.raw/*6.37*/("""

  <h1>"""),_display_(Seq[Any](/*8.8*/publications/*8.20*/.size())),format.raw/*8.27*/(""" Book Chapter Publications</h1>
  <table class="table table-striped table-bordered table-condensed">
    <tr>
      <td>Title</td>
      <td>Authors</td>
      <td>Keywords</td>
      <td>Tags</td>
      <td>Book</td>
      <td>Chapter</td>
      """),_display_(Seq[Any](/*17.8*/if(session.get("email"))/*17.32*/{_display_(Seq[Any](format.raw/*17.33*/("""
      <td>Operation</td>
      """)))})),format.raw/*19.8*/("""
    </tr>

    """),_display_(Seq[Any](/*22.6*/for(publication <- publications) yield /*22.38*/ {_display_(Seq[Any](format.raw/*22.40*/("""
      <tr id=""""),_display_(Seq[Any](/*23.16*/publication/*23.27*/.getId())),format.raw/*23.35*/("""" class="publications">
        <td class="publicationTitle">"""),_display_(Seq[Any](/*24.39*/publication/*24.50*/.getTitle())),format.raw/*24.61*/("""</td>
        <td class="publicationAuthors">"""),_display_(Seq[Any](/*25.41*/publication/*25.52*/.formatStringArray(publication.getAuthors()))),format.raw/*25.96*/("""</td>
        <td class="publicationKeywords">"""),_display_(Seq[Any](/*26.42*/publication/*26.53*/.formatStringArray(publication.getKeywords()))),format.raw/*26.98*/("""</td>
        <td class="publicationTags">"""),_display_(Seq[Any](/*27.38*/publication/*27.49*/.formatStringArray(publication.getCrowdTags()))),format.raw/*27.95*/("""</td>
        <td class="bookName">"""),_display_(Seq[Any](/*28.31*/publication/*28.42*/.getBookName())),format.raw/*28.56*/("""</td>
        <td class="chapter">"""),_display_(Seq[Any](/*29.30*/publication/*29.41*/.getChapter())),format.raw/*29.54*/("""</td>

        """),_display_(Seq[Any](/*31.10*/if(session.get("email"))/*31.34*/{_display_(Seq[Any](format.raw/*31.35*/("""
        <td class="operation">
          """),_display_(Seq[Any](/*33.12*/form(routes.BookChapterPublications.updatePage())/*33.61*/ {_display_(Seq[Any](format.raw/*33.63*/("""
            <input name="idHolder" type="hidden" value=""""),_display_(Seq[Any](/*34.58*/publication/*34.69*/.getId())),format.raw/*34.77*/("""">
            <input type="submit" class="btn btn-primary" value="Update">
          """)))})),format.raw/*36.12*/("""
          """),_display_(Seq[Any](/*37.12*/form(routes.Publications.delete())/*37.46*/{_display_(Seq[Any](format.raw/*37.47*/("""
            <input name="idHolder" type="hidden" value=""""),_display_(Seq[Any](/*38.58*/publication/*38.69*/.getId())),format.raw/*38.77*/("""">
            <input type="submit"  class="btn btn-danger" value="Delete" onclick="return confirm('Are you sure you want to delete this item?')">
          """)))})),format.raw/*40.12*/("""
        </td>
        """)))})),format.raw/*42.10*/("""
      </tr>
    """)))})),format.raw/*44.6*/("""
  </table>
""")))})),format.raw/*46.2*/("""
"""))}
    }
    
    def render(publications:List[BookChapterPublication]): play.api.templates.HtmlFormat.Appendable = apply(publications)
    
    def f:((List[BookChapterPublication]) => play.api.templates.HtmlFormat.Appendable) = (publications) => apply(publications)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 03 13:45:35 PST 2014
                    SOURCE: /Users/ironstone/Desktop/PublicationNetworkAnalysis/frontend/app/views/bookChapterPublications.scala.html
                    HASH: f9b694a9fa896e14a63c01371f0a7ac54da1e277
                    MATRIX: 814->2|968->46|996->65|1032->67|1073->100|1112->102|1155->111|1175->123|1203->130|1486->378|1519->402|1558->403|1622->436|1674->453|1722->485|1762->487|1814->503|1834->514|1864->522|1962->584|1982->595|2015->606|2097->652|2117->663|2183->707|2266->754|2286->765|2353->810|2432->853|2452->864|2520->910|2592->946|2612->957|2648->971|2719->1006|2739->1017|2774->1030|2826->1046|2859->1070|2898->1071|2977->1114|3035->1163|3075->1165|3169->1223|3189->1234|3219->1242|3338->1329|3386->1341|3429->1375|3468->1376|3562->1434|3582->1445|3612->1453|3802->1611|3858->1635|3907->1653|3951->1666
                    LINES: 26->2|30->2|32->5|33->6|33->6|33->6|35->8|35->8|35->8|44->17|44->17|44->17|46->19|49->22|49->22|49->22|50->23|50->23|50->23|51->24|51->24|51->24|52->25|52->25|52->25|53->26|53->26|53->26|54->27|54->27|54->27|55->28|55->28|55->28|56->29|56->29|56->29|58->31|58->31|58->31|60->33|60->33|60->33|61->34|61->34|61->34|63->36|64->37|64->37|64->37|65->38|65->38|65->38|67->40|69->42|71->44|73->46
                    -- GENERATED --
                */
            