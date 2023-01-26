/*검색 탭*/
$(function() {
	$('.tabcontent > div').hide();
	$('.tabnav a').click(function() {
		$('.tabcontent > div').hide().filter(this.hash).fadeIn();
		$('.tabnav a').removeClass('active');
		$(this).addClass('active');
		return false;
	}).filter(':eq(0)').click();
	$(document).mouseup(function(e) {
		if($(".modal-search").has(e.target).length === 0) {
			$(".modal-search").css("display", "none");			
		}
	})
});

/*모달*/
function popup(obj, hashtag) {
	$(".sl__item__contents__tag").remove();
	
	let hashtagList = hashtag.split(",");

	hashtagList.forEach((hashtag) => {
		$(".sl__item__contents__tag__list").append(`<div class="sl__item__contents__tag">${hashtag}</div>`);
	});
	
	$(obj).css("display", "flex");
}

/* 모달창에서 댓글 쓰기 */
function addComment(imageId) {

	let commentInput = $(`#storyCommentInput-${imageId}`);
	let commentList = $(`#storyCommentList-${imageId}`);

	let data = {
		imageId: imageId,
		content: commentInput.val()
	}

	if (data.content === "") {
		alert("댓글을 작성해주세요!");
		return;
	}

	$.ajax({
		type: "POST",
		url: "/api/comment",
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		dataType: "json"
	}).done(resp => {
		let content =
			`<div class="sl__item__contents__comment" id="storyCommentItem-${resp.data.id}"> 
			    <p>
			      <b>${resp.data.user.username} :</b>
			      ${resp.data.content}
			    </p>
			    <button onclick="deleteComment(${resp.data.id})"><i class="fas fa-times"></i></button>
			</div>`;
		commentList.prepend(content);
	}).fail(error => {
		console.log(error);
	});
	
	commentInput.val("");
}

/* 모달창에서 댓글 삭제 */
function deleteComment(commentId) {
	$.ajax({
		type: "DELETE",
		url: `/api/comment/${commentId}`,
		dataType: "json"
	}).done(resp => {
		$(`#storyCommentItem-${commentId}`).remove();
	}).fail(error => {
		console.log(error);
	});
}