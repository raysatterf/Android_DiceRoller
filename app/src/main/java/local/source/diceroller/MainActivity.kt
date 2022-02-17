package local.source.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button) // reference our button object through a variable
        // listener to detect when our button has been clicked
        rollButton.setOnClickListener {
            /* initialize toast var with the makeText method from the Toast Class
             * we could can combine these two lines into one, as seen below
             * val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
             * toast.show()
             * Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
             * val resultTextView: TextView = findViewById(R.id.textView2)
             * resultTextView.text = "6"
             */
            rollDice()
        }
    }

    /* create a function to handle rolling our dice
     * initialize the dice var with the Dice class (creates object instance), pass 6 as an arg to define the sides
     * initialize the diceRoll var with the roll method from the dice object
     * initialize resultTextView var with the textView2 View from our app
     * set the resultTextView text to the result stored in diceRoll
     */
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView2)
        resultTextView.text = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    // this 'method' performs a roll on our dice, we specify that the data returned will be an Int
    var colorNum = 1..6
    var colorList = arrayOf("red","orange","yellow","green","blue","black")
    var color = colorList.random()
    fun roll(): Int {
        return (1..numSides).random() // a return statement returns a value from a function
    }
}