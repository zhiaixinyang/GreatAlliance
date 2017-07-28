package com.greatalliance.ui.map;

import android.Manifest;
import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.ZoomControls;

import com.avos.avoscloud.AVGeoPoint;
import com.avos.avoscloud.AVUser;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.greatalliance.R;
import com.greatalliance.base.BaseFragment;
import com.greatalliance.model.leancloud.User;
import com.greatalliance.ui.my.MyProfileActivity;
import com.greatalliance.widget.CircleImageView;

import butterknife.BindView;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

/**
 * Created by MBENBEN on 2017/7/15.
 */
@RuntimePermissions
public class MapFragment extends BaseFragment {

    @BindView(R.id.mapView)
    MapView mapView;
    @BindView(R.id.civ_my_head_map)
    CircleImageView myHead;

    private BaiduMap baiduMap;
    //定位
    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();


    public static MapFragment newInstance() {

        Bundle args = new Bundle();

        MapFragment fragment = new MapFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.frag_map;
    }

    @Override
    public void initDatas() {
        baiduMap=mapView.getMap();
        // 隐藏logo
        hideLogo();
        //声明LocationClient类
        mLocationClient = new LocationClient(getApplicationContext());
        //注册监听函数
        mLocationClient.registerLocationListener( myListener );
        initLocation();

        mLocationClient.start();

    }

    private void hideLogo() {
        View child = mapView.getChildAt(1);
        if (child != null && (child instanceof ImageView || child instanceof ZoomControls)){
            child.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MapFragmentPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @Override
    public void configViews() {
        MapFragmentPermissionsDispatcher.initLocationWithCheck(this);
        // 开启定位图层
        baiduMap.setMyLocationEnabled(true);
        //定义Maker坐标点
        LatLng point = new LatLng(39.963175, 116.400244);
        //构建Marker图标
        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(R.drawable.icon_logo);
        //构建MarkerOption，用于在地图上添加Marker
        OverlayOptions option = new MarkerOptions()
                .position(point)
                .icon(bitmap);
        //在地图上添加Marker，并显示
        baiduMap.addOverlay(option);

        initEvent();
    }

    private void initEvent(){
        onHeadClick();
    }
    private void onHeadClick(){
        myHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(getContext(), MyProfileActivity.class);
                myHead.animate()
                        .translationX(300)
                        .setDuration(300)
                        .setListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {
                                startActivity(intent);
                                activity.overridePendingTransition(0, 0);
                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                myHead.setTranslationX(0);
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        }).start();
            }
        });
    }
    @NeedsPermission({Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION})
    public void initLocation(){
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        //可选，默认高精度，设置定位模式，高精度，低功耗，仅设备

        option.setCoorType("bd09ll");
        //可选，默认gcj02，设置返回的定位结果坐标系

        int span=1000;
        option.setScanSpan(span);
        //可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的

        option.setIsNeedAddress(true);
        //可选，设置是否需要地址信息，默认不需要

        option.setOpenGps(true);
        //可选，默认false,设置是否使用gps

        option.setLocationNotify(true);
        //可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果

        option.setIsNeedLocationDescribe(true);
        //可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”

        option.setIsNeedLocationPoiList(true);
        //可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到

        option.setIgnoreKillProcess(false);
        //可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死

        option.SetIgnoreCacheException(false);
        //可选，默认false，设置是否收集CRASH信息，默认收集

        option.setEnableSimulateGps(false);
        //可选，默认false，设置是否需要过滤GPS仿真结果，默认需要

        mLocationClient.setLocOption(option);
    }

    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            //获取定位结果
            //获取定位时间：location.getTime()
            //获取纬度信息：location.getLatitude()，获取经度信息：location.getLongitude()
            //获取定位精准度：location.getRadius()

            if (location.getLocType() == BDLocation.TypeGpsLocation){
                // GPS定位结果
                // 单位：公里每小时：location.getSpeed()
                //获取卫星数：location.getSatelliteNumber()
                //获取海拔高度信息，单位米：location.getAltitude()
                //获取方向信息，单位度：location.getDirection()
                //获取地址信息：location.getAddrStr()
            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation){
                User user= (User) AVUser.getCurrentUser(User.class);
                if (user!=null){
                    AVGeoPoint avGeoPoint=new AVGeoPoint(location.getLatitude(),location.getLongitude());
                    user.setLocation(avGeoPoint);
                    user.saveInBackground();
                }
                // 网络定位结果
                //获取地址信息：location.getAddrStr()
                //获取运营商信息：location.getOperators()
            } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {
                // 离线定位结果
            } else if (location.getLocType() == BDLocation.TypeServerError) {
                //服务端网络定位失败
            } else if (location.getLocType() == BDLocation.TypeNetWorkException) {
                //网络不同导致定位失败，请检查网络是否通畅
            } else if (location.getLocType() == BDLocation.TypeCriteriaException) {
                //无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机
            }
            //位置语义化信息:location.getLocationDescribe()
            // POI数据:location.getPoiList()
        }
        @Override
        public void onConnectHotSpotMessage(String s, int i) {
        }
    }

}
