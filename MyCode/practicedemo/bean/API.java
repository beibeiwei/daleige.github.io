package net.cyq.italker.practicedemo.bean;

/**
 * 常用API 常量等
 * Created by CYQ on 2017/8/26.
 */

public class API {
    /**
     * 凤凰新闻头条API
     * 在后面拼接请求第几页数据
     */
    public static final String fh_toutiao = "http://api.iclient.ifeng.com/ClientNews?id=SYLB10,SYDT10,SYRECOMMEND&page=";

    public static String getFh_toutiao() {
        return fh_toutiao;
    }
}
