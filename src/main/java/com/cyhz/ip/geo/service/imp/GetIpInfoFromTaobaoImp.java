package com.cyhz.ip.geo.service.imp;

import com.cyhz.ip.geo.bean.IpGeo;
import com.cyhz.ip.geo.service.GetIpInfo;
import com.cyhz.ip.geo.utils.HtmlUnit;
import com.cyhz.ip.geo.utils.PropertiesRead;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取ip地址信息，淘宝接口
 *
 * Created by Administrator on 2015/7/12.
 */
public class GetIpInfoFromTaobaoImp implements GetIpInfo{

    public List<IpGeo> getIpInfo(List<String> ips) throws IOException {
        final WebClient webClient = new HtmlUnit().getFastWebClient();
        List<IpGeo> ipGeos = new ArrayList<IpGeo>();

        for (String ip : ips){
            final Page page = webClient.getPage(PropertiesRead.getInstance().getValue("ip.geo.host.taobao")+ip);
            String response = page.getWebResponse().getContentAsString();

            JsonElement jelement = new JsonParser().parse(response);
            JsonObject jobject = jelement.getAsJsonObject();
            jobject = jobject.getAsJsonObject("data");

            IpGeo ipGeo = new Gson().fromJson(jobject, IpGeo.class);

            ipGeos.add(ipGeo);
        }

        return ipGeos;
    }

}
