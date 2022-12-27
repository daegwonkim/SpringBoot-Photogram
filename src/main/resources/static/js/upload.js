// 해시 태그 추가, 삭제 로직
function addHashtag() {
	let hashtag = $("#hashtag").val();
	let item = getHashtagItem(hashtag);
	$("#hashtagList").append(item);
}

function removeHashtag(hashtag) {
	document.getElementById(hashtag).remove();
}

function getHashtagItem(hashtag) {
	let item =
		`<div class="hashtag" id="${hashtag}">
			<span>#${hashtag}</span>
			<button type="button" onclick="removeHashtag('${hashtag}')">×</button>
		</div>`
	
	return item;
}

// 스토리 이미지 업로드를 위한 사진 선택 로직
function imageChoose(obj) {
	let f = obj.files[0];

	if (!f.type.match("image.*")) {
		alert("이미지를 등록해야 합니다.");
		return;
	}

	let reader = new FileReader();
	reader.onload = (e) => {
		$("#imageUploadPreview").attr("src", e.target.result);
	}
	reader.readAsDataURL(f); // 이 코드 실행시 reader.onload 실행됨.
}