package org.dcsc.core.user;

import javax.persistence.*;

@Entity
@Table(name = "dcsc_class", schema = "dcsc_accounts")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "class_name")
    private String className;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}