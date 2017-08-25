package com.example.administrator.nonyezhichuang.bean;

import java.util.List;

/**
 * 商品详情对象
 * Created by Administrator on 2017/8/25.
 */

public class ShangpinXiangQingBean {

    /**
     * data : {"goods_id":12253,"goods_name":"小葱","store_id":217,"goods_cover":"http://oqv8tlktu.bkt.clouddn.com/87db306eaf55ab2ad2680ff50c038edf.jpg","goods_subtitle":"小葱别名：香葱、绵葱、火葱、四季葱、细米葱。葱属百合科，是多年生草本植物葱的茎与叶，上部为青色葱叶，下部为白色葱白。","goods_images":["http://oqv8tlktu.bkt.clouddn.com/87db306eaf55ab2ad2680ff50c038edf.jpg"],"evaluation_count":2,"is_favorites":2,"store":{"store_phone":"0579-89970906"},"cart_num":0,"cart_price":0,"spec":[{"spec_id":10096,"price":"4.00","spec_promo_price":"0.00","ratio":"/斤/500g","cart_goods_num":0}],"comment":{"comment_content":"很方便，希望你们越做越好，越做越大\n","comment_addtime":"2017-08-14","avatar":"http://oqv8tlktu.bkt.clouddn.com/avatar.jpg","user_nicename":"兰州拉面"}}
     * msg :
     * code : 200
     */

    private DataBean data;
    private String msg;
    private int code;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class DataBean {
        /**
         * goods_id : 12253
         * goods_name : 小葱
         * store_id : 217
         * goods_cover : http://oqv8tlktu.bkt.clouddn.com/87db306eaf55ab2ad2680ff50c038edf.jpg
         * goods_subtitle : 小葱别名：香葱、绵葱、火葱、四季葱、细米葱。葱属百合科，是多年生草本植物葱的茎与叶，上部为青色葱叶，下部为白色葱白。
         * goods_images : ["http://oqv8tlktu.bkt.clouddn.com/87db306eaf55ab2ad2680ff50c038edf.jpg"]
         * evaluation_count : 2
         * is_favorites : 2
         * store : {"store_phone":"0579-89970906"}
         * cart_num : 0
         * cart_price : 0
         * spec : [{"spec_id":10096,"price":"4.00","spec_promo_price":"0.00","ratio":"/斤/500g","cart_goods_num":0}]
         * comment : {"comment_content":"很方便，希望你们越做越好，越做越大\n","comment_addtime":"2017-08-14","avatar":"http://oqv8tlktu.bkt.clouddn.com/avatar.jpg","user_nicename":"兰州拉面"}
         */

        private int goods_id;
        private String goods_name;
        private int store_id;
        private String goods_cover;
        private String goods_subtitle;
        private int evaluation_count;
        private int is_favorites;
        private StoreBean store;
        private int cart_num;
        private int cart_price;
        private CommentBean comment;
        private List<String> goods_images;
        private List<SpecBean> spec;

        public int getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public int getStore_id() {
            return store_id;
        }

        public void setStore_id(int store_id) {
            this.store_id = store_id;
        }

        public String getGoods_cover() {
            return goods_cover;
        }

        public void setGoods_cover(String goods_cover) {
            this.goods_cover = goods_cover;
        }

        public String getGoods_subtitle() {
            return goods_subtitle;
        }

        public void setGoods_subtitle(String goods_subtitle) {
            this.goods_subtitle = goods_subtitle;
        }

        public int getEvaluation_count() {
            return evaluation_count;
        }

        public void setEvaluation_count(int evaluation_count) {
            this.evaluation_count = evaluation_count;
        }

        public int getIs_favorites() {
            return is_favorites;
        }

        public void setIs_favorites(int is_favorites) {
            this.is_favorites = is_favorites;
        }

        public StoreBean getStore() {
            return store;
        }

        public void setStore(StoreBean store) {
            this.store = store;
        }

        public int getCart_num() {
            return cart_num;
        }

        public void setCart_num(int cart_num) {
            this.cart_num = cart_num;
        }

        public int getCart_price() {
            return cart_price;
        }

        public void setCart_price(int cart_price) {
            this.cart_price = cart_price;
        }

        public CommentBean getComment() {
            return comment;
        }

        public void setComment(CommentBean comment) {
            this.comment = comment;
        }

        public List<String> getGoods_images() {
            return goods_images;
        }

        public void setGoods_images(List<String> goods_images) {
            this.goods_images = goods_images;
        }

        public List<SpecBean> getSpec() {
            return spec;
        }

        public void setSpec(List<SpecBean> spec) {
            this.spec = spec;
        }

        public static class StoreBean {
            /**
             * store_phone : 0579-89970906
             */

            private String store_phone;

            public String getStore_phone() {
                return store_phone;
            }

            public void setStore_phone(String store_phone) {
                this.store_phone = store_phone;
            }
        }

        public static class CommentBean {
            /**
             * comment_content : 很方便，希望你们越做越好，越做越大

             * comment_addtime : 2017-08-14
             * avatar : http://oqv8tlktu.bkt.clouddn.com/avatar.jpg
             * user_nicename : 兰州拉面
             */

            private String comment_content;
            private String comment_addtime;
            private String avatar;
            private String user_nicename;

            public String getComment_content() {
                return comment_content;
            }

            public void setComment_content(String comment_content) {
                this.comment_content = comment_content;
            }

            public String getComment_addtime() {
                return comment_addtime;
            }

            public void setComment_addtime(String comment_addtime) {
                this.comment_addtime = comment_addtime;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getUser_nicename() {
                return user_nicename;
            }

            public void setUser_nicename(String user_nicename) {
                this.user_nicename = user_nicename;
            }
        }

        public static class SpecBean {
            /**
             * spec_id : 10096
             * price : 4.00
             * spec_promo_price : 0.00
             * ratio : /斤/500g
             * cart_goods_num : 0
             */

            private int spec_id;
            private String price;
            private String spec_promo_price;
            private String ratio;
            private int cart_goods_num;

            public int getSpec_id() {
                return spec_id;
            }

            public void setSpec_id(int spec_id) {
                this.spec_id = spec_id;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getSpec_promo_price() {
                return spec_promo_price;
            }

            public void setSpec_promo_price(String spec_promo_price) {
                this.spec_promo_price = spec_promo_price;
            }

            public String getRatio() {
                return ratio;
            }

            public void setRatio(String ratio) {
                this.ratio = ratio;
            }

            public int getCart_goods_num() {
                return cart_goods_num;
            }

            public void setCart_goods_num(int cart_goods_num) {
                this.cart_goods_num = cart_goods_num;
            }
        }
    }
}
