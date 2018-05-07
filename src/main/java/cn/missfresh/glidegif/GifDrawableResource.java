package cn.missfresh.glidegif;

import android.support.rastermill.FrameSequenceDrawable;

import com.bumptech.glide.load.resource.drawable.DrawableResource;

/**
 * File description.
 * 自定义gif资源
 * @author lihongjun
 * @date 2018/4/24
 */

public class GifDrawableResource extends DrawableResource<FrameSequenceDrawable> {

    public GifDrawableResource(FrameSequenceDrawable drawable) {
        super(drawable);
    }
    /**
     * Returns the size in bytes of the wrapped resource to use to determine how much of the memory cache this resource
     * uses.
     */
    @Override
    public int getSize() {
        return 16 * 1024;
    }

    /**
     * Cleans up and recycles internal resources.
     * <p>
     * <p>
     * It is only safe to call this method if there are no current resource consumers and if this method has not
     * yet been called. Typically this occurs at one of two times:
     * <ul>
     * <li>During a resource load when the resource is transformed or transcoded before any consumer have
     * ever had access to this resource</li>
     * <li>After all consumers have released this resource and it has been evicted from the cache</li>
     * </ul>
     * <p>
     * For most users of this class, the only time this method should ever be called is during transformations or
     * transcoders, the framework will call this method when all consumers have released this resource and it has
     * been evicted from the cache.
     * </p>
     */
    @Override
    public void recycle() {
        drawable.stop();
        drawable.destroy();
    }
}
