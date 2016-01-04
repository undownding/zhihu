package me.undownding.zhihu.model;

import java.util.List;

/**
 * Created by undow on 2016/1/4.
 */
public class LongComments {
    /**
     * author : 思霖Candy
     * content : 估计是我喜欢清淡吧，舌头很敏感，一直觉得飞机餐挺好吃的。感觉到的问题，一个是味道不纯粹，可能饭菜一起加热的缘故，然后味觉下降应该是感觉的到的，以前不知道，还以为是环境影响的～

     最后，如果在南航厦航海航上看到一个问空姐要第二份的蓝荒人，还吃的一点不剩，很可能是我～
     * avatar : http://pic1.zhimg.com/4624d6db4_im.jpg
     * time : 1413721757
     * id : 549001
     * likes : 1
     */

    private List<Comment> comments;

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public static class Comment {
        private String author;
        private String content;
        private String avatar;
        private int time;
        private int id;
        private int likes;

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        public String getAuthor() {
            return author;
        }

        public String getContent() {
            return content;
        }

        public String getAvatar() {
            return avatar;
        }

        public int getTime() {
            return time;
        }

        public int getId() {
            return id;
        }

        public int getLikes() {
            return likes;
        }
    }
}
