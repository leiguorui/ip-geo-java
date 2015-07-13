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
 * 新浪接口
 *
 * Created by Administrator on 2015/7/12.
 */
public class GetIpInfoFromSinaImp implements GetIpInfo {
    public List<IpGeo> getIpInfo(List<String> ips) throws IOException {
        final WebClient webClient = new HtmlUnit().getFastWebClient();
        List<IpGeo> ipGeos = new ArrayList<IpGeo>();

        for (String ip : ips){
            final Page page = webClient.getPage(PropertiesRead.getInstance().getValue("ip.geo.host.sina")+ip);
            String response = page.getWebResponse().getContentAsString();

            JsonElement jelement = new JsonParser().parse(response);
            JsonObject jobject = jelement.getAsJsonObject();
            String city = jobject.get("city").getAsString();
            String country = jobject.get("country").getAsString();
            String province = jobject.get("province").getAsString();

            IpGeo ipGeo = new IpGeo();
            ipGeo.setRegion(province);
            ipGeo.setCity(city);
            ipGeo.setCountry(country);
            ipGeo.setIp(ip);

            ipGeos.add(ipGeo);
        }

        return ipGeos;
    }
}
