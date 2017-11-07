package net.cyq.italker.practicedemo.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import net.cyq.italker.practicedemo.R;
import net.cyq.italker.practicedemo.adapter.DocNewsAdapter;
import net.cyq.italker.practicedemo.bean.API;
import net.cyq.italker.practicedemo.bean.DocNewsBean;
import net.cyq.italker.practicedemo.bean.SlideNewsBean;
import net.cyq.italker.practicedemo.bean.TextLiveNewsBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

public class BRVAHActivity extends AppCompatActivity implements BaseQuickAdapter.OnItemClickListener,
        BaseQuickAdapter.OnItemChildClickListener, BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {
    Toolbar toolbar;
    LinearLayout container;
    int currentPage = 0, totalPage = 0;
    boolean isRefresh = true;//当前操作是否是下拉刷新
    List<NewsBean> list = new ArrayList<>();
    @BindView(R.id.recyc_news)
    RecyclerView recyclerView;
    DocNewsAdapter adapter;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brvah);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        toolbar = (Toolbar) findViewById(R.id.tb_toolbar);
        setSupportActionBar(toolbar);
        requestData(currentPage);
        adapter = new DocNewsAdapter(BRVAHActivity.this, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(BRVAHActivity.this));
        recyclerView.setAdapter(adapter);
        //item点击事件
        adapter.setOnItemClickListener(this);
        //item子元素点击事件
        adapter.setOnItemChildClickListener(this);
//        adapter.openLoadAnimation();
        adapter.isFirstOnly(false);
        //adapter设置头部banner
        adapter.addHeaderView(initBanner());
        //自动加载
        adapter.setOnLoadMoreListener(this);
        //上拉刷新
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
    }

    /**
     * 初始化banner
     */
    private View initBanner() {
        container = (LinearLayout) findViewById(R.id.container);
        View customBanner = LayoutInflater.from(this).inflate(R.layout.custom_banner, container, false);
        ViewGroup viewGroup = (ViewGroup) customBanner;
        Banner banner = (Banner) viewGroup.getChildAt(0);
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(BRVAHActivity.this, "点击了focus news" + position, Toast.LENGTH_SHORT).show();
            }
        });
        return customBanner;
    }

    /**
     * 请求新闻数据
     *
     * @param page 第几页新闻
     */
    private void requestData(final int page) {
        OkHttpUtils
                .get()
                .url(API.getFh_toutiao() + page)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(BRVAHActivity.this, "网络请求失败，请检查网络设置", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        JSONObject data = (JSONObject) JSON.parseArray(response).get(0);
                        totalPage = data.getInteger("totalPage");
                        currentPage = data.getInteger("currentPage");
                        JSONArray item = data.getJSONArray("item");
                        for (int i = 0; i < item.size(); i++) {
                            JSONObject newsData = (JSONObject) item.get(i);
                            String newsType = newsData.getString("type");
                            if (newsType.equals("doc")) {
                                DocNewsBean docNewsBean = JSON.parseObject(item.get(i).toString(), DocNewsBean.class);
                                NewsBean newsBean = new NewsBean(NewsBean.doc, docNewsBean, null, null);
                                list.add(newsBean);
                            } else if (newsType.equals("slide")) {
                                SlideNewsBean slideNewsBean = JSON.parseObject(item.get(i).toString(), SlideNewsBean.class);
                                NewsBean newsBean = new NewsBean(NewsBean.slide, null, slideNewsBean, null);
                                list.add(newsBean);
                            } else if (newsType.equals("text_live")) {
                                TextLiveNewsBean textLiveNewsBean = JSON.parseObject(item.get(i).toString(), TextLiveNewsBean.class);
                                NewsBean newsBean = new NewsBean(NewsBean.text_live, null, null, textLiveNewsBean);
                                list.add(newsBean);
                            }
                        }
                        adapter.notifyDataSetChanged();
                        if (isRefresh) {
                            //结束下拉刷新动画
                            mSwipeRefreshLayout.setRefreshing(false);
                        } else {
                            //结束加载更多动画
                            adapter.loadMoreComplete();
                        }

                    }
                });
    }

    /**
     * item的点击事件
     *
     * @param adapter  设置点击事件的Adapter
     * @param view     item的view
     * @param position item位置
     */
    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Intent intent = new Intent(BRVAHActivity.this, NewsDitailsActivity.class);
        String url = null;
        if (list.get(position).docNewsBean != null)
            url = list.get(position).docNewsBean.getLink().getWeburl();
        else if (list.get(position).slideNewsBean != null)
            url = list.get(position).slideNewsBean.getLink().getWeburl();
        else if (list.get(position).textLiveNewsBean != null)
            url = list.get(position).textLiveNewsBean.getLink().getWeburl();
        intent.putExtra("url", url);
        startActivity(intent);
    }

    /**
     * item子元素点击事件
     *
     * @param adapter
     * @param view
     * @param position
     * @return
     */
    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        Toast.makeText(BRVAHActivity.this, "点击子元素中的图片" + position, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onLoadMoreRequested() {
        isRefresh = false;
        if (currentPage < totalPage) {
            requestData(currentPage + 1);
        } else {
            adapter.loadMoreEnd();
        }

    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        isRefresh = true;
        currentPage = 0;
        list.clear();
        requestData(currentPage);
    }

    /**
     * 包含三种类型的新闻实体
     */
    public class NewsBean implements MultiItemEntity {
        public DocNewsBean docNewsBean;
        public SlideNewsBean slideNewsBean;
        public TextLiveNewsBean textLiveNewsBean;
        private int itemType;
        public static final int doc = 1;
        public static final int slide = 2;
        public static final int text_live = 3;

        public NewsBean(int itemType, DocNewsBean docNewsBean, SlideNewsBean slideNewsBean, TextLiveNewsBean
                textLiveNewsBean) {
            this.docNewsBean = docNewsBean;
            this.slideNewsBean = slideNewsBean;
            this.textLiveNewsBean = textLiveNewsBean;
            this.itemType = itemType;
        }

        @Override
        public int getItemType() {
            return this.itemType;
        }
    }

}
