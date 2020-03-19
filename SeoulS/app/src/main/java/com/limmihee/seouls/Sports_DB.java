package com.limmihee.seouls;

public class Sports_DB {
        private String name;
        private String event;
        private String simple_info;
        private String Detail_info;
        private String photo_name;

        public  Sports_DB(){

        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getEvent() {
                return event;
        }

        public void setEvent(String event) {
                this.event = event;
        }

        public String getSimple_info() {
                return simple_info;
        }

        public void setSimple_info(String simple_info) {
                this.simple_info = simple_info;
        }

        public String getDetail_info() {
                return Detail_info;
        }

        public void setDetail_info(String detail_info) {
                Detail_info = detail_info;
        }

        public String getPhoto_name() {
                return photo_name;
        }

        public void setPhoto_name(String photo_name) {
                this.photo_name = photo_name;
        }
}
