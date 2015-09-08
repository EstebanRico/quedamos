(function (global) {

    global.stargui = global.stargui || {};
    global.stargui.ws = global.stargui.ws || {};
    var $ws = global.stargui.ws;
    const BASE_URL = global.stargui.BASE_URL;

    const onConnectionLeverChange = function () {
        console.log("onConnectionLeverChange");
        const $connectionCheckBox = $("#connectionCheckBox");
        const $contents = $("#contents");
        var isFormValid = document.getElementById('connectionForm').checkValidity();
        const mid = $("#midInput").val();
        if (!isFormValid) {
            console.log("not valid !");
            $connectionCheckBox.prop('checked', false);
            $contents.hide();
        } else {
            if ($connectionCheckBox.prop('checked') == false) {
                disconnectFromQueue(mid, $contents, $connectionCheckBox);
            } else {
                connectToQueue(mid, $contents, $connectionCheckBox);
            }
        }
    };

    const disconnectFromQueue = function (mid, $contents, $connectionCheckBox) {
        $.ajax({
            type: "DELETE",
            url: BASE_URL + "/channels/" + mid
        }).done(function (data) {
            console.log("disconnected !");
            $contents.hide();
        }).fail(function (data) {
            console.log("FAIL");
            console.log(data);
            $connectionCheckBox.prop('checked', false);
        });
    };

    const connectToQueue = function (mid, $contents, $connectionCheckBox) {
        $.ajax({
            type: "POST",
            url: BASE_URL + "/channels/" + mid
        }).done(function (data) {
            console.log("connected !");
            $contents.slideDown("slow");
            $ws.connect(mid);
        }).fail(function (data) {
            console.log("FAIL");
            console.log(data);
            $connectionCheckBox.prop('checked', false);
            $contents.hide();
        });
    };

    const onSendBtnClick = function () {
        console.log("onSendBtnClick");
        var messageMQ = $("#textarea1").val();
        const mid = $("#midInput").val();
        $.ajax({
            type: "POST",
            url: BASE_URL + "/channels/" + mid + "/send",
            contentType: "text/plain; charset=UTF-8",
            data: messageMQ
        }).done(function (data) {
            console.log("send ok !");
        }).fail(function (data) {
            console.log("FAIL");
            console.log(data);
        });
        return false;
    };

    const onIdentifyBtnClick = function () {
        console.log("onIdentifyBtnClick");
        var messageMQ = $("#textarea1").val();
        const mid = $("#midInput").val();
        $.ajax({
            type: "POST",
            url: BASE_URL + "/channels/" + mid + "/send",
            contentType: "text/plain; charset=UTF-8",
            data: messageMQ
        }).done(function (data) {
            console.log("send ok !");
        }).fail(function (data) {
            console.log("FAIL");
            console.log(data);
        });
        return false;
    };

    /**
     * utility (logs)
     */
    const logger = function () {
        var oldConsoleLog = null;
        var pub = {};

        pub.enableLogger = function enableLogger() {
            if (oldConsoleLog == null)
                return;

            window['console']['log'] = oldConsoleLog;
        };

        pub.disableLogger = function disableLogger() {
            oldConsoleLog = console.log;
            window['console']['log'] = function () {
            };
        };

        return pub;
    }();

    logger.disableLogger();
    logger.enableLogger();

    var disconnect = function () {
        if (stompClient != null) {
            stompClient.disconnect();
        }
        console.log("Disconnected");
    };

    var logMessage = function (message) {
        console.log(message);
        $("#logsContents").prepend("<li class=\"collection-item avatar\">" +
        new Date() +
        "<span class=\"title\">" + message.mid + "</span>" +
        "<p>" + message.msgType + "<br/>" +
        message.entity + "</p>" +
        "</li>");
    };


    // bindings
    $("#connectionCheckBox").bind("change", onConnectionLeverChange);
    $("#identifyButton").bind("click", onIdentifyBtnClick);
    $('.modal-trigger').leanModal();
    $(".dropdown-button").dropdown();
    $('select').material_select();

})(window);