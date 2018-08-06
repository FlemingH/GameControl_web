// 告诉服务器自己上线了、
// 改按钮都不可点击、
// 检查app登录情况、对面在线：改标志，改按钮
// 实现启动连接和关闭连接的按钮点击事件
function GetQueryString(name)
{
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}

var username = GetQueryString("username");

$.ajax({
    url:"http://118.25.180.193:8090/WebIsReady?username="+username,
    type:"GET",
    dataType: 'json',
    async:false
});

document.getElementById("openConn").disable = "true";
document.getElementById("closeConn").disable = "true";

$.ajax({
    url:"http://118.25.180.193:8090/CheckAppIsOnlie?username="+username,
    type:"GET",
    dataType: 'json',
    async:false,
    success:function (data) {
        //对面在线的情况
        if("ok" == data.ajaxState){
            document.getElementById("appState").className = "OnlineStateBox_Online";
            document.getElementById("openConn").disable = "false";
        }
    }
});

//连接开启按钮点击事件：改自己为不可点击、改关闭连接可以点击、连接开启
function openConnOnClick() {
    document.getElementById("openConn").disable = "true";
    document.getElementById("closeConn").disable = "false";
    openConn4Socket();
}

//连接关闭按钮点击事件：改自己为不可点击，改开启连接可以点击、连接关闭
function closeConnOnClick() {
    document.getElementById("closeConn").disable = "true";
    document.getElementById("openConn").disable = "true";
    closeConn4Socket();
}