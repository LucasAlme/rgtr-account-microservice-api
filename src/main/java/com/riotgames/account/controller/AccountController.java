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
import com.riotgames.account.model.dto.LoginAccountDTO;
import com.riotgames.account.service.AccountService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "AccountService")
@RequestMapping("/v1/account")
public class AccountController {

	@Autowired
	AccountService service;

	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, path = "/create-account")
	public ResponseEntity<Account> createAccount(@RequestBody CreateAccountDTO dto) {
		try {
			Account account = service.createAccount(dto);
			return new ResponseEntity<Account>(account, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, path = "/login-account")
	public ResponseEntity<Account> loginAccount(@RequestBody LoginAccountDTO dto) {
		try {
			Account account = service.loginAccount(dto);
			return new ResponseEntity<Account>(account, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}