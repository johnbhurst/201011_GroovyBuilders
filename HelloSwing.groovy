import groovy.swing.SwingBuilder

def swing = new SwingBuilder()
def frame = swing.frame(title: "Hello Swing!") {
  hbox {
    label(text: "Hello, Swing!")
    button(text: "Click Me to close", actionPerformed: {System.exit(0)})
  }
}
frame.pack()
frame.show()

