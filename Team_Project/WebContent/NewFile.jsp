<%@page import="java.io.File"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="_DAO.BookDAO"%>
<%@page import="_DTO.Book"%>

<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.net.URL"%>

<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@page import="org.jsoup.nodes.Element"%>
<%@page import="org.jsoup.select.Elements"%>

<%@page import="_DAO.BookDAO"%>
<%@page import="_DTO.Book"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// TODO Auto-generated method stub
//Book book = new Book();
Book book = new Book();
try {
   
   for(int a=1;a<4;a++) {//3바퀴 ( 1~3페이지)
   for(int b=1;b<6;b++) {//5바퀴 ( 5장르)
      
   String url = "https://series.naver.com/ebook/categoryProductList.nhn?categoryTypeCode=genre&genreCode=30"+b+"&page="+a;
   Document doc = Jsoup.connect(url).get();
   Elements movieList = doc.select(".lst_list").select("li");        //메인 본문페이지를 먼저따야함.
   
   for (int i = 0; i < movieList.size(); i++) {    //이미지 타이틀 제목 따기위한 포문
      Element movie = movieList.get(i);
      //String tit = movie.select(".tit").select("span").text();// 관람연령
      String imgfile=null;
      String name=null;
      String genre=null;
      String writer=null;
      String publish=null;
      String content=null;
      String tprice=null;
      String bookfile=null;
      
      //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 페이지에서 뽑아내기 위한 공간 (장르,이미지파일이름,텍스트파일이름)3개
      
      if(b==1) {
         genre="소설";
      }else if (b==2) {
         genre="시에세이";
      }else if (b==3) {
         genre="경제경영";
      }else if (b==4) {
         genre="자기계발";
      }else if (b==5) {
         genre="인문";
      }
         
      // select 할때 .이 붙을때 안붙을때 태그랑 클래스 명 차이 일수도이고 아닐수도있더라 ??.
      if(b==1) {
      imgfile = "소설 "+movie.select(".cont").select("a").text()+".jpg";// 
      imgfile = imgfile.replace("?", "");
      imgfile = imgfile.replace("/", "");
      }else if(b==2) {
         imgfile = "시에세이 "+   movie.select(".cont").select("a").text()+".jpg";// 
         imgfile = imgfile.replace("?", "");
         imgfile = imgfile.replace("/", "");
      }else if(b==3) {
         imgfile = "경제경영 "+movie.select(".cont").select("a").text()+".jpg";//
         imgfile = imgfile.replace("?", "");
         imgfile = imgfile.replace("/", "");
      }else if(b==4) {
         imgfile = "자기계발 "+movie.select(".cont").select("a").text()+".jpg";// 
         imgfile = imgfile.replace("?", "");
         imgfile = imgfile.replace("/", "");
      }else if(b==5) {
         imgfile = "인문 "+movie.select(".cont").select("a").text()+".jpg";// 
         imgfile = imgfile.replace("?", "");
         imgfile = imgfile.replace("/", "");
      }
      
      if(b==1) {
         bookfile = "소설 "+movie.select(".cont").select("a").text()+".txt";// 
         bookfile = bookfile.replace("?", "");
         bookfile = bookfile.replace("/", "");
         }else if(b==2) {
            bookfile = "시에세이 "+   movie.select(".cont").select("a").text()+".txt";// 
            bookfile = bookfile.replace("?", "");
            bookfile = bookfile.replace("/", "");
         }else if(b==3) {
            bookfile = "경제경영 "+movie.select(".cont").select("a").text()+".txt";// 
            bookfile = bookfile.replace("?", "");
            bookfile = bookfile.replace("/", "");
         }else if(b==4) {
            bookfile = "자기계발 "+movie.select(".cont").select("a").text()+".txt";// 
            bookfile = bookfile.replace("?", "");
            bookfile = bookfile.replace("/", "");
         }else if(b==5) {
            bookfile = "인문 "+movie.select(".cont").select("a").text()+".txt";//
            bookfile = bookfile.replace("?", "");
            bookfile = bookfile.replace("/", "");
         }
      
      //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 페이지에서 뽑아내기 위한 공간 (제목,작가,출판사,내용,가격) 5개
      
      name = movie.select(".cont").select("a").text(); //책 제목                                                완
      String booka = movie.select(".cont").select("p").text(); // 뽑아낼 문자열인데 작가랑 출판사 뽑아내야함                       완
      content = movie.select(".cont").select(".dsc").text(); //책 내용                                            완
      tprice = movie.select(".cont").select(".price").select("strong").text(); //책 가격                             완
      
      //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 문자열 입맛대로 조지기위한 공간
      
      //가격 조짐
      tprice = tprice.replace(",", "");//            가격에 ,를 지워야 인트형으로 
      String xprice = tprice.split("\\s")[0];          // 가격 1000 1050 형식을 앞에 가격만 출력하게하기위해 
      if(xprice.equals("무료")) {
         xprice="0";
      }
      int price = Integer.parseInt(xprice);
      
      //작가 조짐
      writer = booka.split("\\|")[1];   
      writer = writer.trim();
      
      //출판사 조짐
      publish = booka.split("\\|")[2];   
      publish = publish.trim();
   

      
      //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
      
      System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//      
//      System.out.println(name);    //책이름                             완   
//      System.out.println(genre);   //장르                            완
//      System.out.println(writer);  //작가                             완
//      System.out.println(publish);  //출판사                          완
//      System.out.println(content); //줄거리                           완
//      System.out.println(price); //가격                              완
//      System.out.println(imgfile);  //이미지파일이름                      완
//      System.out.println(bookfile);  //텍스트파일이름                      완

      
      //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
      
      // str안에 star안에 평점
      //String str = movie.select(".info_txt1").select("dd").text();
      String strImageUrl = movie.select(".pic").select("img").attr("src");
   //   System.out.println(strImageUrl);
      //String imageName="movieImage"+i+".jpg";
      //String strImageName = strImageUrl.substring(strImageUrl.lastIndexOf("/") + 1, strImageUrl.indexOf("?"));
      //String ext = strImageName.substring(strImageName.indexOf("."));
      //strImageName = strImageName.substring(0, strImageName.indexOf(".") - 1) + i + ext;
      // System.out.println(strImageName);
      // System.out.println(tit+" "+imgfile+" "+str);
      
      //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 빈에 일단 넣어둠
      book.setName(name);
      book.setGenre(genre);
      book.setWriter(writer);
      book.setPublish(publish);
      book.setContent(content);
      book.setPrice(price);
      book.setImgFile(imgfile);
      book.setBookFile(bookfile);
      //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ넣은걸 DB에 추가
      BookDAO bDao = BookDAO.getInstance();
      bDao.bookInsert(book);
      //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ이미지 파일및 텍스트 파일 저장 
//        downloadImage(imgfile, strImageUrl);       //이미지 파일 다운로드용
//        downloadImage2(bookfile, strImageUrl);       //텍스트 파일 다운로드용 

      URL urlImage = new URL(strImageUrl);
      
      InputStream in =urlImage.openStream();
      byte[] buffer = new byte[4096];
      int n = -1;
      File f = new File("C:/Users/whaks/Desktop/개발/CODE/BusanIT_Project2/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Team_Project/upload/"+b);
      f.length();
      OutputStream os = new FileOutputStream("C:/Users/whaks/Desktop/개발/CODE/BusanIT_Project2/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Team_Project/upload/" + imgfile);
      while ((n = in.read(buffer)) != -1) {
         os.write(buffer, 0, n);
      }
      os.close();      

      urlImage = new URL(strImageUrl);
      
      in =urlImage.openStream();
      buffer = new byte[4096];
      n = -1;
      os = new FileOutputStream("C:/Users/whaks/Desktop/개발/CODE/BusanIT_Project2/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Team_Project/upload/" + bookfile);
      while ((n = in.read(buffer)) != -1) {
         os.write(buffer, 0, n);
      }
      os.close();

   }
   }
   }
   
} catch (Exception e) {
   e.printStackTrace();
}
%>
</body>
</html>