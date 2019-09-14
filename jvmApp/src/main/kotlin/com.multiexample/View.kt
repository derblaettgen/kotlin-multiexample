package com.multiexample

import javafx.beans.property.SimpleIntegerProperty
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.TextAlignment
import tornadofx.*
import javax.swing.Box
import javax.swing.GroupLayout

class Counter(count: Int = 0) {
    val countProperty = SimpleIntegerProperty(this, "count", count)
//    var count by countProperty
}

class CounterModel(counter:Counter): ItemViewModel<Counter>(counter) {
    var count = bind(Counter::countProperty)
}

class MainView: View("TornadoFX GUI") {
    private val counter = Counter()
    private val counterModel = CounterModel(counter)

    override val root = hbox {
        prefWidth = 120.0
        prefHeight = 100.0

        vbox {
            style {
                prefWidth = 100.pc
            }
            alignment = Pos.CENTER

            label(counterModel.count) {
                    addClass(Styles.heading)
                }

            button("Add") {
                action {
                    raiseCounter()
                    counterModel.count.value = receiveCounter()
                }
            }
        }

//        button("reset") {
//            action {
//                counterModel.rollback()
//            }
//        }
    }
}