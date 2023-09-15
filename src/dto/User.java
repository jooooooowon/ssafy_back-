package dto;

public class User {
    private int num;
    private String id;
    private String pwd;
    private String name;

    public User() {
        // TODO Auto-generated constructor stub
    }

    public User(String id, String pwd, String name) {
        super();
        this.id = id;
        this.pwd = pwd;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [num=" + num + ", id=" + id + ", pwd=" + pwd + ", name=" + name + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User temp = (User) obj;
            if(temp.getId().equals(this.id) && temp.getPwd().equals(this.pwd)) {
                return true;
            }
        }
        return false;
    }

}
