<%@ page import="edu.njpi.fleming.thread.StopDThread" %>
<%@ page import="edu.njpi.fleming.thread.L5" %>
<html>
<body>
    <%
        StopDThread.stopAllDThread();
        new L5().start();
    %>
</body>
</html>
