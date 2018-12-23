<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		$('#delBtn').click(function() {
			if (confirm('정말로 탈퇴하시겠습니까?')) {
				$.ajax({
					url : '${root}/member/users/${user.userid}',
					type : 'DELETE',
					contentType : 'application/json;charset=utf-8',
					dataType : 'json',
					success : function(response) {
						console.log(response.result);
						$(location).attr('href', '${root}/member/logout.cafe');
					},
					error : function(xhr, status, msg) {
						console.log("상태값:" + status + "HTTP에러 메시지:" + msg);
					}
				});
			}
		});

		$.ajax({
			url : "${root}/member/users",
			type : "PUT",
			dataType : "json",
			data : data,
			contentType : "application/json;charset=UTF-8",
			mimeType : "application/json",
			success : function(response) {
				$('#registerModal').modal('hide');
				$(location).attr('href', '${root}/member/view.cafe');
			},
			error : function(xhr, status, message) {
				alert("status:" + status + "error:" + message);
			}
		});
	</script>
</body>
</html>