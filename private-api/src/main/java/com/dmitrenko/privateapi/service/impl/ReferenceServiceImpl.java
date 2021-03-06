package com.dmitrenko.privateapi.service.impl;

import com.dmitrenko.database.dto.request.reference.ReferenceFieldRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsUpdateRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceRequest;
import com.dmitrenko.database.dto.response.reference.ReferenceFieldResponse;
import com.dmitrenko.database.dto.response.reference.ReferenceResponse;
import com.dmitrenko.database.service.domain.reference.ReferenceDomainService;
import com.dmitrenko.database.service.domain.reference.ReferenceFieldDomainService;
import com.dmitrenko.privateapi.service.ReferenceService;
import com.dmitrenko.privateapi.wrapper.ListResponse;
import com.dmitrenko.privateapi.wrapper.ObjectResponse;
import com.dmitrenko.privateapi.wrapper.SuccessWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReferenceServiceImpl implements ReferenceService {

	private final ReferenceDomainService referenceDomainService;
	private final ReferenceFieldDomainService referenceFieldDomainService;

	@Override
	public ObjectResponse<ReferenceResponse> addReference(ReferenceRequest request) {
		return ObjectResponse.success(referenceDomainService.addReference(request));
	}

	@Override
	public ObjectResponse<ReferenceResponse> getReference(Long referenceId) {
		return ObjectResponse.success(referenceDomainService.getReference(referenceId));
	}

	@Override
	public ListResponse<ReferenceResponse> getAllReferences() {
		return ListResponse.success(referenceDomainService.getAllReferences());
	}

	@Override
	public ObjectResponse<ReferenceResponse> updateReference(Long referenceId, ReferenceRequest request) {
		return ObjectResponse.success(referenceDomainService.updateReference(referenceId, request));
	}

	@Override
	public SuccessWrapper deleteReference(Long referenceId) {
		return new SuccessWrapper(referenceDomainService.deleteReference(referenceId));
	}

	@Override
	public ObjectResponse<ReferenceFieldResponse> addReferenceField(ReferenceFieldRequest request) {
		return ObjectResponse.success(referenceFieldDomainService.addReferenceField(request));
	}

	@Override
	public ListResponse<ReferenceFieldResponse> addReferenceFields(ReferenceFieldsRequest request) {
		return ListResponse.success(referenceFieldDomainService.addReferenceFields(request));
	}

	@Override
	public ObjectResponse<ReferenceFieldResponse> getReferenceField(Long fieldId) {
		return ObjectResponse.success(referenceFieldDomainService.getReferenceField(fieldId));
	}

	@Override
	public ListResponse<ReferenceFieldResponse> getAllReferenceFields() {
		return ListResponse.success(referenceFieldDomainService.getAllReferenceFields());
	}

	@Override
	public ObjectResponse<ReferenceFieldResponse> updateReferenceField(Long fieldId, ReferenceFieldRequest request) {
		return ObjectResponse.success(referenceFieldDomainService.updateReferenceField(fieldId, request));
	}

	@Override
	public ListResponse<ReferenceFieldResponse> updateReferenceFields(ReferenceFieldsUpdateRequest request) {
		return ListResponse.success(referenceFieldDomainService.updateReferenceFields(request));
	}

	@Override
	public SuccessWrapper deleteReferenceField(Long fieldId) {
		return new SuccessWrapper(referenceFieldDomainService.deleteReferenceField(fieldId));
	}

	@Override
	public SuccessWrapper deleteAllReferenceFieldsByReferenceId(Long referenceId) {
		return new SuccessWrapper(referenceFieldDomainService.deleteAllReferenceFieldsByReferenceId(referenceId));
	}
}
