package com.greatalliance.ui.share;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.greatalliance.R;
import com.greatalliance.base.BaseFragment;
import com.greatalliance.base.CommonAdapter;
import com.greatalliance.base.OnItemClickListener;
import com.greatalliance.base.ViewHolder;
import com.greatalliance.model.bean.SharerBean;
import com.greatalliance.utils.AppUtils;
import com.greatalliance.utils.GlideUtils;
import com.greatalliance.utils.ToastUtils;
import com.greatalliance.widget.ScaleImageView;

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
        datas.add(new SharerBean(R.mipmap.ic_launcher, "震惊！XX大学生竟然。。", R.mipmap.head3
                , "齐鲁工业大学", "野比大雄"));
        datas.add(new SharerBean(R.mipmap.cover2, "我靠！！一对情侣旁若无人竟然。。", R.mipmap.head2
                , "上冻中医药大学", "张三"));
        datas.add(new SharerBean(R.mipmap.cover3, "长见识了！这东西还有如此妙用！？", R.mipmap.head3
                , "山东交通学院", "李四"));
        datas.add(new SharerBean(R.mipmap.cover1, "震惊！XX大学生竟然。。", R.mipmap.head1
                , "上冻女子学院", "李逵"));
        datas.add(new SharerBean(R.mipmap.head1, "我靠！！一对情侣旁若无人竟然。。", R.mipmap.head2
                , "上冻中医药大学", "张三"));
        datas.add(new SharerBean(R.mipmap.cover3, "长见识了！这东西还有如此妙用！？", R.mipmap.head3
                , "山东交通学院", "李四"));
        datas.add(new SharerBean(R.mipmap.cover1, "震惊！XX大学生竟然。。", R.mipmap.head1
                , "上冻女子学院", "李逵"));
        datas.add(new SharerBean(R.mipmap.cover2, "我靠！！一对情侣旁若无人竟然。。", R.mipmap.head2
                , "上冻中医药大学", "张三"));
        datas.add(new SharerBean(R.mipmap.ic_launcher, "长见识了！这东西还有如此妙用！？", R.mipmap.head3
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
        datas.add(new SharerBean(R.mipmap.ic_launcher, "长见识了！这东西还有如此妙用！？", R.mipmap.head3
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
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2
                , StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);

        rlv_share.setLayoutManager(layoutManager);
        //rlv_share.addItemDecoration(new SpaceItemDecoration(15));
        rlv_share.setHasFixedSize(true);
        rlv_share.setAdapter(new CommonAdapter<SharerBean>(AppUtils.getAppContext()
                ,R.layout.item_share,datas) {
            @Override
            public void convert(final ViewHolder holder, final SharerBean sharerBean) {
//                final CardView cardView = holder.getView(R.id.card_item_share);
//                final TextView title = holder.getView(R.id.tv_articleTitle);
//                final TextView address = holder.getView(R.id.tv_addOfArticle);

                holder.setText(R.id.tv_author_nick, sharerBean.getAuthorNick());
                holder.setText(R.id.tv_addOfArticle, sharerBean.getAddOfArticle());
                holder.setText(R.id.tv_articleTitle, sharerBean.getArticleTitle());

                  GlideUtils.load((ImageView) holder.getView(R.id.civ_author_head)
                          ,sharerBean.getAuthorHead());
                  Bitmap bitmap = BitmapFactory.decodeResource(getResources()
                        ,sharerBean.getArticleCover());
                ScaleImageView imageView = holder.getView(R.id.iv_articleCover);
                imageView.initSize(bitmap.getWidth(),bitmap.getHeight());


                setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(ViewGroup parent, View view, Object o, int position) {
                        Intent intent  = new Intent(getContext(),ContentOfShareActivity.class);
                        Bundle data = new Bundle();
                        data.putString("articleTitle", datas.get(position).getArticleTitle());
                        data.putInt("articleCover", datas.get(position).getArticleCover());
                        intent.putExtras(data);
                        int[] startingLocation = new int[2];
                        view.getLocationOnScreen(startingLocation);
                        intent.putExtra("drawStartingLocationY", startingLocation[1]);
                        intent.putExtra("drawStartingLocationX", startingLocation[0]);

                        startActivity(intent);
                        activity.overridePendingTransition(0,0);
                    }

                    @Override
                    public boolean onItemLongClick(ViewGroup parent, View view, Object o, int position) {
                        datas.remove(position);
                        notifyItemRemoved(position);
                        ToastUtils.showMyToast("item被移除",Toast.LENGTH_SHORT);
                        return true;
                    }
                });
            }
        });
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ToastUtils.showMyToast("OnViewCreated", Toast.LENGTH_SHORT);
    }
}
