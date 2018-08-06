<%@ page import="edu.njpi.fleming.thread.SThread" %>
<%@ page import="edu.njpi.fleming.thread.StopSThread" %>
<html>
<body>
    <%
        SThread.setIsSStop(true);
        new StopSThread().start();
    %>
</body>
</html>
