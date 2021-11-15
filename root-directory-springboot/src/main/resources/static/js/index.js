$(function () {
    var state = true;
    $("#navBLeft").load("nav.html");
    $(".pageLink").click(function(){
        var link = "" + $(this).text().toLowerCase() + ".html";
        window.location.href=link;
    });

    $(".landing-page").click(function () {
        if(state){
            $("#navLeft").remove();
            $("#navBLeft").load("navEmpty.html");
            state = false;
        }
        else{
            state = true;
        }
    });

    $("#navBLeft").click(function () {
        if(!state){
            $("#navEmpty").remove();
            $("#navBLeft").load("nav.html");
            
        }
        state = false;
    });

    $(".profile-page").click(function () {
        if(state){
            $("#navLeft").remove();
            $("#navBLeft").load("navEmpty.html");
            state = false;
        }
        else{
            state = true;
        }
    });


    
  });

