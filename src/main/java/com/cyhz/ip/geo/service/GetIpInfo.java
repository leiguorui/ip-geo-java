package com.cyhz.ip.geo.service;

import com.cyhz.ip.geo.bean.IpGeo;

import java.io.IOException;
import java.util.List;

/**
 * ip地址接口
 *
 * Created by Administrator on 2015/7/12.
 */
public interface GetIpInfo {
    List<IpGeo> getIpInfo(List<String> ips) throws IOException;
}
