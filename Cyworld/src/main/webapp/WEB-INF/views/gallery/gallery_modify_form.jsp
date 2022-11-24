<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사진첩 수정</title>

	<!-- Ajax활용을 위한 js파일 로드 -->
	<script src="/cyworld/resources/js/httpRequest.js"></script>

	<script>
		function send(f){
			//encodeURIComponent : 특수문자가 포함되어 있는 경우에 내용을 그대로 서버로 전달하기 위해
			//존재하는 메서드
			
			var url = "gallery_modify.do";
			var param = "galleryContentRef="+f.galleryContentRef.value +
			            "&galleryContent="+ encodeURIComponent(f.galleryContent.value) +
			            "&galleryFileName=" + encodeURIComponent(f.galleryFileName.value);
			sendRequest( url, param, sendCallback, "POST");
			
		}
		
		function sendCallback(){
			
			if( xhr.readyState == 4 && xhr.status == 200 ){
				//"{'result':'no'}"
				var data = xhr.responseText;
				
				//문자열 구조로 넘어온 data를 실제 JSON타입으로 변경
				var json = (new Function('return'+data))();
				
				if( json.result == 'no' ){
					alert("수정실패");
					return;
				}
				
				alert("수정성공");
				location.href="gallery_list.do";
				
			}
			
		}
		
		
	</script>
	
	

</head>
<body>
	<form method="post" enctype="multipart/form-data">
		<input type="hidden" name="galleryContentRef" value="${ vo.galleryContentRef }">
		
		<table border="1" align="center">
		
			<caption>사진첩 수정</caption>
			
			<tr>
				<th>내용</th>
				<td><pre><textarea rows="5" cols="50" name="galleryContent">${vo.galleryContent}</textarea></pre></td>
			</tr>
			
			<tr>
				<th>파일첨부</th>
				<td><input type="file" name="galleryFileName">${vo.galleryFileName}  </td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="수정" onclick="send(this.form);">
					<input type="button" value="취소" onclick="location.href='gallery_list.do'">
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>