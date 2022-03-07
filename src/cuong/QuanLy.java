package cuong;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultListModel;

import gui.ChildPanel;
import gui.MainPanel;
import gui.MainTabbedButton;
import gui.MainTabbedPane;

public class QuanLy {
	public static void readFile(ArrayList<ThanhVien> tViens, MainPanel mainPanel) {
		try {
			QuanLy.doc_file(tViens);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		//Set gui
		ArrayList<String> IDs = new ArrayList<String>();
		for(ThanhVien tv: tViens) {
			String id = tv.getId();
			if(!IDs.contains(id)) {
				IDs.add(id);
		    	mainPanel.myList.removeListSelectionListener(mainPanel.listListener);
		        DefaultListModel<String> model = (DefaultListModel<String>) mainPanel.myList.getModel();
		        String item = "" + (mainPanel.familyPane.size()+1) + "." + id.trim();
		        model.addElement(item);
		        mainPanel.myList.setModel(model);
		        mainPanel.myList.addListSelectionListener(mainPanel.listListener);
		        
		        //Thêm Panel tương ứng với list vừa tạo vào bên trái
		        mainPanel.leftPanel.removeAll();
		        MainTabbedPane tabbedPane = mainPanel.createNewPanel(id);
		        mainPanel.leftPanel.add(tabbedPane);
		        
		        //Cập nhật lại tabbedPane theo gia đình (dựa theo ID)
		        try {
					//ArrayList<ThanhVien> giadinh = new ArrayList<ThanhVien>(ReadFile.thong_tin_thanh_vien(id));
		        	tabbedPane.giaDinh.clear();
		        	tabbedPane.giaDinh.addAll(QuanLy.thong_tin_thanh_vien(id));
					int soTV = tabbedPane.giaDinh.size();
					int thutu = 1;
					if(soTV > 3) {
						for(int i=0; i<soTV - 3; i++) {
							int index = tabbedPane.numTabs - 1;
				        	ChildPanel newChild = new ChildPanel(tabbedPane, thutu + 2);
				        	tabbedPane.childPanel.add(newChild);
				            tabbedPane.mainTabbedPane.insertTab("Con thứ " + String.valueOf(index - 1), null, newChild,null, index);
				            /* set tab is custom tab */
				            tabbedPane.mainTabbedPane.setTabComponentAt(index, new MainTabbedButton(tabbedPane));
				            tabbedPane.mainTabbedPane.removeChangeListener(tabbedPane.changeListener);
				            tabbedPane.mainTabbedPane.setSelectedIndex(index);
				            tabbedPane.mainTabbedPane.addChangeListener(tabbedPane.changeListener);
				            tabbedPane.numTabs++;
				            thutu++;
						}
					}
					
					thutu = 1;
					for(ThanhVien t: tabbedPane.giaDinh) {
						QuanLy.doc_du_lieu(t, tabbedPane, thutu);
						if(t instanceof TreCon)	thutu++;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

		        
		        
		        mainPanel.leftPanel.validate();
			}
		}
	}
	
	public static void doc_du_lieu(ThanhVien tv, MainTabbedPane panel, int thuTuCon) {
		if(tv instanceof Bo) {
			panel.dadPanel.dadInfor.nameTField.setText(tv.getName());
			panel.dadPanel.dadInfor.mailTField.setText(((Bo) tv).getEmail());
			panel.dadPanel.dadInfor.ageTField.setText(""+tv.getAge());
			panel.dadPanel.dadInfor.comboBox.setSelectedIndex(0);
			
			for(int i=0; i<tv.tiemChungs.size(); i++) {
				TiemChung t = tv.tiemChungs.get(i);
				String ngayTiem = t.getNgayTiem().getDayOfMonth() + "/" +
						t.getNgayTiem().getMonthValue() +"/" + 
						t.getNgayTiem().getYear();
				panel.dadPanel.dadInject.readToTab(t.getTenThuocString(), ngayTiem, t.file_anh, 0, i);
			}
		}
		
		if(tv instanceof Me) {
			panel.mumPanel.mumInfor.nameTField.setText(tv.getName());
			panel.mumPanel.mumInfor.mailTField.setText(((Me) tv).getEmail());
			panel.mumPanel.mumInfor.ageTField.setText(""+tv.getAge());
			panel.mumPanel.mumInfor.comboBox.setSelectedItem("Nữ");
			
			for(int i=0; i<tv.tiemChungs.size(); i++) {
				TiemChung t = tv.tiemChungs.get(i);
				String ngayTiem = t.getNgayTiem().getDayOfMonth() + "/" +
						t.getNgayTiem().getMonthValue() +"/" + 
						t.getNgayTiem().getYear();
				panel.mumPanel.mumInject.readToTab(t.getTenThuocString(), ngayTiem, t.file_anh, 1, i);
			}
			
			if(((Me) tv).isMangThai()) {
				String ngayThamKham = ((Me)tv).getNgayThamKham().getDayOfMonth() + "/" +
									  ((Me)tv).getNgayThamKham().getMonthValue() + "/" +
									  ((Me)tv).getNgayThamKham().getYear();
				panel.mumPanel.mumPregnancy.ReadToThis(((Me) tv).CanNang(), ngayThamKham, ((Me)tv).getTuanThu());
			}
		}
		
		if(tv instanceof TreCon) {
			int thutu = thuTuCon - 1;
			panel.childPanel.get(thutu).childInfor.nameTField.setText(tv.getName());
			panel.childPanel.get(thutu).childInfor.mailTField.setText("");
			panel.childPanel.get(thutu).childInfor.ageTField.setText(""+tv.getAge());
			panel.childPanel.get(thutu).childInfor.comboBox.setSelectedItem(((TreCon)tv).getSex());
			panel.childPanel.get(thutu).childInfor.thang.setVisible(true);
			
			for(int i=0; i<tv.tiemChungs.size(); i++) {
				TiemChung t = tv.tiemChungs.get(i);
				String ngayTiem = t.getNgayTiem().getDayOfMonth() + "/" +
						t.getNgayTiem().getMonthValue() +"/" + 
						t.getNgayTiem().getYear();
				panel.childPanel.get(thutu).childInject.readToTab(t.getTenThuocString(), ngayTiem, t.file_anh, thuTuCon + 1, i);
			}
			if(!((TreCon)tv).chieu_cao.isEmpty())
				panel.childPanel.get(thutu).childNutrition.ReadToThis(((TreCon)tv).chieu_cao, ((TreCon)tv).can_nang, tv.getAge(), thuTuCon + 1);
		}
	}
	
    public static void doc_file(List<ThanhVien> tViens) throws IOException{
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
        	 
            File file = new File(System.getProperty("user.dir") + "\\mywrite.txt");
 
            if (!file.exists()) 
                file.createNewFile();
            else {
                try {
                    fis = new FileInputStream("mywrite.txt");
                    ois = new ObjectInputStream(fis);
                    while(fis.available() > 0){
                        tViens.add((ThanhVien) ois.readObject());
                    }
                
                } catch (Exception e) {
                    e.printStackTrace();
                }finally{
                    if(ois != null) ois.close();
                    fis.close();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    
    public static ArrayList<ThanhVien> thong_tin_thanh_vien(String ID) throws IOException{
        List<ThanhVien> tViens = new ArrayList<>();
        ArrayList<ThanhVien> giadinh = new ArrayList<ThanhVien>();
        QuanLy.doc_file(tViens);
        for (ThanhVien thanhVien : tViens) {
            if(thanhVien.getId().equals(ID)){
            	giadinh.add(thanhVien);
            }
        }       
        return giadinh;
    }
    
    public static ArrayList<Integer> dem_vacxin_nam_nay(int year, ArrayList<MainTabbedPane> familyPane) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        for(int i=0; i<12; i++) {
        	array.add(0);
        }
        
        for(MainTabbedPane f: familyPane) {
            for (ThanhVien tv: f.giaDinh){
            	for(TiemChung tc: tv.tiemChungs) {
	                if(tc.getNgayTiem().getYear() == year ){
	                    int thang = tc.getNgayTiem().getMonthValue();
	                    array.set(thang - 1, array.get(thang - 1) + 1);
	                }
                }
            }
        }
        return array;

    }
    
    
	public static void gui_mail(final String username,final String password, String receiver, String subject, String content) throws Exception{
		Properties prop = new Properties();
		prop.put("mail.smtp.host","smtp.gmail.com");// mấy cái này để đăng nhập
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); //TLS

		Session session = Session.getInstance(prop,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress((username)));//txtEmailSend.getText()
			message.setRecipients(
					Message.RecipientType.TO,
					InternetAddress.parse(receiver)//txtEmailTo.getText(): email người nhận
					);
			message.setSubject(subject);//txtSubject.getText(): tiêu đề
			message.setText(content);//txtMessage.getText(): nội dung

			Transport.send(message);
			;

		
	}

	public static void writeFile(ArrayList<MainTabbedPane> cacGiaDinh) {
		ArrayList<ThanhVien> thanhvien = new ArrayList<ThanhVien>();
		for(MainTabbedPane p: cacGiaDinh) {
			thanhvien.addAll(p.giaDinh);
		}
		try {
			luu_danh_sach(thanhvien);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
		
	}
	
	public static void luu_danh_sach(List<ThanhVien> tViens) throws IOException{
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("mywrite.txt");
			oos = new ObjectOutputStream(fos);
			for (ThanhVien thanhVien : tViens) {
				oos.writeObject(thanhVien);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			oos.close();
			fos.close();
		}
	}
}


