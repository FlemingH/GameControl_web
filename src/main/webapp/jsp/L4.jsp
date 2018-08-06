<%@ page import="edu.njpi.fleming.thread.StopDThread" %>
<%@ page import="edu.njpi.fleming.thread.L4" %>
<html>
<body>
    <%
        StopDThread.stopAllDThread();
        new L4().start();
    %>
</body>
</html>
