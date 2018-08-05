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
    <script type="application/javascript" src="js/WebIsReady.js"></script>
    <script type="application/javascript" src="js/InitWebSocket.js"></script>
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
</body>
</html>
