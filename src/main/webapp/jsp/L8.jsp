<%@ page import="edu.njpi.fleming.thread.StopDThread" %>
<%@ page import="edu.njpi.fleming.thread.L8" %>
<html>
<body>
    <%
        StopDThread.stopAllDThread();
        new L8().start();
    %>
</body>
</html>
