package com.ufaar;

public class Classes {

    private int classid;
    private String classnum;

    public Classes() {
    }
    public Classes(int classid, String classnum){
        this.classid = classid;
        this.classnum = classnum;

    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public String getClassnum() {
        return classnum;
    }

    public void setClassnum(String classnum) {
        this.classnum = classnum;
    }

    @Override
    public String toString(){
        return classid + " "
                + classnum + "\n";
    }
}
