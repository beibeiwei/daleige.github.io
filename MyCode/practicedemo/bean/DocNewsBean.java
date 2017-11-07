package net.cyq.italker.practicedemo.bean;

import java.util.List;

/**
 * doc类型新闻
 * Created by CYQ on 2017/8/26.
 */

public class DocNewsBean {
    /**
     * type : doc
     * thumbnail : http://d.ifengimg.com/w198_h141_q100/p2.ifengimg.com/cmpp/2017/08/27/a7e8fd99d921f0ad0142ce1fb37d84b3_size35_w168_h120.jpg
     * online : 1
     * title : 媒体质疑海底捞危机公关：只顾比烂，不分对错？
     * showType : 0
     * source : 新京报
     * subscribe : {"cateid":"新京报","type":"source","catename":"新京报","description":""}
     * updateTime : 2017/08/27 02:38:57
     * id : http://api.3g.ifeng.com/ipadtestdoc?aid=cmpp_030010051769802&channelKey=Y21wcF8xNzAwN183MTlfNzU=&channelid=SYLB10
     * documentId : cmpp_030010051769802
     * staticId : cmpp_030010051769802
     * style : {"backreason":["不感兴趣","不想看:新京报","内容质量差","看过了","不感兴趣"],"view":"titleimg"}
     * commentsUrl : http://news.ifeng.com/a/20170827/51769802_0.shtml
     * comments : 1048
     * commentsall : 3826
     * link : {"type":"doc","url":"http://api.3g.ifeng.com/ipadtestdoc?aid=cmpp_030010051769802&channelKey=Y21wcF8xNzAwN183MTlfNzU=&channelid=SYLB10","weburl":"http://m.ifeng.com/sharenews.f?ch=qd_sdk_dl1&aid=030010051769802"}
     * reftype : editor
     */
    private String type;
    private String thumbnail;
    private String online;
    private String title;
    private String showType;
    private String source;
    private SubscribeBean subscribe;
    private String updateTime;
    private String id;
    private String documentId;
    private String staticId;
    private StyleBean style;
    private String commentsUrl;
    private String comments;
    private String commentsall;
    private LinkBean link;
    private String reftype;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public SubscribeBean getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(SubscribeBean subscribe) {
        this.subscribe = subscribe;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getStaticId() {
        return staticId;
    }

    public void setStaticId(String staticId) {
        this.staticId = staticId;
    }

    public StyleBean getStyle() {
        return style;
    }

    public void setStyle(StyleBean style) {
        this.style = style;
    }

    public String getCommentsUrl() {
        return commentsUrl;
    }

    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCommentsall() {
        return commentsall;
    }

    public void setCommentsall(String commentsall) {
        this.commentsall = commentsall;
    }

    public LinkBean getLink() {
        return link;
    }

    public void setLink(LinkBean link) {
        this.link = link;
    }

    public String getReftype() {
        return reftype;
    }

    public void setReftype(String reftype) {
        this.reftype = reftype;
    }

    public static class SubscribeBean {
        /**
         * cateid : 新京报
         * type : source
         * catename : 新京报
         * description :
         */

        private String cateid;
        private String type;
        private String catename;
        private String description;

        public String getCateid() {
            return cateid;
        }

        public void setCateid(String cateid) {
            this.cateid = cateid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCatename() {
            return catename;
        }

        public void setCatename(String catename) {
            this.catename = catename;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public static class StyleBean {
        /**
         * backreason : ["不感兴趣","不想看:新京报","内容质量差","看过了","不感兴趣"]
         * view : titleimg
         */

        private String view;
        private List<String> backreason;

        public String getView() {
            return view;
        }

        public void setView(String view) {
            this.view = view;
        }

        public List<String> getBackreason() {
            return backreason;
        }

        public void setBackreason(List<String> backreason) {
            this.backreason = backreason;
        }
    }

    public static class LinkBean {
        /**
         * type : doc
         * url : http://api.3g.ifeng.com/ipadtestdoc?aid=cmpp_030010051769802&channelKey=Y21wcF8xNzAwN183MTlfNzU=&channelid=SYLB10
         * weburl : http://m.ifeng.com/sharenews.f?ch=qd_sdk_dl1&aid=030010051769802
         */

        private String type;
        private String url;
        private String weburl;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getWeburl() {
            return weburl;
        }

        public void setWeburl(String weburl) {
            this.weburl = weburl;
        }
    }
}
