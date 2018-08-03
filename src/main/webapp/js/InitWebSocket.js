//将信息显示在标题
function setMessageInnerHtml(message) {
    document.getElementById("topTitle").innerHTML = message;
}

var websocket = null;
var username = GetQueryString("username");

if('WebSocket' in window) {
    websocket = new WebSocket("ws://118.25.180.193:8090/SocketHandle/web/"+username);
} else {
    alert("当前浏览器不支持WebSocket");
}

websocket.onerror = function () {
    setMessageInnerHtml("连接错误");
}

websocket.onopen = function () {
    setMessageInnerHtml("连接成功");
}
