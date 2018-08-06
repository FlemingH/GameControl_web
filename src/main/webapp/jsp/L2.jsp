<%@ page import="edu.njpi.fleming.thread.StopDThread" %>
<%@ page import="edu.njpi.fleming.thread.L2" %>
<html>
<body>
    <%
        StopDThread.stopAllDThread();
        new L2().start();
    %>
</body>
</html>
