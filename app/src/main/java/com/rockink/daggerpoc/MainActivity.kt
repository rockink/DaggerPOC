package com.rockink.daggerpoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rockink.daggerpoc.application.RandomStringer
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var randomStringer: RandomStringer

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textview.text = randomStringer.getRandomString();
    }
}
