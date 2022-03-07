package cuong;

//import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Me extends ThanhVien {

	/**
	 * 
	 */
	private static final long serialVersionUID = 415003013611625062L;
	boolean mangThai ;
    private int tuanThu ;
    private int canNang ;
    private LocalDate ngayThamKham;
    private String email ;
    
   
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Me(String id, String name, int age, String sex, List<TiemChung> tiemChungs, String email) {
        super(id, name, age,sex, tiemChungs);
        //this.ngayThamKham = ngayThamKham;
        this.email = email ;
    }
    public boolean isMangThai() {
        return mangThai;
    }
    public void setMangThai(boolean mangThai) {
        this.mangThai = mangThai;
    }
    public int getTuanThu() {
        return tuanThu;
    }
    public void setThangThu(int tuanThu) {
        this.tuanThu = tuanThu;
    }
    public int CanNang() {
        return canNang;
    }
    public void setCanNang(int i) {
        this.canNang = i;
    }
    public LocalDate getNgayThamKham() {
        return ngayThamKham;
    } 
    public void setNgayThamKham(LocalDate ngayThamKham) {
        this.ngayThamKham = ngayThamKham;
    }
    
    public Me(String id, String name, int age, String sex,List<TiemChung> tiemChungs, boolean mangThai, int tuanThu, int canNang, LocalDate ngayThamKham, String email) {
        super(id, name, age, sex,tiemChungs);
        this.mangThai = mangThai;
        this.tuanThu = tuanThu;
        this.canNang = canNang;
        this.ngayThamKham = ngayThamKham;
        this.email = email ;
    }
    public Me() {
		// TODO Auto-generated constructor stub
	}
	@Override
    public String toString() {
        return "Me [ Id=" + super.getId() + ", name=" + super.getName()+ ", age=" + super.getAge()  +
                   "gioi tinh="+super.getSex()+",canNang=" + canNang + ", mangThai=" + mangThai + ", tuanThu="+ tuanThu + 
                    super.tiemChungs.toString()+ email +"]";
    }
    
   
    
    
}
