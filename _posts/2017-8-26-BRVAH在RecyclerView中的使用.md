# BRVAH在RecyclerView中的使用

------

### 前言
最近在项目中完全用RecyclerView取代了ListView，好处就是RecyclerView能够自动处理item的复用问题，更新数据方面也更多样化，但是对比ListView而言，易用性就没那么好了。比如：为列表添加下划线，添加一个头部banner等还是挺费周折的，而且一个项目中各种Adapter绝对写到想吐。
好吧，写过五遍以上的原始的RecyclerView.Adapter后我迫切的打开了全球最大单生交友平台GitHub，寻找BaseAdapter for RecyclerView。然后我找到了[BAVAH](https://github.com/CymChad/BaseRecyclerViewAdapterHelper)。哈哈赶快学习一下。
BRVAH github地址：[https://github.com/CymChad/BaseRecyclerViewAdapterHelper](https://github.com/CymChad/BaseRecyclerViewAdapterHelper)

### 学习过程
> * 加载普通列表布局
> * item点击事件，item子元素点击事件
> * item设置加载动画
> * 下拉刷新上拉加载
> * RecyclerView添加头部和尾部
> * 多类item布局
> * item添加拖拽，滑动删除
> * 恩 暂时就先这么多吧，后续有新需求再持续更新......


### 具体实现

> 仿照凤凰新闻客户端头条新闻列表部分，使用RecyclerView+BRVAH实现具有banner头部的新闻列表，具有上拉刷新下拉加载，点击查看新闻详情的功能。凤凰新闻-头条新闻列表如下：
项目使用到的库如下：
______
```python

dependencies {
    ...
    compile 'com.android.support:recyclerview-v7:26.+'
    compile 'cn.yipianfengye.android:zxing-library:1.1'
    compile 'com.jakewharton:butterknife:8.8.1'
     annotationProcessor 'com.jakewharton:butterknife-compiler:8.8.1'
    compile 'com.zhy:okhttputils:2.6.2'
    compile 'net.qiujuer.genius:ui:2.0.0'
    compile 'net.qiujuer.genius:res:2.0.0'
    compile 'de.hdodenhof:circleimageview:2.1.0'
    compile 'com.github.bumptech.glide:glide:3.7.0'
    testCompile 'junit:junit:4.12'
    compile files('libs/fastjson-1.2.36.jar')
    compile files('libs/glide-3.7.0.jar')
    compile 'com.github.CymChad:BaseRecyclerViewAdapterHelper:2.9.22'
}

```



------
# 1： 加载普通列表布局
现加载凤凰新闻type为doc的普通新闻数据列表
________
初始化Adapter，三部曲没啥好说的

```java
adapter = new DocNewsAdapter(BRVAHActivity.this, list);
recyclerView.setLayoutManager(new LinearLayoutManager(BRVAHActivity.this));
recyclerView.setAdapter(adapter);
```
 Adapter实现如下,传入数据绑定即可(R.layout.item_doc_news是item布局，list是新闻数据实体类）
```java
 public class DocNewsAdapter extends BaseQuickAdapter<DocNewsBean, BaseViewHolder> {
    private Context context;
    private List<DocNewsBean> list = new ArrayList<>();

    public DocNewsAdapter(Context context, List<DocNewsBean> list) {
        super(R.layout.item_doc_news,list);
        this.context = context;
        this.list = list;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, DocNewsBean item) {
        baseViewHolder.setText(R.id.txt_doc_title, item.getTitle())
                .setText(R.id.txt_doc_commentsall, item.getCommentsall())
                .setText(R.id.txt_doc_source, item.getSource())
                .setText(R.id.txt_doc_updateTime, item.getUpdateTime());
        Glide.with(context).load(item.getThumbnail()).placeholder(R.drawable.ic_fh_defals).crossFade().into((ImageView) baseViewHolder.getView(R.id.img_doc_thumbnail));
    }
}   
```
效果如如下：

![123.png](http://upload-images.jianshu.io/upload_images/7312294-238498d7366530e3.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)






### 2：item，item子元素点击事件
持续更新中。。。。。