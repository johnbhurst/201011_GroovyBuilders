import groovy.util.BuilderSupport

class SpoofBuilder extends BuilderSupport {

  int n = 0

  protected void setParent(Object parent, Object child) {
    println "setParent($parent, $child)"
  }

  protected Object createNode(Object name) {
    println "createNode($name)"
    return "node(${name})"
  }

  protected Object createNode(Object name, Object value) {
    println "createNode($name, $value)"
    return "node(${name})"
  }

  protected Object createNode(Object name, Map attributes) {
    println "createNode($name, $attributes)"
    return "node(${name})"
  }

  protected Object createNode(Object name, Map attributes, Object value) {
    println "createNode($name, $attributes, $value)"
    return "node(${name})"
  }

  protected void nodeCompleted(Object parent, Object node) {
    println "nodeCompleted($parent, $node)"
  }

  protected Object postNodeCompletion(Object parent, Object node) {
    println "postNodeCompletion($parent, $node)"
    node
  }
}

new SpoofBuilder().foo(a: 'one', b: 'two') {
  bar("BAR", c: 'three') {
    baz()
  }
}


