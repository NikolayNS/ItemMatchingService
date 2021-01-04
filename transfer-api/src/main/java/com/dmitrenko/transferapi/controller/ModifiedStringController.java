package com.dmitrenko.transferapi.controller;

import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringAddRequest;
import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringUpdateRequest;
import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringsAddRequest;
import com.dmitrenko.database.dto.response.modifiedstring.ModifiedStringResponse;
import com.dmitrenko.transferapi.service.TransferService;
import com.dmitrenko.transferapi.wrapper.ListResponse;
import com.dmitrenko.transferapi.wrapper.ObjectResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class ModifiedStringController {

	public static final String MODIFIED_STRING_ADD = "/api/v1/modified-string";
	public static final String MODIFIED_STRINGS = "/api/v1/modified-strings";
	public static final String MODIFIED_STRING = "/api/v1/modified-string/{modifiedStringId}";

	private final TransferService transferService;

	@ResponseStatus(CREATED)
	@PostMapping(value = MODIFIED_STRING_ADD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Add modified string")
	public ObjectResponse<ModifiedStringResponse> addModifiedString(@RequestBody ModifiedStringAddRequest request) {
		return ObjectResponse.success(transferService.addModifiedString(request));
	}

	@ResponseStatus(OK)
	@GetMapping(value = MODIFIED_STRINGS, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Add modified strings")
	public ListResponse<ModifiedStringResponse> addModifiedStrings(@RequestBody ModifiedStringsAddRequest request) {
		return ListResponse.success(transferService.addModifiedStrings(request));
	}

	@ResponseStatus(OK)
	@GetMapping(value = MODIFIED_STRING, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get modified string by id")
	public ObjectResponse<ModifiedStringResponse> getModifiedString(@PathVariable Long modifiedStringId) {
		return ObjectResponse.success(transferService.getModifiedString(modifiedStringId));
	}

	@ResponseStatus(OK)
	@GetMapping(value = MODIFIED_STRINGS, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get all modified strings")
	public ListResponse<ModifiedStringResponse> getAllModifiedStrings() {
		return ListResponse.success(transferService.getAllModifiedStrings());
	}

	@ResponseStatus(OK)
	@PatchMapping(value = MODIFIED_STRING, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Update modified string by id")
	public ObjectResponse<ModifiedStringResponse> updateModifiedString(@PathVariable Long modifiedStringId,
																	   @RequestBody ModifiedStringUpdateRequest request) {
		return ObjectResponse.success(transferService.updateModifiedString(modifiedStringId, request));
	}

	@ResponseStatus(OK)
	@DeleteMapping(value = MODIFIED_STRING, consumes = APPLICATION_JSON_VALUE)
	@Operation(description = "Delete modified string by id")
	public void deleteModifiedString(@PathVariable Long modifiedStringId) {
		transferService.deleteModifiedString(modifiedStringId);
	}

	@ResponseStatus(OK)
	@DeleteMapping(value = MODIFIED_STRINGS, consumes = APPLICATION_JSON_VALUE)
	@Operation(description = "Delete all modified string")
	public void deleteAllModifiedStrings() {
		transferService.deleteAllModifiedStrings();
	}
}
