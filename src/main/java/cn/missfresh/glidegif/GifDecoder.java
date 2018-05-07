package cn.missfresh.glidegif;

import android.support.rastermill.FrameSequence;

import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.SimpleResource;

import java.io.IOException;
import java.io.InputStream;

/**
 * File description.
 * 自定义gif 解码器
 * @author lihongjun
 * @date 2018/4/24
 */

public class GifDecoder implements ResourceDecoder<InputStream,FrameSequence> {

    @Override
    public Resource<FrameSequence> decode(InputStream source, int width, int height) throws IOException {
        try {
            FrameSequence fs = FrameSequence.decodeStream(source);
            return new SimpleResource<>(fs);
        } catch (Exception e) {
            throw new IOException("Cannot load gif from stream", e);
        }
    }

    @Override
    public String getId() {
        return "cn.missfresh.gifdecoder";
    }
}
