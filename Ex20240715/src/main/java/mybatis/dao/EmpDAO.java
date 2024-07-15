package mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mybatis.vo.EmpVO;

@Component
public class EmpDAO {
	
	@Autowired
	private SqlSessionTemplate ss;
	
	// 사원들을 배열로 반환하는 기능
	public EmpVO[] getList() {
		EmpVO[] e_ar = null;
		
		List<EmpVO> e_list = ss.selectList("emp.all");
		// list가 null이 아니고 비어있지 않다면
		if(e_list != null && e_list.size()>0) {
			e_ar = new EmpVO[e_list.size()];
			// e_list의 요소를 비어있는 배열에 복사한다.
			e_list.toArray(e_ar);
		}
		
		
		return e_ar;
	}
	
	public EmpVO[] getSearch(String searchType, String searchValue) {
		EmpVO[] e_ar = null;
		
		Map<String, String> e_map = new HashMap<String, String>();
		e_map.put("searchType", searchType);
		e_map.put("searchValue", searchValue);
		
		List<EmpVO> e_list = ss.selectList("emp.search",e_map);
		// list가 null이 아니고 비어있지 않다면
		if(e_list != null && e_list.size()>0) {
			e_ar = new EmpVO[e_list.size()];
			// e_list의 요소를 비어있는 배열에 복사한다.
			e_list.toArray(e_ar);
		}
		
		return e_ar;
	}
	
	
	
}
