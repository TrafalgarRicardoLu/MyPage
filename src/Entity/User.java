package Entity;


import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.UUID;

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
}