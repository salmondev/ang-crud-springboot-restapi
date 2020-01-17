/*package com.example.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.entity.CrudEntity;
import com.example.crud.exception.ResourceNotFoundException;
import com.example.crud.repository.CrudRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/connect")
public class CrudController {
	@Autowired
	private CrudRepository crudRepository;

	@GetMapping("/api")
	public List<CrudEntity> getAllCrud() {
		return crudRepository.findAll();
	}

	@GetMapping("/api/{id}")
	public ResponseEntity<CrudEntity> getCrudById(@PathVariable(value = "id") String id)
			throws ResourceNotFoundException {
		CrudEntity crud = crudRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("API not found for this id :: " + id));
		return ResponseEntity.ok().body(crud);
	}

	@PostMapping("/api")
	public CrudEntity createCrud(@Valid @RequestBody CrudEntity crud) {
		return crudRepository.save(crud);
	}

	@PutMapping("/api/{id}")
	public ResponseEntity<CrudEntity> updateEmployee(@PathVariable(value = "id") String id,
			@Valid @RequestBody CrudEntity crudDetail) throws ResourceNotFoundException {
		CrudEntity crud = crudRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("API not found for this id :: " + id));
		crud.setId(crudDetail.getId());
		crud.setProductName(crudDetail.getProductName());
		crud.setProductPrice(crudDetail.getProductPrice());
		final CrudEntity updatedCrud = crudRepository.save(crud);
		return ResponseEntity.ok(updatedCrud);
	}

	@DeleteMapping("/api/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") String id) throws ResourceNotFoundException {
		CrudEntity crud = crudRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("API not found for this id :: " + id));
		crudRepository.delete(crud);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}*/
package com.example.crud.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.exception.ResourceNotFoundException;
import com.example.crud.entity.CrudEntity;
import com.example.crud.repository.CrudRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CrudController {
	@Autowired
	private CrudRepository crudRepository;

	@GetMapping("/products")
	public List<CrudEntity> getAllProducts() {
		return crudRepository.findAll();
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<CrudEntity> getProductById(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		CrudEntity product = crudRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
		return ResponseEntity.ok().body(product);
	}

	@PostMapping("/products")
	public CrudEntity createProduct(@Valid @RequestBody CrudEntity product) {
		return crudRepository.save(product);
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<CrudEntity> updateProduct(@PathVariable(value = "id") Long id,
			@Valid @RequestBody CrudEntity productDetails) throws ResourceNotFoundException {
		CrudEntity product = crudRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
		product.setProductPrice(productDetails.getProductPrice());
		product.setProductName(productDetails.getProductName());
		final CrudEntity updatedProduct = crudRepository.save(product);
		return ResponseEntity.ok(updatedProduct);
	}

	@DeleteMapping("/products/{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		CrudEntity product = crudRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));

		crudRepository.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}