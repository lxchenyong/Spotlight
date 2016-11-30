package bz.sunlight.store.myspotlight;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/11/18.
 */
public class Pero implements Serializable,Comparable {
    private String id;
    private String name;

    public Pero(String id, String name) {
        this.id = id;
        this.name = name;
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


    @Override
    public int compareTo(Object another) {
        return CompareToBuilder.reflectionCompare(this, another);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(name)
                .toHashCode();
    }

    public boolean equals(Object o) {
        if (!(o instanceof Bean)) return false;

        Pero otherPerson = (Pero) o;
        return new EqualsBuilder()
                .append(id, otherPerson.getId())
                .append(name, otherPerson.getName())
                .isEquals();
    }
}
