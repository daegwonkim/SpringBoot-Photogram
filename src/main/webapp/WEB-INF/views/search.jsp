<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>

<main class="main">
	<section class="container">
		<!--전체 리스트 시작-->
		<article class="search-list" id="searchList">

			<!--전체 리스트 아이템-->
			<ul class="nav nav-tabs" style="width: 128.2px; margin: auto;">
				<li class="nav-item"><a class="nav-link active" data-toggle="tab" href="#person">사람</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#tag">태그</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane fade show active" id="person">
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
				</div>
				<div class="tab-pane fade" id="tag">
					<div class="search-summary">
						<div class="search-title" align="center">태그</div>
						<div class="search-count" align="center">${images.size()}개</div>
					</div>

					<section id="tab-content">
						<!--게시물컨컨테이너-->
						<div class="profileContainer">
							<!--그냥 감싸는 div (지우면이미지커짐)-->
							<div id="tab-1-content" class="tab-content-item show">
								<!--게시물컨 그리드배열-->
								<div class="tab-1-content-inner">
					
									<!--아이템들-->
					
									<c:forEach var="image" items="${images}">
										<div class="img-box">
											<a href=""> <img src="/upload/${image.post_image_url}" />
											</a>
											<div class="comment">
												<a href="#" class=""> <i class="fas fa-heart"></i><span>${image.likesCount}</span>
												</a>
											</div>
										</div>
									</c:forEach>
					
									<!--아이템들end-->
								</div>
							</div>
						</div>
					</section>
				</div>
			</div>

		</article>
	</section>
</main>
<script src="/js/profile.js"></script>
</body>
</html>
