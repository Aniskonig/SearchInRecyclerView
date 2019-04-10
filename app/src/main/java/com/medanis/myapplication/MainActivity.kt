package com.medanis.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    fun filter(pl: MutableList<listItems>, query: String): MutableList<listItems> {
        var query1 = query
        query1 = query1.toLowerCase()
        val filteredModeList = java.util.ArrayList<listItems>()
        for (model in pl) {
            val fruitNames = model.getFruitNames()!!.toLowerCase()
            val fruitNames2 = model.getFruitNames2()!!.toLowerCase()

            if (fruitNames.startsWith(query1) || (fruitNames.contains(query1))|| (fruitNames2.contains(query1)) || fruitNames2.startsWith(query1)) {
                filteredModeList.add(model)
            }
        }
        return filteredModeList
    }
    internal  var myItemsList: MutableList<listItems>  = ArrayList()

    fun itemsList (){
        myItemsList.add(listItems("Apple","app",R.drawable.ic_launcher_background))
        myItemsList.add(listItems("Orange","new",R.drawable.ic_launcher_background))
        myItemsList.add(listItems("Kiwi","name",R.drawable.ic_launcher_background))
        myItemsList.add(listItems("Passion","Passion",R.drawable.ic_launcher_background))
        myItemsList.add(listItems("Banana","Banana",R.drawable.ic_launcher_background))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val myrv = findViewById<RecyclerView>(R.id.myRV)
        val myMainAdapter: listAdapter?
        itemsList()
        myMainAdapter = listAdapter(this, myItemsList)
        myrv.layoutManager = GridLayoutManager(this, 1)
        myrv.adapter = myMainAdapter

        var isOn = false
        button.setOnClickListener {
            if (!isOn){
                editText.visibility= View.VISIBLE
                button.setBackgroundResource(R.drawable.close)
                isOn = true
            }else {
                editText.visibility= View.GONE
                button.setBackgroundResource(R.drawable.search)
                editText.text.clear()
                myItemsList.clear()
                itemsList()
                isOn = false
            }

        }

        editText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(p0: Editable?) {
                myItemsList.clear()
                itemsList()
                if (p0!!.isNotEmpty()){
                        val filtermodelist = filter(myItemsList, p0.toString())
                        myMainAdapter.setfilter(filtermodelist)
                    }
                    if(myItemsList.isNotEmpty()){
                        nothingfound.visibility= View.GONE
                    }

            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val filtermodelist
                        = filter(myItemsList, p0.toString())
                myMainAdapter.setfilter(filtermodelist)
                if (filtermodelist.isEmpty()) {
                    nothingfound.visibility= View.VISIBLE
                }
            }
        })
    }
}
