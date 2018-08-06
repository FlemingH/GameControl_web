<%@ page import="edu.njpi.fleming.thread.StopDThread" %>
<%@ page import="edu.njpi.fleming.thread.L3" %>
<html>
<body>
    <%
        StopDThread.stopAllDThread();
        new L3().start();
    %>
</body>
</html>
