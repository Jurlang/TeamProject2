package _DTO;

public class PageMaker {
	private int pageSize = 9; // how many read board in page
	private int startPage; // start of block
	private int endPage; // end of block
	private int curPage = 1;
	private int start; // start of page
	private int totalCount; // All record count
	private boolean next; // next page
	private boolean prev; // prev page

	public PageMaker(int curPage, int totalCount) {
		this.curPage = curPage;
		this.totalCount = totalCount;
		start = (curPage - 1) * pageSize;
		int totalPage = (int) (Math.ceil(totalCount / (double) pageSize));

		prev = curPage == 1 ? false : true;
		next = curPage >= totalPage ? false : true;
	}

	public PageMaker(int curPage, int totalCount, int a) {
		this.curPage = curPage; // 현재 페이지 번호
		this.totalCount = totalCount; // 전체 갯수 ( 게시물 )
		start = (curPage - 1) * pageSize; // 각 페이지의 불러올 시작 게시물 번호 ( ex. 1페이지 = 1 ~ 10 / 2페이지 = 11~ 20 )
		endPage = (int) (Math.ceil(curPage / (double) pageSize) * pageSize);
		// 현재 페이지에서의 블록 마지막 페이지 번호( ex. 현재 2페이지 = 1 * 10 = 10 )
		startPage = (endPage - pageSize) + 1;
		// 위에서 반대
		int totalPage = (int) (Math.ceil(totalCount / (double) pageSize));
		// 총 페이지 갯수 ( ex. 게시물 1234개 = 124 페이지 ㅇ.ㅇ )
		if (endPage > totalPage)
			endPage = totalPage;

		prev = startPage == 1 ? false : true;
		next = endPage < totalPage ? true : false;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getCurPage() {
		return curPage;
	}

	public int getStart() {
		return start;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public boolean isNext() {
		return next;
	}

	public boolean isPrev() {
		return prev;
	}

}
