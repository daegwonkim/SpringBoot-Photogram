$(function() {
	$("#search").keyup(function() {
		let keyword = $("#search").val();
		
		/* 검색 상자가 비어있을 경우 */
		if(!keyword) {
			$(".relative-keyword > ul").remove();
		}
		
		$.ajax({
			type: "GET",
			url: `/api/relative/${keyword}`
		}).done(resp => {
			let relative_keyword = $(".relative-keyword");
			$(".relative-keyword > ul").remove();
			
			let ul = document.createElement("ul");
			
			console.log(resp);
			
			let tags = [];
			resp.data.relativeTagDto.forEach((image) => {
				let tagList = image.hashtag.split(",");
				tagList.forEach((tag) => {
					if(tag.startsWith("#" + keyword)) {
						tags.push(tag);
					}
				});
			});
			
			let set = new Set(tags);
			let uniqueTags = [...set];
			console.log(uniqueTags);
			
			uniqueTags.forEach((tag) => {
				let li = document.createElement("li");
				li.textContent = tag;
				ul.append(li);
			});
			
			resp.data.relativeUserDto.forEach((user) => {
				let li = document.createElement("li");
				li.textContent = user.name;
				ul.append(li);
			});
			
			relative_keyword.append(ul);
			relative_keyword[0].style.display = "block";
		}).fail(error => {
			console.log(error);
		});
	});
});