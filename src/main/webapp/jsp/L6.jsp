<%@ page import="edu.njpi.fleming.thread.StopDThread" %>
<%@ page import="edu.njpi.fleming.thread.L6" %>
<html>
<body>
    <%
        StopDThread.stopAllDThread();
        new L6().start();
    %>
</body>
</html>
