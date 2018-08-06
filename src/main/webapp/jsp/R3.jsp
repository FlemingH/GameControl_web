<%@ page import="edu.njpi.fleming.thread.StopDThread" %>
<%@ page import="edu.njpi.fleming.thread.R3" %>
<html>
<body>
    <%
        StopDThread.stopAllDThread();
        new R3().start();
    %>
</body>
</html>
