/**
 * @author Timofti Gabriel
 */

import beans.ProcessedStudentBean;
import beans.StudentBean;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Year;


public class ProcessStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        // se citesc parametrii din cererea de tip POST
        String nume = request.getParameter("nume");
        String prenume = request.getParameter("prenume");
        int varsta = Integer.parseInt(request.getParameter("varsta"));
        int nrRestante = Integer.parseInt(request.getParameter("nrRestante"));
        String pet = request.getParameter("pet");

        /*
        procesarea datelor - calcularea anului nasterii
        */
        int anCurent = Year.now().getValue();
        int anNastere = anCurent - varsta;

        // initializare serializator Jackson
        XmlMapper mapper = new XmlMapper();

        // creare bean si populare cu date
        ProcessedStudentBean bean = new ProcessedStudentBean();
        bean.setNume(nume);
        bean.setPrenume(prenume);
        bean.setVarsta(varsta);
        bean.setAnNastere(anNastere);
        bean.setNrRestante(nrRestante);
        bean.setPet(pet);

        // serializare bean sub forma de string XML
        // NU MERGE CALEA RELATIVA ! :(
        try // un student pe o line xml
        {
            String currentStudentEntry = mapper.writeValueAsString(bean);
            String filename = "E:\\facultate\\AN_3_SEM_2\\SD\\lab_1\\JEE-Test\\store\\student.xml";
            FileWriter fileWriter = new FileWriter(filename, true);
            fileWriter.write(currentStudentEntry);
            fileWriter.write("\n");
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }

        /*
        se trimit datele primite si anul nasterii catre o alta
        pagina JSP pentru afisare
         */
        request.setAttribute("nume", nume);
        request.setAttribute("prenume", prenume);
        request.setAttribute("varsta", varsta);
        request.setAttribute("anNastere", anNastere);
        request.setAttribute("nrRestante", nrRestante);
        request.setAttribute("pet", pet);
        request.getRequestDispatcher("./info-student.jsp").forward(request, response);
    }
}
