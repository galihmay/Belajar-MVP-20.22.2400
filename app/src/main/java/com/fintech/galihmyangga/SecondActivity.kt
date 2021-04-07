package com.fintech.galihmyangga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.fintech.galihmyangga.presenter.KelilingPresenter
import com.fintech.galihmyangga.presenter.KelilingView
import com.fintech.galihmyangga.presenter.LuasPresenter
import com.fintech.galihmyangga.presenter.LuasView

class SecondActivity : AppCompatActivity(), KelilingView {

    private lateinit var presenter: KelilingPresenter
    private lateinit var etPanjang: EditText
    private lateinit var etLebar: EditText
    private lateinit var tvHasilKelilingPresenter: TextView
    private lateinit var btnHitungKelilingPersegiPanjang: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        presenter = KelilingPresenter(this)

        etPanjang = findViewById(R.id.et_panjang)
        etLebar = findViewById(R.id.et_lebar)
        tvHasilKelilingPresenter = findViewById(R.id.tv_hasil_keliling_persegi_panjang)
        btnHitungKelilingPersegiPanjang = findViewById(R.id.btn_hitung_keliling_persegi_panjang)



        btnHitungKelilingPersegiPanjang.setOnClickListener {
            val panjang = etPanjang.text.toString().trim().toFloat()
            val lebar = etLebar.text.toString().trim().toFloat()

            presenter.hitungKelilingPersegi(panjang, lebar)

        }



    }


    override fun hasilKelilingPersegiPanjang(keliling: Float) {
        tvHasilKelilingPresenter.text = keliling.toString()
    }
}