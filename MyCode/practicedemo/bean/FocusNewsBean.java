package net.cyq.italker.practicedemo.bean;

import java.util.List;

/**
 * Created by CYQ on 2017/8/27.
 */

public class FocusNewsBean {
    /**
     * type : slide
     * thumbnail : http://p0.ifengimg.com/cmpp/2017/08/26/1258d2e955c9b051342e6b68821edb16_size565_w640_h360.jpg
     * online : 1
     * title : “最强飓风”登陆美国后
     * showType : 0
     * source : 视觉中国
     * subscribe : {"cateid":"视觉中国","type":"source","catename":"视觉中国","description":""}
     * updateTime : 2017/08/26 22:57:19
     * id : http://api.3g.ifeng.com/ipadtestdoc?aid=cmpp_030240051768807
     * documentId : cmpp_030240051768807
     * staticId : cmpp_030240051768807
     * style : {"backreason":["不感兴趣","不想看:视觉中国","内容质量差","看过了","不感兴趣"],"type":"slides","images":["http://d.ifengimg.com/w155_h107_q100/p3.ifengimg.com/cmpp/2017/08/26/22/bf40d614-2c8d-4bfb-bb03-c9718524fa46_size700_w1000_h667.jpg","http://d.ifengimg.com/w155_h107_q100/p0.ifengimg.com/cmpp/2017/08/26/22/c9236f3f-084f-4613-8c1a-e00362b0dd1f_size225_w1200_h900.jpg","http://d.ifengimg.com/w155_h107_q100/p3.ifengimg.com/cmpp/2017/08/26/22/2b7c592f-ebf5-4e10-9cbd-a5ffc355f31c_size704_w1033_h774.png"],"slideCount":20,"view":"slideimg"}
     * hasSlide : true
     * commentsUrl : http://news.ifeng.com/a/20170826/51768807_0.shtml
     * comments : 468
     * commentsall : 996
     * link : {"type":"slide","url":"http://api.3g.ifeng.com/ipadtestdoc?aid=cmpp_030240051768807","weburl":"http://m.ifeng.com/sharenews.f?ch=qd_sdk_dl1&aid=030240051768807"}
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
         * cateid : 视觉中国
         * type : source
         * catename : 视觉中国
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
         * backreason : ["不感兴趣","不想看:视觉中国","内容质量差","看过了","不感兴趣"]
         * type : slides
         * images : ["http://d.ifengimg.com/w155_h107_q100/p3.ifengimg.com/cmpp/2017/08/26/22/bf40d614-2c8d-4bfb-bb03-c9718524fa46_size700_w1000_h667.jpg","http://d.ifengimg.com/w155_h107_q100/p0.ifengimg.com/cmpp/2017/08/26/22/c9236f3f-084f-4613-8c1a-e00362b0dd1f_size225_w1200_h900.jpg","http://d.ifengimg.com/w155_h107_q100/p3.ifengimg.com/cmpp/2017/08/26/22/2b7c592f-ebf5-4e10-9cbd-a5ffc355f31c_size704_w1033_h774.png"]
         * slideCount : 20
         * view : slideimg
         */

        private String type;
        private int slideCount;
        private String view;
        private List<String> backreason;
        private List<String> images;

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
         * url : http://api.3g.ifeng.com/ipadtestdoc?aid=cmpp_030240051768807
         * weburl : http://m.ifeng.com/sharenews.f?ch=qd_sdk_dl1&aid=030240051768807
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
