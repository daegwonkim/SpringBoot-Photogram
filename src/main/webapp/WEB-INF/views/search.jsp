<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>

<main class="main" style="height: 290px;">
	<section class="container">
		<!--전체 리스트 시작-->
		<article class="search-list" id="searchList">

			<div class="tab">
				<ul class="tabnav">
					<li><a href="#person">사람</a></li>
					<li><a href="#tag">태그</a></li>
				</ul>
				<div class="tabcontent">
					<div id="person">
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
					<div id="tag">
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
											<div class="img-box" onclick="popup('#modal-search-${image.id}', '${image.hashtag}')">
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
			</div>

		</article>
	</section>

	<c:forEach var="image" items="${images}">
		<div class="modal-search" id="modal-search-${image.id}" onclick="modalSearch()">
			<div class="modal">
				<div class="story-list__item">
					<div class="sl__item__header">
						<div>
							<img class="profile-image" src="/upload/${image.user.profile_image_url}" onerror="this.src='/images/person.jpeg'">
						</div>
						<div>${image.user.name}</div>
					</div>

					<div class="sl__item__img">
						<img src="/upload/${image.post_image_url}">
					</div>

					<div class="sl__item__contents">
						<div class="sl__item__contents__icon">
							<button>
								<i class="far fa-heart" id="storyLikeIcon-6" onclick="toggleLike(6)"></i>
							</button>

							<span class="like"><b id="storyLikeCount-6">${image.likesCount}</b>likes</span>
						</div>

						<div class="sl__item__contents__content">
							<p>${image.caption}</p>
						</div>

						<div class="sl__item__contents__tag__list">
							
						</div>

					</div>
				</div>
			</div>
		</div>
	</c:forEach>

	<script src="/js/search.js"></script>
</main>
</body>
</html>
