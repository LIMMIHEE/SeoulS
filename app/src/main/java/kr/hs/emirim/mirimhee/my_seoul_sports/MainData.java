package kr.hs.emirim.mirimhee.my_seoul_sports;

public class MainData {
    private int iv_profile;
    private  String iv_name;
    private  String iv_number;

    public MainData(int iv_profile, String iv_name, String iv_number) {
        this.iv_profile = iv_profile;
        this.iv_name = iv_name;
        this.iv_number = iv_number;
    }


    public int getIv_profile() {
        return iv_profile;
    }

    public void setIv_profile(int iv_profile) {
        this.iv_profile = iv_profile;
    }

    public String getIv_name() {
        return iv_name;
    }

    public void setIv_name(String iv_name) {
        this.iv_name = iv_name;
    }

    public String getIv_number() {
        return iv_number;
    }

    public void setIv_number(String iv_number) {
        this.iv_number = iv_number;
    }
}
