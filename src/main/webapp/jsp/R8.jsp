<%@ page import="edu.njpi.fleming.thread.StopDThread" %>
<%@ page import="edu.njpi.fleming.thread.R8" %>
<html>
<body>
    <%
        StopDThread.stopAllDThread();
        new R8().start();
    %>
</body>
</html>
