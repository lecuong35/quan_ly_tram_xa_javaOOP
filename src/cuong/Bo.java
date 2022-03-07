package cuong;

import java.util.List;

public class Bo extends ThanhVien{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8673838953908559110L;

	private String email;
    

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public Bo(String id, String name, int age, String sex,List<TiemChung> tiemChungs, String email) {
        super(id, name, age, sex,tiemChungs);
        this.email = email ;
    }
    
    
    public Bo() {
	}


	@Override
    public String toString() {
        return "Bo []" + email+ super.tiemChungs.toString();
    }
    
     
}