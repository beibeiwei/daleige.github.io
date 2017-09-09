------
### 介绍
最近在项目中需要展示后台发送过来的新闻公告页面，后台返回数据的形式竟然是html标签，我勒个去，写接口的都是爷。直接用TextView解析html标签实在是忒丑，那就用内置html自己写css样式展示吧
确定思路后需要解决几个问题：

> * Android传递数据到JavaScript，使用JavaScript添加到html节点
> * JavaScript返回数据给原生Android

原本的思路是使用Cordova或者React Native,但是本项目只需要展示页面，不需要调用Android系统的硬件，所示直接嵌入html+css+javasript就足够，其实大部分应用也是这样，展示页面使用h5,其他使用原生

效果如下：(标题就是android传递到js的，配合css效果比textview显示html标签好太多)

![image.png](http://upload-images.jianshu.io/upload_images/7312294-1b50485d086a7711.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

------
### 步骤
* 1 项目中添加文件夹assets放置html+css+js
* 2 创建一个与JavaScript交互的工具类JavaScriptSupport(命名随意)
* 3 布局中使用WebView，在activity或fragment初始化
* 4 JavaScript中调用JavaScriptSupport中方法实现与原生交互

------
#### 1：创建assets
切换到项目project目录下，在projectName/app/src/main/目录下新建文件夹assets，并在assets下放置你的html+css+js

![73M18F5EU$ESR1P}CNM{B9N.png](http://upload-images.jianshu.io/upload_images/7312294-30c4f2f4ed6eaa0c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


#### 2：创建JavaScriptSupport.class

> * JavaScriptSupport中被js调用的方法必须用public修饰
> * 且必须实现 @JavascriptInterface接口(告诉js这个方法是能够被js调用的)
```java
import android.util.Log;
import android.webkit.JavascriptInterface;
/**
 * android原生与JavaScript交互工具类
 * Created by CYQ on 2017/9/9.
 */
public class JavascriptSupport {

    /**
     * 给js发送一个字符串
     * @return
     */
    @JavascriptInterface
    public String setParameter() {
        String newsTitle = "Android与JavaScript交互";
        return newsTitle;
    }

    /**
     * 获取js返回的数据
     * @param result
     */
    @JavascriptInterface
    public void getJSReBack(String result) {
        Log.e("js", "js返回的数据：" + result);
    }
}

```

#### 3：WebView初始化
主要是mWebView.addJavascriptInterface(javascriptSupport, "newsinfo");
javascriptSupport是我们JavaScriptSupport的实例化对象
newsinfo是我们在js中通过window.newsinfo.setParameter()调用工具类的标志(命名随意)
```java
public class WebViewInfomationActivity extends SwipeBackActivity {
    @BindView(R.id.webview_test)
    WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_infomation);
        mWebView.setWebViewClient(new WebViewClient());
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        //允许访问assets目录
        settings.setAllowFileAccess(true);
        //设置WebView排版算法, 实现单列显示, 不允许横向移动
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //assets下要显示的html文件路径
        String path = "file:///android_asset/information_news.html";
        JavascriptSupport javascriptSupport = new JavascriptSupport();
        mWebView.addJavascriptInterface(javascriptSupport, "newsinfo");
        mWebView.loadUrl(path);
    }
}

```
#### 4：JavaScript通过工具类与获取android端数据并返回数据
在JavaScript中调用工具类中的实现了@JavascriptInterface接口的方法获取数据和返回数据
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title></title>
    <meta name="viewport" content="width=device-width; initial-scale=1">
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {
        
        //调用javascripteSupport中setParameter获取android数据，并显示在html中
        var android_data=window.newsinfo.setParameter();
        $('#title').text(android_data);
        
        //调用javascripteSupport中setParameter返回js端的数据
        window.newsinfo.getJSReBack("hello android, I am js reback data");
    });
    </script>
</head>
<body>
<div class="contioner">
    <section class="information">
        <h1 id="title"></h1>
```
html页面显示android发送到js端的字符串，并设置为标题，效果如下

![image.png](http://upload-images.jianshu.io/upload_images/7312294-4fbdad16626e4d7e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

android端接收接js返回的数据，并使用Log打印
![image.png](http://upload-images.jianshu.io/upload_images/7312294-c2f3a6a73fa92eba.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
-----------
#### 总结：
至此就完成了android与JavaScript中数据的相互的调用，并且内置html的效果也非常不错，凤凰新闻客户端等app就大量使用了原生与html混合开发展示新闻详情页面
> * 若有有不足之处，请留言指正，共同学习