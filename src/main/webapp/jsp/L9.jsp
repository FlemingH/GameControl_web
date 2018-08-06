<%@ page import="edu.njpi.fleming.thread.StopDThread" %>
<%@ page import="edu.njpi.fleming.thread.L9" %>
<html>
<body>
    <%
        StopDThread.stopAllDThread();
        new L9().start();
    %>
</body>
</html>
