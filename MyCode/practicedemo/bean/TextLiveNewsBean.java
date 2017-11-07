package net.cyq.italker.practicedemo.bean;

import java.util.List;

/**
 * Created by CYQ on 2017/8/27.
 */

public class TextLiveNewsBean {

    /**
     * type : text_live
     * thumbnail : http://p0.ifengimg.com/cmpp/2017/08/27/db4ffccb1a05e91a60ba8ad62e24aedd_size411_w640_h360.jpg
     * online : 0
     * title : 读家面对面：教您如何让每个孩子精彩
     * id : 109207
     * documentId : imcp_crc_20381861
     * staticId : piclive_109207
     * style : {"view":"titleimg","backreason":["不感兴趣","内容质量差","旧闻、重复","标题党"]}
     * styleType : live
     * liveExt : {"startStamp":"1503815400","endStamp":"1503822600","startTime":"2017-08-27 14:30:00","status":"2","hasVideo":true,"hasVr":false}
     * link : {"type":"text_live","url":"109207","weburl":"http://liveshare.iclient.ifeng.com/live_share?liveId=109207&vt=5"}
     * reftype : editor
     */

    private String type;
    private String thumbnail;
    private String online;
    private String title;
    private String id;
    private String documentId;
    private String staticId;
    private StyleBean style;
    private String styleType;
    private LiveExtBean liveExt;
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

    public String getStyleType() {
        return styleType;
    }

    public void setStyleType(String styleType) {
        this.styleType = styleType;
    }

    public LiveExtBean getLiveExt() {
        return liveExt;
    }

    public void setLiveExt(LiveExtBean liveExt) {
        this.liveExt = liveExt;
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

    public static class StyleBean {
        /**
         * view : titleimg
         * backreason : ["不感兴趣","内容质量差","旧闻、重复","标题党"]
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

    public static class LiveExtBean {
        /**
         * startStamp : 1503815400
         * endStamp : 1503822600
         * startTime : 2017-08-27 14:30:00
         * status : 2
         * hasVideo : true
         * hasVr : false
         */

        private String startStamp;
        private String endStamp;
        private String startTime;
        private String status;
        private boolean hasVideo;
        private boolean hasVr;

        public String getStartStamp() {
            return startStamp;
        }

        public void setStartStamp(String startStamp) {
            this.startStamp = startStamp;
        }

        public String getEndStamp() {
            return endStamp;
        }

        public void setEndStamp(String endStamp) {
            this.endStamp = endStamp;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public boolean isHasVideo() {
            return hasVideo;
        }

        public void setHasVideo(boolean hasVideo) {
            this.hasVideo = hasVideo;
        }

        public boolean isHasVr() {
            return hasVr;
        }

        public void setHasVr(boolean hasVr) {
            this.hasVr = hasVr;
        }
    }

    public static class LinkBean {
        /**
         * type : text_live
         * url : 109207
         * weburl : http://liveshare.iclient.ifeng.com/live_share?liveId=109207&vt=5
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
