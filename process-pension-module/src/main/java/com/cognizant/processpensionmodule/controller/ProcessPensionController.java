package com.cognizant.processpensionmodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.processpensionmodule.exception.PensionerNotFoundException;
import com.cognizant.processpensionmodule.exception.TokenInvalidException;
import com.cognizant.processpensionmodule.model.PensionDetail;
import com.cognizant.processpensionmodule.model.PensionerInput;
import com.cognizant.processpensionmodule.model.ProcessPensionInput;
import com.cognizant.processpensionmodule.service.PensionDetailService;
import com.cognizant.processpensionmodule.service.PensionDisbursementService;

@RestController
public class ProcessPensionController {

	@Autowired
	private PensionDetailService pensionDetailService;
	@Autowired
	private PensionDisbursementService pensionDisbursementService;

	@GetMapping("/pensiondetail")
	public PensionDetail getPensionDetail(@RequestHeader("Authorization") String token,
			@RequestBody PensionerInput pensionerInput) throws PensionerNotFoundException, TokenInvalidException {
		return pensionDetailService.getPensionDetail(token, pensionerInput);
	}

	@PostMapping("/processpension") // on confirmation by Admin he will use this method with bankservicecharge;
	public Integer getDisbursementCode(@RequestHeader("Authorization") String token,
			@RequestBody ProcessPensionInput processPensionInput) throws PensionerNotFoundException {

		return pensionDisbursementService.getDisbursementCode(token, processPensionInput);
	}
}
