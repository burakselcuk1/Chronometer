package com.example.kronometre

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import com.example.kronometre.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        var zamaniDurdur: Long =0

        binding.btnStart.setOnClickListener {

            binding.kronometre.base = SystemClock.elapsedRealtime()+zamaniDurdur
            binding.kronometre.start()
            binding.btnStart.visibility = View.GONE
            binding.btnPause.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.pause))
        }

        binding.btnPause.setOnClickListener {

            zamaniDurdur = binding.kronometre.base-SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            binding.btnPause.visibility = View.GONE
            binding.btnStart.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))
        }

        binding.btnReset.setOnClickListener {

            binding.kronometre.base = SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            zamaniDurdur = 0
            binding.btnPause.visibility = View.GONE
            binding.btnStart.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))
        }



    }
}