package com.wyc.gif

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.support.rastermill.FrameSequenceDrawable
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gif =
            "http://2zhoumu-comic-public-test.oss-cn-hangzhou.aliyuncs.com/cover/comic/gc1100004.gif"
        GlideApp.with(this).`as`(FrameSequenceDrawable::class.java).load(gif)
            .into(sample_image)
    }
}
