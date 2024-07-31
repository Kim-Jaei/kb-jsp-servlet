package org.scoula.ex05.dto;

public class LoginDTO {
    // attribute O property X
    private String userid;
    private String passwd;

    public LoginDTO() {}

   public LoginDTO(String userid, String passwd) {
        this.userid = userid;
        this.passwd = passwd;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
