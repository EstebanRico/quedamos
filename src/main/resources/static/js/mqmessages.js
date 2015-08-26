(function (global) {

    /**
     * web sockets
     */

    global.stargui = global.stargui || {};
    global.stargui.ws = global.stargui.ws || {};
    var namespace = global.stargui.ws;
    const BASE_URL = global.stargui.BASE_URL;
    var stompClient;

    namespace.connect = function (mid) {
        var socket = new SockJS(BASE_URL + '/stargui');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/incoming/' + mid, function (data) {
                if ("THIS IS THE END" == data.body) {
                    disconnect();
                }
                else {
                    logMessage(data.body);
                }
            });
        });
    };

    //stompClient.send("/messages/deploy", {}, uuid);

    namespace.disconnect = function () {
        if (stompClient != null) {
            stompClient.disconnect();
        }
        console.log("Disconnected");
    };

    var ackMessage = function (message) {

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

})(window);