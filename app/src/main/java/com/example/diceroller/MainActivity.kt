package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val dice = MainActivity.Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)

        diceImage.contentDescription = diceRoll.toString()

        val luckyNumber = 3

        when (diceRoll) {
            luckyNumber -> {
                Toast.makeText(this, "Lucky Number!", Toast.LENGTH_SHORT).show()
                diceImage.setImageResource(R.drawable.dice_3)
            }
            5 -> {
                Toast.makeText(this, "Unlucky Number", Toast.LENGTH_SHORT).show()
                diceImage.setImageResource(R.drawable.dice_5)
            }
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
    }

    class MainActivity : AppCompatActivity() {
        class Dice(val numSides: Int) {
            fun roll(): Int {
                return (1..numSides).random()
            }
        }
    }
}