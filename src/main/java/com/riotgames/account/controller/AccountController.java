package com.riotgames.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riotgames.account.model.Account;
import com.riotgames.account.model.dto.CreateAccountDTO;
import com.riotgames.account.model.dto.DefinePlayerNameAccountDTO;
import com.riotgames.account.model.dto.LoginAccountDTO;
import com.riotgames.account.model.dto.RedefinePasswordDTO;
import com.riotgames.account.model.dto.RedefineRegionDTO;
import com.riotgames.account.service.AccountService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "AccountService")
@RequestMapping("/v1/account")
public class AccountController {

	@Autowired
	AccountService service;

	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, path = "/create-account")
	public ResponseEntity<Account> createAccount(@RequestBody CreateAccountDTO dto) throws Exception {
		try {
			Account account = service.createAccount(dto);
			if (account != null) {
				return new ResponseEntity<Account>(account, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}

		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, path = "/login-account")
	public ResponseEntity<Account> loginAccount(@RequestBody LoginAccountDTO dto) throws Exception {
		try {
			Account account = service.loginAccount(dto);
			if (account != null) {
				return new ResponseEntity<Account>(account, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}

		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, path = "/define-playername")
	public ResponseEntity<Account> definePlayerNameAccount(@RequestBody DefinePlayerNameAccountDTO dto)
			throws Exception {
		try {
			Account account = service.definePlayerNameAccount(dto);
			if (account != null) {
				return new ResponseEntity<Account>(account, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
			}

		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, path = "/redefine-password")
	public ResponseEntity<Account> redefinePassword(@RequestBody RedefinePasswordDTO dto) throws Exception {
		try {
			Account account = service.redefinePassword(dto);
			if (account != null) {
				return new ResponseEntity<Account>(account, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
			}

		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, path = "/redefine-region")
	public ResponseEntity<Account> redefineRegion(@RequestBody RedefineRegionDTO dto) throws Exception {
		try {
			Account account = service.redefineRegion(dto);
			if (account != null) {
				return new ResponseEntity<Account>(account, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
			}

		} catch (Exception e) {
			throw new Exception(e);
		}
	}

}
