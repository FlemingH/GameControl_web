<%@ page import="edu.njpi.fleming.thread.L1" %>
<%@ page import="edu.njpi.fleming.thread.StopDThread" %>
<html>
<body>
    <%
        StopDThread.stopAllDThread();
        new L1().start();
    %>
</body>
</html>
