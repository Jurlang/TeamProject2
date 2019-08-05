package _DTO;

public class Book {
	private int no;
	private String name;
	private String genre;
	private String writer;
	private String publish;
	private String content;
	private int read_count;
	private int reply_count;
	private int price;
	private int score;
	private int buyCount;
	private String imgFile;
	private String bookFile;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRead_count() {
		return read_count;
	}
	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}
	public int getReply_count() {
		return reply_count;
	}
	public void setReply_count(int reply_count) {
		this.reply_count = reply_count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}
	public String getImgFile() {
		return imgFile;
	}
	public void setImgFile(String imgFile) {
		this.imgFile = imgFile;
	}
	public String getBookFile() {
		return bookFile;
	}
	public void setBookFile(String bookFile) {
		this.bookFile = bookFile;
	}
	@Override
	public String toString() {
		return "Book [no=" + no + ", name=" + name + ", genre=" + genre + ", writer=" + writer + ", publish=" + publish
				+ ", content=" + content + ", read_count=" + read_count + ", reply_count=" + reply_count + ", price="
				+ price + ", score=" + score + ", buyCount=" + buyCount + ", imgFile=" + imgFile + ", bookFile="
				+ bookFile + "]";
	}
	
	
	
}
