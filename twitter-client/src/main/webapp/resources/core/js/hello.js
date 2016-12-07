	//Handle if Long to short URL button is clicked
	
var main = function() {
	'use strict';
	
$("#searchBtn").click(function(){

		var val = $("#searchHashTag").val();
		//'%23'-->#
		if (val.indexOf('#') === -1) {
			val = '%23' +val;
		}
		console.log("hashtag:",val);
		//Send data to servlet
		$.ajax({
			url: "/hSearch/"+val,
			type: 'POST',
			data: {"hashTag":val},
			success: function(response) {
				console.log(response);
				var html='';
				for (var i = 0; i < response.length; i++) {
				      html+='<li>'+response[i]+ '</li>';
				    }
				    $('#result').html(html);
			}

		});
	});

};

function hiliter(word) {
    var rgxp = new RegExp(word, 'g');
    var repl = '<span class="myClass">' + word + '</span>';
    $('#result').html= $('#result').html().replace(rgxp, repl);
}
hiliter('kevin');
$(document).ready(main);