package com.greatalliance.base;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by MBENBEN on 2017/7/9.
 */

public interface OnItemClickListener<T> {
    void onItemClick(ViewGroup parent, View view, T t, int position);
    boolean onItemLongClick(ViewGroup parent, View view, T t, int position);
}
