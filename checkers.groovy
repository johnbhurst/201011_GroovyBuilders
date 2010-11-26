import groovy.xml.MarkupBuilder

def blacksquare = "fill:#666666;stroke:#000000;stroke-width:0.5;"
def whitesquare = "fill:#cccccc;stroke:#000000;stroke-width:0.5;"
def blackpiece = "fill:#333333;stroke:#000000;"
def whitepiece = "fill:#999999;stroke:#000000;"

new MarkupBuilder().svg(xmlns: "http://www.w3.org/2000/svg", width: 84, height: 84) {
  def square = {i, j, style -> rect(width: 10, height: 10, x: 2 + 10 * j, y: 2 + 10 * i, style: style)}
  def piece = {i, j, style -> circle(cx: 2 + 5 + 10 * j, cy: 2 + 5 + 10 * i, r: 4,  style: style)}
  g {
    for (i in 0..7) {
      for (j in 0..7) {
        if (i % 2 == j % 2) {
          square(i, j, whitesquare)
        }
        else {
          square(i, j, blacksquare)
          if (i <= 2) {
            piece(i, j, whitepiece)
          }
          if (i >= 5) {
            piece(i, j, blackpiece)
          }
        }
      }
    }
  }
}

