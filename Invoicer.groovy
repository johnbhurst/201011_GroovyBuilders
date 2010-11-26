import groovy.util.XmlSlurper
import java.awt.Color
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Element
import com.lowagie.text.Font
import com.lowagie.text.Paragraph
import com.lowagie.text.Phrase

def invoice = new XmlSlurper().parse("invoice.xml")

new PDFBuilder(new FileOutputStream("invoice.pdf")).document() {
  Font BOLD_FONT = new Font(Font.HELVETICA, 10, Font.BOLD,  Color.BLACK)
  Color GRAY_BACKGROUND = new Color(230, 230, 230)
  def head = {cell(new Paragraph(it, BOLD_FONT), backgroundColor: GRAY_BACKGROUND)}
  def desc = {cell(new Phrase(it))}
  def charge = {cell(new Phrase(it), horizontalAlignment: Element.ALIGN_RIGHT)}

  paragraph(alignment: Element.ALIGN_RIGHT, string: "Invoice Date: ${invoice.date}")
  paragraph(alignment: Element.ALIGN_RIGHT, string: "Invoice To: ${invoice.to}")
  paragraph(" ")
  table(numColumns: 2) {
    head("Description") ; head("Charge")
    invoice.items.item.each {item ->
      desc("${item.description}") ; charge("${item.charge}")
    }
  }
}

