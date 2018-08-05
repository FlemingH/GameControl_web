//告诉服务器自己上线了、
// 改按钮都不可点击、
// 检查app登录情况、对面在线：改标志，改按钮
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
})