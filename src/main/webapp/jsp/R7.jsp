<%@ page import="edu.njpi.fleming.thread.StopDThread" %>
<%@ page import="edu.njpi.fleming.thread.R7" %>
<html>
<body>
    <%
        StopDThread.stopAllDThread();
        new R7().start();
    %>
</body>
</html>
