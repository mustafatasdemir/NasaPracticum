
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
object updateBook extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[BookPublication,play.data.Form[BookPublication],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*2.2*/(publication: BookPublication, publicationForm: play.data.Form[BookPublication]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*2.82*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Update Publication")/*6.28*/ {_display_(Seq[Any](format.raw/*6.30*/("""

  """),_display_(Seq[Any](/*8.4*/if(session.get("email"))/*8.28*/{_display_(Seq[Any](format.raw/*8.29*/("""
    <h2>Update existing book publication</h2>

    """),_display_(Seq[Any](/*11.6*/form(routes.BookPublications.update())/*11.44*/ {_display_(Seq[Any](format.raw/*11.46*/("""
      <input name="idHolder" type="hidden" value=""""),_display_(Seq[Any](/*12.52*/publication/*12.63*/.getId())),format.raw/*12.71*/("""">

      """),_display_(Seq[Any](/*14.8*/inputText(publicationForm("paperTitle"), '_label -> "Title"))),format.raw/*14.68*/("""
      """),_display_(Seq[Any](/*15.8*/inputText(publicationForm("paperAuthors"), '_label -> "Authors"))),format.raw/*15.72*/("""
      """),_display_(Seq[Any](/*16.8*/inputText(publicationForm("keywords"), '_label -> "Keywords"))),format.raw/*16.69*/("""
      """),_display_(Seq[Any](/*17.8*/inputText(publicationForm("systemTags"), '_label -> "System Tags"))),format.raw/*17.74*/("""
      """),_display_(Seq[Any](/*18.8*/inputText(publicationForm("crowdTags"), '_label -> "Crowd Tags"))),format.raw/*18.72*/("""
      """),_display_(Seq[Any](/*19.8*/inputText(publicationForm("year"), '_label -> "Year"))),format.raw/*19.61*/("""
      """),_display_(Seq[Any](/*20.8*/inputText(publicationForm("bookName"), '_label -> "Book Name"))),format.raw/*20.70*/("""
      """),_display_(Seq[Any](/*21.8*/inputText(publicationForm("publisherName"), '_label -> "Publisher Name"))),format.raw/*21.80*/("""
      """),_display_(Seq[Any](/*22.8*/inputText(publicationForm("publisherLocation"), '_label -> "Publisher Location"))),format.raw/*22.88*/("""
      """),_display_(Seq[Any](/*23.8*/inputText(publicationForm("time"), '_label -> "Time"))),format.raw/*23.61*/("""
      """),_display_(Seq[Any](/*24.8*/inputText(publicationForm("pages"), '_label -> "Pages"))),format.raw/*24.63*/("""

      <div class="actions">
        <input type="submit" class="btn primary" value="Update">
        <a href=""""),_display_(Seq[Any](/*28.19*/routes/*28.25*/.BookPublications.display())),format.raw/*28.52*/("""" class="btn">Cancel</a>
      </div>
    """)))})),format.raw/*30.6*/("""
  """)))}/*31.4*/else/*31.8*/{_display_(Seq[Any](format.raw/*31.9*/("""
    <h2>Please login to update exiting publications</h2>
  """)))})),format.raw/*33.4*/("""
""")))})),format.raw/*34.2*/("""
"""))}
    }
    
    def render(publication:BookPublication,publicationForm:play.data.Form[BookPublication]): play.api.templates.HtmlFormat.Appendable = apply(publication,publicationForm)
    
    def f:((BookPublication,play.data.Form[BookPublication]) => play.api.templates.HtmlFormat.Appendable) = (publication,publicationForm) => apply(publication,publicationForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 03 13:45:35 PST 2014
                    SOURCE: /Users/ironstone/Desktop/PublicationNetworkAnalysis/frontend/app/views/updateBook.scala.html
                    HASH: fd30dfbb7d6bce02a3e308f2971457cb2f943c3e
                    MATRIX: 820->2|1010->82|1038->101|1074->103|1108->129|1147->131|1186->136|1218->160|1256->161|1344->214|1391->252|1431->254|1519->306|1539->317|1569->325|1615->336|1697->396|1740->404|1826->468|1869->476|1952->537|1995->545|2083->611|2126->619|2212->683|2255->691|2330->744|2373->752|2457->814|2500->822|2594->894|2637->902|2739->982|2782->990|2857->1043|2900->1051|2977->1106|3126->1219|3141->1225|3190->1252|3264->1295|3286->1299|3298->1303|3336->1304|3428->1365|3461->1367
                    LINES: 26->2|30->2|32->5|33->6|33->6|33->6|35->8|35->8|35->8|38->11|38->11|38->11|39->12|39->12|39->12|41->14|41->14|42->15|42->15|43->16|43->16|44->17|44->17|45->18|45->18|46->19|46->19|47->20|47->20|48->21|48->21|49->22|49->22|50->23|50->23|51->24|51->24|55->28|55->28|55->28|57->30|58->31|58->31|58->31|60->33|61->34
                    -- GENERATED --
                */
            