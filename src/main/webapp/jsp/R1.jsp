<%@ page import="edu.njpi.fleming.thread.StopDThread" %>
<%@ page import="edu.njpi.fleming.thread.R1" %>
<html>
<body>
    <%
        StopDThread.stopAllDThread();
        new R1().start();
    %>
</body>
</html>
