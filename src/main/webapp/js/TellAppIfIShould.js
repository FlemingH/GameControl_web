//检查App是否在线：在线的话则发送socket，告诉它web上线了，同时改标志和按钮
var username = GetQueryString("username");

$.ajax({
    url:"http://118.25.180.193:8090/CheckAppIsOnline?username="+username,
    type:"GET",
    dataType: 'json',
    success:function (data) {
        //对面在线的情况
        if("ok" == data.ajaxState){
            document.getElementById("appState").className = "OnlineStateBox_Online";
            document.getElementById("appState").innerText = "在线";
            var socketMessage = {"messageType":"webIsOnline", "data":username};
            websocket.send(JSON.stringify(socketMessage));
        }
    }
});