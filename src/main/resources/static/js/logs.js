$(function () {
$("#next").click(function () {
    var url=$(this).attr("data-url")
    htmlobj=$.ajax({url:url,async:false});
    $("#contents").html(htmlobj.responseText);
})
    $("#up").click(function () {
        var url=$(this).attr("data-url")
        htmlobj=$.ajax({url:url,async:false});
        $("#contents").html(htmlobj.responseText);
    })
    $("#first").click(function () {
        var url=$(this).attr("data-url")
        htmlobj=$.ajax({url:url,async:false});
        $("#contents").html(htmlobj.responseText);
    })
    $("#last").click(function () {
        var url=$(this).attr("data-url")
        htmlobj=$.ajax({url:url,async:false});
        $("#contents").html(htmlobj.responseText);
    })
})