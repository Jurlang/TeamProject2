package _DTO;

import java.sql.Date;

	public class CartList {
		
		String name;
		String bookfile;
		int booksize;
		String u_name;
		Date currdate;
		String genre;
		int price;
		String publish;
		String imgfile;
		
		public int getBooksize() {
			return booksize;
		}
		public void setBooksize(int booksize) {
			this.booksize = booksize;
		}
		public String getImgfile() {
			return imgfile;
		}
		public void setImgfile(String imgfile) {
			this.imgfile = imgfile;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getBookfile() {
			return bookfile;
		}
		public void setBookfile(String bookfile) {
			this.bookfile = bookfile;
		}
		public String getU_name() {
			return u_name;
		}
		public void setU_name(String u_name) {
			this.u_name = u_name;
		}
		public Date getCurrdate() {
			return currdate;
		}
		public void setCurrdate(Date currdate) {
			this.currdate = currdate;
		}
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public String getPublish() {
			return publish;
		}
		public void setPublish(String publish) {
			this.publish = publish;
		}
		
	}

