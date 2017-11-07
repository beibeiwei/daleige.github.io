package net.cyq.italker.practicedemo.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import net.cyq.italker.practicedemo.R;
import net.cyq.italker.practicedemo.activity.BRVAHActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 新闻列表adapter
 * Created by CYQ on 2017/8/26.
 */
public class DocNewsAdapter extends BaseMultiItemQuickAdapter<BRVAHActivity.NewsBean, BaseViewHolder> {
    private Context context;
    private List<BRVAHActivity.NewsBean> list = new ArrayList<>();

    public DocNewsAdapter(Context context, List<BRVAHActivity.NewsBean> list) {
        super(list);
        this.context = context;
        this.list = list;
        addItemType(BRVAHActivity.NewsBean.doc, R.layout.item_doc_news);
        addItemType(BRVAHActivity.NewsBean.slide, R.layout.item_slide_news);
        addItemType(BRVAHActivity.NewsBean.text_live, R.layout.item_textlive_news);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, BRVAHActivity.NewsBean item) {

        switch (baseViewHolder.getItemViewType()) {

            case BRVAHActivity.NewsBean.doc:
                baseViewHolder.setText(R.id.txt_doc_title, item.docNewsBean.getTitle())
                        .setText(R.id.txt_doc_commentsall, item.docNewsBean.getCommentsall())
                        .setText(R.id.txt_doc_source, item.docNewsBean.getSource())
                        .setText(R.id.txt_doc_updateTime, item.docNewsBean.getUpdateTime());
                Glide.with(context).load(item.docNewsBean.getThumbnail()).placeholder(R.drawable.ic_fh_defals)
                        .crossFade().into((ImageView) baseViewHolder.getView(R.id.img_doc_thumbnail));
                baseViewHolder.addOnClickListener(R.id.img_doc_thumbnail);
                break;
            case BRVAHActivity.NewsBean.slide:
                baseViewHolder.setText(R.id.txt_slide_title, item.slideNewsBean.getTitle())
                        .setText(R.id.txt_slide_commensall, item.slideNewsBean.getCommentsall())
                        .setText(R.id.txt_slide_resource, item.slideNewsBean.getSource());
                for (int i = 0; i < item.slideNewsBean.getStyle().getImages().size(); i++) {
                    if (i == 0)
                        Glide.with(context).load(item.slideNewsBean.getStyle().getImages().get(i)).placeholder(R.drawable.ic_fh_defals)
                                .crossFade().into((ImageView) baseViewHolder.getView(R.id.img_slie_img1));
                    else if (i == 1)
                        Glide.with(context).load(item.slideNewsBean.getStyle().getImages().get(i)).placeholder(R.drawable.ic_fh_defals)
                                .crossFade().into((ImageView) baseViewHolder.getView(R.id.img_slie_img2));
                    else if (i == 2)
                        Glide.with(context).load(item.slideNewsBean.getStyle().getImages().get(i)).placeholder(R.drawable.ic_fh_defals)
                                .crossFade().into((ImageView) baseViewHolder.getView(R.id.img_slie_img3));
                }
                break;
            case BRVAHActivity.NewsBean.text_live:
                baseViewHolder.setText(R.id.txt_textlive_title, item.textLiveNewsBean.getTitle());
                Glide.with(context).load(item.textLiveNewsBean.getThumbnail()).placeholder(R.drawable.ic_fh_defals)
                        .centerCrop().into((ImageView) baseViewHolder.getView(R.id.img_textlive_thumbnail));
                break;
        }
    }
}
