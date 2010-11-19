import groovy.xml.MarkupBuilder

def blacksquare = "fill:#666666;stroke:#000000;stroke-width:0.5;"
def whitesquare = "fill:#cccccc;stroke:#000000;stroke-width:0.5;"
def blackpiece = "fill:#333333;stroke:#000000;"
def whitepiece = "fill:#999999;stroke:#000000;"

new MarkupBuilder().svg(xmlns: "http://www.w3.org/2000/svg", width: 84, height: 84) {
  g {
    for (i in 0..7) {
      for (j in 0..7) {
        if (i % 2 == j % 2) {
          rect(width: 10, height: 10, x: 2 + 10 * j, y: 2 + 10 * i, style: whitesquare)
        }
        else {
          rect(width: 10, height: 10, x: 2 + 10 * j, y: 2 + 10 * i, style: blacksquare)
          if (i <= 2) {
            circle(cx: 2 + 5 + 10 * j, cy: 2 + 5 + 10 * i, r: 4,  style: whitepiece)
          }
          if (i >= 5) {
            circle(cx: 2 + 5 + 10 * j, cy: 2 + 5 + 10 * i, r: 4,  style: blackpiece)
          }
        }
      }
    }
  }
}

