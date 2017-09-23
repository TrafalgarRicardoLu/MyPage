package Entity;


import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table()
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 16,unique = true,nullable = false)
    @ColumnDefault("0")
    private Integer id;

    @Column(length = 10)
    private String name;

    @Column(length = 16)
    private String password;


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}