package com.example.tugas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Kirim : AppCompatActivity() {

    companion object{
        const val onamae = "a"
        const val number = "b"
        const val study = "d"
        const val doko = "c"
        const val nannichi = "e"
        const val hideyoshi = "f"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kirim)

        val isi_btn_kirim : TextView = findViewById(R.id.txt_btn_kirim)

        val nama = intent.getStringExtra(onamae)
        val nim = intent.getIntExtra(number, 0)
        val saintek = intent.getStringExtra(study)
        val address = intent.getStringExtra(doko)
        val lahir = intent.getIntExtra(nannichi, 0)
        val kelam = intent.getStringExtra(hideyoshi)
        val sambung = "Nama : $nama \nNIM : $nim \nJurusan : $saintek \nAlamat : $address \nTanggal Lahir : $lahir \nJenis Kelamin : $kelam"
        isi_btn_kirim.text = sambung

    }
}