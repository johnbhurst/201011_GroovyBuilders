import groovy.swing.SwingBuilder

new SwingBuilder().edt {
  frame(title: "Hello Swing!", size: [400, 200], show: true) {
    hbox {
      label(text: "Hello, Swing!")
      button(text: "Click Me to close", actionPerformed: {System.exit(0)})
    }
  }
}

