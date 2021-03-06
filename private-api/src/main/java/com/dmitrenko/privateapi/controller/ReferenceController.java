package com.dmitrenko.privateapi.controller;

import com.dmitrenko.database.dto.request.reference.ReferenceFieldRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsUpdateRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceRequest;
import com.dmitrenko.database.dto.response.reference.ReferenceFieldResponse;
import com.dmitrenko.database.dto.response.reference.ReferenceResponse;
import com.dmitrenko.privateapi.service.ReferenceService;
import com.dmitrenko.privateapi.wrapper.ListResponse;
import com.dmitrenko.privateapi.wrapper.ObjectResponse;
import com.dmitrenko.privateapi.wrapper.SuccessWrapper;
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
public class ReferenceController {

	public static final String REFERENCE_ADD = "/api/v1/reference";
	public static final String REFERENCES = "/api/v1/references";
	public static final String REFERENCE = "/api/v1/reference/{referenceId}";
	public static final String REFERENCE_FIELD_ADD = "/api/v1/reference/field";
	public static final String REFERENCE_FIELDS = "/api/v1/reference/fields";
	public static final String REFERENCE_FIELD = "/api/v1/reference/field/{fieldId}";
	public static final String REFERENCE_FIELD_DELETE_BY_REF = "/api/v1/reference/{referenceId}/fields";

	private final ReferenceService referenceService;

	@ResponseStatus(CREATED)
	@PostMapping(value = REFERENCE_ADD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Add reference")
	public ObjectResponse<ReferenceResponse> addReference(@RequestBody ReferenceRequest request) {

		return referenceService.addReference(request);
	}

	@ResponseStatus(OK)
	@GetMapping(value = REFERENCE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get reference by id")
	public ObjectResponse<ReferenceResponse> getReference(@PathVariable Long referenceId) {

		return referenceService.getReference(referenceId);
	}

	@ResponseStatus(OK)
	@GetMapping(value = REFERENCES, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get all references")
	public ListResponse<ReferenceResponse> getAllReferences() {

		return referenceService.getAllReferences();
	}

	@ResponseStatus(OK)
	@PatchMapping(value = REFERENCE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Update reference by id")
	public ObjectResponse<ReferenceResponse> updateReference(@PathVariable Long referenceId,
															 @RequestBody ReferenceRequest request) {

		return referenceService.updateReference(referenceId, request);
	}

	@ResponseStatus(OK)
	@DeleteMapping(value = REFERENCE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Delete reference by id")
	public SuccessWrapper deleteReference(@PathVariable Long referenceId) {

		return referenceService.deleteReference(referenceId);
	}

	@ResponseStatus(CREATED)
	@PostMapping(value = REFERENCE_FIELD_ADD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Add reference field")
	public ObjectResponse<ReferenceFieldResponse> addReferenceField(@RequestBody ReferenceFieldRequest request) {

		return referenceService.addReferenceField(request);
	}

	@ResponseStatus(CREATED)
	@PostMapping(value = REFERENCE_FIELDS, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Add reference fields")
	public ListResponse<ReferenceFieldResponse> addReferenceFields(@RequestBody ReferenceFieldsRequest request) {

		return referenceService.addReferenceFields(request);
	}

	@ResponseStatus(OK)
	@GetMapping(value = REFERENCE_FIELD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get reference field by id")
	public ObjectResponse<ReferenceFieldResponse> getReferenceField(@PathVariable Long fieldId) {

		return referenceService.getReferenceField(fieldId);
	}

	@ResponseStatus(OK)
	@GetMapping(value = REFERENCE_FIELDS, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get all reference fields")
	public ListResponse<ReferenceFieldResponse> getAllReferenceFields() {

		return referenceService.getAllReferenceFields();
	}

	@ResponseStatus(OK)
	@PatchMapping(value = REFERENCE_FIELD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Update reference field by id")
	public ObjectResponse<ReferenceFieldResponse> updateReferenceField(@PathVariable Long fieldId,
																	   @RequestBody ReferenceFieldRequest request) {

		return referenceService.updateReferenceField(fieldId, request);
	}

	@ResponseStatus(OK)
	@PatchMapping(value = REFERENCE_FIELDS, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Update all reference fields")
	public ListResponse<ReferenceFieldResponse> updateReferenceFields(@RequestBody ReferenceFieldsUpdateRequest request) {

		return referenceService.updateReferenceFields(request);
	}

	@ResponseStatus(OK)
	@DeleteMapping(value = REFERENCE_FIELD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Delete reference field by id")
	public SuccessWrapper deleteReferenceField(@PathVariable Long fieldId) {

		return referenceService.deleteReferenceField(fieldId);
	}

	@ResponseStatus(OK)
	@DeleteMapping(value = REFERENCE_FIELD_DELETE_BY_REF, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Delete all reference fields by reference id")
	public SuccessWrapper deleteAllReferenceFieldsByReferenceId(@PathVariable Long referenceId) {

		return referenceService.deleteAllReferenceFieldsByReferenceId(referenceId);
	}
}
