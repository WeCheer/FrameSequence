package com.wyc.gif;

import android.content.Context;
import android.support.rastermill.FrameSequenceDrawable;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

import java.io.InputStream;

/**
 * 作者： wyc
 * <p>
 * 创建时间： 2020/11/30 16:00
 * <p>
 * 文件名字： com.wyc.gif
 * <p>
 * 类的介绍：
 */
@GlideModule
public class GlideGifModule extends AppGlideModule {
    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        //第一个参数任意填写
        registry.prepend(Registry.BUCKET_GIF, InputStream.class, FrameSequenceDrawable.class,
                new FrameSequenceDecoder(glide.getBitmapPool()));
    }
}
