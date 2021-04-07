package com.fintech.galihmyangga.presenter

class KelilingPresenter (
        private val kelilingView: KelilingView,

        ) {
        fun hitungKelilingPersegi(panjang: Float, lebar: Float) {
            val hasil = 2 * (panjang + lebar);

            kelilingView.hasilKelilingPersegiPanjang(hasil)
        }

    }