package com.cyhz.test;

import com.cyhz.ip.geo.bean.IpGeo;
import com.cyhz.ip.geo.service.GetIpInfo;
import com.cyhz.ip.geo.service.imp.GetIpInfoFromBaiduImp;
import com.cyhz.ip.geo.service.imp.GetIpInfoFromSinaImp;
import com.cyhz.ip.geo.service.imp.GetIpInfoFromTaobaoImp;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/7/12.
 */
public class GetIpInfoTest {
    @Test
    public void test_taobao() {
        List<String> ips = new ArrayList<String>();
        ips.add("210.47.163.59");
        ips.add("210.47.163.50");

        try {
            GetIpInfo getIpInfo = new GetIpInfoFromTaobaoImp();
            List<IpGeo> ipGeos = getIpInfo.getIpInfo(ips);

            for (IpGeo ipGeo : ipGeos){
                System.out.println(ipGeo.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_sina() {
        List<String> ips = new ArrayList<String>();
        ips.add("210.47.163.59");
        ips.add("210.47.163.50");

        try {
            GetIpInfo getIpInfo = new GetIpInfoFromSinaImp();
            List<IpGeo> ipGeos = getIpInfo.getIpInfo(ips);

            for (IpGeo ipGeo : ipGeos){
                System.out.println(ipGeo.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_baidu() {
        List<String> ips = new ArrayList<String>();
        ips.add("210.47.163.59");
        ips.add("210.47.163.50");

        try {
            GetIpInfo getIpInfo = new GetIpInfoFromBaiduImp();
            List<IpGeo> ipGeos = getIpInfo.getIpInfo(ips);

            for (IpGeo ipGeo : ipGeos){
                System.out.println(ipGeo.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
