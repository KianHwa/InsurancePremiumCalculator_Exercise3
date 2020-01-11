package com.example.exercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var insurance = 0
        val calculate = findViewById<Button>(R.id.buttonCalculate)
        val reset = findViewById<Button>(R.id.buttonReset)
        val premium = findViewById<TextView>(R.id.textViewPremium)

        val age = findViewById<Spinner>(R.id.spinnerAge)
        val smoker = findViewById<CheckBox>(R.id.checkBoxSmoker)
        //val gender = findViewById<RadioGroup>(R.id.radioGroupGender)
        val male = findViewById<RadioButton>(R.id.radioButtonMale)
        val female = findViewById<RadioButton>(R.id.radioButtonFemale)

        calculate.setOnClickListener {
            insurance =0;
            var genderSelected = ""
            if(male.isChecked)
                genderSelected = male.text.toString()
            if(female.isChecked)
                genderSelected = female.text.toString()

            var ageSelected = age.selectedItem.toString()

            if(ageSelected.equals(("Less than 17"))){
                insurance += 60
            }
            else if(ageSelected.equals("17 to 25")){
                insurance +=70
                if(genderSelected.equals("Male"))
                    insurance +=50
                if(smoker.isChecked)
                    insurance+=100
            }
            else if(ageSelected.equals("26 to 30")){
                insurance +=90
                if(genderSelected.equals("Male"))
                    insurance +=100
                if(smoker.isChecked)
                    insurance+=150
            }
            else if(ageSelected.equals("31 to 40")){
                insurance +=120
                if(genderSelected.equals("Male"))
                    insurance +=150
                if(smoker.isChecked)
                    insurance+=200
            }
            else if(ageSelected.equals("41 to 55")){
                insurance +=150
                if(genderSelected.equals("Male"))
                    insurance +=200
                if(smoker.isChecked)
                    insurance+=250
            }
            else{
                insurance +=150
                if(genderSelected.equals("Male"))
                    insurance +=200
                if(smoker.isChecked)
                    insurance+=300

            }

            premium.text = "RM " + insurance.toString()
        }

        reset.setOnClickListener {
            radioGroupGender.clearCheck()
            smoker.isChecked = false;
            premium.text = "Insurance Premium"

        }

    }
}
