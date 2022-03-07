package cuong;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TiemChung implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4590645662003036501L;
	private String tenThuocString ;
    private LocalDate ngayTiem;
    List<String> file_anh = new ArrayList<>();


    public String getTenThuocString() {
        return tenThuocString;
    }
    public void setTenThuocString(String tenThuocString) {
        this.tenThuocString = tenThuocString;
    }
    public LocalDate getNgayTiem() {
        return ngayTiem;
    }
    public void setNgayTiem(LocalDate ngayTiem) {
        this.ngayTiem = ngayTiem;
    }
   
    public TiemChung(String tenThuocString, LocalDate ngayTiem) {
        this.tenThuocString = tenThuocString;
        this.ngayTiem = ngayTiem;
    }
    public TiemChung(String tenThuocString, LocalDate ngayTiem, List<String> file_anh) {
        this.tenThuocString = tenThuocString;
        this.ngayTiem = ngayTiem;
        this.file_anh = file_anh;
    }
    public TiemChung() {
    	
	}
	@Override
    public String toString() {
        return "TiemChung [ngayTiem=" + ngayTiem + ", tenThuocString=" + tenThuocString + " "+file_anh + "]";
    }
	public List<String> getFile_anh() {
		return file_anh;
	}
	public void setFile_anh(List<String> file_anh) {
		this.file_anh = file_anh;
	}
    
}
