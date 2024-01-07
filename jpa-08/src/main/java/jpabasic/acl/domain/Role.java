package jpabasic.acl.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    private String id;
    private String name;

    @ElementCollection
    @CollectionTable(
            name = "role_perm", //collection table 이름 지정
            joinColumns = @JoinColumn(name = "role_id") //join에 사용할 column 지정
    )
    @Column(name = "perm") //실제 값을 담고 있는 column
    private Set<String> permissions = new HashSet<>(); //Set<String>

    protected Role() {}

    public Role(String id, String name, Set<String> permissions) {
        this.id = id;
        this.name = name;
        this.permissions = permissions;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void revokeAll() {
        this.permissions.clear(); // SELECT -> DELETE
        // this.permissions = new HashSet<>(); // DELETE
    }

    public void setPermissions(Set<String> newPermissions) {
        this.permissions = newPermissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
