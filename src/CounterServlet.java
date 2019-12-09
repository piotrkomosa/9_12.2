import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculator")
public class CounterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            countLengthUnit(request, response);
    }
    private void countLengthUnit(HttpServletRequest request, HttpServletResponse response) {
        String meters = request.getParameter("metry");
        String centimeters = request.getParameter("centymetry");
        String milimeters = request.getParameter("milimetry");
        Double met;
        Double cent;
        Double mili;

        met = Double.valueOf(meters);
        cent = Double.valueOf(centimeters);
        mili= Double.valueOf(milimeters);

        if (checkIfValuesCorrect(met,cent,mili)) {
            if (met != null) {
                cent = met * 100;
                mili = met * 1000;
            } else if (cent != null) {
                met = cent / 100;
                mili = cent * 10;
            } else if (mili != null) {
                cent = mili / 10;
                met = mili / 1000;
            }
            request.getParameter(meters);
            request.getParameter(centimeters);
            request.getParameter(milimeters);
        } else {
            System.out.println("error");
        }
    }
    private boolean checkIfValuesCorrect(Double met, Double cent, Double mili) {
        if (met != null) {
            if (cent != null) {
                return false;
            } else {
                if (mili != null) {
                    return false;
                } else {
                    return true;
                }
            }
        } else if (cent != null) {
            if (mili != null) {
                return false;
            } else {
                return true;
            }
        } else {
            if (mili != null) {
                return false;
            } else {
                return true;
            }
        }
    }
}
//        if (centymetry.isEmpty() && milimetry.isEmpty() ) {
//            response.getWriter().print("Podana wartość w przeliczeniu na: ");
//            response.getWriter().print("metry: " + meters);
//            response.getWriter().print("centymetry: " + meters / 100);
//            response.getWriter().print("milimetry: " + meters / 1000);
//        } else if (metry.isEmpty() && milimetry.isEmpty()) {
//            response.getWriter().print("Podana wartość w przeliczeniu na: ");
//            response.getWriter().print("metry: " + centimeters / 100);
//            response.getWriter().print("centymetry: " + centimeters);
//            response.getWriter().print("milimetry: " + centimeters * 10);
//        } else if (metry.isEmpty() && centymetry.isEmpty()) {
//            response.getWriter().print("Podana wartość w przeliczeniu na: ");
//            response.getWriter().print("metry: " + milimeters / 100);
//            response.getWriter().print("centymetry: " + milimeters);
//            response.getWriter().print("milimetry: " + milimeters * 10);
//        }
//    }