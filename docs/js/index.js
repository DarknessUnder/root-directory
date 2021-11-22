$(function () {

    //load navigation bar
    var state = true;
    $("#navBLeft").load("../../../../html/Components/nav.html");
    $("#navT").load("../../../../html/Components/navTop.html");
    $(".pageLink").click(function(){
        var link = "./html/" + $(this).attr("path") + ".html";
        window.location.href=link;
    });


    //hide navigation bar
    $(".landing-page").click(function () {
        if(state){
            $("#navLeft").remove();
            $("#navBLeft").load("../../../../html/Components/navEmpty.html");
            state = false;
        }
        else{
            state = true;
        }
    });

    $(".profile-page").click(function () {
        if(state){
            $("#navLeft").remove();
            $("#navBLeft").load("../../../../html/Components/navEmpty.html");
            state = false;
        }
        else{
            state = true;
        }
    });

//display navigation bar
    $("#navBLeft").click(function () {
        if(!state){
            $("#navEmpty").remove();
            $("#navBLeft").load("../../../../html/Components/nav.html");
            
        }
        state = false;
    });




    $(".subPage").click(function () {
        var link = "";
        if($(this).attr("subtype") === "Classes")
        {
            link = "../../../html/" + $(this).attr("subtype") + "/" + $("body").attr("name") + ".html";
        }
        else{
            link = "../../../html/" + $(this).attr("subtype") + "/" + $(this).attr("subtype") + "-" + $("body").attr("name") + ".html";
        }
        window.location.href=link;
    });
});

