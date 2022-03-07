package cuong;

import java.time.LocalDate;
import java.util.ArrayList;
//import java.io.Serializable;
import java.util.List;

public class TreCon extends ThanhVien  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8869726690657446808L;

	private LocalDate ngayChich ;

    List<Integer> chieu_cao = new ArrayList<>();
    List<Integer> can_nang = new ArrayList<>(); 
    
    
    public TreCon(String id, String name, int age, String sex, List<TiemChung> tiemChungs,
        List<Integer> chieu_cao, List<Integer> can_nang) {
            super(id, name, age, sex, tiemChungs);
            //this.ngayChich = ngayChich;
            this.chieu_cao = chieu_cao;
            this.can_nang = can_nang;
    }

   
    
    public List<Integer> getChieu_cao() {
        return chieu_cao;
    }



    public void setChieu_cao(List<Integer> chieu_cao) {
        this.chieu_cao = chieu_cao;
    }



    public List<Integer> getCan_nang() {
        return can_nang;
    }



    public void setCan_nang(List<Integer> can_nang) {
        this.can_nang = can_nang;
    }



    public LocalDate getNgayChich() {
        return ngayChich;
    }

    public void setNgayChich(LocalDate ngayChich) {
        this.ngayChich = ngayChich;
    }

    public TreCon(String id, String name) {
        super(id, name);
    }
    

    public TreCon() {
		// TODO Auto-generated constructor stub
	}



	@Override
    public String toString() {
        return "Con [ Id="+super.getId()+" ,name="+super.getName()+" ,age="+super.getAge() +
                  "gioi tinh ="+super.getSex()+ ", chieuCao=" + chieu_cao +" ,can nang="+can_nang +
                   super.tiemChungs.toString()+"]";
    }
    
}
