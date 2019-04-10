package com.medanis.myapplication


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class listAdapter( val mContext: Context, val mData: MutableList<listItems>) :  RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var mFilteredList: MutableList<listItems> = mData


    override fun getItemCount(): Int {
        return mData.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        
        var viewHolder: RecyclerView.ViewHolder? = null
        val inflater = LayoutInflater.from(parent.context)

                val v = inflater.inflate(R.layout.cardview, parent, false)
                viewHolder = MyMainViewHolder(v)
        return viewHolder
//        return MyMainViewHolder(view)
    }

    fun setfilter(listItems: MutableList<listItems>): MutableList<listItems>? {
        mFilteredList.clear()
        mFilteredList.addAll(listItems)
        notifyDataSetChanged()
        return mFilteredList
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.setIsRecyclable(false)

                val viewHolder = holder as MyMainViewHolder

                viewHolder.listdata.text = mData[position].getFruitNames()
                viewHolder.title.text = mData[position].getFruitNames2()
                viewHolder.imageView.setImageResource(mData[position].getimageShow()!!)


    }

    class MyMainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var listdata: TextView
        internal var title: TextView
        internal var imageView: ImageView
        init {
            listdata = itemView.findViewById(R.id.listdata) as TextView
            title = itemView.findViewById(R.id.title) as TextView
            imageView = itemView.findViewById(R.id.imageView) as ImageView
        }
    }


}

