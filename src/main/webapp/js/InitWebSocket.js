//用于处理在线信息：接收对面在线的信息、发送我在线的信息
//用于处理控制信息：只接受对面的控制信息
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
};

websocket.onopen = function () {
    setMessageInnerHtml("连接成功");
};

websocket.onmessage = function (event) {

    debugger;
    var messageJson = eval("("+event.data+")");

    //接收到对面在线的情况：改标志、改开始按钮可以点击
    if(messageJson.messageType == "AppIsOnline"){
        document.getElementById("appState").className = "OnlineStateBox_Online";
        document.getElementById("openConn").disable = "false";
    }

    //收到对面下线的情况：改标志、改开始按钮不可点击、改结束按钮也不可点击
    if(messageJson.messageType == "AppIsOffline"){
        document.getElementById("appState").className = "OnlineStateBox_Offline";
        document.getElementById("openConn").disable = "true";
        document.getElementById("closeConn").disable = "true";
    }

};