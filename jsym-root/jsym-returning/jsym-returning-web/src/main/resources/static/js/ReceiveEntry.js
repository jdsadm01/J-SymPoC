$(function() {
/*
  $("#mytable button").on("click", function(e) {
    const target = $(this);
	var data = {
	  daikaiskbcod: $('#daikaiskbcod').val(),
	  kigbng: target.closest('tr').find('input[type!=hidden]:first').val(),
	  rowIndex: (target.closest('tr').index())/2
	};
    e.preventDefault();
    $.ajax({
      url: $('form').attr("action")+"/ajax",
      type: "POST",
      data: JSON.stringify(data),
      headers : {
　　　　　 　"X-CSRF-TOKEN": $("*[name=_csrf]").val()
　　　　 },
      contentType: 'application/json',
      dataType: "json"
    })
    .done(function(response) {
      const row1 = target.closest('tr');
      row1.find("td:nth-child(5)").text(response.tnaste);
      row1.find("td:nth-child(8)").text(response.hbidte);
      row1.find("td:nth-child(9)").text(response.tomrakcod);
      row1.find("td:nth-child(10)").text(response.setcod);
      row1.find("td:nth-child(11)").text(response.tnpkbn);
      const row2 = row1.next('tr');
      row2.find("td:first").text(response.hjihnb);
      row2.find("td:nth-child(2)").text(response.titnm+"／"+response.artnm);
      
      if(response.hjihnb == '品番エラーです。') {
		  row2.find("td:first").css('color','red');
		  playSound('warning');
	  } else {
		  row2.find("td:first").css('color','black');
	  }
      if(response.tnaste == '○') {
		  playSound('warning2');
	  }
    })
    .fail(function() {
      alert("error!");
    })
  });
*/
  $("#trncod").on("change", () => {
	  let url = $('form').attr("action")
	  $('form').attr('action', url);
	  $('form').append($('<input/>', {type: 'hidden', name: 'btn_changeTrncod', value: ''}))
	  $('form').submit();
  });
  
  $("input[name$='kigbng']").on("blur", function(e) {
    const target = $(this);
	var data = {
	  daikaiskbcod: $('#daikaiskbcod').val(),
	  kigbng: target.closest('tr').find('input[type!=hidden]:first').val(),
	  rowIndex: (target.closest('tr').index())/2
	};
    e.preventDefault();
    $.ajax({
      url: $('form').attr("action")+"/ajax",
      type: "POST",
      data: JSON.stringify(data),
      headers : {
　　　　　 　"X-CSRF-TOKEN": $("*[name=_csrf]").val()
　　　　 },
      contentType: 'application/json',
      dataType: "json"
    })
    .done(function(response) {
      const row1 = target.closest('tr');
      row1.find("td:nth-child(5)").text(response.tnaste);
      row1.find("td:nth-child(8)").text(response.hbidte);
      row1.find("td:nth-child(9)").text(response.tomrakcod);
      row1.find("td:nth-child(10)").text(response.setcod);
      row1.find("td:nth-child(11)").text(response.tnpkbn);
      const row2 = row1.next('tr');
      row2.find("td:first").text(response.hjihnb);
      row2.find("td:nth-child(2)").text(response.titnm+"／"+response.artnm);
      
      if(response.hjihnb == '品番エラーです。') {
		  row2.find("td:first").css('color','red');
		  playSound('warning');
	  } else {
		  row2.find("td:first").css('color','black');
	  }
      if(response.tnaste == '○') {
		  playSound('warning2');
	  }
    })
    .fail(function() {
      alert("error!");
    })
  });
});

function playSound(elementid){
  const audio = document.getElementById(elementid);
  if(audio == null) {
    return;
  }

  try{
    audio.pause();
    audio.currentTime = 0;
    audio.play();
  }catch(InvalidStateError){
    //合計数量エラー時にInvalidStateErrorが発生する場合がある
    console.log("InvalidStateError");
    audio.pause();
    audio.play();
  }
}