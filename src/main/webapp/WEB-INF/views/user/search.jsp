<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<main class="main">
	<section class="container">
		<!--전체 리스트 시작-->
		<article class="search-list" id="searchList">

			<!--전체 리스트 아이템-->
			<div class="search-summary">
				<div class="search-title" align="center">사람</div>
				<div class="search-count" align="center">${users.size()}명</div>
			</div>
			
			<c:forEach var="user" items="${users}">
				<div class="flex" style="width: 400px;">
					<img class="search-profile-img" src="/upload/${user.profile_image_url}" onerror="this.src='/images/person.jpeg'" />
					<div class="search-profile">
						<div class="search-profile-item">
							<h5 class="pointer" onclick="location.href='/user/${user.id}'">${user.name}</h5>
							<div class="search-profile-content">${user.bio}</div>
						</div>
					</div>
				</div>
				<br>
			</c:forEach>

		</article>
	</section>
</main>
<script src="/js/profile.js"></script>
</body>
</html>
