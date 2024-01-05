package jpabasic.reserve.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity //DB 테이블과 매핑할 대상(보통 Entity 단위로 하기 때문에 어노테이션 entity)
@Table(name = "user") //user 테이블과 매핑
public class User {
    @Id //식별자에 대응. 보통 table의 PK와 매핑하는 Column에 붙이게 됨
    private String email; //(이름이 같은) email 칼럼과 매핑
    private String name; //name 칼럼과 매핑

    @Column(name = "create_date") //column과 이름이 다른 경우 어노테이션 Column 사용. name 이름의 column과 매핑 
    private LocalDateTime createDate;

    protected User() {
    }

    public User(String email, String name, LocalDateTime createDate) {
        this.email = email;
        this.name = name;
        this.createDate = createDate;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void changeName(String newName) {
        this.name = newName;
    }
}
