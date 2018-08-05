<html>
<head>
    <meta charset="UTF-8">
    <title>游戏控制</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        #topBox{
            height: 5em;
            width: 100%;
            background: #3F51B5;
        }
        #topTitle{
            line-height: 3em;
            margin-left: 8em;
            color: aliceblue;
            font-size: 1.7em;
        }
        #box{
            width: 60em;
            height: 35em;
            margin-left: auto;
            margin-right: auto;
        }
        #webOnlineBox{
            margin-top: 5em;
            width: 30em;
            height: 8em;
            margin-left: auto;
            margin-right: auto;
            border-bottom: 1px gray solid;
        }
        #appOnlineBox{
            width: 30em;
            height: 8em;
            margin-left: auto;
            margin-right: auto;
        }
        #buttonBox{
            width: 30em;
            height: 8em;
            margin-left: auto;
            margin-right: auto;
        }
        .OnlineTitleBox{
            float: left;
            height: 100%;
            width: 49%;
            text-align: center;
            line-height: 5em;
            font-size: 1.7em;
        }
        .OnlineStateBox_Online{
            float: right;
            height: 100%;
            width: 49%;
            text-align: center;
            line-height: 7em;
            font-size: 1.2em;
            color: seagreen;
        }
        .OnlineStateBox_Offline{
            float: right;
            height: 100%;
            width: 49%;
            text-align: center;
            line-height: 7em;
            font-size: 1.2em;
            color: gray;
        }
        #openConn{
            float: left;
            margin-left: 8em;
            width: 8em;
            margin-top: 5em;
        }
        #closeConn{
            float: right;
            margin-right: 8em;
            width: 8em;
            margin-top: 5em;
        }
    </style>
    <script type="application/javascript" src="js/jquery-3.3.1.min.js"></script>
</head>
<body>
    <div id="topBox">
        <a id="topTitle">GC web</a>
    </div>
    <div id="box">
        <div id="webOnlineBox">
            <div class="OnlineTitleBox">Web端</div>
            <div class="OnlineStateBox_Online">在线</div>
        </div>
        <div id="appOnlineBox">
            <div class="OnlineTitleBox">App端</div>
            <div id="appState" class="OnlineStateBox_Offline">未在线</div>
        </div>
        <div id="buttonBox">
            <input type="button" id="openConn" value="开启控制">
            <input type="button" id="closeConn" value="关闭控制">
        </div>
    </div>
    <script type="application/javascript" src="js/WebIsReady.js"></script>
    <script type="application/javascript">
        //用于处理在线信息：接收对面在线的信息、发送我在线的信息
        //用于处理控制信息：只接受对面的控制信息：w按下松开、s按下松开和左右个9个，0算一个，-10=-9：一共：24种信息
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
            if("AppIsOnline" == messageJson.messageType){
                document.getElementById("appState").className = "OnlineStateBox_Online";
                document.getElementById("openConn").disable = "false";
            }

            //收到对面下线的情况：改标志、改开始按钮不可点击、改结束按钮也不可点击
            if("AppIsOffline" == messageJson.messageType){
                document.getElementById("appState").className = "OnlineStateBox_Offline";
                document.getElementById("openConn").disable = "true";
                document.getElementById("closeConn").disable = "true";
            }

            //w按下事件
            if("wButtonDown" == messageJson.messageType){

            }

            //w松开事件
            if("wButtonUp" == messageJson.messageType){

            }

            //s键按下事件
            if("sButtonDown" == messageJson.messageType){

            }

            //s键松开事件
            if("sButtonUp" == messageJson.messageType){

            }

            //方向改变信息，内部在进行判断值的大小
            if("dChange" == messageJson.messageType){

                //从左到右-10~9
                switch (parseInt(messageJson.data)) {
                    case -10:
                        break;
                    case -9:
                        break;
                    case -8:
                        break;
                    case -7:
                        break;
                    case -6:
                        break;
                    case -5:
                        break;
                    case -4:
                        break;
                    case -3:
                        break;
                    case -2:
                        break;
                    case -1:
                        break;
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    default:
                        break;
                }
            }

        };
    </script>
</body>
</html>
