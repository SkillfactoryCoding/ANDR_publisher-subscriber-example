package com.devsoldatenkov.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devsoldatenkov.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val publisher = Publisher()
        val subscriber1 = object : Subscriber {
            override fun update(data: String) {
                binding.sub1Text.text = data
                println("VVV subscriber1: $data")
            }
        }
        val subscriber2 = object : Subscriber {
            override fun update(data: String) {
                println("VVV subscriber2: $data")
            }
        }

        binding.sub1.setOnClickListener {
            publisher.subscribe(subscriber1)
        }
        binding.sub2.setOnClickListener {
            publisher.subscribe(subscriber2)
        }
        binding.unsub1.setOnClickListener {
            publisher.unsubscribe(subscriber1)
        }
        binding.unsub2.setOnClickListener {
            publisher.unsubscribe(subscriber2)
        }
        binding.post.setOnClickListener {
            publisher.post(binding.editText.text.toString())
        }
    }
}