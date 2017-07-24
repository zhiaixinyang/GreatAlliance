package com.greatalliance.ui.shop;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.greatalliance.ui.share.SpaceItemDecoration;
import com.greatalliance.utils.ScreenUtils;

/**
 * Created by 谷 聪聪 on 2017/7/23 0023.
 */

public class SpaceDecoration extends RecyclerView.ItemDecoration {

    private int space;
    public SpaceDecoration(int space){
        this.space = ScreenUtils.dp2px(space);
    }
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;
        if (parent.getChildAdapterPosition(view) == 0){
            outRect.top = space*2;
        }
    }
}
