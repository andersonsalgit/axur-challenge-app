package br.com.axur.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.axur.exception.ResourceNotFoundException;
import br.com.axur.model.Whitelist;
import br.com.axur.repository.WhitelistRepository;

@RestController
@RequestMapping("/axurapp")
public class WhitelistController {

	@Autowired
	WhitelistRepository whitelistRepository;

	@GetMapping("/")
	public String teste() {
		return "{teste: 123456}";
	}

	@GetMapping("/whitelist")
	public List<Whitelist> getAllWhitelist() {
		return whitelistRepository.findAll();
	}

	@PostMapping("/whitelist")
	public Whitelist createWhitelist(@Valid @RequestBody Whitelist whitelist) {
		return whitelistRepository.save(whitelist);
	}

	@GetMapping("/whitelist/{id}")
	public Whitelist getWhitelistById(@PathVariable(value = "id") Long whitelistId) {
		return whitelistRepository.findById(whitelistId).orElseThrow(() -> new ResourceNotFoundException("Whitelist", "id", whitelistId));
	}

	@PutMapping("/whitelist/{id}")
	public Whitelist updateWhitelist(@PathVariable(value = "id") Long whitelistId, @Valid @RequestBody Whitelist whitelistDetails) {

		Whitelist whitelist = whitelistRepository.findById(whitelistId)
				.orElseThrow(() -> new ResourceNotFoundException("Whitelist", "id", whitelistId));

		whitelist.setClient(whitelistDetails.getClient());
		whitelist.setRegex(whitelistDetails.getRegex());

		Whitelist updatedWhitelist = whitelistRepository.save(whitelist);
		return updatedWhitelist;
	}

	@DeleteMapping("/whitelist/{id}")
	public ResponseEntity<?> deleteWhitelist(@PathVariable(value = "id") Long whitelistId) {
		Whitelist whitelist = whitelistRepository.findById(whitelistId)
				.orElseThrow(() -> new ResourceNotFoundException("Whitelist", "id", whitelistId));

		whitelistRepository.delete(whitelist);

		return ResponseEntity.ok().build();
	}

}
