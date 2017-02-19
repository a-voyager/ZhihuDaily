package top.wuhaojie.zhd.entities;

import java.util.List;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/02/19 13:26
 * Version: 1.0
 */

public class BeforeMessageResponse {


    /**
     * date : 20170217
     * stories : [{"images":["http://pic2.zhimg.com/f6ee81d691b5878cc0b793e8c4f291dd.jpg"],"type":0,"id":9227204,"ga_prefix":"021722","title":"小事 · 得了一种奇怪的病"},{"images":["http://pic4.zhimg.com/e2dd3f67471a150dcc94d1fd645acb5b.jpg"],"type":0,"id":9216382,"ga_prefix":"021721","title":"在不再需要奇迹的地方，描绘名为「勇气」的奇迹"},{"images":["http://pic1.zhimg.com/2b18b6f0b7701ef1472eb8bcca06e844.jpg"],"type":0,"id":9222753,"ga_prefix":"021720","title":"有的人，光是活着就已经竭尽全力了"},{"images":["http://pic1.zhimg.com/8659d3b6799ac206585a3a415ff01e60.jpg"],"type":0,"id":9229903,"ga_prefix":"021719","title":"为什么在航班起飞前 45 分钟就要办理登机？"},{"images":["http://pic1.zhimg.com/f3442d046fb1e4d6ff7df82d621173cc.jpg"],"type":0,"id":9229971,"ga_prefix":"021718","title":"您好，我是美国国税局，别逃了，你逃不掉的"},{"images":["http://pic3.zhimg.com/4b67cd1b5e62ad8671bae6c3d8c55122.jpg"],"type":0,"id":9229917,"ga_prefix":"021717","title":"从 130nm 到 7nm，晶体管制造的技术是如何发展的？"},{"images":["http://pic2.zhimg.com/4a35928c7c400d086bbbd9c8fe6f74d5.jpg"],"type":0,"id":9229883,"ga_prefix":"021716","title":"中国特色苹果「助手」正沾着苹果的光偷偷收「过路费」"},{"images":["http://pic2.zhimg.com/cb347835e7c25588524854178544fbb9.jpg"],"type":0,"id":9195350,"ga_prefix":"021715","title":"爱情也有保质期，你们的关系进入倦怠期了吗？"},{"images":["http://pic2.zhimg.com/2e82cc6a9454d7c00dd72d5baa02c991.jpg"],"type":0,"id":9229819,"ga_prefix":"021715","title":"身为化妆品研发，告诉你高档产品与平价产品的差别在哪里"},{"images":["http://pic4.zhimg.com/a9a1d6382a7523faeab57caa88e4adb7.jpg"],"type":0,"id":9229286,"ga_prefix":"021713","title":"杨永信的「电疗法」和临床电刺激有什么区别？"},{"images":["http://pic2.zhimg.com/00d6ad3c7a150cba665981dd605612c1.jpg"],"type":0,"id":9229153,"ga_prefix":"021712","title":"大误 · 粉红色的回忆"},{"images":["http://pic2.zhimg.com/285e3712dbc4b82d0e3204a8c7d92331.jpg"],"type":0,"id":9229241,"ga_prefix":"021711","title":"看过这两张图，就明白电脑里的「缓存」是什么意思"},{"title":"地图上的各种等高线，是怎么画出来的？","ga_prefix":"021710","images":["http://pic4.zhimg.com/d33c5f909bdaa89a7ee7ddef1269d58b.jpg"],"multipic":true,"type":0,"id":9228981},{"images":["http://pic2.zhimg.com/44dfd68dead91180bea733ede5b03a59.jpg"],"type":0,"id":9222067,"ga_prefix":"021709","title":"你能分清汉堡和三明治吗？想一下再回答"},{"title":"跑车的声浪，可远不止换个排气管，拆掉消声器那么简单","ga_prefix":"021708","images":["http://pic1.zhimg.com/2d1e8bfffc13cbf09c965f7f2960569c.jpg"],"multipic":true,"type":0,"id":9227351},{"images":["http://pic3.zhimg.com/78021164c388c73a81d9a2165b04adaa.jpg"],"type":0,"id":9228136,"ga_prefix":"021707","title":"年轻白领挣得不如蓝领多，因为还没拿到「职位工资」"},{"images":["http://pic1.zhimg.com/942ff2a7eccedd4fa9bae14bb06bae18.jpg"],"type":0,"id":9228345,"ga_prefix":"021707","title":"为何没多少人买，星巴克还在卖依云？"},{"images":["http://pic4.zhimg.com/89a3a8062235b2e9e528ab7e5589b6e3.jpg"],"type":0,"id":9221954,"ga_prefix":"021706","title":"瞎扯 · 如何正确地吐槽"}]
     */

    private String date;
    private List<StoriesBean> stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public static class StoriesBean {
        /**
         * images : ["http://pic2.zhimg.com/f6ee81d691b5878cc0b793e8c4f291dd.jpg"]
         * type : 0
         * id : 9227204
         * ga_prefix : 021722
         * title : 小事 · 得了一种奇怪的病
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
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

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isUltipic() {
            return multipic;
        }

        public void setUltipic(boolean ultipic) {
            multipic = ultipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
