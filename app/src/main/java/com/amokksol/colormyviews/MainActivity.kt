package com.amokksol.colormyviews

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()

    }

    //функция прослушивания щелчков для каждого представления, findViewByID - каждая ссылка переменная
    private fun setListeners(){
        //переменные для текстовых представлений и основного слоя
        val boxOneText=findViewById<TextView>(R.id.box_one_text)
        val boxTwoText=findViewById<TextView>(R.id.box_two_text)
        val boxThreeText=findViewById<TextView>(R.id.box_three_text)
        val boxFourText=findViewById<TextView>(R.id.box_four_ext)
        val boxFiveText=findViewById<TextView>(R.id.box_five_text)
        val rootConstraintLayout=findViewById<View>(R.id.root_constraint_layout)
        //переменные для кнопок
        val redButton=findViewById<Button>(R.id.red_button)
        val yellowButton=findViewById<Button>(R.id.yellow_button)
        val greenButton=findViewById<Button>(R.id.green_button)
    //создаем спискок из элементов интерфейса - для дальнейшего взаимодействия
        val clickableViews:List<View> = listOf(boxOneText,boxTwoText,boxThreeText,
        boxFourText,boxFiveText,rootConstraintLayout,redButton,yellowButton,greenButton)
    //пробегаемся по списку и всем присваиваем реакцию на клик, подтаскиваем сюда же функцию изменения цвета при клике
        for (item in clickableViews) {
            item.setOnClickListener {makeColored(it)}
        }
    }
    //функция присваивания каждому Текстовому элементу и основному слою - определенного цвета
    private fun makeColored(view:View) {
        val boxThreeText=findViewById<TextView>(R.id.box_three_text)
        val boxFourText=findViewById<TextView>(R.id.box_four_ext)
        val boxFiveText=findViewById<TextView>(R.id.box_five_text)
        when(view.id) {
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)
            R.id.box_three_text -> view.setBackgroundColor(Color.BLUE)
            R.id.box_four_ext -> view.setBackgroundColor(Color.MAGENTA)
            R.id.box_five_text -> view.setBackgroundColor(Color.BLUE)
            //перемна цвета на элементах - при нажатии на кнопку изменения цвета
            R.id.red_button -> boxThreeText.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> boxFourText.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> boxFiveText.setBackgroundResource(R.color.my_green)
            else->view.setBackgroundColor(Color.YELLOW)
        }
    }

}