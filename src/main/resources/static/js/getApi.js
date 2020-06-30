function vowelsAndConsonants() {
    s="javascriptloops";
	let vowels=["a","e","i","o","u"];
	for(let v of s){
		if(vowels.includes(v)){
			console.log(v);
		}else{
			console.log(v);
		}
	}
}

	/* 	$('#json').click(function() {
			alert('json');
			$.getJSON("http://localhost:8082/getcontactus", function(data) {
				alert(data.id+"  "+data.fname+" "+data.query);
			});
		}); */
		
		const Http = new XMLHttpRequest();
		const url='http://localhost:8082/getcontactus';
		Http.open("GET", url);
		Http.send();

		Http.onreadystatechange = (e) => {
			alert(Http.responseText);
		  console.log(Http.responseText)
		}

/*		$(document).ready(function(){	
});*/