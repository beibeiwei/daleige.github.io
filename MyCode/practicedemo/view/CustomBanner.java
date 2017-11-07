package net.cyq.italker.practicedemo.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import net.cyq.italker.practicedemo.R;
import net.cyq.italker.practicedemo.activity.BRVAHActivity;
import net.cyq.italker.practicedemo.bean.API;
import net.cyq.italker.practicedemo.bean.DocNewsBean;
import net.cyq.italker.practicedemo.bean.FocusNewsBean;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by CYQ on 2017/8/26.
 */

public class CustomBanner extends RelativeLayout {
    Banner banner;
    List<String> images = new ArrayList<>();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };

    public CustomBanner(Context context) {
        super(context);
        requestData();
    }

    public CustomBanner(Context context, AttributeSet attrs) {
        super(context, attrs);
        requestData();
    }

    public CustomBanner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        requestData();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }

    /**
     * 请求新闻数据
     */
    private void requestData() {
        OkHttpUtils
                .get()
                .url(API.getFh_toutiao() + 1)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        JSONObject data = (JSONObject) JSON.parseArray(response).get(1);
                        JSONArray item = data.getJSONArray("item");
                        for (int i = 0; i < item.size(); i++) {
                            FocusNewsBean focusNewsBean = JSON.parseObject(item.get(i).toString(), FocusNewsBean.class);
                            String thumbnail = focusNewsBean.getThumbnail();
                            images.add(thumbnail);
                        }
                        banner = findViewById(R.id.banner);
                        banner.setImages(images);
                        banner.setImageLoader(new GlideImageLoader());
                        banner.setDelayTime(4000);
                        banner.setBannerAnimation(Transformer.Default);
                        banner.start();
                    }
                });
    }

    public Banner getBanner() {
        return banner;
    }
}
