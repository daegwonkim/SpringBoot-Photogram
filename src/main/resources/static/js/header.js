$(function() {
	$("#search").keyup(function() {
		let keyword = $("#search").val();
		
		/* 입력 상자가 비어있을 경우 */
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
			
			resp.data.forEach((user) => {
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