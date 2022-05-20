package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SearchDao;
import vo.Product;


@WebServlet("/searchController")
public class SearchController extends HttpServlet {
	private SearchDao searchDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/search/search.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 입력받은 텍스트 설정
 		String name = ""; // 글자로 검색을 안했을때;
 		// 값을 입력 받았을때 
		if(request.getParameter("name") != null) {
			// 로그인 안되어있을시에 LoginController 이동
			name = request.getParameter("name");
		}
		// -----------------------------디버깅-----------------------------
		System.out.println(name + " <-- name doPost() searchController");	
						
		// 시작가격과 끝 가격을 가져옴
		int priceBefore = 0; // 가격입력을 안하면 시작 가격 0원
		int priceAfter = 0; // 가격입력을 안하면 끝 가격 999999원
		if(request.getParameter("priceBefore") != null) {
			priceBefore = Integer.parseInt(request.getParameter("priceBefore"));
		}
		
		if(request.getParameter("priceAfter") != null) {
			priceAfter = Integer.parseInt(request.getParameter("priceAfter"));
		}else {
			priceAfter = 999999;
		}
		// -----------------------------디버깅-----------------------------
		System.out.println(priceBefore+"원부터 " + priceAfter +"원 까지"+ " <-- priceBefore,priceAfter doPost() searchController");	
			
		// 용량 시작 부분
		int volumeBefore = 0; // 선택이 안되면 
		if(request.getParameter("volumeBefore") != null) {
			volumeBefore = Integer.parseInt(request.getParameter("volumeBefore"));
		}
		// 용량 끝 부분
		int volumeAfter = 9999; // 선택이 안되면 	
		if(request.getParameter("volumeAfter") != null) {
			volumeAfter = Integer.parseInt(request.getParameter("volumeAfter"));
		}
		// -----------------------------디버깅-----------------------------
		System.out.println(volumeBefore+"ml" + volumeBefore +"ml <-- volumeBefore,volumeBefore doPost() searchController");	
		
		// 색상을 JSP에서 입력받은값 가져오기
		String color = "";
		if(request.getParameter("color") != null) {
			color = request.getParameter("color");
		}	
		// -----------------------------디버깅-----------------------------
		System.out.println(color+ "색 <-- color doPost() searchController");	

		// 도수를 JSP에서 입력받은 시작 부분 가져오기
		int alcoholLevelBefore = 0; // 선택이 안되면 
		if(request.getParameter("alcoholLevelBefore") != null) {
			alcoholLevelBefore = Integer.parseInt(request.getParameter("alcoholLevelBefore"));
		}
		// 도수를 JSP에서 입력받은 끝 부분 가져오기
		int alcoholLevelAfter = 100; // 선택이 안되면 	
		if(request.getParameter("alcoholLevelAfter") != null) {
			alcoholLevelAfter = Integer.parseInt(request.getParameter("alcoholLevelAfter"));
		}
		// -----------------------------디버깅-----------------------------
		System.out.println(alcoholLevelBefore+"도" + alcoholLevelAfter +"도 <-- alcoholLevelBefore,alcoholLevelAfter doPost() searchController");	 
		
		// 당도를 JSP에서 입력받은 시작 부분 가져오기
		int sweetBefore = 0; // 선택이 안되면 
		if(request.getParameter("sweetBefore") != null) {
			sweetBefore = Integer.parseInt(request.getParameter("sweetBefore"));
		}
		// 당도를 JSP에서 입력받은 끝 부분 가져오기
		int sweetAfter = 100; // 선택이 안되면 	
		if(request.getParameter("sweetAfter") != null) {
			sweetAfter = Integer.parseInt(request.getParameter("sweetAfter"));
		}
		// -----------------------------디버깅-----------------------------
		System.out.println(sweetBefore+"단계" + sweetAfter +"단계 <-- sweetBefore,sweetAfter doPost() searchController");	 
		
		// 숙성도를 JSP에서 입력받은 시작 부분 가져오기
		int maturityBefore = 0; // 선택이 안되면 
		if(request.getParameter("maturityBefore") != null) {
			maturityBefore = Integer.parseInt(request.getParameter("maturityBefore"));
		}
		// 숙성도를 JSP에서 입력받은 끝 부분 가져오기
		int maturityAfter = 100; // 선택이 안되면 	
		if(request.getParameter("maturityAfter") != null) {
			maturityAfter = Integer.parseInt(request.getParameter("maturityAfter"));
		}
		// -----------------------------디버깅-----------------------------
		System.out.println(maturityBefore+"단계" + maturityAfter +"단계 <-- maturityBefore,maturityAfter doPost() searchController");	 

