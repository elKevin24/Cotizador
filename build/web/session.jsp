<%-- 
    Document   : session
    Created on : 28/10/2020, 10:20:10 AM
    Author     : kcordon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <body>
        <script type="text/javascript">
         var timeoutHandle = null;
         function startTimer(timeoutCount){
             if(timeoutCount == 0){
                     window.location.href = 'index.jsp';
         }else if (timeoutCount < 30){
             document.getElementByid('sessionTimer').innerHTML = 'You Have' + (timeoutCount * 1000) / 1000 + ' Seconds untl timeout';
         }
         timeoutHandle = setTimeout(function(){ startTimer(timeoutCount-1);}, '1000');
         }
         function refreshTImer(){
             killTimer(timeouHandle);
             startTimer(30);
         }
         
         
            </script>
            
    </head>
    <body>
        
        
        <%
            
            
if(session.getAttribute("usuario")!=null){
         
            }else{

response.sendRedirect("Login.jsp");

}
            %>
            
            
            
    </body>
</html>
