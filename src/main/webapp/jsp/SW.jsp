<%@ page import="edu.njpi.fleming.thread.WThread" %>
<%@ page import="edu.njpi.fleming.thread.StopWThread" %>
<html>
<body>
    <%
        WThread.setIsWStop(true);
        new StopWThread().start();
    %>
</body>
</html>
