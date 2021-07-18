package com.wyc.gif;

import android.support.rastermill.FrameSequenceDrawable;

import androidx.annotation.NonNull;

import com.bumptech.glide.load.resource.drawable.DrawableResource;

/**
 * 作者： wyc
 * <p>
 * 创建时间： 2020/11/30 15:59
 * <p>
 * 文件名字： com.wyc.gif
 * <p>
 * 类的介绍：
 */
public class FrameSequenceDrawableResource extends DrawableResource<FrameSequenceDrawable> {
    public FrameSequenceDrawableResource(FrameSequenceDrawable drawable) {
        super(drawable);
    }

    @NonNull
    @Override
    public Class<FrameSequenceDrawable> getResourceClass() {
        return FrameSequenceDrawable.class;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void recycle() {
        drawable.stop();
        drawable.destroy();
    }
}
