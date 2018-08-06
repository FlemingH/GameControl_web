// 告诉服务器自己上线了
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