package mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mybatis.vo.DeptVO;

@Component
public class DeptDAO {

	@Autowired
	private SqlSessionTemplate ss;
	
	public DeptVO[] getList() {
		DeptVO[] d_ar = null;
		
		List<DeptVO> d_list = ss.selectList("dept.list");
		
		if(d_list != null && d_list.size()>0) {
			d_ar = new DeptVO[d_list.size()];
			
			d_list.toArray(d_ar);
		}
		
		return d_ar;
	}
	
	public DeptVO[] search(String searchType, String searchValue) {
		DeptVO[] d_ar = null;
		
		Map<String, String> d_map = new HashMap<String, String>();
		d_map.put("searchType", searchType);
		d_map.put("searchValue", searchValue);
		
		List<DeptVO> d_list = ss.selectList("dept.search",d_map);
		
		if(d_list != null && d_list.size()>0) {
			d_ar = new DeptVO[d_list.size()];
			
			d_list.toArray(d_ar);
		}
		
		return d_ar;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}