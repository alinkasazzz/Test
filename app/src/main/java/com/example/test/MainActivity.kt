package com.example.test

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var data1: Data
    private lateinit var data2: Data
    private lateinit var data3: Data


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListener()
    }

    private fun initListener() {
        binding.button.setOnClickListener {
            viewData(binding.text)
            viewCopy(binding.text)
            viewCycle(binding.text)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun viewData(textView: TextView) {
        data1 = Data("Значение: ", "1")
        data2 = Data("Значение: ", "2")
        data3 = Data("Значение: ", "100500")
        textView.append("${data1.getData()}${data2.getData()}${data3.getData()}")
    }

    private fun viewCopy(textView: TextView) {
        textView.append(" Копия ---> " + Object.copy(data3).getData())
    }

    private fun viewCycle(textView: TextView) {
        textView.append("\nВывод циклом: \n")
        val list: Array<Data> = arrayOf(data1, data2, data3)
        for (data in list) {
            textView.append(data.getData())
        }
    }
}