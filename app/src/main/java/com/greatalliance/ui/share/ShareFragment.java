package com.greatalliance.ui.share;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
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
        datas.add(new SharerBean(R.mipmap.cover1, "震惊！XX大学生竟然。。", R.mipmap.head1
                , "齐鲁工业大学", "野比大雄"));
        datas.add(new SharerBean(R.mipmap.cover2, "我靠！！一对情侣旁若无人竟然。。", R.mipmap.head2
                , "上冻中医药大学", "张三"));
        datas.add(new SharerBean(R.mipmap.cover3, "长见识了！这东西还有如此妙用！？", R.mipmap.head3
                , "山东交通学院", "李四"));
        datas.add(new SharerBean(R.mipmap.cover1, "震惊！XX大学生竟然。。", R.mipmap.head1
                , "上冻女子学院", "李逵"));
        datas.add(new SharerBean(R.mipmap.cover2, "我靠！！一对情侣旁若无人竟然。。", R.mipmap.head2
                , "上冻中医药大学", "张三"));
        datas.add(new SharerBean(R.mipmap.cover3, "长见识了！这东西还有如此妙用！？", R.mipmap.head3
                , "山东交通学院", "李四"));
        datas.add(new SharerBean(R.mipmap.cover1, "震惊！XX大学生竟然。。", R.mipmap.head1
                , "上冻女子学院", "李逵"));
        datas.add(new SharerBean(R.mipmap.cover2, "我靠！！一对情侣旁若无人竟然。。", R.mipmap.head2
                , "上冻中医药大学", "张三"));
        datas.add(new SharerBean(R.mipmap.cover3, "长见识了！这东西还有如此妙用！？", R.mipmap.head3
                , "山东交通学院", "李四"));
        datas.add(new SharerBean(R.mipmap.cover1, "震惊！XX大学生竟然。。", R.mipmap.head1
                , "上冻女子学院", "李逵"));
        datas.add(new SharerBean(R.mipmap.cover2, "我靠！！一对情侣旁若无人竟然。。", R.mipmap.head2
                , "上冻中医药大学", "张三"));
        datas.add(new SharerBean(R.mipmap.cover3, "长见识了！这东西还有如此妙用！？", R.mipmap.head3
                , "山东交通学院", "李四"));
        datas.add(new SharerBean(R.mipmap.cover1, "震惊！XX大学生竟然。。", R.mipmap.head1
                , "上冻女子学院", "李逵"));
        datas.add(new SharerBean(R.mipmap.cover2, "我靠！！一对情侣旁若无人竟然。。", R.mipmap.head2
                , "上冻中医药大学", "张三"));
        datas.add(new SharerBean(R.mipmap.cover3, "长见识了！这东西还有如此妙用！？", R.mipmap.head3
                , "山东交通学院", "李四"));
        datas.add(new SharerBean(R.mipmap.cover1, "震惊！XX大学生竟然。。", R.mipmap.head1
                , "上冻女子学院", "李逵"));
        datas.add(new SharerBean(R.mipmap.cover2, "我靠！！一对情侣旁若无人竟然。。", R.mipmap.head2
                , "上冻中医药大学", "张三"));
        datas.add(new SharerBean(R.mipmap.cover3, "长见识了！这东西还有如此妙用！？", R.mipmap.head3
                , "山东交通学院", "李四"));
        datas.add(new SharerBean(R.mipmap.cover1, "震惊！XX大学生竟然。。", R.mipmap.head1
                , "上冻女子学院", "李逵"));
    }

    @Override
    public void configViews() {
        rlv_share.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rlv_share.addItemDecoration(new SpaceItemDecoration(15));
        rlv_share.setAdapter(new CommonAdapter<SharerBean>(AppUtils.getAppContext()
                ,R.layout.item_share,datas) {
            @Override
            public void convert(final ViewHolder holder, final SharerBean sharerBean) {
                holder.setText(R.id.tv_author_nick, sharerBean.getAuthorNick());
                holder.setText(R.id.tv_addOfArticle, sharerBean.getAddOfArticle());
                holder.setText(R.id.tv_articleTitle, sharerBean.getArticleTitle());
                GlideUtils.load((ImageView) holder.getView(R.id.civ_author_head)
                        ,sharerBean.getAuthorHead());
                GlideUtils.load((ImageView) holder.getView(R.id.iv_articleCover)
                        , sharerBean.getArticleCover());
                holder.getView(R.id.tv_author_nick).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent  = new Intent(getContext(),ContentOfShareActivity.class);
                        Bundle data = new Bundle();
                        data.putString("articleTitle", sharerBean.getArticleTitle());
                        data.putInt("articleCover", sharerBean.getArticleCover());
                        intent.putExtras(data);
                        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(getSupportActivity(), holder.getView(R.id.iv_articleCover), "share_img").toBundle());
                    }
                });
            }
        });
    }
}
