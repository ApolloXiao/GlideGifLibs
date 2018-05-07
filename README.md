# GlideGifLibs
用FrameSequence解码glide Stream来播放gif图片

#使用
```
/**
     *
     * @param context
     * @param url
     * @param targeView
     * @param loopCount 必须传LOOP_ONCE LOOP_INF LOOP_DEFAULT具体含义查看FrameSequenceDrawable
     */
ImageGifLoader.display(Context context, String url, final ImageView targeView,int loopCount);
ImageGifLoader.display(Context context,String url,final ImageView targeView,int loopCount,int placeHolder,int errorHolder);
```
