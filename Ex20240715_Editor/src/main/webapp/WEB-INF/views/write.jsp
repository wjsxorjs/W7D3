<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write</title>
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/summernote-lite.css">
</head>
<body>
	<div id="box">
		<header>
			<h1>글쓰기</h1>
		</header>
		<form action="write" method="post" enctype="multipart/form-data">
			<table summary="글쓰기 테이블">
				<caption>글쓰기</caption>
				<tbody>
					<tr>
						<th>제목:</th>
						<td>
							<input type="text" name="subject" />
						</td>
					</tr>
					<tr>
						<th>이름:</th>
						<td>
							<input type="text" name="writer" />
						</td>
					</tr>
					<tr>
						<th>내용:</th>
						<td>
							<textarea name="content" cols="50" rows="15" id="content"></textarea>
						</td>					
					</tr>
					<tr>
						<td colspan="2">
							<button type="button" onclick="exe()">보내기</button>
						</td>					
					</tr>
				</tbody>
				
			</table>
		
		</form>
		
	</div>
	
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="resources/js/summernote-lite.js" type="text/javascript"></script>	
<script type="text/javascript">
	$(function(){
		// 아이디가 content인 요소를 에디터로 표현
		$("#content").summernote();
	});
</script>
</body>
</html>