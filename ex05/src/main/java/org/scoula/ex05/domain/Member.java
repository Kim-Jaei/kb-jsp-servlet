package org.scoula.ex05.domain;

public class Member {
    // VO와 DTO의 차이점
    // VO는 DAO가 사용, DTO는 servlet이 사용
    private String name;
    private String userid;

    public Member(){

    }

    public Member(String name, String userid){
        this.name = name;
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
