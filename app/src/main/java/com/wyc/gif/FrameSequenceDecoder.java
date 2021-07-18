package com.wyc.gif;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.rastermill.FrameSequence;
import android.support.rastermill.FrameSequenceDrawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

import java.io.IOException;
import java.io.InputStream;

/**
 * 作者： wyc
 * <p>
 * 创建时间： 2020/11/30 15:58
 * <p>
 * 文件名字： com.wyc.gif
 * <p>
 * 类的介绍：
 */
public class FrameSequenceDecoder implements ResourceDecoder<InputStream, FrameSequenceDrawable> {


    private BitmapPool bitmapPool;
    private CheckingProvider mProvider = new CheckingProvider();


    public FrameSequenceDecoder(BitmapPool bitmapPool) {
        this.bitmapPool = bitmapPool;
    }

    @Override
    public boolean handles(@NonNull InputStream source, @NonNull Options options) throws IOException {
        return true;
    }

    @Nullable
    @Override
    public FrameSequenceDrawableResource decode(@NonNull InputStream source, int width, int height, @NonNull Options options) throws IOException {
        FrameSequence fs = FrameSequence.decodeStream(source);
        FrameSequenceDrawable drawable = new FrameSequenceDrawable(fs, mProvider);
        return new FrameSequenceDrawableResource(drawable);
    }

    // This provider is entirely unnecessary, just here to validate the acquire/release process
    private class CheckingProvider implements FrameSequenceDrawable.BitmapProvider {

        @Override
        public Bitmap acquireBitmap(int minWidth, int minHeight) {
            Bitmap bitmap = bitmapPool.getDirty(minWidth, minHeight, Bitmap.Config.ARGB_8888);
            return BitmapFillet.fillet(bitmap, dip2px(8), BitmapFillet.CORNER_ALL);
        }

        @Override
        public void releaseBitmap(Bitmap bitmap) {
            bitmapPool.put(bitmap);
        }
    }

    public int dip2px(float dpValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
