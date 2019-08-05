package _DTO;

import java.sql.Date;

public class Member {
	
   private int uno;
   private String u_id;
   private String u_pw;
   private String u_name;
   private Date u_birth;
   private String u_tel;
   private String u_address;
   private int u_point;
   private int u_grade;

   
   @Override
	public String toString() {
		return "Member [uno=" + uno + ", u_id=" + u_id + ", u_pw=" + u_pw + ", u_name=" + u_name + ", u_birth=" + u_birth
				+ ", u_tel=" + u_tel + ", u_address=" + u_address + ", u_point=" + u_point + ", u_grade=" + u_grade + "]";
	}
   
   public int getUno() {
      return uno;
   }
   public void setUno(int uno) {
      this.uno = uno;
   }
   public String getU_id() {
      return u_id;
   }
   public void setU_id(String u_id) {
      this.u_id = u_id;
   }
   public String getU_pw() {
      return u_pw;
   }
   public void setU_pw(String u_pw) {
      this.u_pw = u_pw;
   }
   public String getU_name() {
      return u_name;
   }
   public void setU_name(String u_name) {
      this.u_name = u_name;
   }
   public Date getU_birth() {
      return u_birth;
   }
   public void setU_birth(Date u_birth) {
      this.u_birth = u_birth;
   }
   public String getU_tel() {
      return u_tel;
   }
   public void setU_tel(String u_tel) {
      this.u_tel = u_tel;
   }
   public String getU_address() {
      return u_address;
   }
   public void setU_address(String u_address) {
      this.u_address = u_address;
   }
   public int getU_point() {
      return u_point;
   }
   public void setU_point(int u_point) {
      this.u_point = u_point;
   }
   public int getU_grade() {
      return u_grade;
   }
   public void setU_grade(int u_grade) {
      this.u_grade = u_grade;
   }
   
}