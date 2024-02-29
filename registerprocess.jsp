<%@page import="bean.RegisterDao"%>
<jsp:useBean id="user" class="bean.RegisterBean"/>

<jsp:setProperty property="*" name="user"/>

<%
boolean status = RegisterDao.register(user);
if(status){
    out.println("You are successfully registered.");
    // Optionally redirect to login page or somewhere else
    // response.sendRedirect("index.jsp");
} else {
    out.print("Sorry, registration failed. Please try again.");
    // Include the registration form again for retry
    %><jsp:include page="index.jsp"></jsp:include><%
}
%>
