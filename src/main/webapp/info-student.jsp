<html xmlns:jsp="http://java.sun.com/JSP/Page">
    <head>
        <title>Date introduse cu success</title>
    </head>
    <body>
        <h3>Informatii student</h3>
        <!-- populare bean cu informatii din cererea HTTP -->
        <jsp:useBean id="studentBean" class="beans.ProcessedStudentBean" />
        <jsp:setProperty name="studentBean" property="nume" value='<%=
            request.getAttribute("nume") %>'/>
        <jsp:setProperty name="studentBean" property="prenume" value='<%=
            request.getAttribute("prenume") %>'/>
        <jsp:setProperty name="studentBean" property="varsta" value='<%=
            request.getAttribute("varsta") %>'/>
        <jsp:setProperty name="studentBean" property="anNastere" value='<%=
            request.getAttribute("anNastere") %>'/>
        <jsp:setProperty name="studentBean" property="nrRestante" value='<%=
            request.getAttribute("nrRestante") %>'/>
        <jsp:setProperty name="studentBean" property="pet" value='<%=
            request.getAttribute("pet") %>'/>

        <!-- folosirea bean-ului pentru afisarea informatiilor -->
        <p>Urmatoarele informatii au fost introduse:</p>
        <ul type="bullet">
            <li>Nume: <jsp:getProperty name="studentBean"
                property="nume" /></li>
            <li>Prenume: <jsp:getProperty name="studentBean"
                property="prenume" /></li>
            <li>Varsta: <jsp:getProperty name="studentBean"
                property="varsta" /></li>
            <li>An nastere: <jsp:getProperty name="studentBean"
                property="anNastere" /></li>
            <li>Nr restante: <jsp:getProperty name="studentBean"
                property="nrRestante" /></li>
            <li>Animal companie: <jsp:getProperty name="studentBean"
                property="pet" /></li>
        </ul>

      <br>

    </body>
</html>
