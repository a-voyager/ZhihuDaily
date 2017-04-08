package top.wuhaojie.zhd.entities;

import java.util.List;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/08 20:27
 * Version: 1.0
 */

public class LongCommentResponse {


    private List<CommentsBean> comments;

    public List<CommentsBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentsBean> comments) {
        this.comments = comments;
    }

    public static class CommentsBean {
        /**
         * author : 此间的少年
         * content : 2017年4月8日17点22分：
         * 简单地把女性分为女孩女人老太太这么三个阶段算不算对女性权利的剥夺？全文把女人是否性感作为判断美的唯一标准算不算一种庸俗？
         * <p>
         * 小编我没懂我这条评论到底哪里惹您不开心了，在本文评论连50都不到的情况下还要进行删除。不过没关系，删除了我再发就是。另，投诉已向贵司发出，请注意查收。
         * avatar : http://pic3.zhimg.com/93df1a881ce93dcbf95fc21277f7cbb6_im.jpg
         * time : 1491653233
         * id : 28648590
         * likes : 4
         * reply_to : {"content":"不知道答主是真的没有接触到，还是选择性忽视。对比的对象也都是国际著名的影星对比国内不出彩的普通演艺人员。咱们有 张艾嘉 杨千嬅 张曼玉 章子怡 闫妮 余男 蒋雯丽 陶虹 陈好 刘涛 林心如 赵薇 袁泉 巩俐 张静初 郝蕾 马伊琍\u2026\u2026 你只有说不认同的 哪能说没有？","status":0,"id":28647807,"author":"一不小心"}
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
             * content : 不知道答主是真的没有接触到，还是选择性忽视。对比的对象也都是国际著名的影星对比国内不出彩的普通演艺人员。咱们有 张艾嘉 杨千嬅 张曼玉 章子怡 闫妮 余男 蒋雯丽 陶虹 陈好 刘涛 林心如 赵薇 袁泉 巩俐 张静初 郝蕾 马伊琍…… 你只有说不认同的 哪能说没有？
             * status : 0
             * id : 28647807
             * author : 一不小心
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

            @Override
            public String toString() {
                return "ReplyToBean{" +
                        "content='" + content + '\'' +
                        ", status=" + status +
                        ", id=" + id +
                        ", author='" + author + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "CommentsBean{" +
                    "author='" + author + '\'' +
                    ", content='" + content + '\'' +
                    ", avatar='" + avatar + '\'' +
                    ", time=" + time +
                    ", id=" + id +
                    ", likes=" + likes +
                    ", reply_to=" + reply_to +
                    '}';
        }
    }


    @Override
    public String toString() {
        return "LongCommentResponse{" +
                "comments=" + comments +
                '}';
    }
}
