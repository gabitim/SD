import beans.StudentBean;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author Timofti Gabriel
 */
public class DeleteStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // initializare serializator Jackson
        XmlMapper mapper = new XmlMapper();

        // creare bean si populare cu date goale; la varsta am pus 0
        StudentBean bean = new StudentBean();
        bean.setNume("");
        bean.setPrenume("");
        bean.setVarsta(0);

        // serializare bean sub forma de string XML
        // NU MERGE CALEA RELATIVA ! :(
        mapper.writeValue(new File("E:\\facultate\\AN_3_SEM_2\\SD\\lab_1\\JEE-Test\\store\\student.xml"), bean);

        /*
        se trimit datele primite si anul nasterii catre o alta
        pagina JSP pentru afisare
         */

        request.setAttribute("nume", bean.getNume());
        request.setAttribute("prenume", bean.getPrenume());
        request.setAttribute("varsta", bean.getVarsta());
        // reincarca pagina dupa ce a sters  informatiile studentului
        request.getRequestDispatcher("./info-student.jsp").forward(request, response);

    }

}
