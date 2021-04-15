package com.example.thread

import android.app.Activity
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class SecondActivity:Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        val take=findViewById<Button>(R.id.button2)
        val add=findViewById<Button>(R.id.button3)
        val reset=findViewById<Button>(R.id.button4)
        val res = findViewById<TextView>(R.id.textView)
        val tbar=findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        res.text= initial.toString()
        class Apples(): AsyncTask<Int, Void, Int>() {
            override fun doInBackground(vararg params: Int?): Int? {
                return params[0]!!+params[1]!!
            }

            override fun onPostExecute(result: Int?) {
                if(result==maximum || result==0)
                {

                    reset.visibility=View.VISIBLE
                    take.visibility= View.INVISIBLE
                    add.visibility= View.INVISIBLE
                }
                res.text=result.toString()
                super.onPostExecute(result)
            }
        }
        tbar.setNavigationOnClickListener {
            onBackPressed()
        }
        take.setOnClickListener {
            val t=Apples()
            t.execute(res.text.toString().toInt(),-1)
        }
        add.setOnClickListener {
            val t=Apples()
            t.execute(res.text.toString().toInt(),1)
        }
        reset.setOnClickListener {
            reset.visibility = View.INVISIBLE
            take.visibility = View.VISIBLE
            add.visibility = View.VISIBLE
            res.text= initial.toString()
        }
    }
}