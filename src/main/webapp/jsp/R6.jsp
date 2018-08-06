<%@ page import="edu.njpi.fleming.thread.StopDThread" %>
<%@ page import="edu.njpi.fleming.thread.R6" %>
<html>
<body>
    <%
        StopDThread.stopAllDThread();
        new R6().start();
    %>
</body>
</html>
