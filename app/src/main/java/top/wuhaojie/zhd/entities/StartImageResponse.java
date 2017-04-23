package top.wuhaojie.zhd.entities;

import java.util.List;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/23 16:49
 * Version: 1.0
 */

public class StartImageResponse {


    private List<CreativesBean> creatives;

    public List<CreativesBean> getCreatives() {
        return creatives;
    }

    public void setCreatives(List<CreativesBean> creatives) {
        this.creatives = creatives;
    }

    public static class CreativesBean {
        /**
         * url : https://pic4.zhimg.com/v2-d0837fd8e39d98b2d58d1911e4fbd913.jpg
         * start_time : 1492934694
         * impression_tracks : ["https://sugar.zhihu.com/track?vs=1&ai=3956&ut=&cg=2&ts=1492934694.58&si=3e7f7faeb9454f2e902e839445333940&lu=0&hn=ad-engine.ad-engine.0a163143&at=impression&pf=PC&az=11&sg=882bf51fb340d9088e0a888f3060f61e"]
         * type : 0
         * id : 3956
         */

        private String url;
        private long start_time;
        private int type;
        private String id;
        private List<String> impression_tracks;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public long getStart_time() {
            return start_time;
        }

        public void setStart_time(long start_time) {
            this.start_time = start_time;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getImpression_tracks() {
            return impression_tracks;
        }

        public void setImpression_tracks(List<String> impression_tracks) {
            this.impression_tracks = impression_tracks;
        }
    }
}
