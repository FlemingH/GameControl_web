<%@ page import="edu.njpi.fleming.thread.StopDThread" %>
<%@ page import="edu.njpi.fleming.thread.R2" %>
<html>
<body>
    <%
        StopDThread.stopAllDThread();
        new R2().start();
    %>
</body>
</html>
