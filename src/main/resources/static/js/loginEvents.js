/*(function (global) {

   const BASE_URL = global.stargui.BASE_URL;

    const onIdentifyBtnClick = function () {
        console.log("La méthode onIdentifyBtnClick est appelé");
        var mail = $("#email").val();
        var pass = $("#password").val();
        console.log("Mail:"+mail+"\nPass:"+pass);
        $.ajax({
            url: BASE_URL +  "/login" ,
            type: 'POST',
            dataType:'json',
            contentType: 'application/json',
            mimeType: 'application/json',
            data: JSON.stringify({mail:mail,pass:pass})
        }).done(function (data) {
            console.log("send OK, return:"+data+" !");
            if (data){
                console.log("true");

            }else{
                console.log("false");

            }
        }).fail(function (data) {
            console.log("FAIL");
            console.log(data);
        });
        return false;
    };

    // bindings
    $("#identifyButton").bind("click", onIdentifyBtnClick);

})(window);*/