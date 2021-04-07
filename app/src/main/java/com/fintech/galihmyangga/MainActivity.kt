package com.fintech.galihmyangga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.fintech.galihmyangga.presenter.LuasPresenter
import com.fintech.galihmyangga.presenter.LuasView

class MainActivity : AppCompatActivity(), LuasView {

    private lateinit var presenter: LuasPresenter
    private lateinit var etPanjang: EditText
    private lateinit var etLebar: EditText
    private lateinit var tvHasilLuasPresenter: TextView
    private lateinit var btnHitungLuasPersegiPanjang: Button
    private lateinit var btnHalamanSelanjutnya: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = LuasPresenter(this)

        etPanjang = findViewById(R.id.et_panjang)
        etLebar = findViewById(R.id.et_lebar)
        tvHasilLuasPresenter = findViewById(R.id.tv_hasil_luas_persegi_panjang)
        btnHitungLuasPersegiPanjang = findViewById(R.id.btn_hitung_luas_persegi_panjang)
        btnHalamanSelanjutnya = findViewById(R.id.btn_halaman_selanjutnya)


        btnHitungLuasPersegiPanjang.setOnClickListener {
            val panjang = etPanjang.text.toString().trim().toFloat()
            val lebar = etLebar.text.toString().trim().toFloat()

            presenter.hitungLuasPersegi(panjang, lebar)

        }
        btnHalamanSelanjutnya.setOnClickListener {
            val intent = Intent(MainActivity@this, SecondActivity::class.java )
            startActivity(intent)
        }


    }

    override fun hasilLuasPersegiPanjang(luas: Float) {
        tvHasilLuasPresenter.text = luas.toString()
    }
}