package hu.nye.rft.classes.model;

import java.util.Objects;

public class RegDatas {



    private String reg_id;

    private String is_teacher;

    public RegDatas(String reg_id, String is_teacher) {
        this.reg_id = reg_id;
        this.is_teacher = is_teacher;
    }

    public void setReg_id(String reg_id) {
        this.reg_id = reg_id;
    }

    public void setIs_teacher(String is_teacher) {
        this.is_teacher = is_teacher;
    }


    public String getReg_id() {
        return reg_id;
    }

    public String getIs_teacher() {
        return is_teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegDatas regDatas = (RegDatas) o;
        return  Objects.equals(reg_id, regDatas.reg_id) && Objects.equals(is_teacher, regDatas.is_teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reg_id, is_teacher);
    }

    @Override
    public String toString() {
        return "RegDatas{" +
                ", reg_id='" + reg_id + '\'' +
                ", is_teacher='" + is_teacher + '\'' +
                '}';
    }
}
