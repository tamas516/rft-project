package hu.nye.rft.classes.model;

import java.util.Objects;

/**
 * My <b>class</b>.
 *
 */

public class RegDatas {

    private String regid;

    private String isteacher;

    public RegDatas(String regid, String isteacher) {
        this.regid = regid;
        this.isteacher = isteacher;
    }

    public void setRegid(String regid) {
        this.regid = regid;
    }

    public void setIsteacher(String isteacher) {
        this.isteacher = isteacher;
    }


    public String getRegid() {
        return regid;
    }

    public String getIsteacher() {
        return isteacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RegDatas regDatas = (RegDatas) o;
        return  Objects.equals(regid, regDatas.regid) && Objects.equals(isteacher, regDatas.isteacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regid, isteacher);
    }

    @Override
    public String toString() {
        return "RegDatas{" +
                ", reg_id='" + regid + '\'' +
                ", is_teacher='" + isteacher + '\'' +
                '}';
    }
}
