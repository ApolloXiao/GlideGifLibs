package cn.missfresh.glidegif;

import com.bumptech.glide.load.engine.Resource;

/**
 * File description.
 * 自定义gif资源
 * @author lihongjun
 * @date 2018/4/24
 */

public class GifResource<T> implements Resource<T> {

    protected final T data;

    public GifResource(T data) {
        if (data == null) {
            throw new NullPointerException("Data must not be null");
        }
        this.data = data;
    }

    @Override
    public T get() {
        return data;
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public void recycle() {

    }
}
