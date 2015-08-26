(function (global) {

    global.stargui = global.stargui || {};

    function checkTime(i) {
        return (i < 10) ? "0" + i : i;
    }

    function startTime() {
        var today = new Date(),
            h = checkTime(today.getHours()),
            m = checkTime(today.getMinutes()),
            s = checkTime(today.getSeconds());
        var sinceMidnight = h * 3600 + m * 60 + s * 1;
        global.stargui.time = sinceMidnight;
        document.getElementById('time').innerHTML = "<span class='flow-text'>" + h + ":" + m + ":" + s + "</span><br><i>(" + sinceMidnight + ")</i>";
        t = setTimeout(function () {
            startTime()
        }, 1000);
    }

    startTime();
})(window);