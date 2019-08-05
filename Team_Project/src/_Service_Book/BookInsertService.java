package _Service_Book;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import _DAO.BookDAO;
import _DTO.Book;

public class BookInsertService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			Book book = new Book();
			
			String saveFolder = "/upload"; // webcontent 에 upload라는 폴더가 있어야 아래의 realFolder 생긴다.
			int maxFileSize = 5*1024*1024; // 5MB 까지 업로드 가능
			ServletContext context = request.getServletContext();
			String realFolder = context.getRealPath(saveFolder);
			System.out.println("realFolder : " + realFolder);
			MultipartRequest multi = new MultipartRequest(request, realFolder, maxFileSize, "UTF-8", new DefaultFileRenamePolicy()); 
			
//			Enumeration<String> files = multi.getFileNames();
//			
//			while(files.hasMoreElements()) {
//				String file = files.nextElement();
//				multi.getFilesystemName(file);
//			}
//			여러개의 파일을 올려서 저장 시킬 때
			book.setName(multi.getParameter("name"));
			book.setGenre(multi.getParameter("genre"));
			book.setWriter(multi.getParameter("writer"));
			book.setPublish(multi.getParameter("publish"));
			book.setPrice(Integer.parseInt(multi.getParameter("price")));
			book.setContent(multi.getParameter("content"));
			book.setImgFile(multi.getFilesystemName((String)multi.getFileNames().nextElement())); // 한개만 한다는 전제 하에 이렇게 가능.
			book.setBookFile(multi.getFilesystemName((String)multi.getFileNames().nextElement())); // 한개만 한다는 전제 하에 이렇게 가능.
			
			Enumeration<String> files = multi.getFileNames();
			
			int i = 0;
			while(files.hasMoreElements()) {
				String file = files.nextElement();
				if( i == 0)
					book.setImgFile(multi.getFilesystemName(file));
				else 
					book.setBookFile(multi.getFilesystemName(file));
				i++;
			}
			
			
			BookDAO bDao = BookDAO.getInstance();
			
			bDao.bookInsert(book);
			
			response.sendRedirect("bookPageList.do");
	}
}
