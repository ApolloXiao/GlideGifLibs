package cn.missfresh.glidegif;

import android.support.rastermill.FrameSequence;
import android.support.rastermill.FrameSequenceDrawable;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;

/**
 * File description.
 * 自定义gif变换
 * @author lihongjun
 * @date 2018/4/24
 */

public class GifDrawableTranscoder implements ResourceTranscoder<FrameSequence, FrameSequenceDrawable> {

    @Override
    public Resource<FrameSequenceDrawable> transcode(Resource<FrameSequence> toTranscode) {
        FrameSequenceDrawable drawable = new FrameSequenceDrawable(toTranscode.get());
        return new GifResource<>(drawable);
    }

    @Override
    public String getId() {
        return "";
    }
}