<%@ page import="edu.njpi.fleming.thread.StopDThread" %>
<%@ page import="edu.njpi.fleming.thread.L7" %>
<html>
<body>
    <%
        StopDThread.stopAllDThread();
        new L7().start();
    %>
</body>
</html>
