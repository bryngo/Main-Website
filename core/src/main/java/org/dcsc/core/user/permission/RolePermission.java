package org.dcsc.core.user.permission;

import org.dcsc.core.user.role.DcscRole;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Deprecated
@Entity
@IdClass(RolePermissionId.class)
@Table(name = "dcsc_role_privileges", schema = "dcsc_accounts")
public class RolePermission {
    @Id
    @ManyToOne
    private DcscRole role;

    @Id
    @ManyToOne
    private Permission permission;

    @Column(name = "access_level")
    private int accessLevel;

    public DcscRole getRole() {
        return role;
    }

    public void setRole(DcscRole role) {
        this.role = role;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }
}
