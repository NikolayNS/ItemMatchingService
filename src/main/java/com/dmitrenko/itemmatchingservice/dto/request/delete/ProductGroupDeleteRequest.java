package com.dmitrenko.itemmatchingservice.dto.request.delete;

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
public class ProductGroupDeleteRequest {
	private Long id;
}
