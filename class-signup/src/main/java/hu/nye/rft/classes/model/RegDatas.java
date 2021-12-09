package hu.nye.rft.classes.model;

import java.util.Objects;

public class RegDatas {

    private final String name;
    private final String password;
    private final String is_teacher;

    public RegDatas(String name, String password, String is_teacher) {
        this.name = name;
        this.password = password;
        this.is_teacher = is_teacher;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getIs_teacher() {
        return is_teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegDatas regDatas = (RegDatas) o;
        return Objects.equals(name, regDatas.name) && Objects.equals(password, regDatas.password) && Objects.equals(is_teacher, regDatas.is_teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, is_teacher);
    }

    @Override
    public String toString() {
        return "RegDatas{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", is_teacher='" + is_teacher + '\'' +
                '}';
    }
}
