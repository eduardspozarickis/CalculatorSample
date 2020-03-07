package com.pozarickis.calculator.feature.calculator.model

sealed class CalcButton {

    open class Number(val value: Int) : CalcButton() {
        class Zero : Number(0)
        class One : Number(1)
        class Two : Number(2)
        class Three : Number(3)
        class Four : Number(4)
        class Five : Number(5)
        class Six : Number(6)
        class Seven : Number(7)
        class Eight : Number(8)
        class Nine : Number(9)
    }

    open class Action(val title: String) : CalcButton() {
        class Addition : Action("+")
        class Subtraction : Action("-")
        class Multiplication : Action("x")
        class Division : Action("/")
        class Result : Action("=")

        class Function : Action("func")
        class Delete : Action("<-")
        class Clear : Action("C")
    }
}