package net.cyq.italker.practicedemo.bean;

import java.util.List;

/**
 * Created by CYQ on 2017/8/27.
 */

public class SlideNewsBean {

    /**
     * type : slide
     * thumbnail : http://d.ifengimg.com/w698_h392_q100/p3.ifengimg.com/cmpp/2017/08/27/7a281bafd0773174ee1fdd6cf9ab3ebb_size464_w640_h360.jpeg
     * online : 1
     * title : 印度多地进入紧急状态|组图
     * showType : 1
     * source : 新华图片
     * subscribe : {"cateid":"新华图片","type":"source","catename":"新华图片","description":""}
     * updateTime : 2017/08/27 09:06:17
     * id : http://api.3g.ifeng.com/ipadtestdoc?aid=cmpp_034470051771517
     * documentId : cmpp_034470051771517
     * staticId : cmpp_034470051771517
     * style : {"view":"bigimg","backreason":["不感兴趣","不想看:新华图片","内容质量差","旧闻、重复","标题党"],"type":"slides","images":["http://d.ifengimg.com/w155_h107_q100/p0.ifengimg.com/pmop/2017/0827/72660C5BE8CAF2EBFC8DB6A9274D4BAF5B00C304_size90_w899_h515.jpeg","http://d.ifengimg.com/w155_h107_q100/p0.ifengimg.com/pmop/2017/0827/2A5CEFB81EE9E08B8D464696B7883E3C9853299C_size80_w900_h566.jpeg","http://d.ifengimg.com/w155_h107_q100/p0.ifengimg.com/pmop/2017/0827/B5C6995569ADB95C972A1276C66BF7E5E3ABB6C7_size88_w900_h656.jpeg"],"slideCount":4}
     * hasSlide : true
     * commentsUrl : http://news.ifeng.com/a/20170827/51771517_0.shtml
     * comments : 0
     * commentsall : 0
     * link : {"type":"slide","url":"http://api.3g.ifeng.com/ipadtestdoc?aid=cmpp_034470051771517","weburl":"http://m.ifeng.com/sharenews.f?ch=qd_sdk_dl1&aid=034470051771517"}
     * reftype : editor
     */

    private String type;
    private String thumbnail;
    private String online;
    private String title;
    private int showType;
    private String source;
    private SubscribeBean subscribe;
    private String updateTime;
    private String id;
    private String documentId;
    private String staticId;
    private StyleBean style;
    private boolean hasSlide;
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

    public int getShowType() {
        return showType;
    }

    public void setShowType(int showType) {
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

    public boolean isHasSlide() {
        return hasSlide;
    }

    public void setHasSlide(boolean hasSlide) {
        this.hasSlide = hasSlide;
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
         * cateid : 新华图片
         * type : source
         * catename : 新华图片
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
         * view : bigimg
         * backreason : ["不感兴趣","不想看:新华图片","内容质量差","旧闻、重复","标题党"]
         * type : slides
         * images : ["http://d.ifengimg.com/w155_h107_q100/p0.ifengimg.com/pmop/2017/0827/72660C5BE8CAF2EBFC8DB6A9274D4BAF5B00C304_size90_w899_h515.jpeg","http://d.ifengimg.com/w155_h107_q100/p0.ifengimg.com/pmop/2017/0827/2A5CEFB81EE9E08B8D464696B7883E3C9853299C_size80_w900_h566.jpeg","http://d.ifengimg.com/w155_h107_q100/p0.ifengimg.com/pmop/2017/0827/B5C6995569ADB95C972A1276C66BF7E5E3ABB6C7_size88_w900_h656.jpeg"]
         * slideCount : 4
         */

        private String view;
        private String type;
        private int slideCount;
        private List<String> backreason;
        private List<String> images;

        public String getView() {
            return view;
        }

        public void setView(String view) {
            this.view = view;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getSlideCount() {
            return slideCount;
        }

        public void setSlideCount(int slideCount) {
            this.slideCount = slideCount;
        }

        public List<String> getBackreason() {
            return backreason;
        }

        public void setBackreason(List<String> backreason) {
            this.backreason = backreason;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class LinkBean {
        /**
         * type : slide
         * url : http://api.3g.ifeng.com/ipadtestdoc?aid=cmpp_034470051771517
         * weburl : http://m.ifeng.com/sharenews.f?ch=qd_sdk_dl1&aid=034470051771517
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
