package com.aryo.apppindah

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.content.Intent
import android.widget.ImageView
import android.net.Uri
import android.content.ActivityNotFoundException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnKedua = findViewById<Button>(R.id.btnKedua)
        btnKedua.setOnClickListener {
            val intent = Intent(this, KeduaActivity::class.java)
            startActivity(intent)
        }


        val call = findViewById<ImageView>(R.id.ic_call)
        val noTelp = "+6282161965317"
        call.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$noTelp")
            startActivity(intent)
        }

        val wa = findViewById<ImageView>(R.id.ic_whatsapp)
        val noWa = "6282161965317"
        val pesan = "Halo, saya ingin bertanya tentang aplikasi Anda."
        wa.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://wa.me/$noWa?text=$pesan")
            startActivity(intent)
        }

        val ig = findViewById<ImageView>(R.id.ic_instagram)
        val igUsername = "aryopratamaa"
        ig.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.instagram.com/$igUsername")
            startActivity(intent)
        }

//        val fb = findViewById<ImageView>(R.id.ic_fb)
//        val fbUsername = "aryopratama04082000"
//        fb.setOnClickListener {
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse("https://www.facebook.com/$fbUsername")
//            startActivity(intent)
//        }

        val fb = findViewById<ImageView>(R.id.ic_fb)
        fb.setOnClickListener {
            val appFb = Uri.parse("https://www.facebook.com/aryopratama04082000")
            val intent = Intent(Intent.ACTION_VIEW, appFb)
            intent.setPackage("com.facebook.katana")
            try {
                startActivity(intent)
            } catch (ActivityNotFoundException: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, appFb))
            }
        }

        val tiktok = findViewById<ImageView>(R.id.ic_tiktok)
        tiktok.setOnClickListener {
            val appTiktok = Uri.parse("https://www.tiktok.com/@aryopratamaa")
            val intent = Intent(Intent.ACTION_VIEW, appTiktok)
            intent.setPackage("com.zhiliaoapp.musically")
            try {
                startActivity(intent)
            } catch (ActivityNotFoundException: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, appTiktok))
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}