		// 산미를 JSP에서 입력받은 시작 부분 가져오기
		int acidityBefore = 0; // 선택이 안되면 
		if(request.getParameter("acidityBefore") != null) {
			acidityBefore = Integer.parseInt(request.getParameter("acidityBefore"));
		}
		// 산미를 JSP에서 입력받은 끝 부분 가져오기
		int acidityAfter = 100; // 선택이 안되면 	
		if(request.getParameter("acidityAfter") != null) {
			acidityAfter = Integer.parseInt(request.getParameter("acidityAfter"));
		}
		// -----------------------------디버깅-----------------------------
		System.out.println(acidityBefore+"단계" + acidityAfter +"단계 <-- acidityBefore,acidityAfter doPost() searchController");	 

		// 바디감을 JSP에서 입력받은 끝 부분 가져오기
		int thinBefore = 0; // 선택이 안되면 
		if(request.getParameter("thinBefore") != null) {
			thinBefore = Integer.parseInt(request.getParameter("thinBefore"));
		}
		// 바디감을 JSP에서 입력받은 끝 부분 가져오기
		int thinAfter = 100; // 선택이 안되면 	
		if(request.getParameter("thinAfter") != null) {
			thinAfter = Integer.parseInt(request.getParameter("thinAfter"));
		}
		// -----------------------------디버깅-----------------------------
		System.out.println(thinBefore+"단계" + thinAfter +"단계 <-- thinBefore,thinAfter doPost() searchController");	 
		
		// 청량감을 JSP에서 입력받은 끝 부분 가져오기
		int refreshmentBefore = 0; // 선택이 안되면 
		if(request.getParameter("refreshmentBefore") != null) {
			refreshmentBefore = Integer.parseInt(request.getParameter("refreshmentBefore"));
		}
		// 청량감을 JSP에서 입력받은 끝 부분 가져오기
		int refreshmentAfter = 100; // 선택이 안되면 	
		if(request.getParameter("refreshmentAfter") != null) {
			refreshmentAfter = Integer.parseInt(request.getParameter("refreshmentAfter"));
		}
		// -----------------------------디버깅-----------------------------
		System.out.println(refreshmentBefore+"단계" + refreshmentAfter +"단계 <-- refreshmentBefore,refreshmentAfter doPost() searchController");	 

		searchDao = new SearchDao();
		
		HashMap<String, Object> m = new HashMap<>();

		m.put("name", name);
		m.put("priceAfter", priceAfter);
		m.put("priceBefore", priceBefore);
		m.put("volumeBefore", volumeBefore);
		m.put("volumeAfter", volumeAfter);
		m.put("color", color);
		m.put("alcoholLevelBefore", alcoholLevelBefore);
		m.put("alcoholLevelAfter", alcoholLevelAfter);
		m.put("sweetBefore", sweetBefore);
		m.put("sweetAfter", sweetAfter);
		m.put("maturityBefore", maturityBefore);
		m.put("maturityAfter", maturityAfter);
		m.put("acidityBefore", acidityBefore);
		m.put("acidityAfter", acidityAfter);
		m.put("thinBefore", thinBefore);
		m.put("thinAfter", thinAfter);
		m.put("refreshmentBefore", refreshmentBefore);
		m.put("refreshmentAfter", refreshmentAfter);
		
		// 인기순(order주문 순으로 보여주기)
		List<Map<String,Object>> searchResultList = searchDao.searchSelectProduct(m); 

		for(Map hash : searchResultList) {
			System.out.println(hash.get("productNo") + " <-- productNo doPost() searchController");
			System.out.println(hash.get("name") + " <-- name doPost() searchController");
			System.out.println(hash.get("picture") + " <-- picture doPost() searchController");
			System.out.println(hash.get("price") + " <-- price doPost() searchController");
			System.out.println(hash.get("volume") + " <-- volume doPost() searchController");
			System.out.println(hash.get("alcoholLevel") + " <-- alcoholLevel doPost() searchController");
		}
		
		// 검색결과 리스트
		request.setAttribute("searchResultList", searchResultList);
		request.getRequestDispatcher("/WEB-INF/view/search/search.jsp").forward(request, response);
	}

}
