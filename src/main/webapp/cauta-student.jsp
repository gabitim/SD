<html xmlns:jsp="http://java.sun.com/JSP/Page">
    <head>
        <title>Cauta student</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <h2>Cauta un student dupa nume si prenume</h2>
        Introduceti datele despre student:
        <form action="./find-student" method="post">
            Nume: <input type="text" name="nume" />
            <br />
            Prenume: <input type="text" name="prenume" />
            <br />
            <br />
            <button type="submit" name="submit">Trimite</button>
        </form>
    </body>
</html>
