<%@ page import="edu.njpi.fleming.thread.StopDThread" %>
<%@ page import="edu.njpi.fleming.thread.R5" %>
<html>
<body>
    <%
        StopDThread.stopAllDThread();
        new R5().start();
    %>
</body>
</html>
