<%@ page import="edu.njpi.fleming.thread.StopDThread" %>
<%@ page import="edu.njpi.fleming.thread.R9" %>
<html>
<body>
    <%
        StopDThread.stopAllDThread();
        new R9().start();
    %>
</body>
</html>
