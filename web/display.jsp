<%-- 
    Document   : display
    Created on : Sep 19, 2019, 2:42:14 PM
    Author     : omiro
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.MyFile"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File Handling App</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="styles/styles.css">     


        <script>
            function getConfirmation() {
                return confirm("Delete file?");
            }
        </script>
    </head>

    <body class="container bg-secondary text-white">


        <br>
        <br>
        <br>
        <br>

        <table border="1" class="table table-dark table-hover shadow p-3 mb-5 rounded" id="mainTable">
            <thead class="thead-light" id="mainTableHead">
                <tr><form action="uploadservlet" method="post" enctype="multipart/form-data">

                <div id="fileSelector">Select a file to upload: <input type="file" name="uploadedFile" onchange="this.form.submit()"></div></form></tr>
        <tr>
            <th id="mainTableHeadCol-1">ID</th>
            <th><div id="mainTableHeadCol-2">Filename <img src="images/download.png" width="18" height="18" alt="download"/></div>


            </th>
            <th id="mainTableHeadCol-3"></th>
        </tr>
    </thead>
    <c:choose>
        <c:when test="${empty allmyfiles}">
            <tbody>
                <tr>
                    <td></td>
                    <td>No uploaded files. Click "Choose File" to upload your first file</td>
                    <td></td>
                </tr>
            </tbody>
        </c:when>    
        <c:otherwise>
            <tbody>


                <c:forEach var="myFile" items="${allmyfiles}">

                    <tr>

                        <td>${myFile.id}</td>
                        <td><a href="downloadservlet?id=${myFile.id}">${myFile.filename}</a></td>
                        <td><a onclick="return getConfirmation();" href="deleteservlet?id=${myFile.id}"><img src="images/delete.png" width="16" height="16" alt="delete"/></a>
                            </a></td>
                    </tr>
                </c:forEach>



            </tbody>
        </c:otherwise>
    </c:choose>


</table>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>



</body>
</html>
