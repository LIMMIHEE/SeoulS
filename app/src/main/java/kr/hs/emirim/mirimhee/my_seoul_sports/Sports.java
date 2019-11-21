package kr.hs.emirim.mirimhee.my_seoul_sports;

public class Sports {

    public String  name;
    public String number;

    public Sports(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String kind;

    public Sports(String name, String number, String kind) {
        this.name = name;
        this.number = number;
        this.kind = kind;
    }

}
