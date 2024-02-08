package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Medicine;
import com.examly.springapp.service.MedicineService;


@RestController
@RequestMapping("/api")
public class MedicineController {

	@Autowired
	private MedicineService medicineService;

	@PostMapping("/medicine")
	public ResponseEntity<Boolean> save(@RequestBody Medicine medicine) {

		boolean s = medicineService.saveMedicine(medicine);
		if (s) {
			return new ResponseEntity<>(s, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(s, HttpStatus.ALREADY_REPORTED);
	}


	@GetMapping("/medicines")
	public ResponseEntity<List<Medicine>> getAll() {

		List<Medicine> medicines = medicineService.getAllMedicine();
		return new ResponseEntity<>(medicines, HttpStatus.OK);
	}

	@GetMapping("/medicine/{medicineId}")
	public ResponseEntity<Medicine> getById(@PathVariable int medicineId) {

		Medicine medicine = medicineService.getMedicineById(medicineId);
		return new ResponseEntity<>(medicine, HttpStatus.OK);
	}

	
}
