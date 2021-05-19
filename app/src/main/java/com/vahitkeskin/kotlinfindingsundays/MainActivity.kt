package com.vahitkeskin.kotlinfindingsundays

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.vahitkeskin.kotlinfindingsundays.databinding.ActivityMainBinding
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dateList: ArrayList<String> = ArrayList()
    private val dayList: ArrayList<String> = ArrayList()
    private var itemDayAdapter: ItemDayAdapter? = null
    private var i = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        result()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun result() {
        val dateDayNames = DateDayNames()
        val myFormat = SimpleDateFormat("dd MM yyyy")
        val startDay = "01 01 1900"
        val endDay = "31 12 2000"
        val date1 = myFormat.parse(startDay)
        val date2 = myFormat.parse(endDay)
        val millionSeconds = date2.time - date1.time
        val numberOfDays = TimeUnit.MILLISECONDS.toDays(millionSeconds)

        dateList.clear()
        dayList.clear()
        while (i <= numberOfDays) {
            val c = Calendar.getInstance()
            try {
                c.time = myFormat.parse(startDay)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            c.add(Calendar.DATE, i)
            val output = myFormat.format(c.time)
            val day = output.substring(0, 2).toInt()
            val month = output.substring(3, 5).toInt()
            val year = output.substring(6, 10).toInt()
            dateDayNames.DateDayNames(day, month, year)

            if (day == 1 && dateDayNames.calculate() == "Pazar") {
                val mDate = "$day/$month/$year"
                val mDay = "${dateDayNames.calculate()}"
                println("Day value : $day/$month/$year - ${dateDayNames.calculate()}")
                dateList.add(mDate)
                dayList.add(mDay)
            }
            i++
        }
        itemDayAdapter = ItemDayAdapter(dateList, dayList)
        binding.recyclerView.adapter = itemDayAdapter
        itemDayAdapter!!.notifyDataSetChanged()
    }
}