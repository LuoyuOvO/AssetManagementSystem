package www.glaway.assetmanagementsystem.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class User {

    @Id
    private Long id;//id
    private String username;//用户名
    private String password;//密码
    private Date createData;//创建时间
    private Date description;//描述
    @Generated(hash = 1681675523)
    public User(Long id, String username, String password, Date createData,
            Date description) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createData = createData;
        this.description = description;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getCreateData() {
        return this.createData;
    }
    public void setCreateData(Date createData) {
        this.createData = createData;
    }
    public Date getDescription() {
        return this.description;
    }
    public void setDescription(Date description) {
        this.description = description;
    }
}
