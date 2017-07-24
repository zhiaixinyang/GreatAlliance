package com.greatalliance.ui.share;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.greatalliance.R;
import com.greatalliance.base.BaseFragment;
import com.greatalliance.base.CommonAdapter;
import com.greatalliance.base.ViewHolder;
import com.greatalliance.model.bean.SharerBean;
import com.greatalliance.utils.AppUtils;
import com.greatalliance.utils.GlideUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by MBENBEN on 2017/7/15.
 */

public class ShareFragment extends BaseFragment {
    private String TAG = getClass().getName();
    @BindView(R.id.rlv_share) RecyclerView rlv_share;
    private List<SharerBean> datas = new ArrayList<SharerBean>();


    public static ShareFragment newInstance() {

        Bundle args = new Bundle();

        ShareFragment fragment = new ShareFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int getLayoutResId() {
        return R.layout.frag_share;
    }

    @Override
    public void initDatas() {
        SharerBean sharerOne = new SharerBean();
        sharerOne.setAuthorHead(R.mipmap.head1);
        sharerOne.setAuthorNick("哆啦A梦");
        sharerOne.setAddOfArticle("齐鲁工业大学二食堂");
        sharerOne.setArticleTitle("山西刀削面");
        sharerOne.setArticleCover(R.mipmap.cover1);
        datas.add(sharerOne);

        SharerBean sharerTwo = new SharerBean();
        sharerOne.setAuthorHead(R.mipmap.head2);
        sharerOne.setAuthorNick("飞翔的企鹅");
        sharerOne.setAddOfArticle("齐鲁工业大学三食堂");
        sharerOne.setArticleTitle("红烧牛肉面");
        sharerOne.setArticleCover(R.mipmap.cover2);
        datas.add(sharerTwo);

        SharerBean sharerThree = new SharerBean();
        sharerOne.setAuthorHead(R.mipmap.head3);
        sharerOne.setAuthorNick("且听风吟");
        sharerOne.setAddOfArticle("齐鲁工业大学一食堂");
        sharerOne.setArticleTitle("挪威的森林");
        sharerOne.setArticleCover(R.mipmap.cover3);
        datas.add(sharerThree);

        SharerBean sharer4 = new SharerBean();
        sharerOne.setAuthorHead(R.mipmap.head2);
        sharerOne.setAuthorNick("飞翔的企鹅");
        sharerOne.setAddOfArticle("齐鲁工业大学三食堂");
        sharerOne.setArticleTitle("红烧牛肉面");
        sharerOne.setArticleCover(R.mipmap.cover2);
        datas.add(sharer4);

        SharerBean sharer5 = new SharerBean();
        sharerOne.setAuthorHead(R.mipmap.head3);
        sharerOne.setAuthorNick("且听风吟");
        sharerOne.setAddOfArticle("齐鲁工业大学一食堂");
        sharerOne.setArticleTitle("挪威的森林");
        sharerOne.setArticleCover(R.mipmap.cover3);
        datas.add(sharer5);

        SharerBean sharer6 = new SharerBean();
        sharerOne.setAuthorHead(R.mipmap.head2);
        sharerOne.setAuthorNick("飞翔的企鹅");
        sharerOne.setAddOfArticle("齐鲁工业大学三食堂");
        sharerOne.setArticleTitle("红烧牛肉面");
        sharerOne.setArticleCover(R.mipmap.cover2);
        datas.add(sharer6);

        SharerBean sharer7 = new SharerBean();
        sharerOne.setAuthorHead(R.mipmap.head3);
        sharerOne.setAuthorNick("且听风吟");
        sharerOne.setAddOfArticle("齐鲁工业大学一食堂");
        sharerOne.setArticleTitle("挪威的森林");
        sharerOne.setArticleCover(R.mipmap.cover3);
        datas.add(sharer7);

        SharerBean sharer8 = new SharerBean();
        sharerOne.setAuthorHead(R.mipmap.head2);
        sharerOne.setAuthorNick("飞翔的企鹅");
        sharerOne.setAddOfArticle("齐鲁工业大学三食堂");
        sharerOne.setArticleTitle("红烧牛肉面");
        sharerOne.setArticleCover(R.mipmap.cover2);
        datas.add(sharer8);

        SharerBean sharer9 = new SharerBean();
        sharerOne.setAuthorHead(R.mipmap.head3);
        sharerOne.setAuthorNick("且听风吟");
        sharerOne.setAddOfArticle("齐鲁工业大学一食堂");
        sharerOne.setArticleTitle("挪威的森林");
        sharerOne.setArticleCover(R.mipmap.cover3);
        datas.add(sharer9);

        SharerBean sharer10 = new SharerBean();
        sharerOne.setAuthorHead(R.mipmap.head2);
        sharerOne.setAuthorNick("飞翔的企鹅");
        sharerOne.setAddOfArticle("齐鲁工业大学三食堂");
        sharerOne.setArticleTitle("红烧牛肉面");
        sharerOne.setArticleCover(R.mipmap.cover2);
        datas.add(sharer10);

        SharerBean sharer11 = new SharerBean();
        sharerOne.setAuthorHead(R.mipmap.head3);
        sharerOne.setAuthorNick("且听风吟");
        sharerOne.setAddOfArticle("齐鲁工业大学一食堂");
        sharerOne.setArticleTitle("挪威的森林");
        sharerOne.setArticleCover(R.mipmap.cover3);
        datas.add(sharer11);

        SharerBean sharer12 = new SharerBean();
        sharerOne.setAuthorHead(R.mipmap.head2);
        sharerOne.setAuthorNick("飞翔的企鹅");
        sharerOne.setAddOfArticle("齐鲁工业大学三食堂");
        sharerOne.setArticleTitle("红烧牛肉面");
        sharerOne.setArticleCover(R.mipmap.cover2);
        datas.add(sharer12);

        SharerBean sharer13 = new SharerBean();
        sharerOne.setAuthorHead(R.mipmap.head3);
        sharerOne.setAuthorNick("且听风吟");
        sharerOne.setAddOfArticle("齐鲁工业大学一食堂");
        sharerOne.setArticleTitle("挪威的森林");
        sharerOne.setArticleCover(R.mipmap.cover3);
        datas.add(sharer13);

        SharerBean sharer14 = new SharerBean();
        sharerOne.setAuthorHead(R.mipmap.head2);
        sharerOne.setAuthorNick("飞翔的企鹅");
        sharerOne.setAddOfArticle("齐鲁工业大学三食堂");
        sharerOne.setArticleTitle("红烧牛肉面");
        sharerOne.setArticleCover(R.mipmap.cover2);
        datas.add(sharer14);

        SharerBean sharer15 = new SharerBean();
        sharerOne.setAuthorHead(R.mipmap.head3);
        sharerOne.setAuthorNick("且听风吟");
        sharerOne.setAddOfArticle("齐鲁工业大学一食堂");
        sharerOne.setArticleTitle("挪威的森林");
        sharerOne.setArticleCover(R.mipmap.cover3);
        datas.add(sharer15);

        SharerBean sharer16 = new SharerBean();
        sharerOne.setAuthorHead(R.mipmap.head2);
        sharerOne.setAuthorNick("飞翔的企鹅");
        sharerOne.setAddOfArticle("齐鲁工业大学三食堂");
        sharerOne.setArticleTitle("红烧牛肉面");
        sharerOne.setArticleCover(R.mipmap.cover2);
        datas.add(sharer16);

        SharerBean sharer17 = new SharerBean();
        sharerOne.setAuthorHead(R.mipmap.head3);
        sharerOne.setAuthorNick("且听风吟");
        sharerOne.setAddOfArticle("齐鲁工业大学一食堂");
        sharerOne.setArticleTitle("挪威的森林");
        sharerOne.setArticleCover(R.mipmap.cover3);
        datas.add(sharer17);

        SharerBean sharer18 = new SharerBean();
        sharerOne.setAuthorHead(R.mipmap.head1);
        sharerOne.setAuthorNick("哆啦A梦");
        sharerOne.setAddOfArticle("齐鲁工业大学二食堂");
        sharerOne.setArticleTitle("山西刀削面");
        sharerOne.setArticleCover(R.mipmap.cover1);
        datas.add(sharer18);

        SharerBean sharer19 = new SharerBean();
        sharerOne.setAuthorHead(R.mipmap.head2);
        sharerOne.setAuthorNick("飞翔的企鹅");
        sharerOne.setAddOfArticle("齐鲁工业大学三食堂");
        sharerOne.setArticleTitle("红烧牛肉面");
        sharerOne.setArticleCover(R.mipmap.cover2);
        datas.add(sharer19);

//        SharerBean sharerFour = new SharerBean();
//        sharerOne.setAuthorHead(R.mipmap.head1);
//        sharerOne.setAuthorNick("Tom");
//        sharerOne.setAddOfArticle("Amarica");
//        sharerOne.setArticleTitle("<Title>");
//        sharerOne.setArticleCover(R.mipmap.ic_launcher);
//        datas.add(sharerFour);
    }

    @Override
    public void configViews() {
        rlv_share.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rlv_share.addItemDecoration(new SpaceItemDecoration(15));
        rlv_share.setAdapter(new CommonAdapter<SharerBean>(AppUtils.getAppContext()
                ,R.layout.item_share,datas) {
            @Override
            public void convert(ViewHolder holder, final SharerBean sharerBean) {
                holder.setText(R.id.tv_author_nick, sharerBean.getAuthorNick());
                holder.setText(R.id.tv_addOfArticle, sharerBean.getAddOfArticle());
                holder.setText(R.id.tv_articleTitle, sharerBean.getArticleTitle());
                GlideUtils.load((ImageView) holder.getView(R.id.civ_author_head)
                        ,sharerBean.getAuthorHead());
                GlideUtils.load((ImageView) holder.getView(R.id.iv_articleCover)
                        , sharerBean.getArticleCover());
            }
        });
    }
}
