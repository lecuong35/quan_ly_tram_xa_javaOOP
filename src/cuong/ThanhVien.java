package cuong;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ThanhVien implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 9049476839950852004L;

    private String id ;
    private String name ;
    private int age ;
    private String sex;
    
    
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
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
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "ThanhVien [Id=" + id + ", age=" + age + ", name=" + name + "]";
    }

    public List<TiemChung> tiemChungs = new ArrayList<>();
    
    public ThanhVien() {
    }
    
    public ThanhVien(String id, String name, int age, String sex , List<TiemChung> tiemChungs) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex ;
        this.tiemChungs = tiemChungs;
    }
    public ThanhVien(String id, String name) {
        this.id = id;
        this.name = name;
    }
    


    


}
