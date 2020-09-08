package com.dmitrenko.itemmatchingservice.dto.request.add;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@ToString
@NoArgsConstructor
public class CompanyItemAddRequest {
	private String barcode;
	private String name;
	private Long productGroupId;
}
