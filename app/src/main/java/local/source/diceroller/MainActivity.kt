/*
 *  [Unit 1: Kotlin basics]
 *  [Add a button to an app]
 *  [Add conditional behavior in Kotlin]
 *  [Add images to the Dice Roller app]
 *
 * Lots of exhaustive commenting here to help with new concepts learned to refer bac
 */

package local.source.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.rollButton)
        // listener to detect when our rollButton has been clicked
        rollButton.setOnClickListener {
            rollDice()
            rollDice2()
        }
        rollDice()
        rollDice2()
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageDice1)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }
    private fun rollDice2() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageDice2)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }
}

/**
 * Handle Dice objects and what they can do
 */
class Dice(private val numSides: Int) {
    var colorNum = 1..6
    private var colorList = arrayOf("red", "orange", "yellow", "green", "blue", "black")
    var color = colorList.random()
    fun roll(): Int {
        return (1..numSides).random()
    }
}