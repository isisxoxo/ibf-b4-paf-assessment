package ibf2024.assessment.paf.batch4.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ NoBreweryFoundException.class })
    public ModelAndView handleNoBreweryException(Exception ex) {
        final ModelAndView mav = new ModelAndView("error_page.html");
        mav.addObject("error_message", ex.getMessage());
        return mav;
    }

}