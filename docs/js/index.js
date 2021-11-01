$(function () {
    $("#navBLeft").load("nav.html");
    $(".pageLink").click(function(){
        var link = "" + $(this).text().toLowerCase() + ".html";
        window.location.href=link;
    });
    
  });