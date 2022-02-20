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

        // reference our rollButton object through a variable
        val rollButton: Button = findViewById(R.id.rollButton)
        // listener to detect when our rollButton has been clicked
        rollButton.setOnClickListener {
            /* initialize toast var with the makeText method from the Toast Class
             * we can combine these two lines into one, as seen below
             * val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
             * toast.show()
             * Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
             * val resultTextView: TextView = findViewById(R.id.textDice2)
             * resultTextView.text = "6"
             */
            rollDice()
        }
        rollDice()
    }

    /**
     * create a function to handle rolling our dice
     * initialize the dice var with the Dice class (creates object instance),
     * pass 6 as an arg to define the sides
     * initialize the diceRoll var with the roll method from the dice object
     * initialize resultTextView var with the textDice2 View from our app
     * set the resultTextView text to the result stored in diceRoll
     */
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageDice1)
        /*
         * init diceImage as ImageView 'type'; set equal to imageDice1
         * test to see if we can update the diceImage when we click 'roll'
         * handle conditions of 'diceRoll' result with 'when' statement
         * 'when' statement can be optimized by storing the resource ID to-be used in a variable
         * then we can call 'setImageResource' method on 'diceImage' var only once!
        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }*/
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
    // this 'method' performs a roll on our dice, we specify that the data returned will be an Int
    var colorNum = 1..6
    private var colorList = arrayOf("red", "orange", "yellow", "green", "blue", "black")
    var color = colorList.random()
    fun roll(): Int {
        return (1..numSides).random() // a return statement returns a value from a function
    }
}