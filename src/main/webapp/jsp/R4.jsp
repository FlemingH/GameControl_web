<%@ page import="edu.njpi.fleming.thread.StopDThread" %>
<%@ page import="edu.njpi.fleming.thread.R4" %>
<html>
<body>
    <%
        StopDThread.stopAllDThread();
        new R4().start();
    %>
</body>
</html>
