package com.example.tugas

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var editNama : EditText
    private lateinit var editNim : EditText
    private lateinit var editJurusan : EditText
    private lateinit var editPr : RadioButton
    private lateinit var editLaki : RadioButton
    private lateinit var editJk : RadioGroup
    private lateinit var editLahir : EditText
    private lateinit var editAlamat : EditText
    private lateinit var klikTombol2 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editNama = findViewById(R.id.edit_nama)
        editNim = findViewById(R.id.edit_nim)
        editJurusan = findViewById(R.id.edit_jurus)
        editAlamat = findViewById(R.id.edit_alamat)
        editPr = findViewById(R.id.perempuan)
        editLahir = findViewById(R.id.edit_lahir)
        editLaki = findViewById(R.id.laki)
        editJk = findViewById(R.id.pilihjk)
        klikTombol2=findViewById(R.id.submit2)
        klikTombol2.setOnClickListener(this)


        editLahir.addTextChangedListener(dieditedit)
        editNama.addTextChangedListener(dieditedit)
        editNim.addTextChangedListener(dieditedit)
        editJurusan.addTextChangedListener(dieditedit)
        editAlamat.addTextChangedListener(dieditedit)

        pilihjk.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                Toast.makeText(applicationContext," On checked change :"+ " ${radio.text}", Toast.LENGTH_SHORT).show()
            })

    }

    private val dieditedit: TextWatcher = object : TextWatcher {

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable) {
            val tulis_nama = editNama.text.toString().trim()
            val tulis_nim = editNim.text.toString().trim()
            val tulis_alamat = editAlamat.text.toString().trim()
            val tulis_jurusan = editJurusan.text.toString().trim()
            val tulis_ttl = editLahir.text.toString().trim()

            var amin : String = "Tidak diketahui"
            var cek = 0

            var id: Int = pilihjk.checkedRadioButtonId
            if (id!=-1){
                val radio:RadioButton = findViewById(id)
                cek = 1
            }

            val t = tulis_nama.isNotEmpty() && tulis_nim.isNotEmpty() && tulis_alamat.isNotEmpty() && tulis_jurusan.isNotEmpty() && tulis_ttl.isNotEmpty() && cek==1 && tulis_nama!= null && tulis_nim!= null && tulis_alamat!= null && tulis_jurusan!= null && tulis_ttl!= null && cek == 1
            if (t) {
                submit2.isEnabled = true
            }

        }
    }


    override fun onClick(v: View) {
        val tulis_nama = editNama.text.toString().trim()
        val tulis_nim = editNim.text.toString().trim()
        val tulis_alamat = editAlamat.text.toString().trim()
        val tulis_jurusan = editJurusan.text.toString().trim()
        val tulis_ttl = editLahir.text.toString().trim()
        var amin : String = "Hideyoshi"

        var id: Int = pilihjk.checkedRadioButtonId
        if (id!=-1){
            val radio:RadioButton = findViewById(id)
                amin = radio.text.toString()

        }


        if(v.id == R.id.submit2){

            val pindah = Intent(this@MainActivity, Kirim :: class.java)
            pindah.putExtra(Kirim.onamae, tulis_nama)
            pindah.putExtra(Kirim.number, tulis_nim.toInt())
            pindah.putExtra(Kirim.study, tulis_jurusan)
            pindah.putExtra(Kirim.doko, tulis_alamat)
            pindah.putExtra(Kirim.nannichi, tulis_ttl.toInt())
            pindah.putExtra(Kirim.hideyoshi, amin)
            startActivity(pindah)

        }

    }



}




/*
package com.example.tugas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var editNama : EditText
    private lateinit var editNim : EditText
    private lateinit var editJurusan : EditText
    private lateinit var editPr : RadioButton
    private lateinit var editLaki : RadioButton
    private lateinit var editJk : RadioGroup
    private lateinit var editLahir : EditText
    private lateinit var editAlamat : EditText
    private lateinit var klikTombol : Button
    private lateinit var klikTombol2 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editNama = findViewById(R.id.edit_nama)
        editNim = findViewById(R.id.edit_nim)
        editJurusan = findViewById(R.id.edit_jurus)
        editAlamat = findViewById(R.id.edit_alamat)
        editPr = findViewById(R.id.perempuan)
        editLahir = findViewById(R.id.edit_lahir)
        editLaki = findViewById(R.id.laki)
        editJk = findViewById(R.id.pilihjk)
        klikTombol=findViewById(R.id.submit)
        klikTombol.setOnClickListener(this)
        klikTombol2=findViewById(R.id.submit2)
        klikTombol2.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        val tulis_nama = editNama.text.toString().trim()
        val tulis_nim = editNim.text.toString().trim()
        val tulis_alamat = editAlamat.text.toString().trim()
        val tulis_jurusan = editJurusan.text.toString().trim()
        val tulis_ttl = editLahir.text.toString().trim()
        val pilih_kelamin = editJk.checkedRadioButtonId
        var amin : String = "b"


        if(v.id == R.id.submit){


            var kosongGa = false

            when{
                tulis_nama.isEmpty() -> {
                    kosongGa = true
                    editNama.error = "Nama wajib diisi"
                }

                tulis_nim.isEmpty() ->{
                    kosongGa = true
                    editNim.error = "NIM wajib diisi"
                }



                tulis_jurusan.isEmpty() -> {
                    kosongGa = true
                    editJurusan.error = "Jurusan wajib diisi"
                }

                tulis_alamat.isEmpty() -> {
                    kosongGa = true
                    editAlamat.error = "Alamat wajib diisi"
                }

                tulis_ttl.isEmpty() -> {
                    kosongGa = true
                    editLahir.error = "Tanggal Lahir wajib diisi"
                }


            }

            if(!kosongGa){
                Toast.makeText(this@MainActivity, "Berhasil", Toast.LENGTH_SHORT).show()
                submit2.isEnabled = true

            }


        }

        else if(v.id == R.id.submit2){

            val pindah = Intent(this@MainActivity, Kirim :: class.java)
            pindah.putExtra(Kirim.onamae, tulis_nama)
            pindah.putExtra(Kirim.number, tulis_nim)
            pindah.putExtra(Kirim.study, tulis_jurusan)
            pindah.putExtra(Kirim.doko, tulis_alamat)
            pindah.putExtra(Kirim.nannichi, tulis_ttl)
            pindah.putExtra(Kirim.hideyoshi, amin)
            startActivity(pindah)

        }

    }



}
 */