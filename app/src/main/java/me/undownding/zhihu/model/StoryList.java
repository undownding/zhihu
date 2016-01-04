package me.undownding.zhihu.model;

import java.util.List;

/**
 * Created by undow on 2016/1/4.
 */
public class StoryList {

    /**
     * date : 20160104
     * stories : [{"images":["http://pic4.zhimg.com/98db3c6954d8ecaf56f801b1313553db.jpg"],"type":0,"id":7696036,"ga_prefix":"010413","title":"《武林外传》十周年，再看白展堂的武功有多强"},{"images":["http://pic1.zhimg.com/6e5f99de10d036ffae19fa9c369a60a0.jpg"],"type":0,"id":7681869,"ga_prefix":"010412","title":"向学校的心理咨询室求助，你可能会有这些风险"},{"images":["http://pic1.zhimg.com/0b7602e72f60edc965605df495f00320.jpg"],"type":0,"id":7677958,"ga_prefix":"010411","title":"大家好，我是玫瑰，有颜值有才华也难搏出位啊"},{"images":["http://pic4.zhimg.com/aed9821a2eda73829465db098c1d929f.jpg"],"type":0,"id":7693863,"ga_prefix":"010410","title":"懂语法会单词是一回事，能写英语文章是另一回事"},{"images":["http://pic1.zhimg.com/b99961ceb90a537a9eabe9cbda3e05d8.jpg"],"type":0,"id":7689789,"ga_prefix":"010409","title":"女科学家为什么凭空消失了那么多？"},{"images":["http://pic3.zhimg.com/61b1bf0ec2498b6947859d1fea66f176.jpg"],"type":0,"id":7691868,"ga_prefix":"010408","title":"这将是一次史诗级的事件，北极温度超过了零度"},{"images":["http://pic1.zhimg.com/d5882c9c2e2ead28f5f72bb8fcebc7c0.jpg"],"type":0,"id":7692961,"ga_prefix":"010407","title":"去药店买感冒药需要身份证，这是为什么？"},{"images":["http://pic2.zhimg.com/91aae8af2c96cbdb382ce4ec4d663c69.jpg"],"type":0,"id":7660161,"ga_prefix":"010407","title":"浓重的雾霾为什么可以一夜之间消失不见？"},{"title":"李宇春跨年唱了首普通的魔性歌，叫《普通 DISCO》","theme":{"id":12,"subscribed":false,"name":"用户推荐日报"},"ga_prefix":"010407","images":["http://pic4.zhimg.com/0e7f6c7e2b955779a82c95fa6d7bf13f.jpg"],"type":0,"id":4647028},{"images":["http://pic1.zhimg.com/c69e3e7629f69f602f714d501ab066c0.jpg"],"type":0,"id":7676915,"ga_prefix":"010406","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic3.zhimg.com/5ae400670b5a9e4f75f4179a3fc139da.jpg","type":0,"id":7696036,"ga_prefix":"010413","title":"《武林外传》十周年，再看白展堂的武功有多强"},{"image":"http://pic1.zhimg.com/7cb16a836516058842d4d8020f99c9ec.jpg","type":0,"id":7692961,"ga_prefix":"010407","title":"去药店买感冒药需要身份证，这是为什么？"},{"image":"http://pic1.zhimg.com/314025a193c1d9a93d89c7abd1ef6e30.jpg","type":0,"id":7691868,"ga_prefix":"010408","title":"这将是一次史诗级的事件，北极温度超过了零度"},{"image":"http://pic1.zhimg.com/c2e5ec5e5017e5faca0be7a75c404088.jpg","type":0,"id":4647028,"ga_prefix":"010407","title":"李宇春跨年唱了首普通的魔性歌，叫《普通 DISCO》"},{"image":"http://pic4.zhimg.com/4d17c92d342c320582648e7967d812fb.jpg","type":0,"id":7689789,"ga_prefix":"010409","title":"女科学家为什么凭空消失了那么多？"}]
     */

    private String date;
    /**
     * images : ["http://pic4.zhimg.com/98db3c6954d8ecaf56f801b1313553db.jpg"]
     * type : 0
     * id : 7696036
     * ga_prefix : 010413
     * title : 《武林外传》十周年，再看白展堂的武功有多强
     */

    private List<Story> stories;
    /**
     * image : http://pic3.zhimg.com/5ae400670b5a9e4f75f4179a3fc139da.jpg
     * type : 0
     * id : 7696036
     * ga_prefix : 010413
     * title : 《武林外传》十周年，再看白展堂的武功有多强
     */

    private List<TopStories> top_stories;

    public void setDate(String date) {
        this.date = date;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public void setTop_stories(List<TopStories> top_stories) {
        this.top_stories = top_stories;
    }

    public String getDate() {
        return date;
    }

    public List<Story> getStories() {
        return stories;
    }

    public List<TopStories> getTop_stories() {
        return top_stories;
    }

    public static class Story {
        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public void setType(int type) {
            this.type = type;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public int getType() {
            return type;
        }

        public int getId() {
            return id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public List<String> getImages() {
            return images;
        }

    }

    public static class TopStories {
        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public void setImage(String image) {
            this.image = image;
        }

        public void setType(int type) {
            this.type = type;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public int getType() {
            return type;
        }

        public int getId() {
            return id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public String getTitle() {
            return title;
        }
    }
}
