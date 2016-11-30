package bz.sunlight.store.myspotlight;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.List;

/**
 *
 * Created by Administrator on 2016/11/17.
 */
public class Bean implements Serializable,Comparable {

    private String id;
    private String name;
    private boolean flag;
    private List<String> strs;

    public Bean(String id, String name, boolean flag, List<String> strs) {
        this.id = id;
        this.name = name;
        this.flag = flag;
        this.strs = strs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public List<String> getStrs() {
        return strs;
    }

    public void setStrs(List<String> strs) {
        this.strs = strs;
    }

    @Override
    public int compareTo(Object another) {
        return CompareToBuilder.reflectionCompare(this, another);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(name)
                .append(flag)
                .append(strs)
                .toHashCode();
    }

    public boolean equals(Object o) {
        if (!(o instanceof Bean)) return false;

        Bean otherPerson = (Bean) o;
        return new EqualsBuilder()
                .append(id,otherPerson.getId())
                .append(name,otherPerson.getName())
                .append(flag, otherPerson.isFlag())
                .append(strs, otherPerson.getStrs())
                .isEquals();
    }
}
