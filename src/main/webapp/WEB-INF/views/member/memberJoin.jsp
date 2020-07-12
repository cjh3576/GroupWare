<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="memberVO" id="form">
		<table>
			<tbody>
				<tr>
					<th>아이디(ID)<span>*</span></th>
					<td><form:input path="id" id="id" cssClass="empty_check" /><span
						class="sub">영문 + 숫자 혼용 6~20자</span></td>
				</tr>
				<tr>
					<td></td>
					<td><div>
							<form:errors path="id" />
						</div>
						<div id="id_result"></div></td>
				</tr>
				<tr>
					<th>비밀번호<span>*</span></th>
					<td><form:password path="pw" id="pw" cssClass="empty_check" /><span
						class="sub">영어, 숫자, 특수문자(!@#$%^*+=-) 3가지 조합으로 10~15자 이여야
							합니다.</span></td>
				</tr>
				<tr>
					<td></td>
					<td><div>
							<form:errors path="pw" />
						</div>
						<div id="pw_result"></div></td>
				</tr>
				<tr>
					<th>성명(한글)<span>*</span></th>
					<td><form:input path="name" id="name" cssClass="empty_check" /></td>
				</tr>
				<tr>
					<td></td>
					<td><div>
							<form:errors path="name" />
						</div>
						<div id="name_result"></div></td>
				</tr>
				<tr>
					<th>주민등록번호<span>*</span></th>
					<td><form:input path="regnum" id="regnum"
							cssClass="empty_check" /></td>
				</tr>
				<tr>
					<th>핸드폰번호<span>*</span></th>
					<td><form:input path="phone" id="phone" cssClass="empty_check" />
					</td>
				</tr>
				<tr>
					<th>이메일<span>*</span></th>
					<td id="email"><form:input path="email" id="email"
							cssClass="empty_check" /> <br>
					<span class="sub_2">하나의 아이디에 하나의 이메일 주소를 사용하며, 이메일 주소는 비밀번호
							찾기 또는 인터넷 예약 등의 용도에 사용됩니다.</span><br></td>
				</tr>
				<tr>
					<th>성별<span>*</span></th>
					<td id="gender"><form:radiobutton path="gender" value="1"
							id="man" cssClass="empty_check" /><span>남자</span>
					<form:radiobutton path="gender" value="2" id="woman"
							cssClass="empty_check" /><span>여자</span></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><div>
							<form:errors path="gender" />
						</div>
						<div id="gender_result"></div></td>
				</tr>
				<tr>
					<th>나이</th>
					<td><form:input path="age" id="age" cssClass="empty_check"
							readonly="true" /></td>
				</tr>
				<tr>
					<td></td>
					<td><div>
							<form:errors path="age" />
						</div>
						<div id="age_result"></div></td>
				</tr>
				<tr>
					<td></td>
					<td><div>
							<form:errors path="age" />
						</div>
						<div id="age_result"></div></td>
				</tr>
				<tr>
					<th>소속부서<span>*</span></th>
					<td><form:input path="team" id="team" cssClass="empty_check" />
					</td>
				</tr>
				<tr>
					<th>직급<span>*</span></th>
					<td><form:input path="rank" id="rank" cssClass="empty_check" />
					</td>
				</tr>
			</tbody>
		</table>

		<button id="join">가입완료</button>
	</form:form>
</body>
</html>