$(function(){
  $("#prckbn").on("change", () => {
    let url = $('form').attr("action")
    $('form').attr('action', url);
    $('form').append($('<input/>', {type: 'hidden', name: 'btn_changePrckbn', value: ''}))
    $('form').submit();
  });
});