$(function() {
/*
  $("form").on("submit", function(e) {
    const target = $(this);
    e.preventDefault();
    $.ajax({
      url: $('form').attr("action")+"/checksession",
      type: "GET",
      headers : {
　　　　　 　"X-CSRF-TOKEN": $("*[name=_csrf]").val()
　　　　 }
    })
    .done(function(response) {
      if (response != "423") {
        alert("ちぇっくOK！")
        target.off( 'submit' );
        target.submit();
      } else {
        alert("じかんぎれ！")
      }
        return false;
    })
  });
*/
});

function sendForm(n){
  const form = $('form[name!="userconfirm"]');
  $('form[name!="userconfirm"]').append($('<input/>', {type: 'hidden', name: n, value: ''}))
  $.ajax({
    url: $('form[name!="userconfirm"]').attr("action")+"/checksession",
    type: "POST",
    headers : {
　　　　 　"X-CSRF-TOKEN": $("*[name=_csrf]").val()
　　　 }
  })
  .done(function(response) {
    if (response != "423") {
      alert("ちぇっくOK！")
      form.submit();
    } else {
      const showModalButton = document.getElementById("showModal");
      showModalButton.dispatchEvent(new Event("click"));
      /*
      const myModalEl = document.querySelector('#showModal')
      const modal = new bootstrap.Modal(myModalEl) // initialized with defaults
      modal.show()
      */
    }
    return false;
  })
}

function confirmuser(){
  const form = $('form[name!="userconfirm"]');
  var data = {
    usrid: $('#usrid').val(),
    pwd: $('#password').val(),
    count: $('#count').val()
  };
  /*
  const closeModalButton = document.getElementById("confirmClose");
  closeModalButton.dispatchEvent(new Event("click"));
  */
  /*
  const myModalEl = document.querySelector('#showModal')
  const modal = new bootstrap.Modal(myModalEl) // initialized with defaults
  modal.hide()
  */

  $.ajax({
    url: $('form[name!="userconfirm"]').attr("action")+"/confirmuser",
    type: "POST",
    data: JSON.stringify(data),
    headers : {
　　　　 　"X-CSRF-TOKEN": $("*[name=_csrf]").val()
　　　 },
    contentType: 'application/json'
  })
  .done(function(response) {
    if (response == "0") {
      alert("ちぇっくOK！")
      form.submit();
    } else {
      alert("ちがうよ！")
      $('#count').val(response);
      $('#usrid').val("");
      $('#password').val("");
      /*
      const showModalButton = document.getElementById("showModal");
      showModalButton.dispatchEvent(new Event("click"));
      */
      /*
      modal.show()
      */
    }
    return false;
  })
}