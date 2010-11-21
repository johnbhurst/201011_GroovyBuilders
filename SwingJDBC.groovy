import groovy.sql.Sql
import groovy.swing.SwingBuilder
import java.awt.BorderLayout
import javax.swing.JSplitPane
import javax.swing.JTable
import javax.swing.JTextArea
import javax.swing.table.DefaultTableModel
import oracle.jdbc.pool.OracleDataSource

String url = args[0]
//db = Sql.newInstance(url)
db = new Sql(new OracleDataSource(URL: url))
query = new JTextArea()
results = new JTable()
new SwingBuilder().edt {
  frame(title: "SwingJDBC", size: [1000, 600], show: true) {
    borderLayout()
    menuBar() {
      menu(text: "File", mnemonic: "F") {
        menuItem(text: "Run", mnemonic: "R", actionPerformed: {runQuery()})
        menuItem(text: "Exit", mnemonic: "X", actionPerformed: {dispose()})
      }
    }
    splitPane(orientation: JSplitPane.VERTICAL_SPLIT, dividerLocation: 200) {
      scrollPane(constraints: "top") {widget(query)}
      scrollPane(constraints: "bottom") {widget(results)}
    }
  }
}

void runQuery() {
  columns = []
  rows = db.rows(query.text) {meta -> columns = meta*.columnName}
  data = rows.collect {row -> columns.collect {row[it]}}
  results.model = new DefaultTableModel(data as Object[][], columns as Object[])
}

