package top.wuhaojie.zhd.entities;

import java.util.List;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/08 20:54
 * Version: 1.0
 */

public class ShortCommentResponse {


    private List<CommentsBean> comments;

    public List<CommentsBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentsBean> comments) {
        this.comments = comments;
    }

    public static class CommentsBean {
        /**
         * author : 欢乐杀手
         * content : 先问是不是，然后再讨论吧，很显然立题已经错了
         * avatar : http://pic2.zhimg.com/5a20902ff21a8ba8bca7f29159175ba1_im.jpg
         * time : 1491656056
         * id : 28648828
         * likes : 0
         * reply_to : {"content":"人家30多了，虽然天天发通稿说自己如何少女","status":0,"id":28648377,"author":"听疏大战第二人格"}
         */

        private String author;
        private String content;
        private String avatar;
        private int time;
        private int id;
        private int likes;
        private ReplyToBean reply_to;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        public ReplyToBean getReply_to() {
            return reply_to;
        }

        public void setReply_to(ReplyToBean reply_to) {
            this.reply_to = reply_to;
        }

        public static class ReplyToBean {
            /**
             * content : 人家30多了，虽然天天发通稿说自己如何少女
             * status : 0
             * id : 28648377
             * author : 听疏大战第二人格
             */

            private String content;
            private int status;
            private int id;
            private String author;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }
        }
    }
}
