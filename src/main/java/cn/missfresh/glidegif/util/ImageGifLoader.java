package cn.missfresh.glidegif.util;

import android.content.Context;
import android.net.Uri;
import android.support.rastermill.FrameSequence;
import android.support.rastermill.FrameSequenceDrawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;

import java.io.InputStream;

import cn.missfresh.glidegif.GifDecoder;
import cn.missfresh.glidegif.GifDrawableTranscoder;
import cn.missfresh.glidegif.GifSoftwareLayerSetter;


/**
 * File description.
 * 自定义gif加载工具
 * @author lihongjun
 * @date 2018/4/24
 */

public class ImageGifLoader {

    /**
     *
     * @param context
     * @param url
     * @param targeView
     * @param loopCount 必须传LOOP_ONCE LOOP_INF LOOP_DEFAULT具体含义查看FrameSequenceDrawable
     */
    public static void display(Context context, String url, final ImageView targeView,int loopCount) {
        display(context,url,targeView,loopCount,-1,-1);
    }

    public static void display(Context context,String url,final ImageView targeView,int loopCount,int placeHolder,int errorHolder) {
        Uri uri = Uri.parse(url);
        Glide.with(context)
                .using(Glide.buildStreamModelLoader(Uri.class,context), InputStream.class)
                .from(Uri.class)
                .as(FrameSequence.class)
                .transcode(new GifDrawableTranscoder(), FrameSequenceDrawable.class)
                .sourceEncoder(new StreamEncoder())
                .cacheDecoder(new FileToStreamDecoder(new GifDecoder()))
                .decoder(new GifDecoder())
                .listener(new GifSoftwareLayerSetter<Uri>(loopCount))
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .load(uri)
                .placeholder(placeHolder)
                .error(errorHolder)
                .into(targeView);

    }
}
