package com.example.administrator.nonyezhichuang.util;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Administrator on 2017/8/24.
 */

public class LocationUtil {


    private static LocationManager locationManage;
    private static String gpsProvider;

    /**
     * 获取定位方式
     * @param context
     */

    public static String getProvider(Context context) {

        locationManage = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        List<String> providers = locationManage.getProviders(true);
        if (providers.contains(LocationManager.GPS_PROVIDER)) {
            gpsProvider = LocationManager.GPS_PROVIDER;
            return gpsProvider;
        } else if (providers.contains(LocationManager.NETWORK_PROVIDER)) {
            gpsProvider = LocationManager.NETWORK_PROVIDER;
            return gpsProvider;
        } else {
            Toast.makeText(context, "无法获取定位", Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    /**
     * 获取位置
     */

    public static String getLocation(Context context) {
        LocationManager lmanage = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        String provider = getProvider(context);

        if (ActivityCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return null;
        }
        Location lastKnownLocation = lmanage.getLastKnownLocation(provider);

        if (lastKnownLocation != null) {

            String location = "维度：" + lastKnownLocation.getLatitude() + ",经度" + lastKnownLocation.getLongitude();
            return location;
        }

        return null;
    }
    /**
     * 获取经度信息
     * @param context
     * @return
     */
    public static double getLongitude(Context context) {
        LocationManager lmanage = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        String provider = getProvider(context);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return 0;
        }
        Location lastKnownLocation = lmanage.getLastKnownLocation(provider);

        double latitude = lastKnownLocation.getLongitude();
        return latitude;
    }

    /**
     * 获取维度信息
     * @param context
     * @return
     */
    public static double getLatitude(Context context) {
        LocationManager lmanage = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        String provider = getProvider(context);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return 0;
        }
        Location lastKnownLocation = lmanage.getLastKnownLocation(provider);

        double latitude = lastKnownLocation.getLatitude();
        return latitude;
    }





    /**
     * 监听位置变化信息
     */
    public static LocationListener LocationListener(final Context context) {

        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                getLocation(context);
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };
        return locationListener;

    }

    /**
     * 移除监听
     */

    public void destoryListener(Context context) {
        LocationListener locationListener = LocationListener(context);

        if (locationManage != null) {
            if (ActivityCompat.checkSelfPermission(context,
                    Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManage.removeUpdates(locationListener);
        }
    }

















































}
