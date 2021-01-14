package com.dmitrenko.database.dto.request.reference;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.util.Collections;
import java.util.List;

@Data
@Accessors(chain = true)
@Validated
public class ReferenceFieldsRequest {

	@NotEmpty(message = "The [fields] parameter must contain elements. ")
	private List<ReferenceFieldRequest> fields = Collections.emptyList();
}
