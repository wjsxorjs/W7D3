<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dept_list</title>
<style>
	#box table{
	width: 550px;
	margin-left: 10px;
	border: 1px solid black;
	border-collapse: collapse;
	font-size: 13px;
	}
	
	#box table th, #box table td{
	text-align: center;
	border: 1px solid black;
	padding: 4px;
	}
</style>
</head>
<body>
	<div id="box">
		<header>
			<h1>부서목록</h1>
		</header>
		<table>
			<caption>부서목록</caption>
			<thead>
				<tr>
					<td colspan="3">
						<form action="dept" method="post">
							<select name="searchType">
								<option value="1" ${searchType == 1 ? 'selected' : '' } >부서번호</option>
								<option value="2" ${searchType == 2 ? 'selected' : '' }>부서명</option>
							</select>
							<input type="text" name="searchValue" value="${searchValue }">
							<button type="button" onclick="valid()">검색</button>
							<button type="button" onclick="list()">전체</button>
						</form>
					</td>
				</tr>
				<tr>
					<th>부서코드</th>
					<th>부서명</th>
					<th>부서위치코드</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="dvo" items="${d_ar }">
				<tr>
					<td>${dvo.deptno }</td>
					<td>${dvo.dname }</td>
					<td>${dvo.loc_code }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	
	<script>
	function valid(){
		let searchValue = document.forms[0].searchValue;
		let keyword = searchValue.value.trim();
		if(keyword.length == 0 || keyword == ""){
			alert("검색어를 입력해주세요.");
			searchValue.value = "";
			searchValue.focus();
			return;
		}
		
		
		document.forms[0].submit();
	}	
	function list(){
		document.forms[0].searchType.value = "";
		document.forms[0].searchValue.value = "";
		document.forms[0].action = "dept";
		
		document.forms[0].submit();
	}	
		
	</script>
	
</body>
</html>