package com.calpha.hospital.controllers;

import com.calpha.hospital.model.Patient;
import com.calpha.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PatientController {

	 @Autowired
	public PatientController( PatientService patientService) {
		// TODO Auto-generated constructor stub
		 this.patientService = patientService;
	}

	private final PatientService patientService;

   
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        Patient patient = new Patient();
        modelAndView.addObject("patient", patient);
        modelAndView.setViewName("/registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid Patient patient, BindingResult bindingResult) {

        if (patientService.findByEmail(patient.getEmail()).isPresent()) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
       if (patientService.findPatientByFirstname(patient.getFirstName()).isPresent()) {
            bindingResult
                    .rejectValue("username", "error.patient",
                            "There is already a patient registered with the username provided");
        }

        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("/registration");
        }
        else {
            /**
        	* Registration successful, save user
            * Set user role to USER and set it as active
            **/
        	patientService.savePatient(patient);

            modelAndView.addObject("successMessage", "Patient has been registered successfully");
            modelAndView.addObject("patient", new Patient());
            modelAndView.setViewName("/registration");
        }
        return modelAndView;
    }
}
