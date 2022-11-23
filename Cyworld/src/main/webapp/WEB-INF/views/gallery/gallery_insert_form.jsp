<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사진첩 새글쓰기</title>

<script>
	function send(f){
		
		var galleryContent = f.galleryContent.value;
		
		//유효성 체크
		if( galleryContent == '' ){
			alert("내용 입력은 필수입니다.");
			return;
		}
		
		f.action = "insert.do";
		f.method = "post";
		f.submit();
	}
</script>

</head>
<body>
	<!-- 파일전송시 
	enctype="multipart/form-data"
	method="post"
	속성이 필수적으로 추가되어 있어야 한다 -->
	<form method="post" enctype="multipart/form-data">
		<table border="1" align="center">
			<caption>새 글 쓰기</caption>
			
			<tr>
				<th>내용</th>
				<td><textarea rows="5" cols="50" name="galleryContent"></textarea></td>
			</tr>
			
			<tr>
				<th>파일첨부</th>
				<td><input type="file" name="galleryFile"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="글쓰기" onclick="send(this.form);">
					<input type="button" value="취소" onclick="location.href='list.do'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>














