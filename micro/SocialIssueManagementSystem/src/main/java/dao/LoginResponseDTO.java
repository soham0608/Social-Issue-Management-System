//package dao;
//
//public class LoginResponseDTO {
//    private int uid;
//    private String email;
//    private int rid;
//
//    public LoginResponseDTO(int uid, String email, int rid) {
//        this.uid = uid;
//        this.email = email;
//        this.rid = rid;
//    }
//
//    // Getters and setters
//    public int getUid() {
//        return uid;
//    }
//
//    public void setUid(int uid) {
//        this.uid = uid;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public int getRid() {
//        return rid;
//    }
//
//    public void setRid(int rid) {
//        this.rid = rid;
//    }
//}


package dao;

public class LoginResponseDTO {
    private int uid;
    private String uname;
    private int rid;

    public LoginResponseDTO(int uid, String uname, int rid) {
        this.uid = uid;
        this.uname = uname;
        this.rid = rid;
    }

    // Getters and setters
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }
}