<%-- 
    Document   : index
    Created on : 23/10/2020, 07:34:07 AM
    Author     : kcordon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="menu.jsp" flush="true"></jsp:include>
    </head>
    <body>
        <div class="parallax-container">
            <div class="parallax">
                <img src="https://santotomasport.com.gt/wp-content/uploads/2017/09/WhatsApp-Image-2017-09-20-at-2.34.14-PM.jpeg">
            </div>
        </div>

        <div class="blue white-text center">
            <div class ="container">
                <div class="section">
                    <h1>
                        Puerto Santo Tomás de Castilla
                    </h1>
                </div>

            </div>
        </div>
<div class="parallax-container">
            <div class="parallax">
                <img src="https://santotomasport.com.gt/wp-content/uploads/2017/09/WhatsApp-Image-2017-10-16-at-3.08.39-PM.jpeg">
            </div>
        </div>
        <script>

            document.addEventListener('DOMContentLoaded', function () {
                var elems = document.querySelectorAll('.parallax');
                var instances = M.Parallax.init(elems);
            });
        </script>
    </body>
</html>
