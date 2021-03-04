import beans.ProcessedStudentBean;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Timofti Gabriel
 */
public class FindStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        // deserializare studentii din fisierul XML de pe disc
        File file = new File("E:\\facultate\\AN_3_SEM_2\\SD\\lab_1\\JEE-Test\\store\\student.xml");
        // se returneaza un raspuns HTTP de tip 404 in cazul in care nu se gaseste fisierul cu date
        if (!file.exists()) {
            response.sendError(404, "Nu a fost gasit niciun student serializat pe disc!");
            return;
        }

        XmlMapper xmlMapper = new XmlMapper();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String studentCurent = bufferedReader.readLine();
        ProcessedStudentBean foundStudentBean = null;

        while (studentCurent != null) {
            if( studentCurent.contains(request.getParameter("nume")) &&
                    studentCurent.contains(request.getParameter("prenume")) ) {
                try {
                    foundStudentBean = xmlMapper.readValue(studentCurent, ProcessedStudentBean.class);
                } catch (IOException e) {
                    System.out.println("IOexception: " + e.getMessage());
                }

                request.setAttribute("nume", foundStudentBean.getNume());
                request.setAttribute("prenume", foundStudentBean.getPrenume());
                request.setAttribute("varsta", foundStudentBean.getVarsta());
                request.setAttribute("anNastere", foundStudentBean.getAnNastere());
                request.setAttribute("nrRestante", foundStudentBean.getNrRestante());
                request.setAttribute("pet", foundStudentBean.getPet());

                request.getRequestDispatcher("./info-student.jsp").forward(request, response);
            }
            studentCurent = bufferedReader.readLine();
        }
        bufferedReader.close();

        request.getRequestDispatcher("./not-found-student.jsp").forward(request, response);
    }

}
