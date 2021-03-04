package beans;

/**
 * @author Timofti Gabriel
 */
public class ProcessedStudentBean extends StudentBean {
    private int anNastere = 0;

    public ProcessedStudentBean() {
    }

    public int getAnNastere() {
        return anNastere;
    }

    public void setAnNastere(int anNastere) {
        this.anNastere = anNastere;
    }
}
