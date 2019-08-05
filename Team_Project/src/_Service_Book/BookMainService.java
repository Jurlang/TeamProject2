package _Service_Book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _DAO.BookDAO;

public class BookMainService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<String> genreArr = new ArrayList<String>();
		BookDAO bDao = BookDAO.getInstance();
		genreArr = bDao.bookSelectGenre();
		for(int i=0; i< genreArr.size(); i++) {
			System.out.println(genreArr.get(0));
		}
		request.setAttribute("genreArr", genreArr);
		request.getRequestDispatcher("/Main.jsp").forward(request, response);

	}

}
