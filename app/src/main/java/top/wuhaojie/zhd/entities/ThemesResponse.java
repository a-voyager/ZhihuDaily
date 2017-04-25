package top.wuhaojie.zhd.entities;

import java.util.List;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/25 22:08
 * Version: 1.0
 */

public class ThemesResponse {


    /**
     * stories : [{"type":0,"id":7483486,"title":"更多大公司内容，都在读读日报里"},{"images":["http://pic1.zhimg.com/f443be839f18d4ab28b20c97277c75c0_t.jpg"],"type":2,"id":7259912,"title":"没想象中那么\u201c有钱\u201d 苹果超过80%的现金流都在海外"},{"images":["http://pic2.zhimg.com/d678d1df1d4d84ea58e7e8a24ef7a149_t.jpg"],"type":2,"id":7258996,"title":"商周独家专访大众点评CEO张涛：\u201c权力的游戏很残酷\u201d"},{"images":["http://pic2.zhimg.com/61937a0b9c9096cb820e8000c399a299_t.jpg"],"type":2,"id":7258483,"title":"中国充电桩政策出台 你会因此买辆电动车吗？"},{"images":["http://pic3.zhimg.com/aeedf1e5bd08965e406deb1ae001a1a2_t.jpg"],"type":2,"id":7254472,"title":"Adobe 的黑科技，自动抹掉照片中的路人甲"},{"images":["http://pic4.zhimg.com/474641e26ae3f85c339e78362f5bbe03_t.jpg"],"type":2,"id":7254161,"title":"中兴华为供应商跑路 3800名工人维权"},{"images":["http://pic3.zhimg.com/20f6dc64236c1e5f6ae366c251bbb396_t.jpg"],"type":2,"id":7252116,"title":"马云和马化腾化敌为友了吗？"},{"images":["http://pic1.zhimg.com/9d5ce1912394936543d4cdf8aba7cbd8_t.jpg"],"type":2,"id":7252107,"title":"电子医疗系统实现\u201c自我护理\u201d"},{"images":["http://pic1.zhimg.com/f0d4d6bd418ba154a22665627f56acec_t.jpg"],"type":2,"id":7251992,"title":"滴滴CEO程维：私家车可以做专车 但不能和出租车抢生意"},{"images":["http://pic1.zhimg.com/7a12a613236d195c9aadca2907e6622c_t.jpg"],"type":2,"id":7248119,"title":"《琅琊榜》出品公司估值一年翻倍 13亿身家的柯氏兄弟谋求单独上市"},{"images":["http://pic2.zhimg.com/e52e7fe79df550351f463c33ed7e1d31_t.jpg"],"type":2,"id":7246384,"title":"独家：美团点评合并，估值150亿美元，中国互联网第五极诞生？"},{"images":["http://pic3.zhimg.com/1c995d5ac343418cddda6814f06f66ce_t.jpg"],"type":2,"id":7245852,"title":"大众点评与美团合并 中国最大O2O服务企业将诞生"},{"images":["http://pic2.zhimg.com/6d9ebf007eb46141ece24e0f5bbf178d_t.jpg"],"type":2,"id":7216340,"title":"今天，Google 正式成为 Alphabet（大赌投资）的子公司"},{"images":["http://pic2.zhimg.com/c583936f1db753c83e3d9d012a352825_t.jpg"],"type":2,"id":7207596,"title":"4 年战争带来了什么？我们通过夜里的灯光来看叙利亚和冲突各方 | 难民危机是怎么回事 二"},{"images":["http://pic2.zhimg.com/51e7f78ddf0a00e900704169d8cf3299_t.jpg"],"type":2,"id":7197477,"title":"苹果一口气在中国内地推出Apple Music、iTunes电影、iBooks三项服务"},{"images":["http://pic3.zhimg.com/ad89bddae5cef2e1e8cef19d820a2ea2_t.jpg"],"type":2,"id":7196157,"title":"Evernote宣布全球裁员13% 关闭台湾等三地办公室"},{"images":["http://pic1.zhimg.com/418dc54bacb648126a9da15ef23a7ae0_t.jpg"],"type":2,"id":7195467,"title":"停车应用野心勃勃抢占停车场"},{"images":["http://pic3.zhimg.com/b24cf54ad2ee2f80956e3fbab6deca42_t.jpg"],"type":2,"id":7185961,"title":"新《广告法》满月 侯耀华、郑多燕等明星广告涉嫌违法"},{"images":["http://pic4.zhimg.com/fe04aa410e4c3fe36d3f6e91df56564b_t.jpg"],"type":2,"id":7185066,"title":"独家专访柳井正：优衣库的国际化才完成了20%"},{"images":["http://pic2.zhimg.com/376f310728234218ae5e5749ba0de829_t.jpg"],"type":2,"id":7177021,"title":"Uber中国开放平台 它想像支付宝一样无处不在"}]
     * description : 商业世界变化越来越快，就是这些家伙干的
     * background : http://p1.zhimg.com/46/cb/46cb63bdd2bbcb8e5e4c70719c566c69.jpg
     * color : 1615359
     * name : 大公司日报
     * image : http://p2.zhimg.com/5b/68/5b68d586f273e1408fac1f231d61eb82.jpg
     * editors : [{"url":"http://www.zhihu.com/people/ding-wei","bio":"商业周刊中文版新媒体主编","id":87,"avatar":"http://pic4.zhimg.com/40f7ca4a683566acbe16a30a4992a943_m.jpg","name":"丁伟"},{"url":"http://www.zhihu.com/people/davidchang","bio":"科技媒体从业者","id":26,"avatar":"http://pic3.zhimg.com/f41fcd781_m.jpg","name":"David Chang"},{"url":"http://www.zhihu.com/people/raymond-wang","bio":"律所合伙人，关注公司发展","id":55,"avatar":"http://pic3.zhimg.com/7e626246b_m.jpg","name":"Raymond Wang"}]
     * image_source :
     */

    private String description;
    private String background;
    private int color;
    private String name;
    private String image;
    private String image_source;
    private List<StoriesBean> stories;
    private List<EditorsBean> editors;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage_source() {
        return image_source;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<EditorsBean> getEditors() {
        return editors;
    }

    public void setEditors(List<EditorsBean> editors) {
        this.editors = editors;
    }

    public static class StoriesBean {
        /**
         * type : 0
         * id : 7483486
         * title : 更多大公司内容，都在读读日报里
         * images : ["http://pic1.zhimg.com/f443be839f18d4ab28b20c97277c75c0_t.jpg"]
         */

        private int type;
        private int id;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class EditorsBean {
        /**
         * url : http://www.zhihu.com/people/ding-wei
         * bio : 商业周刊中文版新媒体主编
         * id : 87
         * avatar : http://pic4.zhimg.com/40f7ca4a683566acbe16a30a4992a943_m.jpg
         * name : 丁伟
         */

        private String url;
        private String bio;
        private int id;
        private String avatar;
        private String name;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
